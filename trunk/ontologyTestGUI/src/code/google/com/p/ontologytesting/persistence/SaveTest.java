/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.google.com.p.ontologytesting.persistence;

import code.google.com.p.ontologytesting.model.*;
import code.google.com.p.ontologytesting.model.reasonerinterfaz.*;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

    
/**
 *
 * @author saruskas
 */
public class SaveTest {

    private XMLEncoder e;
    private Reasoner jena = new Reasoner();
    
    public boolean saveProject(boolean as,String carpetaProy, String nombreProy,File fichero) throws FileNotFoundException{
        if(as==true){
            e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fichero)));
            e.writeObject(CollectionTest.getInstance());
            e.close();
            return true;
        }else{
            e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(carpetaProy+"/"+nombreProy)));
            e.writeObject(CollectionTest.getInstance());
            e.close();
            return true;
        }
    }
    
    public boolean loadProject(String ubicOnto,String namespaceOnto) throws ExceptionReadOntology{                                             
        InterfaceReasoner j = jena.getReasoner();
        if(jena.isCargado()==false){
            return false;
        }else{
            if(!namespaceOnto.endsWith("#")){
                namespaceOnto = namespaceOnto.concat("#");
            }
            CollectionTest.getInstance().setOntology(ubicOnto);
            CollectionTest.getInstance().setNamespace(namespaceOnto);
            j.addReasoner(ubicOnto);
            CollectionTest.getInstance().setNamespace(namespaceOnto);
            CollectionTest.getInstance().setOntology(ubicOnto);
            return true;
        }
    }

    public void saveInstanciasInMemory(Instancias instancias){
        if(instanciasYaGuardadas(instancias)==false){
            CollectionTest.getInstance().getInstancias().add(instancias);
        }
    }
    
    public boolean instanciasYaGuardadas(Instancias inst){
        List<Instancias> instancias = CollectionTest.getInstance().getInstancias();
        for(int i=0; i<instancias.size(); i++){
            if(inst.getNombre().equals(instancias.get(i).getNombre())){
                return true;
            }
        }
        return false;
    }
    
    public boolean replaceInstanciasLocally(Instancias inst){
        List<Instancias> instancias = CollectionTest.getInstance().getInstancias();
        for(int i=0; i<instancias.size(); i++){
            if(inst.getNombre().equals(instancias.get(i).getNombre())){
                instancias.remove(i);
                instancias.add(i,inst);
                return true;
            }
        }
        return false;
    }
    
    public void saveTestInMemory(ScenarioTest scenario){
        if(testYaGuardado(scenario)==false){
            CollectionTest.getInstance().getScenariotest().add(scenario);
        }
    }
    
    public boolean testYaGuardado(ScenarioTest scen){
        List<ScenarioTest> scenario = CollectionTest.getInstance().getScenariotest();
        for(int i=0; i<scenario.size(); i++){
            if(scen.getNombre().equals(scenario.get(i).getNombre())){
                return true;
            }
        }
        return false;
    }
    
    public boolean replaceScenarioLocally(ScenarioTest scen){
        List<ScenarioTest> scenario = CollectionTest.getInstance().getScenariotest();
        for(int i=0; i<scenario.size(); i++){
            if(scen.getNombre().equals(scenario.get(i).getNombre())){
                scenario.remove(i);
                scenario.add(i,scen);
                return true;
            }
        }
        return false;
    }

}
