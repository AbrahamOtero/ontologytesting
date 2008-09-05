/*
 * AddSPARQLJPanel.java
 *
 * Created on 19 de mayo de 2008, 19:12
 */

package code.google.com.p.ontologytesting.gui;

import code.google.com.p.ontologytesting.exceptions.*;
import code.google.com.p.ontologytesting.jenainterfaz.Jena;
import code.google.com.p.ontologytesting.jenainterfaz.JenaInterface;
import code.google.com.p.ontologytesting.model.ClassInstances;
import code.google.com.p.ontologytesting.model.Instancias;
import code.google.com.p.ontologytesting.model.OntologyTestCase;
import code.google.com.p.ontologytesting.model.OntologyTestResult;
import code.google.com.p.ontologytesting.model.PropertyInstances;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import code.google.com.p.ontologytesting.model.ScenarioTest;
import code.google.com.p.ontologytesting.model.SparqlQueryOntology;
import code.google.com.p.ontologytesting.model.ValidarTests;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JPanel;

/**
 *
 * @author  Saruskas
 */
public class AddSPARQLJPanel extends javax.swing.JPanel {

    public static javax.swing.JButton getAntQueryButton() {
        return antQueryButton;
    }
    public static javax.swing.JButton getSigQueryButton() {
        return sigQueryButton;
    }
    public static javax.swing.JTextArea getSparqlTextArea() {
        return sparqlTextArea;
    }
    public static void setListAux(ArrayList<SparqlQueryOntology> aListAux) {
        listAux = aListAux;
    }
    private boolean nombreVacio=false,testYaExiste=false,sinConsultas=false,
            ambosNecesarios=false,noHayInsatncias=false,resultadoValido=true,sinTest=false;
    private JPanel panelTree;
    static final int desktopWidth = 700;
    static final int desktopHeight = 600;
    static JFrame frame;
    public static boolean isSeleccionado() {
        return seleccionado;
    }
    public static void setSeleccionado(boolean aSeleccionado) {
        seleccionado = aSeleccionado;
    }
    private static int posListQuerysSel = 0;
    public static boolean seleccionado;
    public static ScenarioTest scenarioTestQuery;
    public static int getContadorAnt() {
        return contadorAnt;
    }
    public static void setContadorAnt(int aContadorAnt) {
        contadorAnt = aContadorAnt;
    }
    public static int getContadorSig() {
        return contadorSig;
    }
    public static void setContadorSig(int aContadorSig) {
        contadorSig = aContadorSig;
    }
    public static void setAntQueryButton(boolean state) {
        getAntQueryButton().setEnabled(state);
    }
     public static void setSigQueryButton(boolean state) {
        getSigQueryButton().setEnabled(state);
    }
    private int aux=0;
    private static int contadorAnt = -1;
    private static int contadorSig = 1;
    public static int getPosListQuerysSel() {
            return posListQuerysSel;
    }
    public static void setPosListQuerysSel(int aPosListQuerysSel) {
        posListQuerysSel = aPosListQuerysSel;
    }
    private int contador=0;
    private int index=0;
    private boolean isAntSelected=false, isSigSelected=false;
    private static ArrayList<SparqlQueryOntology> listAux;
    private Component comp;
    private ScenarioTest scenarioSparql;
    private static ArrayList<SparqlQueryOntology> listSparqlQuerys;
    private ArrayList<ClassInstances> vaciaClase;
    private ArrayList<PropertyInstances> vaciaPropiedad;
    private Instancias instancias;
    private JenaInterface jenaInterface = new JenaInterface();   
    private Jena jena;
    
    
    /** Creates new form AddSPARQLJPanel */
    public AddSPARQLJPanel() {
        initComponents();
        
        sparqlTextArea.setLineWrap(true);
        sparqlTextArea.setWrapStyleWord(true);
        testDescTextArea.setLineWrap(true);
        testDescTextArea.setWrapStyleWord(true);
        resultTextArea.setLineWrap(true);
        resultTextArea.setWrapStyleWord(true);
        
        antQueryButton.setEnabled(false);
        sigQueryButton.setEnabled(false);
        listAux = new ArrayList<SparqlQueryOntology>();
        //scenarioTestQuery = new ScenarioTest();
        //ArrayList<ScenarioTest> scenarioT = MainJPanel.getCollectionTest().getScenariotest();
        //scenarioT.add(scenarioTestQuery);
        //MainJPanel.getCollectionTest().setScenariotest(scenarioT);
        
        instancesPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        instancesPanel.add(new AddInstancesJPanel());
        setSeleccionado(true);
        GroupTestsJPanel.setState(false);
        GroupTestsJPanel.setNewState(false); 
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
        nuevaConsultaButton = new javax.swing.JButton();
        limpiarButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        testNameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        testDescTextArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultTextArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        sparqlTextArea = new javax.swing.JTextArea();
        instancesPanel = new javax.swing.JPanel();
        sigQueryButton = new javax.swing.JButton();
        antQueryButton = new javax.swing.JButton();
        limpiarResultButton = new javax.swing.JButton();
        borrarConsultaJButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Introduzca la consulta en SPARQL:");

        nuevaConsultaButton.setText("Nueva Consulta");
        nuevaConsultaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaConsultaButtonActionPerformed(evt);
            }
        });

        limpiarButton.setText("Limpiar");
        limpiarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Introduzca el nombre del test:");

        jLabel3.setText("Añada una descripción para el test:");

        testDescTextArea.setColumns(20);
        testDescTextArea.setRows(5);
        jScrollPane2.setViewportView(testDescTextArea);

        jLabel4.setText("Resultado esperado:");

        resultTextArea.setColumns(20);
        resultTextArea.setRows(5);
        jScrollPane3.setViewportView(resultTextArea);

        sparqlTextArea.setColumns(20);
        sparqlTextArea.setRows(5);
        jScrollPane1.setViewportView(sparqlTextArea);

        org.jdesktop.layout.GroupLayout instancesPanelLayout = new org.jdesktop.layout.GroupLayout(instancesPanel);
        instancesPanel.setLayout(instancesPanelLayout);
        instancesPanelLayout.setHorizontalGroup(
            instancesPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 839, Short.MAX_VALUE)
        );
        instancesPanelLayout.setVerticalGroup(
            instancesPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 153, Short.MAX_VALUE)
        );

        sigQueryButton.setText(">>");
        sigQueryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sigQueryButtonActionPerformed(evt);
            }
        });

        antQueryButton.setText("<<");
        antQueryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                antQueryButtonActionPerformed(evt);
            }
        });

        limpiarResultButton.setText("Limpiar");
        limpiarResultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarResultButtonActionPerformed(evt);
            }
        });

        borrarConsultaJButton.setText("Borrar Consulta");
        borrarConsultaJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarConsultaJButtonActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/help.gif"))); // NOI18N
        jButton1.setText("Formatos Permitidos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(testNameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 267, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 251, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 209, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(layout.createSequentialGroup()
                                        .add(limpiarButton)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 86, Short.MAX_VALUE)
                                        .add(antQueryButton)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(sigQueryButton)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(nuevaConsultaButton)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(borrarConsultaJButton))
                                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel4)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(limpiarResultButton)
                                        .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 340, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 192, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(instancesPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 480, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 200, Short.MAX_VALUE)
                        .add(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel2)
                .add(11, 11, 11)
                .add(testNameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel1)
                            .add(jLabel4)))
                    .add(jButton1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(limpiarButton)
                    .add(layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(borrarConsultaJButton)
                            .add(nuevaConsultaButton)
                            .add(sigQueryButton)
                            .add(antQueryButton)
                            .add(limpiarResultButton))))
                .add(8, 8, 8)
                .add(instancesPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void nuevaConsultaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaConsultaButtonActionPerformed
// TODO add your handling code here:
    int posSel = getPosListQuerysSel();
    SparqlQueryOntology query = new SparqlQueryOntology();
    SparqlQueryOntology queryAux = new SparqlQueryOntology();
    if(posSel == getListAux().size() || posSel == getListAux().size()-1){
        if(!AddSPARQLJPanel.getSPARQLQuery().equals("") && !AddSPARQLJPanel.getResultTextArea().equals("")){
            query.setQuerySparql(AddSPARQLJPanel.getSPARQLQuery());
            query.setResultexpected(AddSPARQLJPanel.getResultTextArea());
            if(getListAux().size()==posSel){
                getListAux().add(query);
            }else if(pertenece(query)==false){
                getListAux().get(posSel).setQuerySparql(getSPARQLQuery());
                getListAux().get(posSel).setResultexpected(getResultTextArea());
            }
            AddSPARQLJPanel.setResultTextArea("");
            AddSPARQLJPanel.setSPARQLQuery("");
            getAntQueryButton().setEnabled(true);
            getSigQueryButton().setEnabled(false);
            AddSPARQLJPanel.setPosListQuerysSel(posSel+1);
            contador=0;
        }else if(AddSPARQLJPanel.getSPARQLQuery().equals("") || AddSPARQLJPanel.getResultTextArea().equals("")){
            JOptionPane.showMessageDialog(frame,"Ambos campos CONSULTA y RESULTADO ESPERADO " +
                "son obligatorios.", "Warning Message",JOptionPane.WARNING_MESSAGE);
        }
    }else if(!getListAux().get(getListAux().size()-1).getQuerySparql().equals("") &&
            !getListAux().get(getListAux().size()-1).getResultexpected().equals("")){
            if(!AddSPARQLJPanel.getSPARQLQuery().equals("") && !AddSPARQLJPanel.getResultTextArea().equals("")){
                query.setQuerySparql(AddSPARQLJPanel.getSPARQLQuery());
                query.setResultexpected(AddSPARQLJPanel.getResultTextArea());
                if(pertenece(query)==false){
                    getListAux().get(posSel).setQuerySparql(getSPARQLQuery());
                    getListAux().get(posSel).setResultexpected(getResultTextArea());
                }
                queryAux.setQuerySparql("");
                queryAux.setResultexpected("");
                getListAux().add(queryAux);
            }else{
                JOptionPane.showMessageDialog(frame,"Ambos campos CONSULTA y RESULTADO ESPERADO " +
                    "son obligatorios.", "Warning Message",JOptionPane.WARNING_MESSAGE);
            }
    }else if(getListAux().get(getListAux().size()-1).getQuerySparql().equals("") &&
            getListAux().get(getListAux().size()-1).getResultexpected().equals("")){
        if(!AddSPARQLJPanel.getSPARQLQuery().equals("") && !AddSPARQLJPanel.getResultTextArea().equals("")){
            query.setQuerySparql(AddSPARQLJPanel.getSPARQLQuery());
            query.setResultexpected(AddSPARQLJPanel.getResultTextArea());
            if(pertenece(query)==false){
                    getListAux().get(posSel).setQuerySparql(getSPARQLQuery());
                    getListAux().get(posSel).setResultexpected(getResultTextArea());
            }
        }else{
            JOptionPane.showMessageDialog(frame,"Ambos campos CONSULTA y RESULTADO ESPERADO " +
                 "son obligatorios.", "Warning Message",JOptionPane.WARNING_MESSAGE);
        }
    }
}//GEN-LAST:event_nuevaConsultaButtonActionPerformed

private void limpiarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarButtonActionPerformed
// TODO add your handling code here:
    AddSPARQLJPanel.setSPARQLQuery("");
}//GEN-LAST:event_limpiarButtonActionPerformed

private void antQueryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_antQueryButtonActionPerformed
// TODO add your handling code here:
    int posSel = getPosListQuerysSel();
    SparqlQueryOntology sparql,sparqlAux;
    sparqlAux = new SparqlQueryOntology(getSPARQLQuery(),getResultTextArea());
    if(!getSPARQLQuery().equals("") && !getResultTextArea().equals("")){
        if(getListAux().size()==posSel){
            getListAux().add(sparqlAux);
            contador=1;
        }else{
                getListAux().get(posSel).setQuerySparql(getSPARQLQuery());
                getListAux().get(posSel).setResultexpected(getResultTextArea());
            }
        }
        sparql = getListAux().get(posSel-1);
        setSPARQLQuery(sparql.getQuerySparql());
        setResultTextArea(sparql.getResultexpected());
        setPosListQuerysSel(getPosListQuerysSel()-1);
    if(getPosListQuerysSel()==0){
            getAntQueryButton().setEnabled(false);
    }
    if(getListAux().size()>=1){
            getSigQueryButton().setEnabled(true);
    }
    if(contador==0){
        if(!getSPARQLQuery().equals("") && !getResultTextArea().equals("")){
            getListAux().add(sparqlAux);
            contador=1;
        }
    }
    setIsAntSelected(true);
}//GEN-LAST:event_antQueryButtonActionPerformed

private void sigQueryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sigQueryButtonActionPerformed
// TODO add your handling code here:
    int posSel = getPosListQuerysSel();
    SparqlQueryOntology sparql;
    getAntQueryButton().setEnabled(true);
    if(!getSPARQLQuery().equals("") && !getResultTextArea().equals("")){
            getListAux().get(posSel).setQuerySparql(getSPARQLQuery());
            getListAux().get(posSel).setResultexpected(getResultTextArea());
        }
        sparql = getListAux().get(posSel+1);
        setSPARQLQuery(sparql.getQuerySparql());
        setResultTextArea(sparql.getResultexpected());
        setPosListQuerysSel(getPosListQuerysSel()+1);
    if(getPosListQuerysSel()==getListAux().size()-1){
            getSigQueryButton().setEnabled(false);
    }
    setIsSigSelected(true);
}//GEN-LAST:event_sigQueryButtonActionPerformed

private void limpiarResultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarResultButtonActionPerformed
// TODO add your handling code here:
    AddSPARQLJPanel.setResultTextArea("");
}//GEN-LAST:event_limpiarResultButtonActionPerformed

private void borrarConsultaJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarConsultaJButtonActionPerformed
// TODO add your handling code here: 

    int posSel = getPosListQuerysSel();
    if(getListAux().size()==0){
        AddSPARQLJPanel.setSPARQLQuery("");
        AddSPARQLJPanel.setResultTextArea("");
    }else if(!getSPARQLQuery().equals("") && !getResultTextArea().equals("")){
        if(getListAux().size()==1){
            getListAux().remove(posSel);
            AddSPARQLJPanel.setSPARQLQuery("");
            AddSPARQLJPanel.setResultTextArea("");
        }else if(posSel==getListAux().size()){
            if(getListAux().size()==1){
                AddSPARQLJPanel.setSPARQLQuery(getListAux().get(posSel-1).getQuerySparql());
                AddSPARQLJPanel.setResultTextArea(getListAux().get(posSel-1).getResultexpected());
                getListAux().remove(posSel-1);
                setPosListQuerysSel(posSel-1);
                    getSigQueryButton().setEnabled(false);
                    getAntQueryButton().setEnabled(false);
            }else{
                AddSPARQLJPanel.setSPARQLQuery(getListAux().get(posSel-1).getQuerySparql());
                AddSPARQLJPanel.setResultTextArea(getListAux().get(posSel-1).getResultexpected());
                getListAux().remove(posSel-1);
                setPosListQuerysSel(posSel-1);
                    getAntQueryButton().setEnabled(true);
            }
        }else{
            getListAux().remove(posSel);
            if(posSel<=getListAux().size()-1){
                AddSPARQLJPanel.setSPARQLQuery(getListAux().get(posSel).getQuerySparql());
                AddSPARQLJPanel.setResultTextArea(getListAux().get(posSel).getResultexpected());
                if((posSel==0 && getListAux().size()>1) || posSel<getListAux().size()-1){
                        getSigQueryButton().setEnabled(true);
                }else{
                        getSigQueryButton().setEnabled(false);
                }
            }else{
                if(getListAux().size()==1){
                    AddSPARQLJPanel.setSPARQLQuery(getListAux().get(posSel-1).getQuerySparql());
                    AddSPARQLJPanel.setResultTextArea(getListAux().get(posSel-1).getResultexpected());
                    getListAux().remove(posSel-1);
                    setPosListQuerysSel(posSel-1);
                        getSigQueryButton().setEnabled(false);
                        getAntQueryButton().setEnabled(false);
                }else{
                    AddSPARQLJPanel.setSPARQLQuery(getListAux().get(posSel-1).getQuerySparql());
                    AddSPARQLJPanel.setResultTextArea(getListAux().get(posSel-1).getResultexpected());
                    getListAux().remove(posSel-1);
                    setPosListQuerysSel(posSel-1);
                        getAntQueryButton().setEnabled(true);
                }
            }
        }
    }else{
         JOptionPane.showMessageDialog(frame,"No ha introducido ninguna consulta para borrar.",
                 "Warning Message",JOptionPane.WARNING_MESSAGE);
    }
}//GEN-LAST:event_borrarConsultaJButtonActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    FormatTestsJDialog format = new FormatTestsJDialog(frame,true);
    format.setModal(false);
    format.setVisible(true);
}//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton antQueryButton;
    private javax.swing.JButton borrarConsultaJButton;
    private javax.swing.JPanel instancesPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton limpiarButton;
    private javax.swing.JButton limpiarResultButton;
    private javax.swing.JButton nuevaConsultaButton;
    private static javax.swing.JTextArea resultTextArea;
    private static javax.swing.JButton sigQueryButton;
    private static javax.swing.JTextArea sparqlTextArea;
    private static javax.swing.JTextArea testDescTextArea;
    private static javax.swing.JTextField testNameTextField;
    // End of variables declaration//GEN-END:variables
    
public boolean guardarDatos(){
    
    jena = jenaInterface.getJena();
    noHayInsatncias=false;
    resultadoValido=true;
    nombreVacio=false;
    testYaExiste=false;
    sinConsultas=false;
    sinTest=false;

    String ontologyFisical=MainJPanel.getFisicalOntologyTextField();
    
    String ontologyURI = MainJPanel.getNamespaceOntologyTextField();
    
    MainJPanel.getCollectionTest().setOntology("file:".concat(ontologyFisical));
    if(ontologyURI.endsWith("#")){
        MainJPanel.getCollectionTest().setNamespace(ontologyURI);
    }else{
        MainJPanel.getCollectionTest().setNamespace(ontologyURI.concat("#"));
    }   
    
    scenarioSparql = new ScenarioTest();
    listSparqlQuerys = AddSPARQLJPanel.getListSparqlQuerys();
    vaciaClase = new ArrayList<ClassInstances>();
    vaciaPropiedad = new ArrayList<PropertyInstances>();
    instancias = ContentMainJFrame.getInstancias().get(GroupTestsJPanel.getSelectedTabed());
    SparqlQueryOntology query = new SparqlQueryOntology();
    ValidarTests validarTests = new ValidarTests();
    
    if(AddSPARQLJPanel.getTestNameTextField().equals("") && (!AddSPARQLJPanel.getSPARQLQuery().equals("") ||
            !AddSPARQLJPanel.getResultTextArea().equals(""))){
        JOptionPane.showMessageDialog(frame,"El nombre del test es obligatorio.",
                "Warning Message",JOptionPane.WARNING_MESSAGE);  
        nombreVacio=true;
    }else if(GroupTestsJPanel.testYaExiste(AddSPARQLJPanel.getTestNameTextField())==true){
        JOptionPane.showMessageDialog(frame,"Ya existe un test con ese nombre, por favor, " +
                "introduzca uno distinto.","Warning Message",JOptionPane.WARNING_MESSAGE);
        testYaExiste=true;
    }else if(AddSPARQLJPanel.getSPARQLQuery().equals("") && AddSPARQLJPanel.getResultTextArea().equals("") &&
            !AddSPARQLJPanel.getTestNameTextField().equals("") && getListAux().size()==0){
        JOptionPane.showMessageDialog(frame,"Al menosdebe introducir una consulta para" +
                "ejectuar el test","Warning Message",JOptionPane.WARNING_MESSAGE);
        sinConsultas=true;
    }else if((AddSPARQLJPanel.getTestNameTextField().equals("") && AddSPARQLJPanel.getSPARQLQuery().equals("")
            && AddSPARQLJPanel.getResultTextArea().equals("")) && (MainJPanel.getCollectionTest().getScenariotest().size()==0)){
        JOptionPane.showMessageDialog(frame,"No ha creado ningun test para ejecutar",
                "Warning Message",JOptionPane.WARNING_MESSAGE);
        sinTest=true;    
    }else if(resultadoValido==true){
        if(!AddSPARQLJPanel.getResultTextArea().equals("") && !AddSPARQLJPanel.getSPARQLQuery().equals("")){
            if(validarTests.validarSparqlTest(AddSPARQLJPanel.getResultTextArea())==false){
                JOptionPane.showMessageDialog(frame,"Algun formato introducido en el Resultado Esperado " +
                        "es incorrecto. \n Para mas ayuda, consulte los formatos posibles.",
                        "Warning Message",JOptionPane.WARNING_MESSAGE);
                resultadoValido=false;
            }
        }
        if(resultadoValido==true){
            query.setQuerySparql(AddSPARQLJPanel.getSPARQLQuery());
            query.setResultexpected(AddSPARQLJPanel.getResultTextArea());
            try{
                if(!AddSPARQLJPanel.getResultTextArea().equals("") && !AddSPARQLJPanel.getSPARQLQuery().equals("")){
                    jena.addReasoner("file:".concat(MainJPanel.getFisicalOntologyTextField()));
                    jena.validarSparqlQuery(query.getQuerySparql()); 
                    if(AddSPARQLJPanel.getListSparqlQuerys().size()==AddSPARQLJPanel.getPosListQuerysSel()){
                        listSparqlQuerys.add(query);
                    }else if(GroupTestsJPanel.inListSparqlQuerys(query)==false){
                        listSparqlQuerys.remove(AddSPARQLJPanel.getPosListQuerysSel());
                        listSparqlQuerys.add(AddSPARQLJPanel.getPosListQuerysSel(),query);
                    }
                }
                ArrayList<SparqlQueryOntology> querys = AddSPARQLJPanel.getListSparqlQuerys();
                for(int i=0; i<querys.size();i++){
                    if(!querys.get(i).getQuerySparql().equals("") && !querys.get(i).getResultexpected().equals("")){
                        if(validarTests.validarSparqlTest(querys.get(i).getResultexpected())==false){
                            JOptionPane.showMessageDialog(frame,"Algun formato introducido en el Resultado Esperado " +
                                "es incorrecto. \n Para mas ayuda, consulte los formatos posibles.",
                                "Warning Message",JOptionPane.WARNING_MESSAGE);
                            resultadoValido=false;
                        }else{
                            jena.validarSparqlQuery(querys.get(i).getQuerySparql());
                        }
                    }
                }
            boolean result = asociarDatos();
            instancias.setClassInstances(vaciaClase);
            instancias.setPropertyInstances(vaciaPropiedad);
            ContentMainJFrame.getInstancias().set(GroupTestsJPanel.getSelectedTabed(), instancias);
            return result;
            }catch(ExceptionReadOntology ero){
                    JOptionPane.showMessageDialog(frame,"La ontologia introducida no se puede leer." +
                    "No se pueden asociar las consultas sparql.",
                    "Warning Message",JOptionPane.WARNING_MESSAGE);
            }catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame,"Alguna de las consultas SPARQL no es valida",
                    "Warning Message",JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    return false;   
}   
    
public boolean asociarDatos(){

    OntologyTestCase testcase = new OntologyTestCase();
    OntologyTestResult testresult = new OntologyTestResult();
    if(testYaExiste==false && ambosNecesarios==false && sinConsultas==false && nombreVacio==false
    && resultadoValido==true && sinTest==false){
        if(!AddSPARQLJPanel.getSPARQLQuery().equals("") && !AddSPARQLJPanel.getResultTextArea().equals("")){    
            scenarioSparql.setNombre(AddSPARQLJPanel.getTestNameTextField());
            scenarioSparql.setTestName("sparql");
            scenarioSparql.setDescripcion(AddSPARQLJPanel.getTestDescTextArea());
            scenarioSparql.setSparqlQuerys(listSparqlQuerys);
            scenarioSparql.setInstancias(instancias);

            if(GroupTestsJPanel.hayInstanciasAsociadas(instancias)==false){
                int n = JOptionPane.showConfirmDialog(comp, "El test no tiene " +
                        "instancias asociadas. ¿Desea continuar?", "Warning Message",
                        JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.NO_OPTION){ 
                    noHayInsatncias=true;
                }
            }
            if(noHayInsatncias==false){
                if(ambosNecesarios==false){
                    ContentMainJFrame.getInstancias().set(GroupTestsJPanel.getSelectedTabed(), instancias); 

                    ArrayList<ScenarioTest> scenarioT = MainJPanel.getCollectionTest().getScenariotest();
                    if(scenarioT.size()==0){
                        scenarioT.add(scenarioSparql);
                        MainJPanel.getCollectionTest().setScenariotest(scenarioT);
                    }else{
                        MainJPanel.getCollectionTest().getScenariotest().add(scenarioSparql);
                    }
                    listSparqlQuerys = new ArrayList<SparqlQueryOntology>(); 
                    AddSPARQLJPanel.setListSparqlQuerys(listSparqlQuerys);
                }
            }
        }else if((!AddSPARQLJPanel.getSPARQLQuery().equals("") && AddSPARQLJPanel.getResultTextArea().equals(""))
                || (AddSPARQLJPanel.getSPARQLQuery().equals("") && !AddSPARQLJPanel.getResultTextArea().equals("")) &&
                (!AddSPARQLJPanel.getTestNameTextField().equals(""))){
            JOptionPane.showMessageDialog(frame,"Ambos campos CONSULTA y RESULTADO ESPERADO " +
                "son obligatorios.", "Warning Message",JOptionPane.WARNING_MESSAGE);
            ambosNecesarios=true;
        }
    }
        if(noHayInsatncias==false){
            if(testYaExiste==false && ambosNecesarios==false && sinConsultas==false && nombreVacio==false
                    && resultadoValido==true && sinTest==false){
                if(MainJPanel.getCollectionTest().getScenariotest().size()!=0){
                int n = JOptionPane.showConfirmDialog(comp, "¿Quiere guardar estos tests " +
                    "para futuras pruebas?", "Guardar Tests",JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION){
                    ArrayList<ScenarioTest> scenarioT = MainJPanel.getCollectionTest().getScenariotest();
                    try{ 
                        for(int i=0;i<scenarioT.size();i++){
                            if(!scenarioT.get(i).getNombre().equals("")){
                                XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new 
                                FileOutputStream(Configuration.getPathTestSparql()+"/"+scenarioT.get(i).getNombre()+".xml")));
                                e.writeObject(scenarioT.get(i));
                                e.close();
                            }
                        }
                    }catch (FileNotFoundException ex){
                        ex.printStackTrace();
                    }catch (IOException io){
                        io.printStackTrace();
                    }
                    try{
                        testcase.run(testresult, MainJPanel.getCollectionTest());
                        JPanel panel = new TreeResults(testresult);
                        setPanelTree(panel); 
                        return true;
                    }catch (ExceptionReadOntology ex) {
                        JOptionPane.showMessageDialog(frame,"No se puede ejecutar el test. La ontologia " +
                        "introducida no se puede leer.",
                        "Warning Message",JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                    try{
                        testcase.run(testresult, MainJPanel.getCollectionTest());
                        JPanel panel = new TreeResults(testresult);
                        setPanelTree(panel); 
                        return true;
                    }catch (ExceptionReadOntology ex) {
                        JOptionPane.showMessageDialog(frame,"No se puede ejecutar el test. La ontologia " +
                        "introducida no se puede leer.",
                        "Warning Message",JOptionPane.WARNING_MESSAGE);
                    }
                }
            }else{
                    JOptionPane.showMessageDialog(frame,"No ha creado ningun test para ejecutar.",
                    "Warning Message",JOptionPane.WARNING_MESSAGE);
                    return false;       
            }
        }
    }
    return false;
}

public JPanel getPanelTree() {
    return panelTree;
}

public void setPanelTree(JPanel aPanelTree) {
    panelTree = aPanelTree;
}

    public boolean pertenece(SparqlQueryOntology sparql){
        for(int i=0; i<getListAux().size();i++){
            String query = getListAux().get(i).getQuerySparql();
            String res = getListAux().get(i).getResultexpected();
            if(query.equals(sparql.getQuerySparql()) && res.equals(sparql.getResultexpected())){
                return true;
            }
        }
        return false;
    }
    
    public static String getResultTextArea() {
        return resultTextArea.getText();
    }

    public static void setResultTextArea(String aResultTextArea) {
        resultTextArea.setText(aResultTextArea);
    }

    public static String getSPARQLQuery() {
        return getSparqlTextArea().getText();
    }

    public static void setSPARQLQuery(String aSparqlTextArea) {
        getSparqlTextArea().setText(aSparqlTextArea);
    }

    public static String getTestDescTextArea() {
        return testDescTextArea.getText();
    }

    public static void setTestDescTextArea(String aTestDescTextArea) {
        testDescTextArea.setText(aTestDescTextArea);
    }

    public static String getTestNameTextField() {
        return testNameTextField.getText();
    }

    public static void setTestNameTextField(String aTestNameTextField) {
        testNameTextField.setText(aTestNameTextField);
    }

    public static ScenarioTest getScenarioTestQuery() {
        return scenarioTestQuery;
    }

    public static void setScenarioTestQuery(ScenarioTest ascenarioTestQuery) {
       scenarioTestQuery = ascenarioTestQuery;
    }
    
    public static ArrayList<SparqlQueryOntology> getListSparqlQuerys() {
        return getListAux();
    }

    public static void setListSparqlQuerys(ArrayList<SparqlQueryOntology> alistAux) {
        setListAux(alistAux);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static ArrayList<SparqlQueryOntology> getListAux() {
        return listAux;
    }

    public boolean isIsAntSelected() {
        return isAntSelected;
    }

    public void setIsAntSelected(boolean isAntSelected) {
        this.isAntSelected = isAntSelected;
    }

    public boolean isIsSigSelected() {
        return isSigSelected;
    }

    public void setIsSigSelected(boolean isSigSelected) {
        this.isSigSelected = isSigSelected;
    }

}
