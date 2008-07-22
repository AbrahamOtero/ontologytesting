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

/**
 *
 * @author  sara.garcia
 */
public class MainJPanel extends javax.swing.JPanel {

    public static void setExistsTestsCheckBox(Boolean aExistsTestsCheckBox) {
        newTestChekBox.setSelected(aExistsTestsCheckBox);
    }
    public static void setNewInstancesCheckBox(Boolean aNewInstancesCheckBox) {
        newInstancesCheckBox.setSelected(aNewInstancesCheckBox);
    }
    public static void setNewTestCheckBox(Boolean aNewTestCheckBox) {
        newTestChekBox.setSelected(aNewTestCheckBox);
    }
    public static void setSparqlCheckBox(Boolean aSparqlCheckBox) {
        sparqlCheckBox.setSelected(aSparqlCheckBox);
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
    private JFileChooser filechooser;
    private Component frame;
    public static boolean seleccionado;

    /** Creates new form MainJPanel */
    public MainJPanel() {
        initComponents();
        setSeleccionado(true);
        namespaceOntologyTextField.setText("http://www.owl-ontologies.com/family.owl#");
        collectionTest = new CollectionTest();
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
        newInstancesCheckBox = new javax.swing.JCheckBox();
        sparqlCheckBox = new javax.swing.JCheckBox();
        newTestChekBox = new javax.swing.JCheckBox();

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

        newInstancesCheckBox.setText("Crear conjunto de instancias");

        sparqlCheckBox.setText("Realizar consultas SPARQL");

        newTestChekBox.setText("Crear Tests");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sparqlCheckBox)
                        .addContainerGap())
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(newInstancesCheckBox)
                            .addContainerGap())
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(259, Short.MAX_VALUE))
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
                                .addComponent(newTestChekBox)
                                .addContainerGap(572, Short.MAX_VALUE))))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(newTestChekBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newInstancesCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sparqlCheckBox)
                .addGap(93, 93, 93))
        );

        getAccessibleContext().setAccessibleName("card2");
    }// </editor-fold>//GEN-END:initComponents
  
private void examinarFisicalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinarFisicalButtonActionPerformed
// TODO add your handling code here:
    openFile(fisicalOntologyTextField);
}//GEN-LAST:event_examinarFisicalButtonActionPerformed


private void openFile(JTextField textfield){
      filechooser = new JFileChooser("./");
      int option = filechooser.showOpenDialog(frame);
      if (option == JFileChooser.APPROVE_OPTION) {
          File selectedFile = filechooser.getSelectedFile();
          textfield.setText(selectedFile.getPath());
      }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton examinarFisicalButton;
    private static javax.swing.JTextField fisicalOntologyTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private static javax.swing.JTextField namespaceOntologyTextField;
    private static javax.swing.JCheckBox newInstancesCheckBox;
    private static javax.swing.JCheckBox newTestChekBox;
    private static javax.swing.JCheckBox sparqlCheckBox;
    // End of variables declaration//GEN-END:variables


    public static boolean getNewInstancesState() {
        return newInstancesCheckBox.isSelected();
    }

    public static boolean getNewTestState() {
        return newTestChekBox.isSelected();
    }

    public static boolean getSparqlState() {
        return sparqlCheckBox.isSelected();
    }

}