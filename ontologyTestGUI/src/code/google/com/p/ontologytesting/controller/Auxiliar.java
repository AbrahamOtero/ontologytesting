/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.google.com.p.ontologytesting.controller;

import code.google.com.p.ontologytesting.guiNew.*;
import code.google.com.p.ontologytesting.model.*;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sara.garcia
 */
public class Auxiliar {

    private boolean yaEligioGuardarInstancias=false;
    private static int contadorClas=0,contadorProp=0;
    private static int contadorInstSat=0;
    private static int contadorRetClas=0;
    private static int contadorReal=0;
    private static TestSimpleInstSat testSimpleInstSat;
    private static TestSimpleRetClas testSimpleRetClas;
    private static TestSimpleReal testSimpleReal;
    private static AddSPARQLJPanel testSparql;
    
    public ScenarioTest buscarScenario(String name){
        ArrayList<ScenarioTest> scenario = MainApplication.getCollection().getScenariotest();
        for(int i=0;i<scenario.size();i++){
            String nombre = scenario.get(i).getNombre();
            if(nombre.equals(name)){
                return scenario.get(i);
            }
        }
        return null;
    }
    
    public static void inicializarContadores(){
        setContadorClas(0);
        setContadorInstSat(0);
        setContadorProp(0);
        setContadorReal(0);
        setContadorRetClas(0);
    }
    
    public static boolean guardarAntesDeSeguir(){
        int sel = ControladorTests.testSeleccionado();
        boolean seguir=false;
        if(sel==0 || sel==3){
            seguir = Auxiliar.getTestSimpleInstSat().guardarTest();
        }else if(sel==1 || sel==4){
            seguir = Auxiliar.getTestSimpleRetClas().guardarTest();
        }else if(sel==2){
            seguir = Auxiliar.getTestSimpleReal().guardarTest();
        }else if(sel==5){

        }
        return seguir;
    }
    
    public void editarTest(ScenarioTest s, String tipoTest){
        if(tipoTest.equals("Instanciacion")){
            ControladorTests.setTestInstGuardado(false);
            ControladorTests.setTestInstSelect(true);
            TestSimpleInstSat testInst = new TestSimpleInstSat(0, s);
            int cont = MainApplication.getContentTestsJPanel().getComponentCount();
            if(cont==0){
                MainApplication.getContentTestsJPanel().add(testInst,BorderLayout.NORTH);
            }else{
                MainApplication.getContentTestsJPanel().remove(0);
                MainApplication.getContentTestsJPanel().add(testInst,BorderLayout.NORTH);
            }
            MainApplication.getContentTestsJPanel().getParent().validate();
        }else if(tipoTest.equals("Retrieval")){
            ControladorTests.setTestRetGuardado(false);
            ControladorTests.setTestRetSelect(true);
            TestSimpleRetClas testInst = new TestSimpleRetClas(1, s);
            int cont = MainApplication.getContentTestsJPanel().getComponentCount();
            if(cont==0){
                MainApplication.getContentTestsJPanel().add(testInst,BorderLayout.NORTH);
            }else{
                MainApplication.getContentTestsJPanel().remove(0);
                MainApplication.getContentTestsJPanel().add(testInst,BorderLayout.NORTH);
            }
            MainApplication.getContentTestsJPanel().getParent().validate();
        }else if(tipoTest.equals("Realizacion")){
            ControladorTests.setTestRealGuardado(false);
            ControladorTests.setTestRealSelect(true);
            TestSimpleReal testInst = new TestSimpleReal(2, s);
            int cont = MainApplication.getContentTestsJPanel().getComponentCount();
            if(cont==0){
                MainApplication.getContentTestsJPanel().add(testInst,BorderLayout.NORTH);
            }else{
                MainApplication.getContentTestsJPanel().remove(0);
                MainApplication.getContentTestsJPanel().add(testInst,BorderLayout.NORTH);
            }
            MainApplication.getContentTestsJPanel().getParent().validate();

        }else if(tipoTest.equals("Satisfactibilidad")){
            ControladorTests.setTestSatGuardado(false);
            ControladorTests.setTestSatSelect(true);
            TestSimpleInstSat testInst = new TestSimpleInstSat(3, s);
            int cont = MainApplication.getContentTestsJPanel().getComponentCount();
            if(cont==0){
                MainApplication.getContentTestsJPanel().add(testInst,BorderLayout.NORTH);
            }else{
                MainApplication.getContentTestsJPanel().remove(0);
                MainApplication.getContentTestsJPanel().add(testInst,BorderLayout.NORTH);
            }
            MainApplication.getContentTestsJPanel().getParent().validate();

        }else if(tipoTest.equals("Clasificacion")){
            ControladorTests.setTestClasGuardado(false);
            ControladorTests.setTestClasSelect(true);
            TestSimpleRetClas testInst = new TestSimpleRetClas(4, s);
            int cont = MainApplication.getContentTestsJPanel().getComponentCount();
            if(cont==0){
                MainApplication.getContentTestsJPanel().add(testInst,BorderLayout.NORTH);
            }else{
                MainApplication.getContentTestsJPanel().remove(0);
                MainApplication.getContentTestsJPanel().add(testInst,BorderLayout.NORTH);
            }
            MainApplication.getContentTestsJPanel().getParent().validate();
        }else if(tipoTest.equals("sparql")){
            ControladorTests.setTestSparqlGuardado(false);
            ControladorTests.setTestSparqlSelect(true);
            AddSPARQLJPanel testSparql = new AddSPARQLJPanel(5, s);
            int cont = MainApplication.getContentTestsJPanel().getComponentCount();
            if(cont==0){
                MainApplication.getContentTestsJPanel().add(testSparql,BorderLayout.NORTH);
            }else{
                MainApplication.getContentTestsJPanel().remove(0);
                MainApplication.getContentTestsJPanel().add(testSparql,BorderLayout.NORTH);
            }
            MainApplication.getContentTestsJPanel().getParent().validate();
        }
    }
    
    public boolean mismoScenarioSparql (ScenarioTest s1, ScenarioTest s2){
    if(s1.getDescripcion().equals(s2.getDescripcion())){
        if(s1.getNombre().equals(s2.getNombre())){
            if(s1.getTestName().equals(s2.getTestName())){
                if(mismasQuerysSparql(s1.getSparqlQuerys(), s2.getSparqlQuerys())==true){
                    Instancias i1 = s1.getInstancias();
                    Instancias i2 = s2.getInstancias();
                    if(i1.getDescripcion().equals(i2.getDescripcion())){
                        if(i1.getNombre().equals(i2.getNombre())){
                            if(i1.getType().equals(i2.getType())){
                                if(mismasClases(i1.getClassInstances(), i2.getClassInstances())==true){
                                    if(mismasProp(i1.getPropertyInstances(), i2.getPropertyInstances())==true){
                                        return true;
                                    }else{
                                        return false;
                                    }
                                }else{
                                    return false;
                                }
                            }else{
                                return false;
                            }
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }else{
        return false;
    }
    }
    
    
    
    public boolean mismoScenario(ScenarioTest s1, ScenarioTest s2){
    if(s1.getDescripcion().equals(s2.getDescripcion())){
        if(s1.getNombre().equals(s2.getNombre())){
            if(s1.getTestName().equals(s2.getTestName())){
                if(mismasQuerys(s1.getQueryTest(), s2.getQueryTest())==true){
                    Instancias i1 = s1.getInstancias();
                    Instancias i2 = s2.getInstancias();
                    if(i1.getDescripcion().equals(i2.getDescripcion())){
                        if(i1.getNombre().equals(i2.getNombre())){
                            if(i1.getType().equals(i2.getType())){
                                if(mismasClases(i1.getClassInstances(), i2.getClassInstances())==true){
                                    if(mismasProp(i1.getPropertyInstances(), i2.getPropertyInstances())==true){
                                        return true;
                                    }else{
                                        return false;
                                    }
                                }else{
                                    return false;
                                }
                            }else{
                                return false;
                            }
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }else{
        return false;
    }
}

public boolean mismasQuerys(List<QueryOntology> q1, List<QueryOntology> q2){
    int var=0;
    int cont=0;
    if(q1.size()==q2.size()){
        int tam1 = q1.size();
        int tam2 = q2.size();
        for(int i=0;i<tam1;i++){
            if(var==1 || cont==0){
                var=0;
                cont=1;
                String coment1 = q1.get(i).getComment();
                String query1 = q1.get(i).getQuery();
                String result1 = q1.get(i).getResultexpected();
                for(int j=0;j<tam2;j++){
                    String coment2 = q2.get(j).getComment();
                    String query2 = q2.get(j).getQuery();
                    String result2 = q2.get(j).getResultexpected();
                    if(coment1.equals(coment2) && query2.equals(query1) && result2.equals(result1)){
                        var=1;
                    }
                }
            }else return false;
        }
        if(var==0 && tam1>0){
            return false;
        }
    }else{
        return false;
    }
    return true;
}

public boolean mismasQuerysSparql(List<SparqlQueryOntology> q1, List<SparqlQueryOntology> q2){
    int var=0;
    int cont=0;
    if(q1.size()==q2.size()){
        int tam1 = q1.size();
        int tam2 = q2.size();
        for(int i=0;i<tam1;i++){
            if(var==1 || cont==0){
                var=0;
                cont=1;
                String query1 = q1.get(i).getQuerySparql();
                String result1 = q1.get(i).getResultexpected();
                for(int j=0;j<tam2;j++){
                    String query2 = q2.get(j).getQuerySparql();
                    String result2 = q2.get(j).getResultexpected();
                    if(query2.equals(query1) && result2.equals(result1)){
                        var=1;
                    }
                }
            }else return false;
        }
        if(var==0 && tam1>0){
            return false;
        }
    }else{
        return false;
    }
    return true;
}

    public boolean mismasInstancias(Instancias i1, Instancias i2){
        if(i1.getDescripcion().equals(i2.getDescripcion())){
            if(i1.getNombre().equals(i2.getNombre())){
                if(i1.getType().equals(i2.getType())){
                    if(mismasClases(i1.getClassInstances(), i2.getClassInstances())==true){
                        if(mismasProp(i1.getPropertyInstances(), i2.getPropertyInstances())==true){
                            return true;
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        } 
    
    }
    
    
    public boolean mismasClases(List<ClassInstances> c1, List<ClassInstances> c2){
        int var=0;
        int cont=0;
        if(c1.size()==c2.size()){
            int tam1 = c1.size();
            int tam2 = c2.size();
            for(int i=0;i<tam1;i++){
                if(var==1 || cont==0){
                    var=0;
                    cont=1;
                    String coment1 = c1.get(i).getComment();
                    String query1 = c1.get(i).getClassInstance();
                    for(int j=0;j<tam2;j++){
                        String coment2 = c2.get(i).getComment();
                        String query2 = c2.get(i).getClassInstance();
                        if(coment1.equals(coment2) && query2.equals(query1)){
                            var=1;
                        }
                    }
                }else return false;
            }
            if(var==0 && tam1>0){
                return false;
            }
        }else{
            return false;
        }
        return true;
    }

    public boolean mismasProp(List<PropertyInstances> p1, List<PropertyInstances> p2){
        int var=0;
        int cont=0;
        if(p1.size()==p2.size()){
            int tam1 = p1.size();
            int tam2 = p2.size();
            for(int i=0;i<tam1;i++){
                if(var==1 || cont==0){
                    var=0;
                    cont=1;
                    String coment1 = p1.get(i).getComment();
                    String query1 = p1.get(i).getPropertyInstance();
                    for(int j=0;j<tam2;j++){
                        String coment2 = p2.get(i).getComment();
                        String query2 = p2.get(i).getPropertyInstance();
                        if(coment1.equals(coment2) && query2.equals(query1)){
                            var=1;
                        }
                    }
                }else return false;
            }
            if(var==0 && tam1>0){
                return false;
            }
        }else{
            return false;
        }
        return true;
    }
    
    public static int getContadorRetClas() {
        return contadorRetClas;
    }

    public static void setContadorRetClas(int aContadorRetClas) {
        contadorRetClas = aContadorRetClas;
    }
    
    public void setYaEligioGuardarInstancias(boolean selec) {
        yaEligioGuardarInstancias = selec;
    }
    
    public boolean getYaEligioGuardarInstancias() {
        return yaEligioGuardarInstancias;
    }
    
    public static int getContadorClas() {
        return contadorClas;
    }
    
    public static void setContadorClas(int aContador) {
        contadorClas = aContador;
    }

    public static int getContadorProp() {
        return contadorProp;
    }

    public static void setContadorProp(int aContadorProp) {
        contadorProp = aContadorProp;
    }
    
    public static int getContadorInstSat() {
        return contadorInstSat;
    }

    public static void setContadorInstSat(int aContadorInst) {
        contadorInstSat = aContadorInst;
    }
    
    public static int getContadorReal() {
        return contadorReal;
    }

    public static void setContadorReal(int aContadorReal) {
        contadorReal = aContadorReal;
    }

    public static TestSimpleInstSat getTestSimpleInstSat() {
        return testSimpleInstSat;
    }

    public static void setTestSimpleInstSat(TestSimpleInstSat atestSimpleInstSat) {
        testSimpleInstSat = atestSimpleInstSat;
    }
    
    public static TestSimpleRetClas getTestSimpleRetClas() {
        return testSimpleRetClas;
    }

    public static void setTestSimpleRetClas(TestSimpleRetClas atestSimpleRetClas) {
        testSimpleRetClas = atestSimpleRetClas;
    }
    
    public static TestSimpleReal getTestSimpleReal() {
        return testSimpleReal;
    }

    public static void setTestSimpleReal(TestSimpleReal aTestSimpleReal) {
        testSimpleReal = aTestSimpleReal;
    }
    
    public static AddSPARQLJPanel getTestSparql() {
        return testSparql;
    }

    public static void setTestSparql(AddSPARQLJPanel aTestSparql) {
        testSparql = aTestSparql;
    }
    
}
