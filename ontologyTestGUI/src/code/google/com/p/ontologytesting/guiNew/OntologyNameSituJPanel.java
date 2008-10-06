/*
 * OntologyNameSituJPanel.java
 *
 * Created on 6 de octubre de 2008, 10:07
 */

package code.google.com.p.ontologytesting.guiNew;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

/**
 *
 * @author  sara.garcia
 */
public class OntologyNameSituJPanel extends javax.swing.JPanel {

    private boolean state;
    private String ubicOnto, nsOnto;
    private JFileChooser filechooser;
    
    /** Creates new form OntologyNameSituJPanel */
    public OntologyNameSituJPanel() {
        initComponents();
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ubicacionOntoTextField = new javax.swing.JTextField();
        namespaceOntoTextField = new javax.swing.JTextField();
        examinarButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Ontologia: Localizacion y Namespace");

        jLabel2.setText("Ubicacion de la Ontologia:");

        jLabel3.setText("Namespace de la Ontologia:");

        examinarButton.setText("Examinar");
        examinarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examinarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(ubicacionOntoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(namespaceOntoTextField)))
                        .addGap(18, 18, 18)
                        .addComponent(examinarButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ubicacionOntoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(examinarButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(namespaceOntoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void examinarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinarButtonActionPerformed
// TODO add your handling code here:
    openFile(this.getUbicacionOntoTextField());//GEN-LAST:event_examinarButtonActionPerformed
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
        }
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton examinarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField namespaceOntoTextField;
    private javax.swing.JTextField ubicacionOntoTextField;
    // End of variables declaration//GEN-END:variables

    public String getUbicOnto() {
        return ubicOnto;
    }

    public void setUbicOnto(String ubicOnto) {
        this.ubicOnto = ubicOnto;
    }

    public String getNsOnto() {
        return nsOnto;
    }

    public void setNsOnto(String nsOnto) {
        this.nsOnto = nsOnto;
    }

    public String getNamespaceOntoTextField() {
        return namespaceOntoTextField.getText();
    }

    public javax.swing.JTextField getUbicacionOntoTextField() {
        return ubicacionOntoTextField;
    }
    
    public String getUbicacionOnto() {
        return ubicacionOntoTextField.getText();
    }

}
