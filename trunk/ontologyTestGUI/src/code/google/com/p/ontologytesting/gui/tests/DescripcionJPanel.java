/*
 * DescripcionJPanel.java
 *
 * Created on 30 de junio de 2008, 10:45
 */

package code.google.com.p.ontologytesting.gui.tests;

import code.google.com.p.ontologytesting.gui.*;
import code.google.com.p.ontologytesting.gui.auxiliarpanels.FormatTestsJDialog;
import code.google.com.p.ontologytesting.gui.auxiliarclasess.ControladorTests;
import java.awt.Frame;

/**
 *
 * @author  sara.garcia
 */
public class DescripcionJPanel extends javax.swing.JPanel {

    Frame frame;
    /** Creates new form DescripcionJPanel */
    public DescripcionJPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descTextArea = new javax.swing.JTextArea();
        formatosButton = new javax.swing.JButton();

        jLabel6.setText(java.util.ResourceBundle.getBundle(Configuration.getPropiedades().getProperty("IDIOMA")).getString("Nombre_del_test:"));

        nombreTextField.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

        jLabel7.setText(java.util.ResourceBundle.getBundle(Configuration.getPropiedades().getProperty("IDIOMA")).getString("Descripción:"));

        descTextArea.setColumns(20);
        descTextArea.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        descTextArea.setRows(5);
        jScrollPane1.setViewportView(descTextArea);

        formatosButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/information.png"))); // NOI18N
        formatosButton.setToolTipText("Formatos Permitidos");
        formatosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formatosButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(formatosButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addComponent(formatosButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }

private void formatosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formatosButtonActionPerformed
// TODO add your handling code here:
    FormatTestsJDialog format = new FormatTestsJDialog(MainApplicationJFrame.getInstance(),true,ControladorTests.getInstance().testSeleccionado());
    format.setLocationRelativeTo(MainApplicationJFrame.getInstance());
    format.setVisible(true);
}//GEN-LAST:event_formatosButtonActionPerformed

public boolean testSinNombre(){
    if(this.getNombreTextField().equals("")){
        return true;
    }else{
        return false;
    }
}

public String getDescTextArea() {
    return descTextArea.getText();
}

public void setDescTextArea(String adescTextArea) {
    descTextArea.setText(adescTextArea);
}

public String getNombreTextField() {
    return nombreTextField.getText();
}

public void setNombreTextField(String anombreTextField) {
    nombreTextField.setText(anombreTextField);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea descTextArea;
    private javax.swing.JButton formatosButton;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreTextField;
    // End of variables declaration//GEN-END:variables

}
