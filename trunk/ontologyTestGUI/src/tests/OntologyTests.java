/*
 * instantiationTest.java
 * 
 * Created on 21-feb-2008, 10:47:18
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tests;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Resource;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author sara_garcia
 */
public class OntologyTests {
    
    //Saber si un individuo pertenece a una clase
    public String instantiation(String ns, String className, String individualName, 
            OntModel model){
        
        OntClass ontClass = model.getOntClass(ns + className);

        if(ontClass==null) 
        {
            return "El individuo introducido no es una instancia para el modelo";
        }
      
        Iterator it = ontClass.listInstances();       
              
        while(it.hasNext()){
            String instanceName = it.next().toString();
            instanceName = instanceName.substring(instanceName.indexOf("#")+1);
            if(individualName.equals(instanceName)) {
                return "true";
            }
        }
        return "false";
    } 
    
    //Saber TODOS los individuos que pertenecen a una clase
    //TODOS los individuos que son instancias de un concepto    
    public String retieval(String ns, String className, OntModel model){
        
        String rval="";
        OntClass ontClass = model.getOntClass(ns + className);         
        Iterator it = ontClass.listInstances();
        
        while(it.hasNext())
        {
            String instanceName=it.next().toString();
            instanceName=instanceName.substring(instanceName.indexOf("#")+1);
            
            if(!rval.equals(""))
                rval+=",";
            rval+=instanceName;
        }
        return rval;
    }    

    //Saber la clase mas exacta a la que pertenece un individuo
    //Dado un individuo, encontrar el concepto más específico que lo contiene
    public String realization(String ns, String individualName, OntModel model){
         
        Individual individual = model.getIndividual(ns + individualName);
        
        if(individual==null) return "El individuo introducido no es una instancia para el modelo";
        
        Resource resource = individual.getRDFType(true); 
        String className = resource.toString().substring(resource.toString().indexOf("#")+1);
        
        return className;
    }  
    
    //Saber si se puede añadir un concepto
    public String satisfactibility(String ns, OntModel model, String concepto, 
            String clase){
      
       OntClass ontClass = model.getOntClass(ns+clase);
       Iterator it = ontClass.listDisjointWith();
       ArrayList<String> conjuntoDisj = new ArrayList<String>();
       
       while(it.hasNext()){
            String disjunta = it.next().toString();
            disjunta = disjunta.substring(disjunta.indexOf("#")+1);
            conjuntoDisj.add(disjunta);
        }
       
       String clasesConcepto = classification(ns,model,concepto);
       String[] clas = clasesConcepto.split(",");
       int tam = clas.length;
       ArrayList<String> listaInicial = new ArrayList<String>();
       for(int j=0;j<tam;j++){
            listaInicial.add(clas[j]);
       }
       if(clasesConcepto.equals("")){
            return "true";
       }else{
           for(int i=0;i<listaInicial.size();i++){
            for(int k=0;k<conjuntoDisj.size();k++){
                if(listaInicial.get(i).equals(conjuntoDisj.get(k))){
                    return "false";
                }
            }
           }
       }
       return "true";
    }
    
    //Dado un individuo, deducir todas las clases a las que pertenece
    public String classification(String ns, OntModel model, String individuo){
        
        String pertenece;
        String clases="";
        Iterator it = model.listNamedClasses();

        while(it.hasNext()){
            String[] instanceName = it.next().toString().split("#");
            pertenece = instantiation(ns, instanceName[1].toString(), individuo, model);
            if(pertenece.equals("true")){
                if(!clases.equals("")){
                    clases+=","+instanceName[1].toString();
                }else{
                clases=instanceName[1].toString();
                }
            }
        }       
        return clases;
    }
    
}