/*
 * AddSPARQLJPanel.java
 *
 * Created on 19 de mayo de 2008, 19:12
 */

package code.google.com.p.ontologytesting.gui;

import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import code.google.com.p.ontologytesting.model.ScenarioTest;
import code.google.com.p.ontologytesting.model.SparqlQueryOntology;

/**
 *
 * @author  Saruskas
 */
public class AddSPARQLJPanel extends javax.swing.JPanel {

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
        antQueryButton.setEnabled(state);
    }
     public static void setSigQueryButton(boolean state) {
        sigQueryButton.setEnabled(state);
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
    private static ArrayList<SparqlQueryOntology> listAux = new ArrayList<SparqlQueryOntology>();
    
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
            .add(0, 743, Short.MAX_VALUE)
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

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 495, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(testNameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 267, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 224, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 251, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                                    .add(layout.createSequentialGroup()
                                        .add(limpiarButton)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 255, Short.MAX_VALUE)
                                        .add(antQueryButton)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(sigQueryButton)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(nuevaConsultaButton)
                                        .add(24, 24, 24))
                                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 563, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(18, 18, 18)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(limpiarResultButton)
                                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 303, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jLabel4)))))
                    .add(instancesPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(limpiarButton)
                    .add(limpiarResultButton)
                    .add(antQueryButton)
                    .add(sigQueryButton)
                    .add(nuevaConsultaButton))
                .add(8, 8, 8)
                .add(instancesPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void nuevaConsultaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaConsultaButtonActionPerformed
// TODO add your handling code here:
    int posSel = getPosListQuerysSel();
    if(posSel == getListAux().size() || posSel == getListAux().size()-1){
    SparqlQueryOntology query = new SparqlQueryOntology();
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
        antQueryButton.setEnabled(true);
        sigQueryButton.setEnabled(false);
        int pos = AddSPARQLJPanel.getPosListQuerysSel();
        AddSPARQLJPanel.setPosListQuerysSel(pos+1);
        contador=0;
    }else if(AddSPARQLJPanel.getSPARQLQuery().equals("") || AddSPARQLJPanel.getResultTextArea().equals("")){
        JOptionPane.showMessageDialog(frame,"Ambos campos CONSULTA y RESULTADO ESPERADO " +
                "son obligatorios.", "Warning Message",JOptionPane.WARNING_MESSAGE);
    }
    }else if(!getListAux().get(getListAux().size()-1).getQuerySparql().equals("") &&
            !getListAux().get(getListAux().size()-1).getResultexpected().equals("")){
            getListAux().get(posSel).setQuerySparql("");
            getListAux().get(posSel).setResultexpected("");
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
        antQueryButton.setEnabled(false);
    }
    if(getListAux().size()>=1){
        sigQueryButton.setEnabled(true);
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
    antQueryButton.setEnabled(true);
    if(!getSPARQLQuery().equals("") && !getResultTextArea().equals("")){
        getListAux().get(posSel).setQuerySparql(getSPARQLQuery());
        getListAux().get(posSel).setResultexpected(getResultTextArea());
    }
    sparql = getListAux().get(posSel+1);
    setSPARQLQuery(sparql.getQuerySparql());
    setResultTextArea(sparql.getResultexpected());
    setPosListQuerysSel(getPosListQuerysSel()+1);
    if(getPosListQuerysSel()==getListAux().size()-1){
        sigQueryButton.setEnabled(false);
    }
    setIsSigSelected(true);
}//GEN-LAST:event_sigQueryButtonActionPerformed

private void limpiarResultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarResultButtonActionPerformed
// TODO add your handling code here:
    AddSPARQLJPanel.setResultTextArea("");
}//GEN-LAST:event_limpiarResultButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton antQueryButton;
    private javax.swing.JPanel instancesPanel;
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
        return sparqlTextArea.getText();
    }

    public static void setSPARQLQuery(String aSparqlTextArea) {
        sparqlTextArea.setText(aSparqlTextArea);
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
        return listAux;
    }

    public static void setListSparqlQuerys(ArrayList<SparqlQueryOntology> alistAux) {
        listAux = alistAux;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<SparqlQueryOntology> getListAux() {
        return listAux;
    }

    public void setListAux(ArrayList<SparqlQueryOntology> alistAux) {
        listAux = alistAux;
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
