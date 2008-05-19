/*
 * addInstancesTFJPanel.java
 *
 * Created on 24 de abril de 2008, 10:46
 */

package ontologytestinggui;

import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author  sara_garcia
 */
public class addInstancesTFJPanel extends javax.swing.JPanel {    
    
    public saveCommentJDialog addcomment= new saveCommentJDialog(new JFrame(),true);
    
    /** Creates new form addInstancesTFJPanel */
    public addInstancesTFJPanel() {
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

        queryTextField = new javax.swing.JTextField();
        duplexButton = new javax.swing.JButton();
        selectCheckBox = new javax.swing.JCheckBox();
        jRadioButton1 = new javax.swing.JRadioButton();
        falseButton = new javax.swing.JRadioButton();
        comentButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        queryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryTextFieldActionPerformed(evt);
            }
        });

        duplexButton.setText("Duplicar");
        duplexButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duplexButtonActionPerformed(evt);
            }
        });

        jRadioButton1.setText("True");

        falseButton.setText("False");

        comentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesgui/comment.png"))); // NOI18N
        comentButton.setText("Comentario");
        comentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comentButtonActionPerformed(evt);
            }
        });

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesgui/Delete.png"))); // NOI18N
        deleteButton.setText("Borrar");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(queryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(falseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(comentButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(duplexButton)
                .addGap(48, 48, 48)
                .addComponent(selectCheckBox)
                .addGap(31, 31, 31))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comentButton, deleteButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(queryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton1)
                        .addComponent(falseButton)
                        .addComponent(duplexButton)
                        .addComponent(comentButton)
                        .addComponent(deleteButton))
                    .addComponent(selectCheckBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comentButton, deleteButton});

    }// </editor-fold>//GEN-END:initComponents

private void queryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryTextFieldActionPerformed
// TODO add your handling code here:
    
}//GEN-LAST:event_queryTextFieldActionPerformed

private void comentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comentButtonActionPerformed
// TODO add your handling code here:
    addcomment.setTitle("Comentar query");
    addcomment.setVisible(true);
    String comment="";
    addcomment.setCommentTextArea(comment);
}//GEN-LAST:event_comentButtonActionPerformed

private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
// TODO add your handling code here:
    this.setVisible(false);
}//GEN-LAST:event_deleteButtonActionPerformed

private void duplexButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duplexButtonActionPerformed
// TODO add your handling code here:
    addInstancesTFJPanel addInstTF = new addInstancesTFJPanel();
    addInstTF.setVisible(true);
}//GEN-LAST:event_duplexButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton comentButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton duplexButton;
    private javax.swing.JRadioButton falseButton;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JTextField queryTextField;
    private javax.swing.JCheckBox selectCheckBox;
    // End of variables declaration//GEN-END:variables

    public JTextField getQueryTextField() {
        return queryTextField;
    }
    
    public void setQueryTextField(String query){
        queryTextField.setText(query);
    }
    
    public void setFalseButon(){
        falseButton.setSelected(false);
    }

}
