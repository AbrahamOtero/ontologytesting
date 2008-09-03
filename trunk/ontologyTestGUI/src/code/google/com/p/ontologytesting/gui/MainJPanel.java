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
import java.awt.BorderLayout;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author  sara.garcia
 */
public class MainJPanel extends javax.swing.JPanel {

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
    private static boolean simpleTestSelect=false, sparqlTestsSelect=false,
            instancesSelect=false;

    public static boolean getSimpleTestSelect() {
        return simpleTestSelect;
    }

    public static void setSimpleTestSelect(boolean aSimpleTestSelect) {
        simpleTestSelect = aSimpleTestSelect;
    }

    public static boolean getSparqlTestsSelect() {
        return sparqlTestsSelect;
    }
    public static void setSparqlTestsSelect(boolean aSparqlTestsSelect) {
        sparqlTestsSelect = aSparqlTestsSelect;
    }
    public static boolean getInstancesSelect() {
        return instancesSelect;
    }
    public static void setInstancesSelect(boolean aInstancesSelect) {
        instancesSelect = aInstancesSelect;
    }
    Frame parent;
    private JFileChooser filechooser;
    private Component frame;
    public static boolean seleccionado;

    /** Creates new form MainJPanel */
    public MainJPanel(int vez) {
        initComponents();
        setSeleccionado(true);
        if(vez==0){
            newInstances.setEnabled(false);
            newTest.setEnabled(false);
            sparql.setEnabled(false);
            namespaceOntologyTextField.setText("http://www.owl-ontologies.com/family.owl#");
            collectionTest = new CollectionTest();
        }else{
            namespaceOntologyTextField.setText("http://www.owl-ontologies.com/family.owl#");
            collectionTest = new CollectionTest();
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
        jLabel6 = new javax.swing.JLabel();
        configurar = new javax.swing.JButton();
        newTest = new javax.swing.JButton();
        sparql = new javax.swing.JButton();
        newInstances = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

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

        jLabel6.setText("Configure la aplicación:");

        configurar.setText("Configurar");
        configurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configurarActionPerformed(evt);
            }
        });

        newTest.setText("Crear Tests Simples");
        newTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTestActionPerformed(evt);
            }
        });

        sparql.setText("Crear Tests SPARQL");
        sparql.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sparqlActionPerformed(evt);
            }
        });

        newInstances.setText("Crear Instancias");
        newInstances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newInstancesActionPerformed(evt);
            }
        });

        jLabel7.setText("Para realizar consultas simples a su ontología, seleccione esta opción: ");

        jLabel8.setText("Para probar su ontología utlilizando el lenguaje de consultas SPARQL, seleccione esta opción: ");

        jLabel9.setText("Si solo desea crear conjuntos de instancias para futuras pruebas, seleccione esta opción:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(configurar)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(635, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(725, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                        .addGap(418, 418, 418))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(710, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(namespaceOntologyTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fisicalOntologyTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(examinarFisicalButton)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(newTest))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(567, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(sparql, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(newInstances))
                            .addComponent(jLabel9))
                        .addContainerGap(547, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(581, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {newInstances, newTest, sparql});

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
                    .addComponent(fisicalOntologyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(examinarFisicalButton))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namespaceOntologyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(configurar)
                .addGap(47, 47, 47)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newTest)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sparql)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newInstances)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {newInstances, newTest, sparql});

        getAccessibleContext().setAccessibleName("card2");
    }// </editor-fold>//GEN-END:initComponents
  
private void examinarFisicalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinarFisicalButtonActionPerformed
// TODO add your handling code here:
    openFile(fisicalOntologyTextField);
}//GEN-LAST:event_examinarFisicalButtonActionPerformed

private void configurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configurarActionPerformed
// TODO add your handling code here:
    ContentMainJFrame.getContentPanel().remove(0);//GEN-LAST:event_configurarActionPerformed
    ContentMainJFrame.getContentPanel().add(new ConfigurationJPanel());
    ContentMainJFrame.getSeparador().setVisible(true);
    ContentMainJFrame.getSeparadorPanel().add(new SeparatorConfigPanel(),BorderLayout.CENTER);
    ContentMainJFrame.getContentPanel().getParent().validate();
}                                          

private void newTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTestActionPerformed
// TODO add your handling code here:
    if(getFisicalOntologyTextField().equals("") || getNamespaceOntologyTextField().equals("")){
        JOptionPane.showMessageDialog(frame,"Ambos campos Ubicacion Fisica y Namespace " +
                "son obligatorios","Warning Message",JOptionPane.WARNING_MESSAGE);
    }else if(!getFisicalOntologyTextField().endsWith(".owl")){
         JOptionPane.showMessageDialog(frame,"La ontologia debe de ser un archivo " +
                 ".owl","Warning Message",JOptionPane.WARNING_MESSAGE);
    }else{
        ContentMainJFrame.getContentPanel().remove(0);
        ContentMainJFrame.getContentPanel().add(new GroupTestsJPanel(8));
        ContentMainJFrame.getSeparador().setVisible(true);
        ContentMainJFrame.getSeparadorPanel().add(new SeparatorTestsPanel(),BorderLayout.CENTER);
        ContentMainJFrame.getContentPanel().getParent().validate();
        setSimpleTestSelect(true);
    }
}//GEN-LAST:event_newTestActionPerformed

private void sparqlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sparqlActionPerformed
// TODO add your handling code here:
    if(getFisicalOntologyTextField().equals("") || getNamespaceOntologyTextField().equals("")){
       JOptionPane.showMessageDialog(frame,"Ambos campos Ubicacion Fisica y Namespace " +
                "son obligatorios","Warning Message",JOptionPane.WARNING_MESSAGE);
    }else if(!getFisicalOntologyTextField().endsWith(".owl")){
         JOptionPane.showMessageDialog(frame,"La ontologia debe de ser un archivo " +
                 ".owl","Warning Message",JOptionPane.WARNING_MESSAGE);
    }else{
        AddSPARQLJPanel.setSeleccionado(true);
        ContentMainJFrame.getContentPanel().remove(0);
        ContentMainJFrame.getContentPanel().add(new AddSPARQLJPanel());
        ContentMainJFrame.getSeparador().setVisible(true);
        ContentMainJFrame.getSeparadorPanel().add(new SeparatorTestsPanel(),BorderLayout.CENTER);
        ContentMainJFrame.getContentPanel().getParent().validate();
        setSparqlTestsSelect(true);
    }
}//GEN-LAST:event_sparqlActionPerformed

private void newInstancesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newInstancesActionPerformed
// TODO add your handling code here:
    AddInstancesClasPropJDialog addInstances = new AddInstancesClasPropJDialog(parent,true,8,0);
    ContentMainJFrame.getContentPanel().remove(0);
    ContentMainJFrame.getContentPanel().add(addInstances.getContentPanel());
    ContentMainJFrame.getSeparador().setVisible(true);
    ContentMainJFrame.getContentPanel().getParent().validate();
    setInstancesSelect(true);
}//GEN-LAST:event_newInstancesActionPerformed


private void openFile(JTextField textfield){
      filechooser = new JFileChooser("./data/");
      int option = filechooser.showOpenDialog(frame);
      if (option == JFileChooser.APPROVE_OPTION) {
          File selectedFile = filechooser.getSelectedFile();
          textfield.setText(selectedFile.getPath());
      }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton configurar;
    private javax.swing.JButton examinarFisicalButton;
    private static javax.swing.JTextField fisicalOntologyTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private static javax.swing.JTextField namespaceOntologyTextField;
    private javax.swing.JButton newInstances;
    private javax.swing.JButton newTest;
    private javax.swing.JButton sparql;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getNewInstances() {
        return newInstances;
    }

    public javax.swing.JButton getNewTest() {
        return newTest;
    }

    public javax.swing.JButton getSparql() {
        return sparql;
    }


}
