/*
 * TestInstancesTFJPanel.java
 *
 * Created on 19 de mayo de 2008, 18:49
 */

package code.google.com.p.ontologytesting.gui;

import java.awt.Frame;
import javax.swing.ButtonGroup;
import javax.swing.WindowConstants;

/**
 *
 * @author  Saruskas
 */
public class TestInstancesTFJPanel extends javax.swing.JPanel{

    private AddComentJDialog frameComent;
    private Frame frame;
    
    /** Creates new form TestInstancesTFJPanel */
    public TestInstancesTFJPanel() {
        initComponents();
        ButtonGroup group = new ButtonGroup();
        group.add(trueRadioButton);
        group.add(falseRadioButton);
        frameComent = new AddComentJDialog(frame,true); 
        frameComent.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
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
        trueRadioButton = new javax.swing.JRadioButton();
        falseRadioButton = new javax.swing.JRadioButton();
        comentarioButton = new javax.swing.JButton();
        borrarButton = new javax.swing.JButton();
        duplicarButton = new javax.swing.JButton();
        selectCheckBox = new javax.swing.JCheckBox();

        queryTextField.setToolTipText("Consulta");

        trueRadioButton.setText("True");

        falseRadioButton.setText("False");

        comentarioButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/comment.gif"))); // NOI18N
        comentarioButton.setText("Comentario");
        comentarioButton.setToolTipText("Añadir comentario");
        comentarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comentarioButtonActionPerformed(evt);
            }
        });

        borrarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/cancel.gif"))); // NOI18N
        borrarButton.setText("Borrar");
        borrarButton.setToolTipText("Borrar");
        borrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarButtonActionPerformed(evt);
            }
        });

        duplicarButton.setText("Duplicar");
        duplicarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duplicarButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(queryTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 202, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(34, 34, 34)
                .add(trueRadioButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(falseRadioButton)
                .add(40, 40, 40)
                .add(comentarioButton)
                .add(30, 30, 30)
                .add(borrarButton)
                .add(32, 32, 32)
                .add(duplicarButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(selectCheckBox)
                .add(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(queryTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(trueRadioButton)
                        .add(falseRadioButton)
                        .add(comentarioButton)
                        .add(borrarButton)
                        .add(duplicarButton))
                    .add(selectCheckBox))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void comentarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comentarioButtonActionPerformed
// TODO add your handling code here:
    frameComent.setVisible(true);
}//GEN-LAST:event_comentarioButtonActionPerformed

private void borrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarButtonActionPerformed
// TODO add your handling code here:
    this.setVisible(false);
}//GEN-LAST:event_borrarButtonActionPerformed

private void duplicarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duplicarButtonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_duplicarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrarButton;
    private javax.swing.JButton comentarioButton;
    private javax.swing.JButton duplicarButton;
    private javax.swing.JRadioButton falseRadioButton;
    private javax.swing.JTextField queryTextField;
    private javax.swing.JCheckBox selectCheckBox;
    private javax.swing.JRadioButton trueRadioButton;
    // End of variables declaration//GEN-END:variables

    
    public void setQuery(String query){
        queryTextField.setText(query);
    }
    
    public String getQuery(){
        return queryTextField.getText();
    }

    public String isTestTrue() {
        if(trueRadioButton.isSelected()){
            return "true";
        }else{
            return "false";
        }
    }
    
    public String isTestFalse() {
        if(falseRadioButton.isSelected()){
            return "true";
        }else{
            return "false";
        }
    }    

    public void setTrueTest(boolean testT) {
        trueRadioButton.setSelected(testT);
    }

    public void setFalseTest(boolean testF) {
        falseRadioButton.setSelected(testF);
    }
    
    public boolean isSelected() {
        return selectCheckBox.isSelected();
    }

    public void setSelecion(boolean selecion) {
        selectCheckBox.setSelected(selecion);
    }
    
    public AddComentJDialog getComment() {
        return frameComent;
    }

    public void setComment(AddComentJDialog comment) {
        this.frameComent = comment;
    }
}