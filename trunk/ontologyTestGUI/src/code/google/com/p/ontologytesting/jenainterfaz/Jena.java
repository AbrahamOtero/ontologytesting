/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.google.com.p.ontologytesting.jenainterfaz;

import java.util.ArrayList;

/**
 *
 * @author sara.garcia
 */
public interface Jena {
    
    void addInstanceClass(String ns,String nameClass, String value);
    
    void addInstanceProperty(String ns,String nameProperty, String value);
    
    void addReasoner(String ontologia);
    
    void deleteEntries();
    
    String instantiation(String ns, String className, String individualName);
    
    ArrayList<String> retieval(String ns, String className);

    String realization(String ns, String individualName); 
    
    String satisfactibility(String ns, String concepto, String clase);

    ArrayList<String> classification(String ns, String individuo);
    
    ArrayList<String> testSPARQL(String queryStr, boolean formatHTML);   

}
