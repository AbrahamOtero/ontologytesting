/*
 * MainJPanel.java
 *
 * Created on 25 de junio de 2008, 1:27
 */

package code.google.com.p.ontologytesting.gui;

import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import code.google.com.p.ontologytesting.model.CollectionTest;
import javax.swing.ButtonGroup;

/**
 *
 * @author  sara.garcia
 */
public class MainJPanel extends javax.swing.JPanel {

    public static void setExistsTestsCheckBox(Boolean aExistsTestsCheckBox) {
        getNewTest().setSelected(aExistsTestsCheckBox);
    }
    public static void setNewInstancesCheckBox(Boolean aNewInstancesCheckBox) {
        getNewInstances().setSelected(aNewInstancesCheckBox);
    }
    public static void setNewTestCheckBox(Boolean aNewTestCheckBox) {
        getNewTest().setSelected(aNewTestCheckBox);
    }
    public static void setConfigurarCheckBox(Boolean aConfCheckBox) {
        configurar.setSelected(aConfCheckBox);
    }
    public static void setSparqlCheckBox(Boolean aSparqlCheckBox) {
        getSparql().setSelected(aSparqlCheckBox);
    }
    public static String getFisicalOntologyTextField() {
        return fisicalOntologyTextField.getText();
    }
    public static String getNamespaceOntologyTextField() {
        return namespaceOntologyTextField.getText();
    }
    public static boolean isSeleccionado() {
        return seleccionado;
    }
    public static void setSeleccionado(boolean aSeleccionado) {
        seleccionado = aSeleccionado;
    }
    public static CollectionTest getCollectionTest() {
        return collectionTest;
    }
    public static void setCollectionTest(CollectionTest aCollectionTest) {
        collectionTest = aCollectionTest;
    }
    private static CollectionTest collectionTest;
    public static javax.swing.JRadioButton getNewInstances() {
        return newInstances;
    }
    public static javax.swing.JRadioButton getNewTest() {
        return newTest;
    }
    public static javax.swing.JRadioButton getSparql() {
        return sparql;
    }
    private JFileChooser filechooser;
    private Component frame;
    public static boolean seleccionado;

    /** Creates new form MainJPanel */
    public MainJPanel() {
        initComponents();
        setSeleccionado(true);
        ButtonGroup group = new ButtonGroup();
        group.add(sparql);
        group.add(newInstances);
        group.add(newTest);
        group.add(configurar);
        namespaceOntologyTextField.setText("http://www.owl-ontologies.com/family.owl#");
        collectionTest = new CollectionTest();
        if(ConfigurationJPanel.isHaSidoConfigurado()==true){
            MainJPanel.getNewInstances().setEnabled(true);
            MainJPanel.getNewTest().setEnabled(true);
            MainJPanel.getSparql().setEnabled(true);
        }else{
            MainJPanel.getNewInstances().setEnabled(false);
            MainJPanel.getNewTest().setEnabled(false);
            MainJPanel.getSparql().setEnabled(false);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fisicalOntologyTextField = new javax.swing.JTextField();
        examinarFisicalButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        namespaceOntologyTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        newTest = new javax.swing.JRadioButton();
        sparql = new javax.swing.JRadioButton();
        newInstances = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        configurar = new javax.swing.JRadioButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("¡¡BIENVENIDO AL EVALUADOR DE ONTOLOGÍAS!!");

        jLabel2.setText("Rellene los siguientes campos:");

        jLabel3.setText("Introduzca la ubicación de la ontología a evaluar:");

        examinarFisicalButton.setText("Examinar");
        examinarFisicalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examinarFisicalButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Introduzca el namespace de la misma:");

        jLabel5.setText("Seleccione las acciones que desea realizar:");

        newTest.setText("Crear Tests Simples");

        sparql.setText("Crear Tests SPARQL");

        newInstances.setText("Crear Instancias");

        jLabel6.setText("Configure la aplicación:");

        configurar.setText("Configurar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(313, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(403, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(418, 418, 418))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(388, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(namespaceOntologyTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                            .addComponent(fisicalOntologyTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(examinarFisicalButton)
                        .addGap(222, 222, 222))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newInstances)
                        .addContainerGap(548, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sparql)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(259, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newTest)
                        .addContainerGap(534, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(configurar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(examinarFisicalButton)
                    .addComponent(fisicalOntologyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namespaceOntologyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(configurar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(newTest)
                .addGap(3, 3, 3)
                .addComponent(sparql)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newInstances)
                .addGap(39, 39, 39))
        );

        getAccessibleContext().setAccessibleName("card2");
    }// </editor-fold>//GEN-END:initComponents
  
private void examinarFisicalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinarFisicalButtonActionPerformed
// TODO add your handling code here:
    openFile(fisicalOntologyTextField);
}//GEN-LAST:event_examinarFisicalButtonActionPerformed

public static void actualizarEstado(){
    if(ConfigurationJPanel.isHaSidoConfigurado()==true){
            MainJPanel.getNewInstances().setEnabled(true);
            MainJPanel.getNewTest().setEnabled(true);
            MainJPanel.getSparql().setEnabled(true);
    }else{
            MainJPanel.getNewInstances().setEnabled(false);
            MainJPanel.getNewTest().setEnabled(false);
            MainJPanel.getSparql().setEnabled(false);
    }
}

private void openFile(JTextField textfield){
      filechooser = new JFileChooser("./data/");
      int option = filechooser.showOpenDialog(frame);
      if (option == JFileChooser.APPROVE_OPTION) {
          File selectedFile = filechooser.getSelectedFile();
          textfield.setText(selectedFile.getPath());
      }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JRadioButton configurar;
    private javax.swing.JButton examinarFisicalButton;
    private static javax.swing.JTextField fisicalOntologyTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private static javax.swing.JTextField namespaceOntologyTextField;
    private static javax.swing.JRadioButton newInstances;
    private static javax.swing.JRadioButton newTest;
    private static javax.swing.JRadioButton sparql;
    // End of variables declaration//GEN-END:variables


    public static boolean getNewInstancesState() {
        return getNewInstances().isSelected();
    }

    public static boolean getNewTestState() {
        return getNewTest().isSelected();
    }
    
    public static boolean getConfigurarState() {
        return configurar.isSelected();
    }

    public static boolean getSparqlState() {
        return getSparql().isSelected();
    }

}
