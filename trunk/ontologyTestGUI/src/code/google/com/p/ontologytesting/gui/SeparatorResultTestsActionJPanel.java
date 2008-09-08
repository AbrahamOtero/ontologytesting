/*
 * ResultTestsActionJPanel.java
 *
 * Created on 30 de agosto de 2008, 21:18
 */

package code.google.com.p.ontologytesting.gui;

import code.google.com.p.ontologytesting.model.ClassInstances;
import code.google.com.p.ontologytesting.model.CollectionTest;
import code.google.com.p.ontologytesting.model.Instancias;
import code.google.com.p.ontologytesting.model.OntologyTestCase;
import code.google.com.p.ontologytesting.model.PropertyInstances;
import code.google.com.p.ontologytesting.model.QueryOntology;
import code.google.com.p.ontologytesting.model.ScenarioTest;
import code.google.com.p.ontologytesting.model.SparqlQueryOntology;
import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author  saruskas
 */
public class SeparatorResultTestsActionJPanel extends javax.swing.JPanel {
    private Component frame;
    private Component comp;

    /** Creates new form ResultTestsActionJPanel */
    public SeparatorResultTestsActionJPanel() {
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

        inicioButton = new javax.swing.JButton();
        newSimpleTestButton = new javax.swing.JButton();
        newSparqlTestButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        salirButton = new javax.swing.JButton();
        guardarButton = new javax.swing.JButton();

        inicioButton.setText("Ir a Inicio");
        inicioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioButtonActionPerformed(evt);
            }
        });

        newSimpleTestButton.setText("Nuevo Test Simple");
        newSimpleTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSimpleTestButtonActionPerformed(evt);
            }
        });

        newSparqlTestButton.setText("Nuevo Test SPARQL");
        newSparqlTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSparqlTestButtonActionPerformed(evt);
            }
        });

        printButton.setText("Ver Tests Realizados");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        salirButton.setText("Salir");
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        guardarButton.setText("Guardar Informe");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inicioButton)
                .addGap(18, 18, 18)
                .addComponent(salirButton)
                .addGap(56, 56, 56)
                .addComponent(newSimpleTestButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newSparqlTestButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(printButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(guardarButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inicioButton)
                    .addComponent(salirButton)
                    .addComponent(newSimpleTestButton)
                    .addComponent(newSparqlTestButton)
                    .addComponent(guardarButton)
                    .addComponent(printButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
// TODO add your handling code here:
    String resultado = OntologyTestCase.getMuestra();
    if(resultado.equals("null")){
        JOptionPane.showMessageDialog(frame,"Solo es posible guardar informe de errores",
        "Warning Message",JOptionPane.WARNING_MESSAGE);
    }else{
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showSaveDialog(this);
        if(seleccion == JFileChooser.APPROVE_OPTION){
            File fichero = fileChooser.getSelectedFile();
            PrintWriter writer = null;
                try {
                    writer = new PrintWriter(fichero);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(frame,"No se puede guardar el fichero",
                            "Warning Message",JOptionPane.WARNING_MESSAGE);
                } catch(Exception e){
                    JOptionPane.showMessageDialog(frame,"No se puede guardar el fichero",
                            "Warning Message",JOptionPane.WARNING_MESSAGE);
                }
            writer.print(resultado);
            writer.close();
        }
    }
}//GEN-LAST:event_guardarButtonActionPerformed

private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
// TODO add your handling code here:
    VistaTestJFrame fram = new VistaTestJFrame();
    fram.setTitle("Resumen Tests Realizados");
    fram.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    JEditorPane editor = fram.getTestEditorPane();
    editor.setContentType("text/html");
    String result = generarInforme(); 
    editor.setText(result);
    editor.setEditable(false);
    fram.setTestEditorPane(editor);
    fram.setVisible(true);
}//GEN-LAST:event_printButtonActionPerformed

private void newSparqlTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSparqlTestButtonActionPerformed
// TODO add your handling code here:
    AddSPARQLJPanel.setSeleccionado(true);
    MainJPanel.setSimpleTestSelect(false);
    MainJPanel.setSparqlTestsSelect(true);
    ContentMainJFrame.getContentPanel().remove(0);
    ContentMainJFrame.getSeparadorPanel().remove(0);
    //Para que no te conserve los anteriores
    MainJPanel.setCollectionTest(new CollectionTest());
    ArrayList<Instancias> instancias = ContentMainJFrame.getInstancias();
    for(int i=0;i<instancias.size();i++){
        instancias.set(i, new Instancias());
    }
    ContentMainJFrame.getContentPanel().add(new AddSPARQLJPanel());
    ContentMainJFrame.getSeparador().setVisible(true);
    ContentMainJFrame.getSeparadorPanel().add(new SeparatorTestsPanel(),BorderLayout.CENTER);
    ContentMainJFrame.getContentPanel().getParent().validate();
    ContentMainJFrame.getSeparadorPanel().getParent().validate();
}//GEN-LAST:event_newSparqlTestButtonActionPerformed

private void newSimpleTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSimpleTestButtonActionPerformed
// TODO add your handling code here:
    AddSPARQLJPanel.setSeleccionado(false);
    MainJPanel.setSimpleTestSelect(true);
    MainJPanel.setSparqlTestsSelect(false);
    ContentMainJFrame.getContentPanel().remove(0);
    ContentMainJFrame.getSeparadorPanel().remove(0);
    ArrayList<Instancias> instancias = ContentMainJFrame.getInstancias();
    for(int i=0;i<instancias.size();i++){
        instancias.set(i, new Instancias());
    }
    MainJPanel.getCollectionTest().setScenariotest(new ArrayList<ScenarioTest>());
    ContentMainJFrame.getContentPanel().add(new GroupTestsJPanel(8));
    ContentMainJFrame.getSeparador().setVisible(true);
    ContentMainJFrame.getSeparadorPanel().add(new SeparatorTestsPanel(),BorderLayout.CENTER);
    ContentMainJFrame.getContentPanel().getParent().validate();
    ContentMainJFrame.getSeparadorPanel().getParent().validate();
}//GEN-LAST:event_newSimpleTestButtonActionPerformed

private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
// TODO add your handling code here:
    int n = JOptionPane.showConfirmDialog(comp, "¿Desea salir de la aplicacion?", "Exit",JOptionPane.YES_NO_OPTION);
    if (n == JOptionPane.YES_OPTION){
        System.exit(0);
    }
}//GEN-LAST:event_salirButtonActionPerformed

private void inicioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioButtonActionPerformed
// TODO add your handling code here:
    ContentMainJFrame.getContentPanel().remove(0);
    ContentMainJFrame.getSeparadorPanel().remove(0);
    CollectionTest coll = new CollectionTest();
    coll.setScenariotest(new ArrayList<ScenarioTest>());
    coll.setNamespace("");
    coll.setOntology("");
    MainJPanel.setCollectionTest(coll);
    ContentMainJFrame.getContentPanel().add(new MainJPanel(1));
    ContentMainJFrame.getSeparador().setVisible(false);
    ContentMainJFrame.getContentPanel().validate();
    ContentMainJFrame.getSeparadorPanel().validate();
    MainJPanel.setSimpleTestSelect(false);
    MainJPanel.setSparqlTestsSelect(false);
    AddSPARQLJPanel.setSeleccionado(false);
}//GEN-LAST:event_inicioButtonActionPerformed

public String generarInforme(){
    String res="<html>";
    ArrayList<ScenarioTest> scenario = MainJPanel.getCollectionTest().getScenariotest();
    for(int i=0;i<scenario.size();i++){
        res = res + "<b>Nombre: </b>"+scenario.get(i).getNombre();
        res = res + "<br><br><b>Descripcion: </b>"+scenario.get(i).getDescripcion();
        res = res + "<br><br><b>Instancias Asociadas</b><br>";
        Instancias inst = scenario.get(i).getInstancias();
        ArrayList<ClassInstances> clas = inst.getClassInstances();
        ArrayList<PropertyInstances> prop = inst.getPropertyInstances();
        if(clas.size()!=0){
        res = res + "<br><u>Instancias de Clase</u><br>";
        for(int j=0;j<clas.size();j++){
            String clase = clas.get(j).getClassInstance();
            String coment = clas.get(j).getComment();
            if(!clase.equals("")){
                res = res + clase;
            }
            if(!coment.equals("")){
                res = res + "   " +coment + "<br>";
            }else {
                res = res + "<br>";
            } 
        }
        }else{
            res = res + "Test sin instancias de clase<br>";
        }
        if(prop.size()!=0){
        res = res + "<br><u>Instancias de Propiedad</u><br>";
        for(int k=0;k<prop.size();k++){
            String propiedad = prop.get(k).getPropertyInstance();
            String coment = prop.get(k).getComment();
            if(!propiedad.equals("")){
                res = res + propiedad;
            }
            if(!coment.equals("")){
                res = res + "  " +coment + "<br>";
            }else {
                res = res + "<br>";
            }
        }
        }else{
            res = res + "Test sin instancias de propiedad<br>";
        }
        ArrayList<QueryOntology> simpleT = scenario.get(i).getQueryTest();
        if(simpleT.size()!=0){
            res = res + "<br><b>Tests Simples</b><br><br>";
            for(int l=0;l<simpleT.size();l++){
                res = res + "<u>Consulta realizada:</u> "+simpleT.get(l).getQuery()+"<br>";
                res = res + "<u>Resultado esperado:</u> "+simpleT.get(l).getResultexpected()+"<br>";
                String c = simpleT.get(l).getComment();
                if(!c.equals("")){
                    res = res + "Comentario: "+c;
                }else{
                    res = res + "<br>";
                }
            }
        }
        ArrayList<SparqlQueryOntology> sparqlT = scenario.get(i).getSparqlQuerys();
        if(sparqlT.size()!=0){
            res = res + "<br><b>Tests Sparql</b><br><br>";
            for(int l=0;l<sparqlT.size();l++){
                res = res + "<u>Consulta realizada: </u><br>"+sparqlT.get(l).getQuerySparql()+"<br><br>";
                res = res + "<u>Resultado esperado: </u><br>"+sparqlT.get(l).getResultexpected()+"<br><br>";
            }
        }
        res = res + "------------------------------------------<br>";
    }
    return res+"</html>";
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guardarButton;
    private javax.swing.JButton inicioButton;
    private javax.swing.JButton newSimpleTestButton;
    private javax.swing.JButton newSparqlTestButton;
    private javax.swing.JButton printButton;
    private javax.swing.JButton salirButton;
    // End of variables declaration//GEN-END:variables

}