/*
 * TestSimpleRetClas.java
 *
 * Created on 15 de septiembre de 2008, 10:18
 */

package code.google.com.p.ontologytesting.gui.tests;

import code.google.com.p.ontologytesting.gui.auxiliarclasess.*;
import code.google.com.p.ontologytesting.gui.*;
import code.google.com.p.ontologytesting.model.*;
import code.google.com.p.ontologytesting.model.reasonerinterfaz.ExceptionReadOntology;
import code.google.com.p.ontologytesting.persistence.*;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import code.google.com.p.ontologytesting.gui.auxiliarpanels.ProgressControlJDialog;

/**
 *
 * @author  sara.garcia
 */
public class TestSimpleRetClas extends javax.swing.JPanel {

    private ValidarTests validarTests;
    private TestInstancesTextAreaJPanel test;
    private DescripcionJPanel descPanel = null;
    private boolean testSinNombre,validoRet,ambosNecesarios,continuarSinInstancias,continuar,addInst;
    private int actualSubTabRet=0;
    private JPanel panelAyudaRet;
    private int totalRet,hayUnaConsulta=0;
    private List ret;
    private TestInstancesTextJPanel ti;
    private List<QueryOntology> queryTest;
    private TestInstancesTextJPanel texto;
    private ScenarioTest scenario;
    private IOManagerImplementation persist = new IOManagerImplementation();
    private String nombreTest = "",descTest = "";
    private ControladorTests controlador;
    private OpcionesMenu menu;
    private ValidarConsultas validarConsultas = new ValidarConsultas();
    private QueryOntology testQuery;
    private AniadirPanelDeAviso panelAviso;
    private ScenarioTest scenarioActual = new ScenarioTest();
    private ProgressControlJDialog progres;
    
    public TestSimpleRetClas(ScenarioTest s){
        initComponents();
        panelAviso = new AniadirPanelDeAviso();
        TestInstancesTextAreaJPanel.setContadorRetClas(0);
        descripcionJPanel.add(new DescripcionJPanel(),BorderLayout.WEST);
        opcionTextRetPanel.setLayout(new BoxLayout(getOpcionTextRetPanel(), BoxLayout.Y_AXIS));
        retAyudaPanel.setLayout(new BoxLayout(getRetAyudaPanel(), BoxLayout.Y_AXIS));
        controlador = ControladorTests.getInstance();
        opcionTextRetPanel.add(new TestInstancesTextJPanel());
        int cont=1;
        List<QueryOntology> listaQuerys = s.getQueryTest(); 
        ListIterator qi;
        qi = listaQuerys.listIterator();
        
        descPanel = (DescripcionJPanel) descripcionJPanel.getComponent(0);
        descPanel.setNombreTextField(s.getNombre());
        descPanel.setDescTextArea(s.getDescripcion());
        while(qi.hasNext()){ 
            QueryOntology cI = (QueryOntology) qi.next();
            TestInstancesTextAreaJPanel panelInstances = new TestInstancesTextAreaJPanel();
            AddComentJDialog comentPane = panelInstances.getComment();
            comentPane.setComent(cI.getComment());
            panelInstances.setComment(comentPane);
            panelInstances.setQuery(cI.getQuery());
            panelInstances.setQueryResult(cI.getResultexpected());
            retAyudaPanel.add(panelInstances,cont);
            cont++;
        }
        if(cont<2){
            for (int i = cont; i <= 2; i++) {  
                retAyudaPanel.add(new TestInstancesTextAreaJPanel());   
            }
        }
        menu = new OpcionesMenu();
        setScenario(s);
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentRetTabedPanel = new javax.swing.JPanel();
        tabbedPaneRet = new javax.swing.JTabbedPane();
        opcionAyudaRetPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        retAyudaPanel = new javax.swing.JPanel();
        labelRetPanel = new javax.swing.JPanel();
        labelRetLabel = new javax.swing.JLabel();
        opcionTextRetPanel = new javax.swing.JPanel();
        contentGuardarEjecutarPanel = new javax.swing.JPanel();
        guardarButton = new javax.swing.JButton();
        guardarEjecutarButton = new javax.swing.JButton();
        ejecutarButton = new javax.swing.JButton();
        addInstanciasButton = new javax.swing.JButton();
        descripcionJPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        contentRetTabedPanel.setLayout(new java.awt.BorderLayout());

        tabbedPaneRet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedPaneRetMouseClicked(evt);
            }
        });

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        labelRetLabel.setText("                      CONSULTAS                               RESULTADO ESPERADO");

        javax.swing.GroupLayout labelRetPanelLayout = new javax.swing.GroupLayout(labelRetPanel);
        labelRetPanel.setLayout(labelRetPanelLayout);
        labelRetPanelLayout.setHorizontalGroup(
            labelRetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelRetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelRetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        labelRetPanelLayout.setVerticalGroup(
            labelRetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelRetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelRetLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout retAyudaPanelLayout = new javax.swing.GroupLayout(retAyudaPanel);
        retAyudaPanel.setLayout(retAyudaPanelLayout);
        retAyudaPanelLayout.setHorizontalGroup(
            retAyudaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(retAyudaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelRetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        retAyudaPanelLayout.setVerticalGroup(
            retAyudaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(retAyudaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelRetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(495, Short.MAX_VALUE))
        );

        jScrollPane6.setViewportView(retAyudaPanel);

        javax.swing.GroupLayout opcionAyudaRetPanelLayout = new javax.swing.GroupLayout(opcionAyudaRetPanel);
        opcionAyudaRetPanel.setLayout(opcionAyudaRetPanelLayout);
        opcionAyudaRetPanelLayout.setHorizontalGroup(
            opcionAyudaRetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionAyudaRetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                .addContainerGap())
        );
        opcionAyudaRetPanelLayout.setVerticalGroup(
            opcionAyudaRetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionAyudaRetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPaneRet.addTab("Formato ayuda", opcionAyudaRetPanel);

        javax.swing.GroupLayout opcionTextRetPanelLayout = new javax.swing.GroupLayout(opcionTextRetPanel);
        opcionTextRetPanel.setLayout(opcionTextRetPanelLayout);
        opcionTextRetPanelLayout.setHorizontalGroup(
            opcionTextRetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
        );
        opcionTextRetPanelLayout.setVerticalGroup(
            opcionTextRetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );

        tabbedPaneRet.addTab("Formato Texto", opcionTextRetPanel);

        contentRetTabedPanel.add(tabbedPaneRet, java.awt.BorderLayout.CENTER);

        guardarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/disk.png"))); // NOI18N
        guardarButton.setToolTipText("Guardar");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        guardarEjecutarButton.setText("Guardar y Ejecutar");
        guardarEjecutarButton.setToolTipText("Guardar y Ejecutar");
        guardarEjecutarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarEjecutarButtonActionPerformed(evt);
            }
        });

        ejecutarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/cog.png"))); // NOI18N
        ejecutarButton.setToolTipText("Ejecutar");
        ejecutarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecutarButtonActionPerformed(evt);
            }
        });

        addInstanciasButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/add.png"))); // NOI18N
        addInstanciasButton.setText("Instancias");
        addInstanciasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInstanciasButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentGuardarEjecutarPanelLayout = new javax.swing.GroupLayout(contentGuardarEjecutarPanel);
        contentGuardarEjecutarPanel.setLayout(contentGuardarEjecutarPanelLayout);
        contentGuardarEjecutarPanelLayout.setHorizontalGroup(
            contentGuardarEjecutarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentGuardarEjecutarPanelLayout.createSequentialGroup()
                .addContainerGap(247, Short.MAX_VALUE)
                .addComponent(guardarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ejecutarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(guardarEjecutarButton)
                .addGap(18, 18, 18)
                .addComponent(addInstanciasButton)
                .addContainerGap())
        );
        contentGuardarEjecutarPanelLayout.setVerticalGroup(
            contentGuardarEjecutarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentGuardarEjecutarPanelLayout.createSequentialGroup()
                .addGroup(contentGuardarEjecutarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addInstanciasButton)
                    .addComponent(guardarEjecutarButton)
                    .addComponent(ejecutarButton)
                    .addComponent(guardarButton))
                .addContainerGap())
        );

        contentRetTabedPanel.add(contentGuardarEjecutarPanel, java.awt.BorderLayout.PAGE_START);

        add(contentRetTabedPanel, java.awt.BorderLayout.CENTER);

        descripcionJPanel.setLayout(new java.awt.BorderLayout());
        add(descripcionJPanel, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

private void tabbedPaneRetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedPaneRetMouseClicked
// TODO add your handling code here:
    int subTab = getTabbedPaneRet();
    if(getActualSubTabRet()!=subTab){
        if(subTab==1){
            copiarDeAyudaATexto();
        }else{
            copiarDeTextoAAyuda();
        }
        setActualSubTabRet(subTab);
    }
}//GEN-LAST:event_tabbedPaneRetMouseClicked

private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
// TODO add your handling code here:
    guardarTest();
}//GEN-LAST:event_guardarButtonActionPerformed

private void guardarEjecutarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarEjecutarButtonActionPerformed
// TODO add your handling code here:
    if(getTabbedPaneRet()==0){
        copiarTestAScenarioDesdeAyuda();
    }else if(getTabbedPaneRet()==1){
        copiarTestAScenarioDesdeSinAyuda();
    }
    if(continuar==true){
        if(continuarSinInstancias==true){
            this.realizarAccion(true, true);
        }else{
            MainApplicationJFrame.getInstance().cargarInstancia(this.getScenario().getInstancias(),"Asociar Instancias a Test");
        }
    }
}//GEN-LAST:event_guardarEjecutarButtonActionPerformed

private void addInstanciasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInstanciasButtonActionPerformed
// TODO add your handling code here:
    addInst=true;
    if(persist.testYaGuardado(getScenario())==false){
        guardarTest();
    }
    menu.editarInstancias(this.getScenario());
}//GEN-LAST:event_addInstanciasButtonActionPerformed

public boolean guardarTest(){
    if(getTabbedPaneRet()==0){
        copiarTestAScenarioDesdeAyuda();
    }else if(getTabbedPaneRet()==1){
        copiarTestAScenarioDesdeSinAyuda();
    }
    if(continuar==true){
        if(continuarSinInstancias==true){
            this.realizarAccion(true, false);
        }else{
            MainApplicationJFrame.getInstance().cargarInstancia(this.getScenario().getInstancias(),"Asociar Instancias a Test");
        }
    }
    return continuar;
}

private void ejecutarButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
// TODO add your handling code here:
    if(getTabbedPaneRet()==0){
        copiarTestAScenarioDesdeAyuda();
    }else if(getTabbedPaneRet()==1){
        copiarTestAScenarioDesdeSinAyuda();
    }
    if(continuar==true){
        if(continuarSinInstancias==true){
            this.realizarAccion(false, true);
        }else{
            MainApplicationJFrame.getInstance().cargarInstancia(this.getScenario().getInstancias(),"Asociar Instancias a Test");
        }
    }
}

public void realizarAccion(boolean guardar, boolean ejecutar){  
    persist = new IOManagerImplementation();
    if(guardar==true){
        if(persist.testYaGuardado(getScenario())==true){
            persist.replaceScenarioLocally(getScenario());
        }else{
            persist.saveTestInMemory(getScenario());
            controlador.setTestInstSatGuardado(true);
        }
        this.setScenarioActual(new ScenarioTest(scenario));
    }
    if(ejecutar==true){
        try{
            ExecuteTest execTest = new ExecuteTest(getScenario());
            progres = new ProgressControlJDialog(execTest);
            JProgressBar progresBar = progres.getProgressBar();
            execTest.addPropertyChangeListener(new ProgressListener(progresBar,progres,true));
            progresBar.setIndeterminate(true);
            execTest.execute();
            progres.setVisible(true);
        }catch (ExceptionReadOntology ex){
            panelAviso.errorAction("No se pudo ejecutar el test. Ontología no válida", MainApplicationJFrame.getInstance());
        }
    }
    if(guardar==true && ejecutar==false){
        if(addInst==false){
            panelAviso.confirmAction("Test Guardado", MainApplicationJFrame.getInstance());
        }
    }
    menu.actualizarListaDeTestsSimples(CollectionTest.getInstance().getScenariotest());
}

public void inicializarVariables(){
    ambosNecesarios=false;
    continuarSinInstancias=true;
    testSinNombre=false;
    validoRet=true;
    hayUnaConsulta=0;
    continuar=true;
}

public void copiarTestAScenarioDesdeAyuda(){

    inicializarVariables();

    queryTest = new ArrayList<QueryOntology>();
    test = null; 
    
    panelAyudaRet = this.getRetAyudaPanel();
    totalRet = panelAyudaRet.getComponentCount();
    validarTests = new ValidarTests();
    
    ret = new ArrayList();
    this.ret.add(0,0);
    validarConsultas.setListRet(this.ret);
    descPanel = (DescripcionJPanel) descripcionJPanel.getComponent(0);
    nombreTest = descPanel.getNombreTextField();
    descTest = descPanel.getDescTextArea();
    if(descPanel.testSinNombre()==true){
        testSinNombre=true;
    }else{
        for(int i=1;i<totalRet;i++){
            test = (TestInstancesTextAreaJPanel) panelAyudaRet.getComponent(i);
            if(test.panelVacio()==false){
                if(ambosNecesarios==false){
                    if(test.consultaCompletaEnAyuda()==false){
                        ambosNecesarios=true;
                    }else{
                        String query = test.getQuery();
                        String resExpT = test.getQueryResult();
                        AddComentJDialog comentPane = test.getComment();
                        String coment = comentPane.getComent();
                        hayUnaConsulta=1;
                        testQuery = new QueryOntology(query,resExpT,coment);
                        if(validarTests.validarQuery(testQuery.getQuery())==true){
                            queryTest.add(testQuery);
                            this.ret.add(i, 0);
                            validarConsultas.setListRet(this.ret);
                        }else{
                            this.ret.add(i, 1);
                            validarConsultas.setListRet(this.ret);
                            validoRet=false;
                        }
                    }
                }
            }
        }
    }
    
    if(testSinNombre==false && validoRet==true && ambosNecesarios==false
                && hayUnaConsulta==1){  
        
        continuarSinInstancias = this.preguntarSiContinuarSinInstancias();
        if(continuarSinInstancias==true){
            scenario.setDescripcion(descTest);
            scenario.setNombre(nombreTest);
            scenario.setQueryTest(queryTest); 
        }
    }else {
        mostrarErrores(true);
    }
}

    public boolean preguntarSiContinuarSinInstancias(){
        if(addInst==false){
            if(scenario.tieneInstanciasAsociadas()==false){
                int n = JOptionPane.showConfirmDialog(MainApplicationJFrame.getInstance(), "El test no tiene instancias asociadas. " +
                        "¿Desea continuar?", "Warning Message",JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.NO_OPTION){
                    continuarSinInstancias=false;
                }else if(n == JOptionPane.YES_OPTION){
                    continuarSinInstancias=true;
                }
            }
        }else continuarSinInstancias=true;
        return continuarSinInstancias;
    }

public void copiarTestAScenarioDesdeSinAyuda(){
      
    inicializarVariables();
    
    String conjuntoQuerys;
    String conjuntoResult;
    String conjuntoComent;
    String[] cQuery;
    String[] cResult;
    String[] cComent;
    texto = null;
    
    validarTests = new ValidarTests();
    queryTest = new ArrayList<QueryOntology>();
    descPanel = (DescripcionJPanel) descripcionJPanel.getComponent(0);
    texto = (TestInstancesTextJPanel) getOpcionTextRetPanel().getComponent(0);
    conjuntoQuerys = texto.getConsultaQuery();
    conjuntoResult = texto.getResultadoEsperado();
    conjuntoComent = texto.getComentTextArea();
    cQuery = conjuntoQuerys.split("\\\n");
    cResult = conjuntoResult.split("\\\n");
    cComent = conjuntoComent.split("\\\n");
    
    nombreTest = descPanel.getNombreTextField();
    descTest = descPanel.getDescTextArea();
    
    ret = new ArrayList();
    this.ret.add(0,0);
    validarConsultas.setListRet(this.ret);
    if(descPanel.testSinNombre()==true){
        testSinNombre=true;
    }else{
        if(!conjuntoQuerys.equals("") && !conjuntoResult.equals("")){
            testQuery = new QueryOntology();
            int tamQ = cQuery.length;
            int tamR = cResult.length;
            if(tamQ==tamR){
                for(int i=0; i<tamQ;i++){
                    if(texto.consultaCompletaEnSinAyuda(cQuery[i], cResult[i])==true){
                        if(continuar=true){
                            hayUnaConsulta=1;
                            if(validarTests.validarQuery(cQuery[i])==true &&
                                    validarTests.validarResultado(cResult[i])==true){
                                if(cComent.length!=0 && i!=cComent.length && i<=cComent.length){
                                    testQuery = new QueryOntology(cQuery[i],cResult[i],cComent[i]);
                                }else{
                                    testQuery = new QueryOntology(cQuery[i],cResult[i]);
                                }
                                queryTest.add(testQuery);
                                this.ret.add(i, 0);
                                validarConsultas.setListRet(this.ret);
                            }else if(validarTests.validarQuery(cQuery[i])==false &&
                                    validarTests.validarResultado(cResult[i])==true){
                                this.ret.add(i, 1);
                                validarConsultas.setListRet(this.ret);
                                validoRet=false;
                            }else if(validarTests.validarQuery(cQuery[i])==true &&
                                    validarTests.validarResultado(cResult[i])==false){
                                this.ret.add(i, 2);
                                validarConsultas.setListRet(this.ret);
                                validoRet=false;
                            }else{
                                this.ret.add(i, 3);
                                validarConsultas.setListRet(this.ret);
                                validoRet=false;
                            }
                        }
                    }else{
                        ambosNecesarios=true;
                        continuar=false;
                    }
                } 
            }else{
                ambosNecesarios=true;
            }
        }else if((!conjuntoQuerys.equals("") && conjuntoResult.equals("")) || 
                (conjuntoQuerys.equals("") && !conjuntoResult.equals(""))){
            ambosNecesarios=true;
        }
    }
    if(testSinNombre==false && validoRet==true && ambosNecesarios==false
        && hayUnaConsulta==1){
        continuarSinInstancias = this.preguntarSiContinuarSinInstancias();
        if(continuarSinInstancias==true){
            scenario.setDescripcion(descTest);
            scenario.setNombre(nombreTest);
            scenario.setQueryTest(queryTest);
        }
    }else {
        mostrarErrores(false);
    }
}

public void mostrarErrores(boolean ayuda){
    if(testSinNombre==true){
        panelAviso.warningAction("El nombre del test es obligatorio", MainApplicationJFrame.getInstance());
            JOptionPane.showMessageDialog(MainApplicationJFrame.getInstance(),"El nombre del test es obligatorio",
            "Warning Message",JOptionPane.WARNING_MESSAGE);
            continuar=false;
    }else if(ambosNecesarios==true){
        panelAviso.warningAction("Ambos campos CONSULTA y RESULTADO ESPERADO son obligatorios", MainApplicationJFrame.getInstance());
        JOptionPane.showMessageDialog(MainApplicationJFrame.getInstance(),"Ambos campos CONSULTA y RESULTADO ESPERADO son" +
        "obligatorios","Warning Message",JOptionPane.WARNING_MESSAGE);
        continuar=false;
    }else if(hayUnaConsulta==0 && testSinNombre==false){
        panelAviso.warningAction("Al menos debe introducir una consulta para guardar el test", MainApplicationJFrame.getInstance());
        JOptionPane.showMessageDialog(MainApplicationJFrame.getInstance(),"Al menos debe introducir una consulta " +
        "para guardar el test.","Warning Message",JOptionPane.WARNING_MESSAGE);
        continuar=false;
    }else if(validoRet==false){
        if(ayuda==true){
            validarConsultas.formatoIncorrecto(panelAyudaRet, this.getTabbedPaneRet(),1);
        }else{
            validarConsultas.formatoIncorrecto(texto, this.getTabbedPaneRet(),1);
        }
        continuar=false;
    }
}

public void copiarDeAyudaATexto(){
     
    test = null;
    TestInstancesTextJPanel t;
    StringBuffer conjuntoQuerysRet=new StringBuffer();
    StringBuffer conjuntoResExpRet=new StringBuffer();
    StringBuffer conjuntoComentRet=new StringBuffer();

    panelAyudaRet = this.getRetAyudaPanel();
    totalRet = panelAyudaRet.getComponentCount();

    for(int i=1;i<totalRet;i++){
        test = (TestInstancesTextAreaJPanel) panelAyudaRet.getComponent(i);
            if(!test.getQuery().equals("") || !test.getQueryResult().equals("")){
                String query = test.getQuery();
                String queryExp = test.getQueryResult();
                AddComentJDialog comentPane = test.getComment();
                String coment = comentPane.getComent();
                String[] conjFinal = queryExp.split("\n| |,");

                if(!query.equals("") || !queryExp.equals("")){
                        conjuntoQuerysRet.append(query).append("\n");
                    if(conjFinal.length==1){
                        conjuntoResExpRet.append(conjFinal[0]);
                    }else{
                        for(int j=0;j<conjFinal.length;j++){
                            if(conjuntoResExpRet.toString().equals("")){
                                conjuntoResExpRet.append(conjFinal[j]).append(",");
                            }else{
                                if(j==conjFinal.length-1){
                                    conjuntoResExpRet.append(conjFinal[j]);
                                }else{
                                    conjuntoResExpRet.append(conjFinal[j]).append(",");
                                }
                            }
                        } 
                    }
                    conjuntoResExpRet.append("\n");
                    conjuntoComentRet.append(coment).append("\n");
                } 
            }
    }
    t = (TestInstancesTextJPanel) getOpcionTextRetPanel().getComponent(0);
    t.setConsultaQuery(conjuntoQuerysRet.toString());
    t.setResultadoEsperado(conjuntoResExpRet.toString());
    t.setComentTextArea(conjuntoComentRet.toString());
    int c = retAyudaPanel.getComponentCount();
    TestInstancesTextAreaJPanel.setContadorRetClas(0);
    for(int i=1;i<c;i++){
        retAyudaPanel.remove(retAyudaPanel.getComponent(i));
        retAyudaPanel.add(new TestInstancesTextAreaJPanel(),i); 
    }
    retAyudaPanel.validate();
    t.validate();
}

public void copiarDeTextoAAyuda(){
    
    String conjuntoQuerysRet="", conjuntoResultRet="", conjuntoComentRet="";
    String cQuery[],cResult[],cComent[];
    test = null;
    
    ti = (TestInstancesTextJPanel) getOpcionTextRetPanel().getComponent(0);
    conjuntoQuerysRet = ti.getConsultaQuery();
    conjuntoResultRet = ti.getResultadoEsperado();
    conjuntoComentRet = ti.getComentTextArea();
    cQuery = conjuntoQuerysRet.split("\\n");
    cResult = conjuntoResultRet.split("\\n");
    cComent = conjuntoComentRet.split("\\n");
    int tamI = getRetAyudaPanel().getComponentCount();
    int tamInst = tamI-1;
    int j=1;
    if(!conjuntoQuerysRet.equals("")){
        for(int i=0; i<cQuery.length; i++){
            if(!cQuery[i].equals("")){
                if(i<tamInst){
                    test = (TestInstancesTextAreaJPanel) panelAyudaRet.getComponent(j);
                    test.setQuery(cQuery[i]);
                    j++;
                }else{
                    if(j<tamInst){
                        test = (TestInstancesTextAreaJPanel) panelAyudaRet.getComponent(j);
                        test.setQuery(cQuery[i]);
                        j++;
                    }else{
                        TestInstancesTextAreaJPanel instP = new TestInstancesTextAreaJPanel();
                        instP.setQuery(cQuery[i]);
                        getRetAyudaPanel().add(instP);
                    }
                }
            }
        }
        test.validate();
    }
    j=1;
    if(!conjuntoResultRet.equals("")){
    for(int i=0; i<cResult.length; i++){
        String res = cResult[i];
        if(!res.equals("")){
            if(i<tamInst){
                test = (TestInstancesTextAreaJPanel) panelAyudaRet.getComponent(j);
                if(res.equals(",") || res.endsWith(" ")){
                    test.setQueryResult("\n");
                }else{
                    test.setQueryResult(res);
                }
                j++;
            }else{
                if(j<tamInst){
                    test = (TestInstancesTextAreaJPanel) panelAyudaRet.getComponent(j);
                    if(res.equals(",") || res.endsWith(" ")){
                        test.setQueryResult("\n");
                    }else{
                        test.setQueryResult(res);
                    }
                    j++;
                }else{
                    TestInstancesTextAreaJPanel instP = new TestInstancesTextAreaJPanel();
                    if(res.equals(",") || res.endsWith(" ")){
                        instP.setQueryResult("\n");
                    }else{
                        instP.setQueryResult(res);
                    }
                    getRetAyudaPanel().add(instP);
                }
            }
        }
    }
    test.validate();
    }
    j=1;
    if(!conjuntoComentRet.equals("")){
    for(int i=0; i<cComent.length; i++){
        if(!cComent[i].equals("")){
            if(i<tamInst){
                test = (TestInstancesTextAreaJPanel) panelAyudaRet.getComponent(j);
                AddComentJDialog comentPane = test.getComment();
                comentPane.setComent(cComent[i]);
                test.setComment(comentPane);
                j++;
            }else{
                if(j<tamInst){
                    test = (TestInstancesTextAreaJPanel) panelAyudaRet.getComponent(j);
                    AddComentJDialog comentPane = test.getComment();
                    comentPane.setComent(cComent[i]);
                    test.setComment(comentPane);
                    j++;
                }else{
                    TestInstancesTextAreaJPanel instP = new TestInstancesTextAreaJPanel();
                    AddComentJDialog comentPane = instP.getComment();
                    comentPane.setComent(cComent[i]);
                    instP.setComment(comentPane);
                    getRetAyudaPanel().add(instP);
                }
            }
        }
    }
    test.validate();
    }
}

public JPanel getRetAyudaPanel() {
    return retAyudaPanel;
}

public JPanel getOpcionTextRetPanel() {
    return opcionTextRetPanel;
}

public int getActualSubTabRet() {
    return actualSubTabRet;
}

public void setActualSubTabRet(int aActualSubTabRet) {
    actualSubTabRet= aActualSubTabRet;
}

public  int getTabbedPaneRet() {
    return tabbedPaneRet.getSelectedIndex();
}

public ScenarioTest getScenario() {
    return scenario;
}

public void setScenario(ScenarioTest scenario) {
    this.scenario = scenario;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addInstanciasButton;
    private javax.swing.JPanel contentGuardarEjecutarPanel;
    private javax.swing.JPanel contentRetTabedPanel;
    private javax.swing.JPanel descripcionJPanel;
    private javax.swing.JButton ejecutarButton;
    private javax.swing.JButton guardarButton;
    private javax.swing.JButton guardarEjecutarButton;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel labelRetLabel;
    private javax.swing.JPanel labelRetPanel;
    private javax.swing.JPanel opcionAyudaRetPanel;
    private javax.swing.JPanel opcionTextRetPanel;
    private javax.swing.JPanel retAyudaPanel;
    private javax.swing.JTabbedPane tabbedPaneRet;
    // End of variables declaration//GEN-END:variables

    public ScenarioTest getScenarioActual() {
        return scenarioActual;
    }

    public void setScenarioActual(ScenarioTest scenarioActual) {
        this.scenarioActual = scenarioActual;
    }

}
