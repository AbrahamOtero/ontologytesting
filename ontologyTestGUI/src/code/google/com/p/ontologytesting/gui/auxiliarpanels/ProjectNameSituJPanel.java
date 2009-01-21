/*
 * ProjectNameSituJPanel.java
 *
 * Created on 6 de octubre de 2008, 10:06
 */

package code.google.com.p.ontologytesting.gui.auxiliarpanels;

import code.google.com.p.ontologytesting.gui.Configuration;
import code.google.com.p.ontologytesting.gui.auxiliarclasess.FileChooserSelector;
import java.util.Locale;

/**
 *
 * @author  sara.garcia
 */
public class ProjectNameSituJPanel extends javax.swing.JPanel {

    private boolean state;
    private String nombreP="", ubicP="";
    private FileChooserSelector utils;
    
    /** Creates new form ProjectNameSituJPanel */
    public ProjectNameSituJPanel() {
        initComponents();
        utils = new FileChooserSelector();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        nombreProyectoTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ubicacionProyectoTextField = new javax.swing.JTextField();
        examinarProyecto = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        carpetaProyectoTextField = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText(java.util.ResourceBundle.getBundle(Configuration.getPropiedades().getProperty("IDIOMA"),new Locale(Configuration.getPropiedades().getProperty("LOCALE"))).getString("Proyecto:_Nombre_y_Localizacion"));

        jLabel2.setText(java.util.ResourceBundle.getBundle(Configuration.getPropiedades().getProperty("IDIOMA"),new Locale(Configuration.getPropiedades().getProperty("LOCALE"))).getString("Nombre_del_Proyecto:"));

        nombreProyectoTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreProyectoTextFieldKeyPressed(evt);
            }
        });

        jLabel3.setText(java.util.ResourceBundle.getBundle(Configuration.getPropiedades().getProperty("IDIOMA"),new Locale(Configuration.getPropiedades().getProperty("LOCALE"))).getString("Ubicacion_del_Proyecto:"));

        examinarProyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/folder_explore.png"))); // NOI18N
        examinarProyecto.setText(java.util.ResourceBundle.getBundle(Configuration.getPropiedades().getProperty("IDIOMA"),new Locale(Configuration.getPropiedades().getProperty("LOCALE"))).getString("Examinar"));
        examinarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examinarProyectoActionPerformed(evt);
            }
        });

        jLabel4.setText(java.util.ResourceBundle.getBundle(Configuration.getPropiedades().getProperty("IDIOMA"),new Locale(Configuration.getPropiedades().getProperty("LOCALE"))).getString("Carpeta_del_Proyecto:"));

        carpetaProyectoTextField.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)
                                .addComponent(nombreProyectoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(ubicacionProyectoTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(26, 26, 26)
                                .addComponent(carpetaProyectoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(examinarProyecto)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {nombreProyectoTextField, ubicacionProyectoTextField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreProyectoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ubicacionProyectoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(examinarProyecto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carpetaProyectoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {nombreProyectoTextField, ubicacionProyectoTextField});

    }

private void nombreProyectoTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreProyectoTextFieldKeyPressed
// TODO add your handling code here:
    if(!carpetaProyectoTextField.getText().equals("")){//GEN-LAST:event_nombreProyectoTextFieldKeyPressed
        carpetaProyectoTextField.setText(FileChooserSelector.getPathSelected()+"\\"+getNombreProyectoTextField());
    }
}

private void examinarProyectoActionPerformed(java.awt.event.ActionEvent evt) {                                                 
// TODO add your handling code here:
     boolean res = utils.fileChooser(true, false, false);
     if(res == true){
        this.getUbicacionProyectoTextField().setText(FileChooserSelector.getPathSelected());    
        carpetaProyectoTextField.setText(FileChooserSelector.getPathSelected()+"\\"+getNombreProyectoTextField());
     }
}                                                                                                

public boolean isState() {
    return state;
}

public void setState(boolean state) {
    this.state = state;
}

public String getNombreProyectoTextField() {
    return nombreProyectoTextField.getText();
}

public String getUbicacionProyecto() {
    return ubicacionProyectoTextField.getText();
}

public String getNombreP() {
    return nombreP;
}

public void setNombreP(String nombreP) {
    this.nombreP = nombreP;
}

public String getUbicP() {
    return ubicP;
}

public void setUbicP(String ubicP) {
    this.ubicP = ubicP;
}

public javax.swing.JTextField getUbicacionProyectoTextField() {
    return ubicacionProyectoTextField;
}

public String getCarpetaProyectoTextField() {
    return carpetaProyectoTextField.getText();
}

public void setCarpetaProyectoTextField(String carpeta) {
    carpetaProyectoTextField.setText(carpeta);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField carpetaProyectoTextField;
    private javax.swing.JButton examinarProyecto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nombreProyectoTextField;
    private javax.swing.JTextField ubicacionProyectoTextField;
    // End of variables declaration//GEN-END:variables
    
}
