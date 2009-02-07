/*
 * TestSimpleReal.java
 *
 * Created on 15 de septiembre de 2008, 11:27
 */

package code.google.com.p.ontologytesting.gui.tests;

import code.google.com.p.ontologytesting.gui.auxiliarclasess.*;
import code.google.com.p.ontologytesting.gui.*;
import code.google.com.p.ontologytesting.gui.auxiliarpanels.ProgressControlJDialog;
import code.google.com.p.ontologytesting.model.*;
import code.google.com.p.ontologytesting.model.reasonerinterfaz.InvalidOntologyException;
import code.google.com.p.ontologytesting.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author  sara.garcia
 */
public class TestSimpleReal extends javax.swing.JPanel {

    private ValidarTests validarTests;
    private TestInstancesQueryJPanel test;
    private DescripcionJPanel descPanel = null;
    private boolean testSinNombre,validoReal,ambosNecesarios,continuar,guardado,nombreCambio=false;
    private JPanel panelAyudaReal;
    private int totalReal=0,hayUnaConsulta=0,actualSubTabReal=0;
    private List real;
    private TestInstancesTextJPanel texto;
    private ScenarioTest scenario;
    private IOManagerImplementation persist = new IOManagerImplementation();
    private ScenarioTest scenarioActual;
    private String nombreTest = "",descTest = "",nombreTestBis="";
    private ControladorTests controlador;
    private OpcionesMenu menu;
    private ValidarConsultas validarConsultas = new ValidarConsultas();
    private List<QueryOntology> queryTest;
    private QueryOntology testQuery;
    private AniadirPanelDeAviso panelAviso;
    private ProgressControlJDialog progres;

    public TestSimpleReal(ScenarioTest s){
        initComponents();
        panelAviso = new AniadirPanelDeAviso();
        jScrollPane6.getVerticalScrollBar().setUnitIncrement(7);
        TestInstancesQueryJPanel.setContadorReal(0);
        descripcionJPanel.setLayout(new BoxLayout(descripcionJPanel, BoxLayout.X_AXIS));
        descripcionJPanel.add(new DescripcionJPanel());
        opcionAyudaRealPanel.setLayout(new BoxLayout(opcionAyudaRealPanel, BoxLayout.Y_AXIS));
        opcionTextRealPanel.setLayout(new BoxLayout(getOpcionTextRealPanel(), BoxLayout.Y_AXIS));
        realAyudaPanel.setLayout(new BoxLayout(getRealAyudaPanel(), BoxLayout.Y_AXIS));
        controlador = ControladorTests.getInstance();
        opcionTextRealPanel.add(new TestInstancesTextJPanel());
        int cont=1;
        List<QueryOntology> listaQuerys = s.getQueryTest(); 
        ListIterator qi;
        qi = listaQuerys.listIterator();
        
        descPanel = (DescripcionJPanel) descripcionJPanel.getComponent(0);
        descPanel.setNombreTextField(s.getNombre());
        descPanel.setDescTextArea(s.getDescripcion());
        while(qi.hasNext()){ 
            QueryOntology cI = (QueryOntology) qi.next();
            TestInstancesQueryJPanel panelInstances = new TestInstancesQueryJPanel();
            AddComentJDialog comentPane = panelInstances.getComment();
            comentPane.setComent(cI.getComment());
            panelInstances.setComment(comentPane);
            panelInstances.setQuery(cI.getQuery());
            panelInstances.setQueryResult(cI.getResultexpected());
            realAyudaPanel.add(panelInstances,cont);
            cont++;
        }
        if(cont<8){
            for (int i = cont; i <= 8; i++) {  
                realAyudaPanel.add(new TestInstancesQueryJPanel());   
            }
        }
        menu = new OpcionesMenu();
        setScenario(s);
        if(s.getNombre().equals("")){
            this.setGuardado(false);
        }else{
            nombreTestBis=s.getNombre();
            this.setGuardado(true);
        }
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        contentRealTabedPanel = new javax.swing.JPanel();
        tabbedPaneReal = new javax.swing.JTabbedPane();
        opcionAyudaRealPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        realAyudaPanel = new javax.swing.JPanel();
        labelRealPanel = new javax.swing.JPanel();
        labelRealLabel = new javax.swing.JLabel();
        opcionTextRealPanel = new javax.swing.JPanel();
        contentGuardarEjecutarPanel = new javax.swing.JPanel();
        guardarButton = new javax.swing.JButton();
        guardarEjecutarButton = new javax.swing.JButton();
        ejecutarButton = new javax.swing.JButton();
        addInstanciasButton = new javax.swing.JButton();
        descripcionJPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        contentRealTabedPanel.setLayout(new java.awt.BorderLayout());

        tabbedPaneReal.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedPaneRealMouseClicked(evt);
            }
        });

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        labelRealLabel.setText(java.util.ResourceBundle.getBundle(Configuration.getPropiedades().getProperty("IDIOMA"),new Locale(Configuration.getPropiedades().getProperty("LOCALE"))).getString("CONSULTASREAL_RESULTADO_ESPERADO"));

        javax.swing.GroupLayout labelRealPanelLayout = new javax.swing.GroupLayout(labelRealPanel);
        labelRealPanel.setLayout(labelRealPanelLayout);
        labelRealPanelLayout.setHorizontalGroup(
            labelRealPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelRealPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelRealLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        labelRealPanelLayout.setVerticalGroup(
            labelRealPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelRealPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelRealLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout realAyudaPanelLayout = new javax.swing.GroupLayout(realAyudaPanel);
        realAyudaPanel.setLayout(realAyudaPanelLayout);
        realAyudaPanelLayout.setHorizontalGroup(
            realAyudaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
            .addGroup(realAyudaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(realAyudaPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(labelRealPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(127, Short.MAX_VALUE)))
        );
        realAyudaPanelLayout.setVerticalGroup(
            realAyudaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
            .addGroup(realAyudaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(realAyudaPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(labelRealPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(302, Short.MAX_VALUE)))
        );

        jScrollPane6.setViewportView(realAyudaPanel);

        javax.swing.GroupLayout opcionAyudaRealPanelLayout = new javax.swing.GroupLayout(opcionAyudaRealPanel);
        opcionAyudaRealPanel.setLayout(opcionAyudaRealPanelLayout);
        opcionAyudaRealPanelLayout.setHorizontalGroup(
            opcionAyudaRealPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionAyudaRealPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                .addContainerGap())
        );
        opcionAyudaRealPanelLayout.setVerticalGroup(
            opcionAyudaRealPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionAyudaRealPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPaneReal.addTab(java.util.ResourceBundle.getBundle(Configuration.getPropiedades().getProperty("IDIOMA"),new Locale(Configuration.getPropiedades().getProperty("LOCALE"))).getString("Formato_ayuda"), opcionAyudaRealPanel);

        javax.swing.GroupLayout opcionTextRealPanelLayout = new javax.swing.GroupLayout(opcionTextRealPanel);
        opcionTextRealPanel.setLayout(opcionTextRealPanelLayout);
        opcionTextRealPanelLayout.setHorizontalGroup(
            opcionTextRealPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
        );
        opcionTextRealPanelLayout.setVerticalGroup(
            opcionTextRealPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );

        tabbedPaneReal.addTab(java.util.ResourceBundle.getBundle(Configuration.getPropiedades().getProperty("IDIOMA"),new Locale(Configuration.getPropiedades().getProperty("LOCALE"))).getString("Formato_Texto"), opcionTextRealPanel);

        contentRealTabedPanel.add(tabbedPaneReal, java.awt.BorderLayout.CENTER);

        guardarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/disk.png"))); // NOI18N
        guardarButton.setToolTipText("Guardar");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        guardarEjecutarButton.setText(java.util.ResourceBundle.getBundle(Configuration.getPropiedades().getProperty("IDIOMA"),new Locale(Configuration.getPropiedades().getProperty("LOCALE"))).getString("Guardar_y_Ejecutar"));
        guardarEjecutarButton.setToolTipText("Guardar y Ejecutar");
        guardarEjecutarButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarEjecutarButtonActionPerformed(evt);
            }
        });

        ejecutarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/cog.png"))); // NOI18N
        ejecutarButton.setToolTipText("Ejecutar");
        ejecutarButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecutarButtonActionPerformed(evt);
            }
        });

        addInstanciasButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/add.png"))); // NOI18N
        addInstanciasButton.setText(java.util.ResourceBundle.getBundle(Configuration.getPropiedades().getProperty("IDIOMA"),new Locale(Configuration.getPropiedades().getProperty("LOCALE"))).getString("Instancias"));
        addInstanciasButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInstanciasButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentGuardarEjecutarPanelLayout = new javax.swing.GroupLayout(contentGuardarEjecutarPanel);
        contentGuardarEjecutarPanel.setLayout(contentGuardarEjecutarPanelLayout);
        contentGuardarEjecutarPanelLayout.setHorizontalGroup(
            contentGuardarEjecutarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentGuardarEjecutarPanelLayout.createSequentialGroup()
                .addContainerGap(257, Short.MAX_VALUE)
                .addComponent(guardarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ejecutarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guardarEjecutarButton)
                .addGap(18, 18, 18)
                .addComponent(addInstanciasButton)
                .addGap(8, 8, 8))
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

        contentRealTabedPanel.add(contentGuardarEjecutarPanel, java.awt.BorderLayout.PAGE_START);

        add(contentRealTabedPanel, java.awt.BorderLayout.CENTER);

        descripcionJPanel.setLayout(new java.awt.BorderLayout());
        add(descripcionJPanel, java.awt.BorderLayout.PAGE_START);
    }

private void tabbedPaneRealMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedPaneRealMouseClicked
// TODO add your handling code here:
    int subTab = getTabbedPaneReal();
    if(getActualSubTabReal()!=subTab){
        if(subTab==1){
            copiarDeAyudaATexto();
        }else{
            copiarDeTextoAAyuda();
        }
        setActualSubTabReal(subTab);
    }
}//GEN-LAST:event_tabbedPaneRealMouseClicked

private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
// TODO add your handling code here:
    boolean g = guardarTest();
    if(g==true){
        setGuardado(true);
        ListAndTestsJPanel.getInstance().aniadirNombre(this.getTabbedPaneReal(), getScenario().getNombre());
    }
}//GEN-LAST:event_guardarButtonActionPerformed

private void guardarEjecutarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarEjecutarButtonActionPerformed
// TODO add your handling code here:
    if(getTabbedPaneReal()==0){
        copiarTestAScenarioDesdeAyuda();
    }else if(getTabbedPaneReal()==1){
        copiarTestAScenarioDesdeSinAyuda();
    }
    if(continuar==true){
        //if(continuarSinInstancias==0){
            this.realizarAccion(true, true);
        /*}else if(continuarSinInstancias==1){
            menu.editarInstancias(this.getScenario());
        }*/
    } 
}//GEN-LAST:event_guardarEjecutarButtonActionPerformed

private void ejecutarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarButtonActionPerformed
// TODO add your handling code here:
   if(getTabbedPaneReal()==0){
        copiarTestAScenarioDesdeAyuda();
    }else if(getTabbedPaneReal()==1){
        copiarTestAScenarioDesdeSinAyuda();
    }
    if(continuar==true){
        //if(continuarSinInstancias==0){
            this.realizarAccion(false, true);
        /*}else if(continuarSinInstancias==1){
            menu.editarInstancias(this.getScenario());
        }*/
    }
}//GEN-LAST:event_ejecutarButtonActionPerformed

private void addInstanciasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInstanciasButtonActionPerformed
// TODO add your handling code here:
    menu.editarInstancias(this.getScenario());
}//GEN-LAST:event_addInstanciasButtonActionPerformed

public boolean guardarTest(){
    if(getTabbedPaneReal()==0){
        copiarTestAScenarioDesdeAyuda();
    }else if(getTabbedPaneReal()==1){
        copiarTestAScenarioDesdeSinAyuda();
    }
    if(continuar==true){
        //if(continuarSinInstancias==0){
            this.realizarAccion(true, false);
        /*}else if(continuarSinInstancias==1){
            menu.editarInstancias(this.getScenario());
        }*/
    }
    return continuar;
}

public void realizarAccion(boolean guardar, boolean ejecutar){  
    persist = new IOManagerImplementation();
    if(guardar==true){
        if(persist.testYaGuardado(scenario)==true){
            Object[] options = {"Sobreescribir", "Cancelar"};
            int n = JOptionPane.showOptionDialog(MainApplicationJFrame.getInstance(), "Ya existe un test guardado con este nombre. ¿Qué desea hacer?", 
                    "Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (n == JOptionPane.YES_OPTION){
                persist.replaceScenarioLocally(getScenario());
            }else continuar=false;
            }else{
                if(persist.testExiste(scenario)==false){
                    persist.saveTestInMemory(getScenario());
                    controlador.setTestRealGuardado(true);
                }
            }
            this.setScenarioActual(new ScenarioTest(this.getScenario()));
            this.setGuardado(true);
            ListAndTestsJPanel.getInstance().aniadirNombre(this.getTabbedPaneReal(), getScenario().getNombre());
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
        }catch (InvalidOntologyException ex){
            panelAviso.errorAction("No se pudo ejecutar el test. Ontología no válida", MainApplicationJFrame.getInstance());
        }
    }
    if(guardar==true && ejecutar==false && continuar==true){
        panelAviso.confirmAction("Test Guardado", MainApplicationJFrame.getInstance());
    }
    menu.actualizarListaDeTestsSimples(CollectionTest.getInstance().getScenariotest());
}

public void inicializarVariables(){
    ambosNecesarios=false;
    testSinNombre=false;
    validoReal=true;
    hayUnaConsulta=0;
    continuar=true;
}

public void copiarTestAScenarioDesdeAyuda(){

    inicializarVariables();

    queryTest = new ArrayList<QueryOntology>();
    test = null; 
    
    panelAyudaReal= this.getRealAyudaPanel();
    totalReal = panelAyudaReal.getComponentCount();
    validarTests = new ValidarTests();
    
    real = new ArrayList();
    this.real.add(0,0);
    validarConsultas.setListReal(this.real);
    descPanel = (DescripcionJPanel) descripcionJPanel.getComponent(0);
    nombreTest = descPanel.getNombreTextField();
    descTest = descPanel.getDescTextArea();
    if(descPanel.testSinNombre()==true){
        testSinNombre=true;
    }else{
        for(int i=1;i<totalReal;i++){
            test = (TestInstancesQueryJPanel) panelAyudaReal.getComponent(i);
            if(test.panelVacio()==false){
                if(ambosNecesarios==false){
                    if(test.consultaCompletaEnAyuda()==false){
                        ambosNecesarios=true;
                    }else{
                        String query = test.getQuery().trim();
                        String resExpT = test.getQueryResult().trim();
                        AddComentJDialog comentPane = test.getComment();
                        String coment = comentPane.getComent();
                        hayUnaConsulta=1;
                        testQuery = new QueryOntology(query,resExpT,coment);
                        if(validarTests.validarQuery(testQuery.getQuery())==true){
                            queryTest.add(testQuery);
                            this.real.add(i, 0);
                            validarConsultas.setListReal(this.real);
                        }else{
                            this.real.add(i, 1);
                            validarConsultas.setListReal(this.real);
                            validoReal=false;
                        }
                    }
                }
            }
        }
    }
    
    if(testSinNombre==false && validoReal==true && ambosNecesarios==false
                && hayUnaConsulta==1){  
        //int res = this.preguntarSiContinuarSinInstancias();
        //if(res==0){
        this.getScenario().setDescripcion(descTest);
        if(!nombreTest.equals(nombreTestBis)){
            nombreCambio=true;
        }
        this.getScenario().setNombre(nombreTest);
        this.getScenario().setQueryTest(queryTest); 
        //}
    }else {
        mostrarErrores(true);
    }
}

/*public int preguntarSiContinuarSinInstancias(){
        if(scenario.tieneInstanciasAsociadas()==false){
            int n = JOptionPane.showConfirmDialog(MainApplicationJFrame.getInstance(), "El test no tiene instancias asociadas. " +
                    "¿Desea continuar?", "Warning Message",JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.NO_OPTION){
                return continuarSinInstancias=1;
            }else if(n == JOptionPane.YES_OPTION){
                return continuarSinInstancias=0;
            }else{
                return continuarSinInstancias=2;
            }
        }else return continuarSinInstancias=2;
}*/

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
    texto = (TestInstancesTextJPanel) getOpcionTextRealPanel().getComponent(0);
    conjuntoQuerys = texto.getConsultaQuery();
    conjuntoResult = texto.getResultadoEsperado();
    conjuntoComent = texto.getComentTextArea();
    cQuery = conjuntoQuerys.split("\\\n");
    cResult = conjuntoResult.split("\\\n");
    cComent = conjuntoComent.split("\\\n");
    
    nombreTest = descPanel.getNombreTextField();
    descTest = descPanel.getDescTextArea();
    
    real = new ArrayList();
    this.real.add(0,0);
    validarConsultas.setListReal(this.real);
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
                                    validarTests.validarQuery(cResult[i])==true){
                                if(cComent.length!=0 && i!=cComent.length && i<=cComent.length){
                                    testQuery = new QueryOntology(cQuery[i],cResult[i],cComent[i]);
                                }else{
                                    testQuery = new QueryOntology(cQuery[i],cResult[i]);
                                }
                                queryTest.add(testQuery);
                                this.real.add(i, 0);
                                validarConsultas.setListReal(this.real);
                            }else if(validarTests.validarQuery(cQuery[i])==false &&
                                    validarTests.validarQuery(cResult[i])==true){
                                this.real.add(i, 1);
                                validarConsultas.setListReal(this.real);
                                validoReal=false;
                            }else if(validarTests.validarQuery(cQuery[i])==true &&
                                    validarTests.validarQuery(cResult[i])==false){
                                this.real.add(i, 2);
                                validarConsultas.setListReal(this.real);
                                validoReal=false;
                            }else{
                                this.real.add(i, 3);
                                validarConsultas.setListReal(this.real);
                                validoReal=false;
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
    if(testSinNombre==false && validoReal==true && ambosNecesarios==false
        && hayUnaConsulta==1){
        //continuarSinInstancias = this.preguntarSiContinuarSinInstancias();
        //if(continuarSinInstancias==0){
        this.getScenario().setDescripcion(descTest);
        if(!nombreTest.equals(nombreTestBis)){
            nombreCambio=true;
        }
        this.getScenario().setNombre(nombreTest);
        this.getScenario().setQueryTest(queryTest);
        //}
    }else {
        mostrarErrores(false);
    }
}

public void mostrarErrores(boolean ayuda){
    if(testSinNombre==true){
            panelAviso.warningAction("El nombre del test es obligatorio", MainApplicationJFrame.getInstance());
            continuar=false;
    }else if(ambosNecesarios==true){
        panelAviso.warningAction("Ambos campos CONSULTA y RESULTADO ESPERADO son obligatorios", MainApplicationJFrame.getInstance());
        continuar=false;
    }else if(hayUnaConsulta==0 && testSinNombre==false){
        panelAviso.warningAction("Al menos debe introducir una consulta para guardar el test", MainApplicationJFrame.getInstance());
        continuar=false;
    }else if(validoReal==false){
        if(ayuda==true){
            validarConsultas.formatoIncorrecto(panelAyudaReal, this.getTabbedPaneReal(),2);
        }else{
            validarConsultas.formatoIncorrecto(texto, this.getTabbedPaneReal(),2);
        }
        continuar=false;
    }
}

public void copiarDeAyudaATexto(){
     
    test = null;
    TestInstancesTextJPanel t;
    StringBuffer conjuntoQuerysReal = new StringBuffer();
    StringBuffer conjuntoResExpReal = new StringBuffer();
    StringBuffer conjuntoComentReal = new StringBuffer();

    panelAyudaReal = this.getRealAyudaPanel();
    totalReal = panelAyudaReal.getComponentCount();

   for(int i=1;i<totalReal;i++){
        test = (TestInstancesQueryJPanel) panelAyudaReal.getComponent(i);
            if(!test.getQuery().equals("") || !test.getQueryResult().equals("")){
                String query = test.getQuery().trim();
                String queryExp = test.getQueryResult().trim();
                AddComentJDialog comentPane = test.getComment();
                String coment = comentPane.getComent();
                if(!query.equals("") || !queryExp.equals("")){
                    conjuntoQuerysReal.append(query).append("\n");
                    conjuntoResExpReal.append(queryExp).append("\n");
                    conjuntoComentReal.append(coment).append("\n");
                } 
            }
    }
    t = (TestInstancesTextJPanel) getOpcionTextRealPanel().getComponent(0);
    t.setConsultaQuery(conjuntoQuerysReal.toString());
    t.setResultadoEsperado(conjuntoResExpReal.toString());
    t.setComentTextArea(conjuntoComentReal.toString());
    int c = realAyudaPanel.getComponentCount();
    TestInstancesQueryJPanel.setContadorReal(0);
    for(int i=1;i<c;i++){
        realAyudaPanel.remove(realAyudaPanel.getComponent(i));
        realAyudaPanel.add(new TestInstancesQueryJPanel(),i); 
    }
    realAyudaPanel.validate();
    t.validate();
}

public void copiarDeTextoAAyuda(){

    test = null;

    panelAyudaReal = this.getRealAyudaPanel();
    totalReal = panelAyudaReal.getComponentCount();

    TestInstancesTextJPanel ti;

    String conjuntoQuerysReal="",conjuntoResultReal="",conjuntoComentReal="";
    String cQuery[],cResult[],cComent[];

    ti = (TestInstancesTextJPanel) getOpcionTextRealPanel().getComponent(0);
        conjuntoQuerysReal = ti.getConsultaQuery().trim();
        conjuntoResultReal = ti.getResultadoEsperado().trim();
        conjuntoComentReal = ti.getComentTextArea().trim();
        cQuery = conjuntoQuerysReal.split("\\\n");
        cResult = conjuntoResultReal.split("\\\n");
        cComent = conjuntoComentReal.split("\\\n");
        int tamI = getRealAyudaPanel().getComponentCount();
        int tamInst = tamI-1;
        int j=1;
        if(!conjuntoQuerysReal.equals("")){
        for(int i=0; i<cQuery.length; i++){
            if(!cQuery[i].equals("")){
                if(i<tamInst){
                    test = (TestInstancesQueryJPanel) panelAyudaReal.getComponent(j);
                    test.setQuery(cQuery[i].trim());
                    j++;
                }else{
                    if(j<tamInst){
                        test = (TestInstancesQueryJPanel) panelAyudaReal.getComponent(j);
                        test.setQuery(cQuery[i].trim());
                        j++;
                    }else{
                        TestInstancesQueryJPanel instP = new TestInstancesQueryJPanel();
                        instP.setQuery(cQuery[i].trim());
                        getRealAyudaPanel().add(instP);
                    }
                }
            }
        }
        test.validate();
        }
        j=1;
        if(!conjuntoResultReal.equals("")){
        for(int i=0; i<cResult.length; i++){
            String res = cResult[i];
            if(!res.equals("")){
                if(i<tamInst){
                    test = (TestInstancesQueryJPanel) panelAyudaReal.getComponent(j);
                    test.setQueryResult(res.trim());
                    j++;
                }else{
                    if(j<tamInst){
                        test = (TestInstancesQueryJPanel) panelAyudaReal.getComponent(j);
                        test.setQueryResult(res.trim());
                        j++;
                    }else{
                        TestInstancesQueryJPanel instP = new TestInstancesQueryJPanel();
                        instP.setQueryResult(res.trim());
                        getRealAyudaPanel().add(instP);
                    }
                }
            }
        }
        test.validate();
        }
        j=1;
        if(!conjuntoComentReal.equals("")){
        for(int i=0; i<cComent.length; i++){
            if(!cComent[i].equals("")){
                if(i<tamInst){
                    test = (TestInstancesQueryJPanel) panelAyudaReal.getComponent(j);
                    AddComentJDialog comentPane = test.getComment();
                    comentPane.setComent(cComent[i]);
                    test.setComment(comentPane);
                    j++;
                }else{
                    if(j<tamInst){
                        test = (TestInstancesQueryJPanel) panelAyudaReal.getComponent(j);
                        AddComentJDialog comentPane = test.getComment();
                        comentPane.setComent(cComent[i]);
                        test.setComment(comentPane);
                        j++;
                    }else{
                        TestInstancesQueryJPanel instP = new TestInstancesQueryJPanel();
                        AddComentJDialog comentPane = instP.getComment();
                        comentPane.setComent(cComent[i]);
                        instP.setComment(comentPane);
                        getRealAyudaPanel().add(instP);
                    }
                }
            }
        }  
        test.validate();
        }
}

public int getActualSubTabReal() {
    return actualSubTabReal;
}

public void setActualSubTabReal(int aActualSubTabReal) {
    actualSubTabReal = aActualSubTabReal;
}

public JPanel getRealAyudaPanel() {
    return realAyudaPanel;
}

public JPanel getOpcionTextRealPanel() {
        return opcionTextRealPanel;
}

public ScenarioTest getScenario() {
    if(this.isGuardado()==false || nombreCambio==true){
        return scenario;
    }else{
        return scenario.buscarScenario(CollectionTest.getInstance().getScenariotest(), scenario.getNombre());
    }
}

public void setScenario(ScenarioTest aScenarioInst) {
    scenario = aScenarioInst;
}

public  int getTabbedPaneReal() {
    return tabbedPaneReal.getSelectedIndex();
}

public JPanel panelActualReal(){
    return this.getRealAyudaPanel();
}

public boolean isGuardado() {
    return guardado;
}

public void setGuardado(boolean guardado) {
    this.guardado = guardado;
}

public ScenarioTest getScenarioActual() {
    return scenarioActual;
}

public void setScenarioActual(ScenarioTest scenarioActual) {
    this.scenarioActual = scenarioActual;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addInstanciasButton;
    private javax.swing.JPanel contentGuardarEjecutarPanel;
    private javax.swing.JPanel contentRealTabedPanel;
    private javax.swing.JPanel descripcionJPanel;
    private javax.swing.JButton ejecutarButton;
    private javax.swing.JButton guardarButton;
    private javax.swing.JButton guardarEjecutarButton;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel labelRealLabel;
    private javax.swing.JPanel labelRealPanel;
    private javax.swing.JPanel opcionAyudaRealPanel;
    private javax.swing.JPanel opcionTextRealPanel;
    private javax.swing.JPanel realAyudaPanel;
    private javax.swing.JTabbedPane tabbedPaneReal;
    // End of variables declaration//GEN-END:variables
}
