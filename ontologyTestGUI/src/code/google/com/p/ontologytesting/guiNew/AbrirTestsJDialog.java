/*
 * AbrirTestsJDialog.java
 *
 * Created on 14 de julio de 2008, 13:48
 */

package code.google.com.p.ontologytesting.guiNew;

import code.google.com.p.ontologytesting.model.CollectionTest;
import code.google.com.p.ontologytesting.model.ScenarioTest;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author  sara.garcia
 */
public class AbrirTestsJDialog extends javax.swing.JDialog {

    private ListaFicheros listaFicheros;
    private JFileChooser filechooser;
    private String pathProyect;
    private XMLDecoder decoder;
    private CollectionTest collection;
    private JFrame frame = new JFrame();
    
    /** Creates new form AbrirTestsJDialog */
    public AbrirTestsJDialog(Frame parent, boolean modal,final CollectionTest collection) {
        super(parent, modal);
        initComponents();
        this.setModal(false);
        this.setTitle("Descripción Tests");
    }

    public void prepararImport(ArrayList<ScenarioTest> listaTests){
        
        contentPanel.setLayout(new FlowLayout());  
        listaFicheros = new ListaFicheros(listaTests);
        contentPanel.add(listaFicheros.getSplitPane());
        contentPanel.getParent().validate(); 
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        abrirButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        pathProyectoTextField = new javax.swing.JTextField();
        examinarButton = new javax.swing.JButton();
        importarButton = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        abrirButton.setText("Ver Test Completo");
        abrirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirButtonActionPerformed(evt);
            }
        });

        cancelarButton.setText("Salir");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Ubicación de los Tests");

        jLabel3.setText("Seleccione el proyecto:");

        examinarButton.setText("Examinar");
        examinarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examinarButtonActionPerformed(evt);
            }
        });

        importarButton.setText("Importar");
        importarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pathProyectoTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(examinarButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
                        .addComponent(abrirButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(importarButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(examinarButton)
                    .addComponent(jLabel3)
                    .addComponent(pathProyectoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importarButton)
                    .addComponent(cancelarButton)
                    .addComponent(abrirButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void abrirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirButtonActionPerformed
// TODO add your handling code here:  
    SeeTestJDialog seeTestCompleted = new SeeTestJDialog(frame, false, listaFicheros.getScenarioSelect());
    seeTestCompleted.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    seeTestCompleted.setVisible(true);
}//GEN-LAST:event_abrirButtonActionPerformed

private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
// TODO add your handling code here:
    this.setVisible(false);
}//GEN-LAST:event_cancelarButtonActionPerformed

private void examinarButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
// TODO add your handling code here:
    openFile(this.getPathProyectoTextField());
    System.out.println(this.getPathProyect());
    try{
        decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(this.getPathProyect())));
        collection = (CollectionTest) decoder.readObject();
        this.prepararImport(collection.getScenariotest());
        decoder.close();    
    }catch(FileNotFoundException e){
    
    }catch(ClassCastException e){
        System.out.println("Este no es un proyecto valido");
    }catch(Exception ex){
        System.out.println("Este no es un proyecto valido");
    }
}

private void importarButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
// TODO add your handling code here:
    List<ScenarioTest> scenImp = listaFicheros.getListaDeScenarios();
    ListarTestsJPanel.aniadirTestSimple(scenImp);
}

    private void openFile(JTextField textfield){
        String path="";
        filechooser = new JFileChooser("");
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int option = filechooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
          File selectedFile = filechooser.getSelectedFile();
          path = selectedFile.getAbsolutePath();
          textfield.setText(path);
          this.setPathProyect(path);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrirButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton examinarButton;
    private javax.swing.JButton importarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField pathProyectoTextField;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTextField getPathProyectoTextField() {
        return pathProyectoTextField;
    }

    public String getPathProyect() {
        return pathProyect;
    }

    public void setPathProyect(String pathProyect) {
        this.pathProyect = pathProyect;
    }

}