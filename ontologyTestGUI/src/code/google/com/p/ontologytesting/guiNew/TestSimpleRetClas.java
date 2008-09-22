/*
 * TestSimpleRetClas.java
 *
 * Created on 15 de septiembre de 2008, 10:18
 */

package code.google.com.p.ontologytesting.guiNew;

import code.google.com.p.ontologytesting.controller.*;
import code.google.com.p.ontologytesting.exceptions.ExceptionReadOntology;
import code.google.com.p.ontologytesting.model.*;
import code.google.com.p.ontologytesting.validations.*;
import code.google.com.p.ontologytesting.persistence.SaveTest;
import java.awt.Component;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author  sara.garcia
 */
public class TestSimpleRetClas extends javax.swing.JPanel {

    private static ValidarTests validarTests;
    private static TestInstancesTextAreaJPanel test;
    private static DescripcionJPanel descPanel = null;
    private static boolean testSinNombre;
    private static int actualSubTabRet=0;
    private static boolean validoRet;
    private static JPanel panelAyudaRet;
    private static int totalRet;
    static final int desktopWidth = 750;
    static final int desktopHeight = 600;
    static JFrame frame;
    private static boolean ambosNecesarios;
    public static boolean seleccionado;
    private static List ret;
    private static boolean continuarSinInstancias;
    private static boolean testYaExiste;
    private static int hayUnaConsulta=0;
    private TestInstancesTextJPanel ti;
    private Component comp;
    private static List<QueryOntology> queryTest;
    private static TestInstancesTextJPanel texto;
    private ScenarioTest scenario;
    private boolean continuar;
    private int tipo;
    private SaveTest saveTest;
    private AddInstancesClasPropJDialog addInst;
    private String nombreTest = "",descTest = "";
    private static OntologyTestResult testresult;
    private OntologyTestCase testcase;
    private ResultTests resultTests;
    private ScenarioTest scenarioAEditar;
    private Auxiliar auxiliar;
    private boolean importado;
    private boolean soloEjecutar;
    
    /** Creates new form TestSimpleRetClas */
    public TestSimpleRetClas(int type) {
        initComponents();
        Auxiliar.setContadorInstSat(0);
        descripcionJPanel.setLayout(new FlowLayout());
        descripcionJPanel.add(new DescripcionJPanel());
        opcionTextRetPanel.setLayout(new BoxLayout(getOpcionTextRetPanel(), BoxLayout.Y_AXIS));
        retAyudaPanel.setLayout(new BoxLayout(getRetAyudaPanel(), BoxLayout.Y_AXIS));
        for (int i = 1; i <= 10; i++) {  
            retAyudaPanel.add(new TestInstancesTextAreaJPanel());   
        }
        opcionTextRetPanel.add(new TestInstancesTextJPanel());
        setTipo(type);
        setScenarioAEditar(null);
        setScenario(new ScenarioTest()); 
        Auxiliar.setTestSimpleRetClas(this);
        setImportado(false);
        setSoloEjecutar(false);
    }
    
    public TestSimpleRetClas(int type,ScenarioTest s){
        initComponents();
        Auxiliar.setContadorInstSat(0);
        descripcionJPanel.setLayout(new FlowLayout());
        descripcionJPanel.add(new DescripcionJPanel());
        opcionTextRetPanel.setLayout(new BoxLayout(getOpcionTextRetPanel(), BoxLayout.Y_AXIS));
        retAyudaPanel.setLayout(new BoxLayout(getRetAyudaPanel(), BoxLayout.Y_AXIS));
        
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
        if(cont<10){
            for (int i = cont; i <= 10; i++) {  
                retAyudaPanel.add(new TestInstancesTextAreaJPanel());   
            }
        }
        scenarioAEditar = new ScenarioTest(s);
        setScenario(s);
        setTipo(type);
        Auxiliar.setTestSimpleRetClas(this);
        setImportado(true);
        setSoloEjecutar(false);
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
        descripcionJPanel = new javax.swing.JPanel();
        contentGuardarEjecutarPanel = new javax.swing.JPanel();
        guardarButton = new javax.swing.JButton();
        guardarEjecutarButton = new javax.swing.JButton();
        ejecutarButton = new javax.swing.JButton();

        tabbedPaneRet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedPaneRetMouseClicked(evt);
            }
        });

        labelRetLabel.setText("                      CONSULTAS                               RESULTADO ESPERADO");

        javax.swing.GroupLayout labelRetPanelLayout = new javax.swing.GroupLayout(labelRetPanel);
        labelRetPanel.setLayout(labelRetPanelLayout);
        labelRetPanelLayout.setHorizontalGroup(
            labelRetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelRetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelRetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
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
                .addContainerGap(431, Short.MAX_VALUE))
        );
        retAyudaPanelLayout.setVerticalGroup(
            retAyudaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(retAyudaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelRetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(501, Short.MAX_VALUE))
        );

        jScrollPane6.setViewportView(retAyudaPanel);

        javax.swing.GroupLayout opcionAyudaRetPanelLayout = new javax.swing.GroupLayout(opcionAyudaRetPanel);
        opcionAyudaRetPanel.setLayout(opcionAyudaRetPanelLayout);
        opcionAyudaRetPanelLayout.setHorizontalGroup(
            opcionAyudaRetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionAyudaRetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        opcionAyudaRetPanelLayout.setVerticalGroup(
            opcionAyudaRetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionAyudaRetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE))
        );

        tabbedPaneRet.addTab("Formato ayuda", opcionAyudaRetPanel);

        javax.swing.GroupLayout opcionTextRetPanelLayout = new javax.swing.GroupLayout(opcionTextRetPanel);
        opcionTextRetPanel.setLayout(opcionTextRetPanelLayout);
        opcionTextRetPanelLayout.setHorizontalGroup(
            opcionTextRetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 825, Short.MAX_VALUE)
        );
        opcionTextRetPanelLayout.setVerticalGroup(
            opcionTextRetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        tabbedPaneRet.addTab("Formato Texto", opcionTextRetPanel);

        javax.swing.GroupLayout contentRetTabedPanelLayout = new javax.swing.GroupLayout(contentRetTabedPanel);
        contentRetTabedPanel.setLayout(contentRetTabedPanelLayout);
        contentRetTabedPanelLayout.setHorizontalGroup(
            contentRetTabedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
            .addGroup(contentRetTabedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contentRetTabedPanelLayout.createSequentialGroup()
                    .addComponent(tabbedPaneRet, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        contentRetTabedPanelLayout.setVerticalGroup(
            contentRetTabedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
            .addGroup(contentRetTabedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contentRetTabedPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabbedPaneRet, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout descripcionJPanelLayout = new javax.swing.GroupLayout(descripcionJPanel);
        descripcionJPanel.setLayout(descripcionJPanelLayout);
        descripcionJPanelLayout.setHorizontalGroup(
            descripcionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        descripcionJPanelLayout.setVerticalGroup(
            descripcionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 145, Short.MAX_VALUE)
        );

        guardarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/disk.png"))); // NOI18N
        guardarButton.setText("Guardar");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        guardarEjecutarButton.setText("Guardar y Ejecutar");
        guardarEjecutarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarEjecutarButtonActionPerformed(evt);
            }
        });

        ejecutarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/cog.png"))); // NOI18N
        ejecutarButton.setText("Ejecutar");
        ejecutarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecutarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentGuardarEjecutarPanelLayout = new javax.swing.GroupLayout(contentGuardarEjecutarPanel);
        contentGuardarEjecutarPanel.setLayout(contentGuardarEjecutarPanelLayout);
        contentGuardarEjecutarPanelLayout.setHorizontalGroup(
            contentGuardarEjecutarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentGuardarEjecutarPanelLayout.createSequentialGroup()
                .addContainerGap(477, Short.MAX_VALUE)
                .addComponent(guardarButton)
                .addGap(18, 18, 18)
                .addComponent(ejecutarButton)
                .addGap(18, 18, 18)
                .addComponent(guardarEjecutarButton)
                .addContainerGap())
        );
        contentGuardarEjecutarPanelLayout.setVerticalGroup(
            contentGuardarEjecutarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentGuardarEjecutarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(guardarEjecutarButton)
                .addComponent(ejecutarButton)
                .addComponent(guardarButton))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(contentGuardarEjecutarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(descripcionJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(contentRetTabedPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(descripcionJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contentRetTabedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentGuardarEjecutarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
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
    Auxiliar.setTestSimpleRetClas(this);
    guardarTest();
}//GEN-LAST:event_guardarButtonActionPerformed

private void guardarEjecutarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarEjecutarButtonActionPerformed
// TODO add your handling code here:
    Auxiliar.setTestSimpleRetClas(this);
    saveTest = new SaveTest();
    testcase = new OntologyTestCase();
    resultTests = new ResultTests();
    testresult = new OntologyTestResult();
    if(getTabbedPaneRet()==0){
        copiarTestAScenarioDesdeAyuda();
    }else if(getTabbedPaneRet()==1){
        copiarTestAScenarioDesdeSinAyuda();
    }
    if(continuar==true){
        if(continuarSinInstancias==true){
            guardarYEjecutar();
        }else{
            addInst = new AddInstancesClasPropJDialog(frame,true,0);
            addInst.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            addInst.setVisible(true);
        }
    }
    Auxiliar.setTestSimpleRetClas(this);
}//GEN-LAST:event_guardarEjecutarButtonActionPerformed

private void ejecutarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarButtonActionPerformed
// TODO add your handling code here:
    setSoloEjecutar(true);
    Auxiliar.setTestSimpleRetClas(this);//GEN-LAST:event_ejecutarButtonActionPerformed
    saveTest = new SaveTest();
    testcase = new OntologyTestCase();
    resultTests = new ResultTests();
    testresult = new OntologyTestResult();
    if(getTabbedPaneRet()==0){
        copiarTestAScenarioDesdeAyuda();
    }else if(getTabbedPaneRet()==1){
        copiarTestAScenarioDesdeSinAyuda();
    }
    if(continuar==true){
        if(continuarSinInstancias==true){
            ejecutar(0);
        }else{
            addInst = new AddInstancesClasPropJDialog(frame,true,0);
            addInst.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            addInst.setVisible(true);
        }
    }
    Auxiliar.setTestSimpleRetClas(this);
}

public void ejecutar(int cuantos){
    if(isSoloEjecutar()==true){
        auxiliar = new Auxiliar();
        if(auxiliar.mismoScenario(scenario, this.getScenarioAEditar())==false){
            saveTest.replaceTestLocally(scenario);
        }else{
            saveTest.saveTestLocally(scenario);
        }
    }
    try{
        if(cuantos==0){
            testcase.runScenario(testresult, MainApplication.getCollection(),getScenario());   
        }else if(cuantos==1){
            testcase.run(testresult, MainApplication.getCollection());
        }
        JPanel panel = new TreeResults(testresult);
        resultTests.getContentPanelResults().add(panel);
        resultTests.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        resultTests.setVisible(true);
        resultTests.validate();
    }catch (ExceptionReadOntology ex) {
        new ExceptionReadOntology("La ontologia introducida no es valida." +
        "\nSolo pueden realizarse tests sobre documentos owl consistentes");
    }
}

public boolean guardarTest(){
    if(getTabbedPaneRet()==0){
        copiarTestAScenarioDesdeAyuda();
    }else if(getTabbedPaneRet()==1){
        copiarTestAScenarioDesdeSinAyuda();
    }
    if(continuar==true){
        if(continuarSinInstancias==true){
            guardar();
            Auxiliar.setTestSimpleRetClas(this);
            return true;
        }else{
            addInst = new AddInstancesClasPropJDialog(frame,true,getTipo());
            addInst.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            addInst.setVisible(true);
            return false;
        }
    }else{
        return false;
    }  
}

public void guardar(){
    saveTest = new SaveTest();
    auxiliar = new Auxiliar();
    if(testYaExiste==true || isImportado()==true){
        if(auxiliar.mismoScenario(scenario, this.getScenarioAEditar())==false){
            Object[] options = {"Sobreescribir", "Cancelar"};
            int n = JOptionPane.showOptionDialog(frame, "El test ya existe o ha sido modificado. ¿Que desea hacer?", 
                    "Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (n == JOptionPane.YES_OPTION) {
                try {
                    saveTest.saveTestInMemory(scenario);
                    if(testYaExiste==true){
                        saveTest.replaceTestLocally(scenario);
                    }else{
                        saveTest.saveTestLocally(scenario);
                    }
                    setScenarioAEditar(new ScenarioTest(scenario));
                    setScenario(new ScenarioTest(scenario));
                    if(getTipo()==1){
                        ControladorTests.setTestRetGuardado(true);
                    }else if(getTipo()==4){
                        ControladorTests.setTestClasGuardado(true);
                    }
                    JOptionPane.showMessageDialog(this.getParent(),"El test ha sido sobreescrito",
                    "Confirm Message",JOptionPane.INFORMATION_MESSAGE);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(this.getParent(),"El test no ha sido guardado",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
                }
            }else if (n == JOptionPane.NO_OPTION) {
            }
        }else{
            if(getTipo()==1){
                ControladorTests.setTestRetGuardado(true);
            }else if(getTipo()==4){
                ControladorTests.setTestClasGuardado(true);
            }
            JOptionPane.showMessageDialog(this.getParent(),"No se han producido cambios en el test",
            "Confirm Message",JOptionPane.INFORMATION_MESSAGE);
        }
        setImportado(false);
    }else{ 
        try {
            saveTest.saveTestInMemory(scenario);
            saveTest.saveTestLocally(scenario);
            setScenarioAEditar(new ScenarioTest(scenario));
            setScenario(new ScenarioTest(scenario));
            if(getTipo()==1){
                ControladorTests.setTestRetGuardado(true);
            }else if(getTipo()==4){
                ControladorTests.setTestClasGuardado(true);
            }
            JOptionPane.showMessageDialog(this.getParent(),"El test ha sido guardado",
            "Confirm Message",JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this.getParent(),"El test no ha sido guardado",
            "Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }
}


public void guardarYEjecutar(){  
    auxiliar = new Auxiliar();
    if(testYaExiste==true || isImportado()==true){
        if(auxiliar.mismoScenario(scenario, this.getScenarioAEditar())==false){
            Object[] options = {"Sobreescribir", "Cancelar"};
            int n = JOptionPane.showOptionDialog(frame, "El test ya existe o ha sido modificado. ¿Que desea hacer?", 
                    "Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (n == JOptionPane.YES_OPTION) {
                try {
                    saveTest.saveTestInMemory(scenario);
                    if(testYaExiste==true){
                        saveTest.replaceTestLocally(scenario);
                    }else{
                        saveTest.saveTestLocally(scenario);
                    }
                    setScenarioAEditar(new ScenarioTest(scenario));
                    setScenario(new ScenarioTest(scenario));
                    if(getTipo()==1){
                        ControladorTests.setTestRetGuardado(true);
                    }else if(getTipo()==4){
                        ControladorTests.setTestClasGuardado(true);
                    }
                    JOptionPane.showMessageDialog(this.getParent(),"El test ha sido sobreescrito",
                    "Confirm Message",JOptionPane.INFORMATION_MESSAGE);
                    ejecutar(0);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(this.getParent(),"El test no ha sido guardado",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
                }
            }else if (n == JOptionPane.NO_OPTION) {
            }
        }else{
            if(getTipo()==1){
                ControladorTests.setTestRetGuardado(true);
            }else if(getTipo()==4){
                ControladorTests.setTestClasGuardado(true);
            }
            JOptionPane.showMessageDialog(this.getParent(),"No se han producido cambios en el test",
            "Confirm Message",JOptionPane.INFORMATION_MESSAGE);
            ejecutar(0);
        }
        setImportado(false);
     }else{
        try {
            saveTest.saveTestInMemory(scenario);
            saveTest.saveTestLocally(scenario);
            setScenarioAEditar(new ScenarioTest(scenario));
            setScenario(new ScenarioTest(scenario));
            if(getTipo()==1){
                ControladorTests.setTestRetGuardado(true);
            }else if(getTipo()==4){
                ControladorTests.setTestClasGuardado(true);
            }
            JOptionPane.showMessageDialog(this.getParent(),"El test ha sido guardado",
            "Confirm Message",JOptionPane.INFORMATION_MESSAGE);
            ejecutar(0);
        }catch (FileNotFoundException ex){
            JOptionPane.showMessageDialog(this.getParent(),"El test no ha sido guardado",
            "Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }    
}

public void inicializarVariables(){
    ambosNecesarios=false;
    continuarSinInstancias=true;
    testYaExiste=false;
    testSinNombre=false;
    validoRet=true;
    hayUnaConsulta=0;
    continuar=true;
}

public static boolean testYaExiste(String nombre){
    ListIterator li;
    ArrayList<ScenarioTest> lista = MainApplication.getCollection().getScenariotest();
    li = lista.listIterator();
    while(li.hasNext()){
        ScenarioTest s = (ScenarioTest) li.next();
        String n = s.getNombre();
        if(n.equals(nombre)){
            return true;
        }
    }
    return false;
}

public static ScenarioTest scenarioTestExistente(String nombre){
    ListIterator li;
    ArrayList<ScenarioTest> lista = MainApplication.getCollection().getScenariotest();
    li = lista.listIterator();
    while(li.hasNext()){
        ScenarioTest s = (ScenarioTest) li.next();
        String n = s.getNombre();
        if(n.equals(nombre)){
            return s;
        }
    }
    return null;
}

public boolean testVacio(String nombre){
    if(nombre.equals("")){
        return true;
    }else{
        return false;
    }
}

public boolean consultaCompletaEnSinAyuda(String consulta,String resultado){
    if((!consulta.equals("") && resultado.equals("")) || (consulta.equals("") && !resultado.equals(""))){
        return false;
    }else{
        return true;
    }
}

public boolean consultaCompletaEnAyuda(TestInstancesTextAreaJPanel test){
    if((!test.getQuery().equals("") && test.getQueryResult().equals("")) ||
        test.getQuery().equals("") && !test.getQueryResult().equals("")){
        return false;
    }else{
        return true;
    }
}

public boolean panelVacio(TestInstancesTextAreaJPanel test){
    if(test.getQuery().equals("") && test.getQueryResult().equals("")){
        return true;
    }else{
        return false;
    }
}

public boolean tieneInstanciasAsociadas(ScenarioTest scenario){
    Instancias instancias = scenario.getInstancias();
    List<ClassInstances> clasI = instancias.getClassInstances();
    List<PropertyInstances> propI = instancias.getPropertyInstances();
    
    if(clasI.size()==0 && propI.size()==0){
        return false;
    }else{
        return true;
    }
}

public void copiarTestAScenarioDesdeAyuda(){

    int tipoT = getTipo();
    inicializarVariables();

    queryTest = new ArrayList<QueryOntology>();
    test = null; 
    
    panelAyudaRet = this.getRetAyudaPanel();
    totalRet = panelAyudaRet.getComponentCount();
    validarTests = new ValidarTests();
    
    int cont=0;
    
    ret = new ArrayList();
    getRet().add(0,0);
    descPanel = (DescripcionJPanel) descripcionJPanel.getComponent(0);
    nombreTest = descPanel.getNombreTextField();
    descTest = descPanel.getDescTextArea();
    if(testYaExiste(nombreTest)==true){
        testYaExiste=true;
    }
    if(testVacio(nombreTest)==true){
        testSinNombre=true;
    }else{
        for(int i=1;i<totalRet;i++){
            test = (TestInstancesTextAreaJPanel) panelAyudaRet.getComponent(i);
            if(panelVacio(test)==false){
                if(ambosNecesarios==false){
                    if(consultaCompletaEnAyuda(test)==false){
                        ambosNecesarios=true;
                    }else{
                        String query = test.getQuery();
                        String resExpT = test.getQueryResult();
                        AddComentJDialog comentPane = test.getComment();
                        String coment = comentPane.getComent();
                        hayUnaConsulta=1;
                        QueryOntology testQuery = new QueryOntology(query,resExpT,coment);
                        if(validarTests.validarQuery(testQuery.getQuery())==true){
                            queryTest.add(testQuery);
                            cont++;
                            getRet().add(i, 0);
                        }else{
                            getRet().add(i, 1);
                            validoRet=false;
                        }
                    }
                }
            }
        }
    }
    
    if(testSinNombre==false && validoRet==true && ambosNecesarios==false
                && hayUnaConsulta==1){  
        preguntarSiContinuarSinInstancias(scenario);
        if(continuarSinInstancias==true){
            if(tipoT==1){
                scenario.setTestName("Retrieval"); 
            }else if(tipoT==4){
                scenario.setTestName("Clasificacion");
            }
            scenario.setDescripcion(descTest);
            scenario.setNombre(nombreTest);
            scenario.setQueryTest(queryTest); 
        }
    }else if(testSinNombre==true){
            JOptionPane.showMessageDialog(this.getParent(),"El nombre del test es obligatorio",
            "Warning Message",JOptionPane.WARNING_MESSAGE);
            continuar=false;
    }else if(ambosNecesarios==true){
        JOptionPane.showMessageDialog(this.getParent(),"Ambos campos CONSULTA y RESULTADO ESPERADO son" +
        "obligatorios","Warning Message",JOptionPane.WARNING_MESSAGE);
        continuar=false;
    }else if(hayUnaConsulta==0 && testSinNombre==false){
        JOptionPane.showMessageDialog(this.getParent(),"Al menos debe introducir una consulta " +
        "para guardar el test.","Warning Message",JOptionPane.WARNING_MESSAGE);
        continuar=false;
    }else if(validoRet==false){
        JOptionPane.showMessageDialog(this.getParent(),"El formato de " +
        "los datos marcados en rojo no es correcto." +
        "\nPor favor, consulte la ayuda acerca del formato " +
        "de las consultas y el resultado.","Warning Message",JOptionPane.WARNING_MESSAGE);
        formatoIncorrecto();
        continuar=false;
    }
}


public boolean preguntarSiContinuarSinInstancias(ScenarioTest scen){
    if(tieneInstanciasAsociadas(scen)==false){
        int n = JOptionPane.showConfirmDialog(comp, "El test no tiene instancias asociadas. " +
                "¿Desea continuar?", "Warning Message",JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.NO_OPTION){
            continuarSinInstancias=false;
        }else if(n == JOptionPane.YES_OPTION){
            continuarSinInstancias=true;
        }
    }

    return continuarSinInstancias;
}

public void copiarTestAScenarioDesdeSinAyuda(){
      
    int tipoT = getTipo();
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
    getRet().add(0,0);
    if(testYaExiste(nombreTest)==true){
        testYaExiste=true;
    }
    if(testVacio(nombreTest)==true){
        testSinNombre=true;
    }else{
        if(!conjuntoQuerys.equals("") && !conjuntoResult.equals("")){
            QueryOntology testQuery = new QueryOntology();
            int tamQ = cQuery.length;
            int tamR = cResult.length;
            if(tamQ==tamR){
                for(int i=0; i<tamQ;i++){
                    if(consultaCompletaEnSinAyuda(cQuery[i], cResult[i])==true){
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
                                getRet().add(i, 0);
                            }else if(validarTests.validarQuery(cQuery[i])==false &&
                                    validarTests.validarResultado(cResult[i])==true){
                                getRet().add(i, 1);
                                validoRet=false;
                            }else if(validarTests.validarQuery(cQuery[i])==true &&
                                    validarTests.validarResultado(cResult[i])==false){
                                getRet().add(i, 2);
                                validoRet=false;
                            }else{
                                getRet().add(i, 3);
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
        preguntarSiContinuarSinInstancias(scenario);
        if(continuarSinInstancias==true){
            if(tipoT==1){
                scenario.setTestName("Retrieval");
            }else if(tipoT==4){
                scenario.setTestName("Clasificacion");
            }
            scenario.setDescripcion(descTest);
            scenario.setNombre(nombreTest);
            scenario.setQueryTest(queryTest);
        }
    }else if(testSinNombre==true){
        JOptionPane.showMessageDialog(this.getParent(),"El nombre del test es obligatorio",
        "Warning Message",JOptionPane.WARNING_MESSAGE);
        continuar=false;
    }else if(ambosNecesarios==true){
        JOptionPane.showMessageDialog(this.getParent(),"Ambos campos CONSULTA y RESULTADO ESPERADO son" +
        "obligatorios","Warning Message",JOptionPane.WARNING_MESSAGE);
        continuar=false;
    }else if(hayUnaConsulta==0 && testSinNombre==false){
        JOptionPane.showMessageDialog(this.getParent(),"Al menos debe introducir una consulta " +
        "para guardar el test.","Warning Message",JOptionPane.WARNING_MESSAGE);
        continuar=false;
    }else if(validoRet==false){
        JOptionPane.showMessageDialog(this.getParent(),"El formato de los datos marcados en rojo no es correcto." +
        "\nPor favor, consulte la ayuda acerca del formato " +
        "de las consultas y el resultado.","Warning Message",JOptionPane.WARNING_MESSAGE);
        formatoIncorrecto();
        continuar=false;
    }
}

public void copiarDeAyudaATexto(){
     
    test = null;
    TestInstancesTextJPanel t;
    String conjuntoQuerysRet="";
    String conjuntoResExpRet="";
    String conjuntoComentRet="";

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
                    if(conjuntoQuerysRet.equals("")){
                        conjuntoQuerysRet = query.concat("\n");
                    }else{
                        conjuntoQuerysRet = conjuntoQuerysRet.concat(query).concat("\n");
                    }  
                    if(conjFinal.length==1){
                        conjuntoResExpRet = conjuntoResExpRet.concat(conjFinal[0]);
                    }else{
                        for(int j=0;j<conjFinal.length;j++){
                            if(conjuntoResExpRet.equals("")){
                                conjuntoResExpRet = conjFinal[j]+",";
                            }else{
                                if(j==conjFinal.length-1){
                                    conjuntoResExpRet = conjuntoResExpRet.concat(conjFinal[j]);
                                }else{
                                    conjuntoResExpRet = conjuntoResExpRet.concat(conjFinal[j])+",";
                                }
                            }
                        } 
                    }
                    conjuntoResExpRet = conjuntoResExpRet.concat("\n");
                    if(conjuntoComentRet.equals("")){
                        conjuntoComentRet = coment.concat("\n");
                    }else{
                        conjuntoComentRet = conjuntoComentRet.concat(coment).concat("\n");
                    }
                } 
            }
    }
    t = (TestInstancesTextJPanel) getOpcionTextRetPanel().getComponent(0);
    t.setConsultaQuery(conjuntoQuerysRet);
    t.setResultadoEsperado(conjuntoResExpRet);
    t.setComentTextArea(conjuntoComentRet);
    int c = retAyudaPanel.getComponentCount();
    Auxiliar.setContadorRetClas(0);
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

public static void formatoIncorrecto(){
    ValidarConsultas validar = new ValidarConsultas();
    if(TestSimpleRetClas.getActualSubTabRet()==0){
        if(validar.comprovarErrorEnAyudaRet()==false){
        }
    }else{
        if(validar.comprovarErrorQuerysRet()==false){
        }
    }
}

    public JPanel getRetAyudaPanel() {
        return retAyudaPanel;
    }

    public JPanel getOpcionTextRetPanel() {
        return opcionTextRetPanel;
    }

    public static int getActualSubTabRet() {
        return actualSubTabRet;
    }
    
    public static void setActualSubTabRet(int aActualSubTabRet) {
        actualSubTabRet= aActualSubTabRet;
    }
    
    public  int getTabbedPaneRet() {
        return tabbedPaneRet.getSelectedIndex();
    }
    
    public static List getRet() {
        return ret;
    }

    public static void setRet(List aRet) {
        ret = aRet;
    }
    
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public ScenarioTest getScenario() {
        return scenario;
    }

    public void setScenario(ScenarioTest scenario) {
        this.scenario = scenario;
    }

    public ScenarioTest getScenarioAEditar() {
        return scenarioAEditar;
    }

    public void setScenarioAEditar(ScenarioTest scenarioAEditar) {
        this.scenarioAEditar = scenarioAEditar;
    }

    public boolean isImportado() {
        return importado;
    }

    public void setImportado(boolean importado) {
        this.importado = importado;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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

    public boolean isSoloEjecutar() {
        return soloEjecutar;
    }

    public void setSoloEjecutar(boolean soloEjecutar) {
        this.soloEjecutar = soloEjecutar;
    }

    

}
