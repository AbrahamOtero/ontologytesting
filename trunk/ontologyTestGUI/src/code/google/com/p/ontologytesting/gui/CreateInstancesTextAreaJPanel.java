/*
 * CreateInstancesTextAreaJPanel.java
 *
 * Created on 1 de agosto de 2008, 12:22
 */

package code.google.com.p.ontologytesting.gui;

/**
 *
 * @author  sara.garcia
 */
public class CreateInstancesTextAreaJPanel extends javax.swing.JPanel {

    /** Creates new form CreateInstancesTextAreaJPanel */
    public CreateInstancesTextAreaJPanel() {
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
        jScrollPane16 = new javax.swing.JScrollPane();
        claseTextArea = new javax.swing.JTextArea();
        jScrollPane17 = new javax.swing.JScrollPane();
        propiedadTextArea = new javax.swing.JTextArea();

        jLabel1.setText("                      INSTANCIAS DE CLASE                                                                    INSTANCIAS DE PROPIEDAD  ");

        claseTextArea.setColumns(20);
        claseTextArea.setRows(5);
        jScrollPane16.setViewportView(claseTextArea);

        propiedadTextArea.setColumns(20);
        propiedadTextArea.setRows(5);
        jScrollPane17.setViewportView(propiedadTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(85, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane16, jScrollPane17});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane16, jScrollPane17});

    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea claseTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JTextArea propiedadTextArea;
    // End of variables declaration//GEN-END:variables

    public String getClaseTextArea() {
        return claseTextArea.getText();
    }

    public void setClaseTextArea(String aclaseTextArea) {
        claseTextArea.setText(aclaseTextArea);
    }

    public String getPropiedadTextArea() {
        return propiedadTextArea.getText();
    }

    public void setPropiedadTextArea(String apropiedadTextArea) {
        propiedadTextArea.setText(apropiedadTextArea);
    }

}
