/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.google.com.p.ontologytesting.model.jenainterfaz;


/**
 *
 * @author saruskas
 */
public class ExceptionReadOntology extends RuntimeException {

    /**
     * Creates a new instance of <code>ExceptionReadOntology</code> without detail message.
     */
    public ExceptionReadOntology() {
    }

    /**
     * Constructs an instance of <code>ExceptionReadOntology</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ExceptionReadOntology(String msg) {
        super(msg);
        
    }   
    
}
