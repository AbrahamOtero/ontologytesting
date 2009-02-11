/*
 * OntologyJDialog.java
 *
 * Created on 19 de enero de 2009, 16:23
 */

package code.google.com.p.ontologytesting.gui.auxiliarpanels;

import code.google.com.p.ontologytesting.gui.Configuration;
import code.google.com.p.ontologytesting.gui.MainApplicationJFrame;
import code.google.com.p.ontologytesting.gui.MainApplicationJFrame.SwingWorkerOntology;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Locale;

/**
 *
 * @author  sara.garcia
 */
public class OntologyJDialog extends javax.swing.JDialog {

    /** Creates new form OntologyJDialog */
    public OntologyJDialog(java.awt.Frame parent, boolean modal, SwingWorkerOntology sw) {
        super(parent, modal);
        initComponents();
        String sCadena;
        this.setTitle(java.util.ResourceBundle.getBundle(Configuration.getPropiedades().getProperty("IDIOMA"),new Locale(Configuration.getPropiedades().getProperty("LOCALE"))).getString("Ontología"));
        this.setLocationRelativeTo(MainApplicationJFrame.getInstance());
        ontologyEditorPane.setEditable(false);
        ontologyEditorPane.setContentType("text/plain");
        StringBuffer ontology = new StringBuffer();
        BufferedReader bf;
        try {
            bf = new BufferedReader(new FileReader(AbrirProyectoJDialog.getUbicFisica()));
            try {
                while ((sCadena = bf.readLine())!=null && sw.isCancelled()==false){
                    ontology.append(sCadena).append("\r\n");
                }
                try{
                    bf.close();
                }catch (IOException ex){
                    System.out.println("No se pudo cerrar el fichero");
                }
                if(sw.isCancelled()==false){
                    ontologyEditorPane.setText(ontology.toString());
                    ontologyEditorPane.setCaretPosition(0);
                }
            } catch (IOException ex) {
                Logger.getLogger(OntologyJDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OntologyJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ontologyEditorPane = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(ontologyEditorPane);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 667, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JEditorPane ontologyEditorPane;
    // End of variables declaration//GEN-END:variables

}
