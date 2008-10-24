/*
 * CreateInstancesJPanel.java
 *
 * Created on 19 de mayo de 2008, 19:05
 */

package code.google.com.p.ontologytesting.guiNew;

import java.awt.Frame;
import javax.swing.WindowConstants;


/**
 *
 * @author  Saruskas
 */
public class CreateInstancesJPanel extends javax.swing.JPanel {

    private AddComentJDialog frameComent; 
    private Frame frame;
    private int posicion;
    private static int contadorClas=0,contadorProp=0,tab;
    
    /** Creates new form CreateInstancesJPanel */
    public CreateInstancesJPanel(int type) {
        initComponents();
        frame = new Frame();
        if(type==0){
            int pos = CreateInstancesJPanel.getContadorClas();
            this.setPosicion(pos);
            int cont = pos+1;
            CreateInstancesJPanel.setContadorClas(cont);
        }else if(type==1){
            int pos = CreateInstancesJPanel.getContadorProp();
            this.setPosicion(pos);
            int cont = pos+1;
            CreateInstancesJPanel.setContadorProp(cont);
        }
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

        instanciaTextField = new javax.swing.JTextField();
        comentarioButton = new javax.swing.JButton();
        borrarButton = new javax.swing.JButton();
        duplicarButton = new javax.swing.JButton();
        selectedCheckBox = new javax.swing.JCheckBox();

        setName("instances"); // NOI18N

        instanciaTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                instanciaTextFieldMouseClicked(evt);
            }
        });

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
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(instanciaTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .add(18, 18, 18)
                .add(comentarioButton)
                .add(18, 18, 18)
                .add(borrarButton)
                .add(18, 18, 18)
                .add(duplicarButton)
                .add(18, 18, 18)
                .add(selectedCheckBox)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(instanciaTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(duplicarButton)
                        .add(borrarButton)
                        .add(comentarioButton))
                    .add(layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(selectedCheckBox)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("instances");
    }// </editor-fold>//GEN-END:initComponents

private void comentarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comentarioButtonActionPerformed
// TODO add your handling code here:
    frameComent.setVisible(true);
}//GEN-LAST:event_comentarioButtonActionPerformed

private void borrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarButtonActionPerformed
// TODO add your handling code here:
   this.setVisible(false);
   if(getTab() == 0){
       int finalPos=0;
       int p = this.getPosicion();
       int total = this.getParent().getComponentCount();
       for(int i=p+1;i<total;i++){
            CreateInstancesJPanel panel = (CreateInstancesJPanel) this.getParent().getComponent(i);
            int pos = panel.getPosicion();
            panel.setPosicion(pos-1);
            finalPos=pos-1;
       }
       CreateInstancesJPanel pa = new CreateInstancesJPanel(0);
       pa.setPosicion(finalPos+1);
       this.getParent().add(pa);
       this.getParent().remove(this);
   }else if(getTab() == 1){
       int finalPos=0;
       int p = this.getPosicion();
       int total = this.getParent().getComponentCount();
       for(int i=p+1;i<total;i++){
            CreateInstancesJPanel panel = (CreateInstancesJPanel) this.getParent().getComponent(i);
            int pos = panel.getPosicion();
            panel.setPosicion(pos-1);
            finalPos=pos-1;
       }
       CreateInstancesJPanel pa = new CreateInstancesJPanel(1);
       pa.setPosicion(finalPos+1);
       this.getParent().add(pa);
       this.getParent().remove(this);
   }
}//GEN-LAST:event_borrarButtonActionPerformed

private void duplicarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duplicarButtonActionPerformed
// TODO add your handling code here:
    if(getTab()==0){
         int tam = this.getParent().getComponentCount();
         String query = this.getQuery();
         CreateInstancesJPanel panel = new CreateInstancesJPanel(0);
         panel.setInstance(query);
         int pos = this.getPosicion();
         panel.setPosicion(pos+1);
         if(pos+1==tam){
             this.getParent().add(panel);
         }else{
            this.getParent().add(panel, pos+1);
         }
         int total = this.getParent().getComponentCount();
         for(int i=pos+2;i<total;i++){
                CreateInstancesJPanel p = (CreateInstancesJPanel) this.getParent().getComponent(i);
                int po = p.getPosicion();
                p.setPosicion(po+1);
           }  
         this.getParent().validate();
    }else if(getTab()==1){
         int tam = this.getParent().getComponentCount();
         String query = this.getQuery();
         CreateInstancesJPanel panel = new CreateInstancesJPanel(1);
         panel.setInstance(query);
         int pos = this.getPosicion();
         panel.setPosicion(pos+1);
         if(pos+1==tam){
             this.getParent().add(panel);
         }else{
            this.getParent().add(panel, pos+1);
         }
         int total = this.getParent().getComponentCount();
         for(int i=pos+2;i<total;i++){
                CreateInstancesJPanel p = (CreateInstancesJPanel) this.getParent().getComponent(i);
                int po = p.getPosicion();
                p.setPosicion(po+1);
           }  
         this.getParent().validate();
    }
}//GEN-LAST:event_duplicarButtonActionPerformed

private void instanciaTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instanciaTextFieldMouseClicked
// TODO add your handling code here:
    int pos = this.getPosicion();
    int tamClas = this.getParent().getComponentCount();
    int tamProp = this.getParent().getComponentCount();
    if(getTab() == 0){
        if(pos+1==tamClas){
             for(int i=0;i<9;i++){
                this.getParent().add(new CreateInstancesJPanel(0));
             }
        }
        this.getParent().validate();
    }else if(getTab() == 1){
        if(pos+1==tamProp){
             for(int i=0;i<9;i++){
                this.getParent().add(new CreateInstancesJPanel(1));
             }
        }
        this.getParent().validate();
    }
}//GEN-LAST:event_instanciaTextFieldMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrarButton;
    private javax.swing.JButton comentarioButton;
    private javax.swing.JButton duplicarButton;
    private javax.swing.JTextField instanciaTextField;
    private javax.swing.JCheckBox selectedCheckBox;
    // End of variables declaration//GEN-END:variables

    public void setInstance(String instance){
        getInstanciaTextField().setText(instance);
    }
    
    public String getQuery(){
        return getInstanciaTextField().getText();
    }

    public AddComentJDialog getComment() {
        return frameComent;
    }

    public void setComment(AddComentJDialog comment) {
        this.frameComent = comment;
    }

    public void setInstanciaTextField(javax.swing.JTextField instanciaTextField) {
        this.instanciaTextField = instanciaTextField;
    }

    public javax.swing.JTextField getInstanciaTextField() {
        return instanciaTextField;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public boolean getSelectedCheckBox() {
        return selectedCheckBox.isSelected();
    }
    
    public static int getContadorClas() {
        return contadorClas;
    }
    
    public static void setContadorClas(int aContador) {
        contadorClas = aContador;
    }

    public static int getContadorProp() {
        return contadorProp;
    }

    public static void setContadorProp(int aContadorProp) {
        contadorProp = aContadorProp;
    }

    public static int getTab() {
        return tab;
    }

    public static void setTab(int atab) {
        tab = atab;
    }
}
