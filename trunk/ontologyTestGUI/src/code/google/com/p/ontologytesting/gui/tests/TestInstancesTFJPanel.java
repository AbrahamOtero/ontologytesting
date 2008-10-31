/*
 * TestInstancesTFJPanel.java
 *
 * Created on 19 de mayo de 2008, 18:49
 */

package code.google.com.p.ontologytesting.gui.tests;

import java.awt.Color;
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
    private int posicion;
    private static int contadorInstSat=0;
    
    /** Creates new form TestInstancesTFJPanel */
    public TestInstancesTFJPanel() {
        initComponents();
        int pos = TestInstancesTFJPanel.getContadorInstSat();
        this.setPosicion(pos);
        int cont = pos+1;
        TestInstancesTFJPanel.setContadorInstSat(cont);
        ButtonGroup group = new ButtonGroup();
        group.add(trueRadioButton);
        group.add(falseRadioButton);
        frame = new Frame();
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

        queryTextField.setToolTipText("Consulta");
        queryTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                queryTextFieldMouseClicked(evt);
            }
        });

        trueRadioButton.setText("True");

        falseRadioButton.setText("False");

        comentarioButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/comment_add.png"))); // NOI18N
        comentarioButton.setText("Comentario");
        comentarioButton.setToolTipText("Añadir comentario");
        comentarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comentarioButtonActionPerformed(evt);
            }
        });

        borrarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/delete.png"))); // NOI18N
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
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(queryTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(trueRadioButton)
                    .add(falseRadioButton)
                    .add(comentarioButton)
                    .add(borrarButton)
                    .add(duplicarButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void comentarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comentarioButtonActionPerformed
// TODO add your handling code here:
    System.out.println("pos"+this.getPosicion());
    frameComent.setVisible(true);
}//GEN-LAST:event_comentarioButtonActionPerformed

private void borrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarButtonActionPerformed
// TODO add your handling code here:
   this.setVisible(false);
   int finalPos=0;
   int p = this.getPosicion();
   int total = this.getParent().getComponentCount();
   for(int i=p+1;i<total;i++){
        TestInstancesTFJPanel panel = (TestInstancesTFJPanel) this.getParent().getComponent(i);
        int pos = panel.getPosicion();
        panel.setPosicion(pos-1);
        finalPos=pos-1;
   }
   TestInstancesTFJPanel pa = new TestInstancesTFJPanel();
   pa.setPosicion(finalPos+1);
   this.getParent().add(pa);
   this.getParent().remove(this);
}//GEN-LAST:event_borrarButtonActionPerformed

private void duplicarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duplicarButtonActionPerformed
// TODO add your handling code here:
     int tam = this.getParent().getComponentCount();
     String query = this.getQuery();
     String result = this.isTestTrue();
     TestInstancesTFJPanel panel = new TestInstancesTFJPanel();
     panel.setQuery(query);
     if(result.equals("true")){
        panel.setTrueTest(true);
     }else{
        panel.setFalseTest(true);
     }
     panel.setComment(this.frameComent);
     int pos = this.getPosicion();
     panel.setPosicion(pos+1);
     if(pos+2==tam){
         this.getParent().add(panel);
     }else{
        this.getParent().add(panel, pos+2);
     }
     int total = this.getParent().getComponentCount();
     for(int i=pos+3;i<total;i++){
            TestInstancesTFJPanel p = (TestInstancesTFJPanel) this.getParent().getComponent(i);
            int po = p.getPosicion();
            p.setPosicion(po+1);
       }  
     this.getParent().validate();
}//GEN-LAST:event_duplicarButtonActionPerformed

private void queryTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_queryTextFieldMouseClicked
// TODO add your handling code here:
    getQueryTextField().setForeground(Color.BLACK);   
    int pos = this.getPosicion();
    int tamInst = this.getParent().getComponentCount();
    if(pos+2==tamInst){
         for(int i=0;i<9;i++){
            this.getParent().add(new TestInstancesTFJPanel());
         }
    }
    this.getParent().validate();
}//GEN-LAST:event_queryTextFieldMouseClicked

public boolean consultaCompletaEnAyuda(){
    if((!this.getQuery().equals("") && this.ningunoSeleccionado()==true) ||
        this.getQuery().equals("") && this.ningunoSeleccionado()==false){
        return false;
    }else{
        return true;
    }
}

public boolean panelVacio(){
    if(this.getQuery().equals("") && this.ningunoSeleccionado()==true){
        return true;
    }else{
        return false;
    }
}

public void setQuery(String query){
    getQueryTextField().setText(query);
}

public String getQuery(){
    return getQueryTextField().getText();
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

public boolean ningunoSeleccionado(){
    if(falseRadioButton.isSelected()==false && trueRadioButton.isSelected()==false){
        return true;
    }else{
        return false;
    }
}

public void setTrueTest(boolean testT) {
    trueRadioButton.setSelected(testT);
}

public void setFalseTest(boolean testF) {
    falseRadioButton.setSelected(testF);
}

public AddComentJDialog getComment() {
    return frameComent;
}

public void setComment(AddComentJDialog comment) {
    this.frameComent = comment;
}

public javax.swing.JTextField getQueryTextField() {
    return queryTextField;
}

public int getPosicion() {
    return posicion;
}

public void setPosicion(int aPosicion) {
    posicion = aPosicion;
}

public static int getContadorInstSat() {
    return contadorInstSat;
}

public static void setContadorInstSat(int aContadorInst) {
    contadorInstSat = aContadorInst;
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrarButton;
    private javax.swing.JButton comentarioButton;
    private javax.swing.JButton duplicarButton;
    private javax.swing.JRadioButton falseRadioButton;
    private javax.swing.JTextField queryTextField;
    private javax.swing.JRadioButton trueRadioButton;
    // End of variables declaration//GEN-END:variables
    
}