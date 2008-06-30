/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author sara_garcia
 */
public class SparqlQueryOntology {

    private String resultexpected;
    private String querySparql;

    
    public SparqlQueryOntology(String querySparql, String resultexpected){
        this.querySparql=querySparql;
        this.resultexpected = resultexpected;
    }
    
    public SparqlQueryOntology(){
        this.querySparql=null;
        this.resultexpected = null;
    }

    public String getResultexpected() {
        return resultexpected;
    }

    public void setResultexpected(String resultexpected) {
        this.resultexpected = resultexpected;
    }

    public String getQuerySparql() {
        return querySparql;
    }

    public void setQuerySparql(String querySparql) {
        this.querySparql = querySparql;
    }
}