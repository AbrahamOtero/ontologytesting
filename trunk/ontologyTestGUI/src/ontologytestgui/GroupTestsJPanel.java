/*
 * GroupTestQueryJPanel.java
 *
 * Created on 29 de mayo de 2008, 9:02
 */

package ontologytestgui;

import clases.OntologyTestCase;
import clases.OntologyTestResult;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.PropertyInstances;
import model.ClassInstances;
import model.CollectionTest;
import model.QueryOntology;
import model.ScenarioTest;
import model.SparqlQueryOntology;

/**
 *
 * @author  sara.garcia
 */
public class GroupTestsJPanel extends javax.swing.JPanel {

    static final int desktopWidth = 750;
    static final int desktopHeight = 600;
    private static boolean instanciacion=false, retrieval=false,realizacion=false,
            satisfactibilidad=false,clasificacion=false;
    static JFrame frame;
    private HelpJDialog frameHelp;
    public static boolean isState() {
        return seleccionado;
    }
    public static void setState(boolean aState) {
        seleccionado = aState;
    }
    public static boolean isNewState() {
        return seleccionado;
    }
    public static void setNewState(boolean aState) {
        seleccionado = aState;
    }
    public static boolean isDatosGuardados() {
        return datosGuardados;
    }
    public static void setDatosGuardados(boolean aDatosGuardados) {
        datosGuardados = aDatosGuardados;
    }
    public static OntologyTestResult getTestresult() {
        return testresult;
    }
    /*public static CollectionTest getCollectionTest() {
        return collectionTest;
    }
    public static void setCollectionTest(CollectionTest aCollectionTest) {
        collectionTest = aCollectionTest;
    }*/
    private AddInstancesJPanel addInstances;
    //private static CollectionTest collectionTest;
    private int aux=0;
    public static boolean seleccionado;
    private static boolean datosGuardados;
    private static OntologyTestResult testresult;
    private XMLDecoder decoder;
    private AddComentJDialog commentPane;
    
    /** Creates new form GroupTestQueryJPanel */
    public GroupTestsJPanel(int num) {
        initComponents(); 
        setState(true);
        frameHelp = new HelpJDialog(frame,true); 
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setPreferredSize(new Dimension(850, 600));
        testInstPanel.setLayout(new BoxLayout(testInstPanel, BoxLayout.Y_AXIS));
        testRetPanel.setLayout(new BoxLayout(testRetPanel, BoxLayout.Y_AXIS));
        testRealPanel.setLayout(new BoxLayout(testRealPanel, BoxLayout.Y_AXIS));
        testSatPanel.setLayout(new BoxLayout(testSatPanel, BoxLayout.Y_AXIS));
        testClasPanel.setLayout(new BoxLayout(testClasPanel, BoxLayout.Y_AXIS));
        labelInstPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        labelRetPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        labelRealPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        labelClasPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        labelSatisPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        testInstPanel.add(new DescripcionJPanel());
        testInstPanel.add(labelInstPanel);
        testRetPanel.add(new DescripcionJPanel());
        testRetPanel.add(labelRetPanel);
        testRealPanel.add(new DescripcionJPanel());
        testRealPanel.add(labelRealPanel);
        testSatPanel.add(new DescripcionJPanel());
        testSatPanel.add(labelSatisPanel);
        testClasPanel.add(new DescripcionJPanel());
        testClasPanel.add(labelClasPanel);
        
        for (int i = 0; i <= num; i++) {
            testInstPanel.add(new TestInstancesTFJPanel());
            testRetPanel.add(new TestInstancesQueryJPanel());
            testRealPanel.add(new TestInstancesQueryJPanel());
            testSatPanel.add(new TestInstancesTFJPanel());
            testClasPanel.add(new TestInstancesQueryJPanel());
        }
        //collectionTest = new CollectionTest();
        ArrayList<ScenarioTest> scenarioTestCollection = new ArrayList<ScenarioTest>(4);
        for(int i=0;i<5;i++){
            scenarioTestCollection.add(new ScenarioTest());
        }
        MainJPanel.getCollectionTest().setScenariotest(scenarioTestCollection);
        
        contentPanel.add(introduccionPanel,BorderLayout.NORTH);
        addInstances = new AddInstancesJPanel(this);
        //test1ScrollPane.setSize(new Dimension(700,550));
        contentPanel.add(testsTabbedPane,BorderLayout.CENTER);
        contentPanel.add(addInstances,BorderLayout.SOUTH);
    }
    
    public GroupTestsJPanel(String path) {
        
        initComponents(); 
        setNewState(true);
        frameHelp = new HelpJDialog(frame,true);
        
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setPreferredSize(new Dimension(desktopWidth, desktopHeight));
        testInstPanel.setLayout(new BoxLayout(testInstPanel, BoxLayout.Y_AXIS));
        testRetPanel.setLayout(new BoxLayout(testRetPanel, BoxLayout.Y_AXIS));
        testRealPanel.setLayout(new BoxLayout(testRealPanel, BoxLayout.Y_AXIS));
        testSatPanel.setLayout(new BoxLayout(testSatPanel, BoxLayout.Y_AXIS));
        testClasPanel.setLayout(new BoxLayout(testClasPanel, BoxLayout.Y_AXIS));
        labelInstPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        labelRetPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        labelRealPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        labelClasPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        labelSatisPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
               
        testClasPanel.add(new DescripcionJPanel());
        testClasPanel.add(labelClasPanel);
        testInstPanel.add(new DescripcionJPanel());
        testInstPanel.add(labelInstPanel);
        testRetPanel.add(new DescripcionJPanel());
        testRetPanel.add(labelRetPanel);
        testRealPanel.add(new DescripcionJPanel());
        testRealPanel.add(labelRealPanel);
        testSatPanel.add(new DescripcionJPanel());
        testSatPanel.add(labelSatisPanel);
        testClasPanel.add(labelClasPanel); 

        try{
        decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)));
        CollectionTest cT = (CollectionTest) decoder.readObject();
        MainJPanel.setCollectionTest(cT);
        ArrayList<ScenarioTest> scenario = MainJPanel.getCollectionTest().getScenariotest();
        ListIterator it;
        it = scenario.listIterator();
        while(it.hasNext()){
                ScenarioTest s = (ScenarioTest) it.next();
                ArrayList<QueryOntology> qO = s.getQueryTest();
                
                ListIterator qi;
                qi = qO.listIterator();
                while(qi.hasNext()){   
                    QueryOntology cI = (QueryOntology) qi.next();
                    TestInstancesTFJPanel testTF = new TestInstancesTFJPanel();
                    TestInstancesQueryJPanel testQuery = new TestInstancesQueryJPanel();
                    if(s.getTestName().equals("Instanciación") || s.getTestName().equals("Satisfactibilidad")){   
                        testTF.setQuery(cI.getQuery());
                        String resultExp = cI.getResultexpected();
                        if(resultExp.equals("true")){
                            testTF.setTrueTest(true);
                        }else{
                            testTF.setFalseTest(true);
                        }
                        commentPane = testTF.getComment();
                        commentPane.setComent(cI.getComment());
                        testTF.setComment(commentPane);
                    }else{
                        testQuery.setQuery(cI.getQuery());
                        testQuery.setQueryResult(cI.getResultexpected());
                        commentPane = testQuery.getComment();
                        commentPane.setComent(cI.getComment());
                        testQuery.setComment(commentPane);
                    }
                    if(s.getTestName().equals("Instanciación")){
                        testInstPanel.add(testTF);
                    }else if(s.getTestName().equals("Retrieval")){
                        testRetPanel.add(testQuery);
                    }else if(s.getTestName().equals("Realización")){
                        testRealPanel.add(testQuery);
                    }else if(s.getTestName().equals("Satisfactibilidad")){
                        testSatPanel.add(testTF);
                    }else if(s.getTestName().equals("Clasificación")){
                        testClasPanel.add(testQuery);
                    }
                }           
        }
            decoder.close();    
        }catch(FileNotFoundException e){
        } 

        if(testInstPanel.getComponentCount()<8){
            while(testInstPanel.getComponentCount()<8){
                testInstPanel.add(new TestInstancesTFJPanel());
            }
        }
        if(testRetPanel.getComponentCount()<8){
            while(testRetPanel.getComponentCount()<8){
                testRetPanel.add(new TestInstancesQueryJPanel());
            }
        }
        if(testRealPanel.getComponentCount()<8){
            while(testRealPanel.getComponentCount()<8){
                testRealPanel.add(new TestInstancesQueryJPanel());
            }
        }
        if(testSatPanel.getComponentCount()<8){
            while(testSatPanel.getComponentCount()<8){
                testSatPanel.add(new TestInstancesTFJPanel());
            }
        }
        if(testClasPanel.getComponentCount()<8){
            while(testClasPanel.getComponentCount()<8){
                testClasPanel.add(new TestInstancesQueryJPanel());
            }
        }
        
        contentPanel.add(introduccionPanel,BorderLayout.NORTH);
        addInstances = new AddInstancesJPanel(this);
        contentPanel.add(testsTabbedPane,BorderLayout.CENTER);
        contentPanel.add(addInstances,BorderLayout.SOUTH);  
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        testsTabbedPane = new javax.swing.JTabbedPane();
        test1ScrollPane = new javax.swing.JScrollPane();
        testInstPanel = new javax.swing.JPanel();
        labelInstPanel = new javax.swing.JPanel();
        labelInstLabel = new javax.swing.JLabel();
        test2ScrollPane = new javax.swing.JScrollPane();
        testRetPanel = new javax.swing.JPanel();
        labelRetPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        test3ScrollPane = new javax.swing.JScrollPane();
        testRealPanel = new javax.swing.JPanel();
        labelRealPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        test4ScrollPane = new javax.swing.JScrollPane();
        testSatPanel = new javax.swing.JPanel();
        labelSatisPanel = new javax.swing.JPanel();
        labelInstLabel1 = new javax.swing.JLabel();
        test5ScrollPane = new javax.swing.JScrollPane();
        testClasPanel = new javax.swing.JPanel();
        labelClasPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        introduccionPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        helpButton = new javax.swing.JButton();

        setName("GroupTestsJPanel"); // NOI18N

        testsTabbedPane.setToolTipText("");
        testsTabbedPane.setMinimumSize(new java.awt.Dimension(700, 550));

        test1ScrollPane.setToolTipText("Deduce si el individuo pertenece a la clase dada.");
        test1ScrollPane.setMinimumSize(new java.awt.Dimension(700, 550));

        labelInstLabel.setText("                      CONSULTAS                               RESULTADO ESPERADO                           ");

        javax.swing.GroupLayout labelInstPanelLayout = new javax.swing.GroupLayout(labelInstPanel);
        labelInstPanel.setLayout(labelInstPanelLayout);
        labelInstPanelLayout.setHorizontalGroup(
            labelInstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelInstPanelLayout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(labelInstLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        labelInstPanelLayout.setVerticalGroup(
            labelInstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, labelInstPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelInstLabel)
                .addContainerGap())
        );

        javax.swing.GroupLayout testInstPanelLayout = new javax.swing.GroupLayout(testInstPanel);
        testInstPanel.setLayout(testInstPanelLayout);
        testInstPanelLayout.setHorizontalGroup(
            testInstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testInstPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelInstPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(567, Short.MAX_VALUE))
        );
        testInstPanelLayout.setVerticalGroup(
            testInstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testInstPanelLayout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(labelInstPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(438, Short.MAX_VALUE))
        );

        test1ScrollPane.setViewportView(testInstPanel);
        testInstPanel.getAccessibleContext().setAccessibleName("0");

        testsTabbedPane.addTab("Instanciación", test1ScrollPane);

        test2ScrollPane.setToolTipText("Deduce TODOS los individuos que pertenecen a una clase dada.");

        jLabel2.setText("                    CONSULTAS                                 RESULTADO ESPERADO                           ");

        javax.swing.GroupLayout labelRetPanelLayout = new javax.swing.GroupLayout(labelRetPanel);
        labelRetPanel.setLayout(labelRetPanelLayout);
        labelRetPanelLayout.setHorizontalGroup(
            labelRetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, labelRetPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        labelRetPanelLayout.setVerticalGroup(
            labelRetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelRetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout testRetPanelLayout = new javax.swing.GroupLayout(testRetPanel);
        testRetPanel.setLayout(testRetPanelLayout);
        testRetPanelLayout.setHorizontalGroup(
            testRetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testRetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelRetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(635, Short.MAX_VALUE))
        );
        testRetPanelLayout.setVerticalGroup(
            testRetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testRetPanelLayout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(labelRetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(411, Short.MAX_VALUE))
        );

        test2ScrollPane.setViewportView(testRetPanel);
        testRetPanel.getAccessibleContext().setAccessibleName("1");

        testsTabbedPane.addTab("Retrieval", test2ScrollPane);

        test3ScrollPane.setToolTipText("Deduce dado un individuo, cual es la clase más exacta a la que pertenece.");

        jLabel3.setText("                    CONSULTAS                                 RESULTADO ESPERADO                           ");

        javax.swing.GroupLayout labelRealPanelLayout = new javax.swing.GroupLayout(labelRealPanel);
        labelRealPanel.setLayout(labelRealPanelLayout);
        labelRealPanelLayout.setHorizontalGroup(
            labelRealPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, labelRealPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        labelRealPanelLayout.setVerticalGroup(
            labelRealPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelRealPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout testRealPanelLayout = new javax.swing.GroupLayout(testRealPanel);
        testRealPanel.setLayout(testRealPanelLayout);
        testRealPanelLayout.setHorizontalGroup(
            testRealPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testRealPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelRealPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(635, Short.MAX_VALUE))
        );
        testRealPanelLayout.setVerticalGroup(
            testRealPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testRealPanelLayout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(labelRealPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(420, Short.MAX_VALUE))
        );

        test3ScrollPane.setViewportView(testRealPanel);

        testsTabbedPane.addTab("Realización", test3ScrollPane);

        test4ScrollPane.setToolTipText("Deduce si se puede o no añadir una nueva instancia de clase.");

        labelInstLabel1.setText("                      CONSULTAS                               RESULTADO ESPERADO                           ");

        javax.swing.GroupLayout labelSatisPanelLayout = new javax.swing.GroupLayout(labelSatisPanel);
        labelSatisPanel.setLayout(labelSatisPanelLayout);
        labelSatisPanelLayout.setHorizontalGroup(
            labelSatisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelSatisPanelLayout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(labelInstLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        labelSatisPanelLayout.setVerticalGroup(
            labelSatisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, labelSatisPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelInstLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout testSatPanelLayout = new javax.swing.GroupLayout(testSatPanel);
        testSatPanel.setLayout(testSatPanelLayout);
        testSatPanelLayout.setHorizontalGroup(
            testSatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testSatPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSatisPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(567, Short.MAX_VALUE))
        );
        testSatPanelLayout.setVerticalGroup(
            testSatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testSatPanelLayout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(labelSatisPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(418, Short.MAX_VALUE))
        );

        test4ScrollPane.setViewportView(testSatPanel);

        testsTabbedPane.addTab("Satisfactibilidad", test4ScrollPane);

        test5ScrollPane.setToolTipText("Deduce, dado un individuo, TODAS las clases a las que pertenece.");

        jLabel4.setText("                    CONSULTAS                                 RESULTADO ESPERADO                           ");

        javax.swing.GroupLayout labelClasPanelLayout = new javax.swing.GroupLayout(labelClasPanel);
        labelClasPanel.setLayout(labelClasPanelLayout);
        labelClasPanelLayout.setHorizontalGroup(
            labelClasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, labelClasPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        labelClasPanelLayout.setVerticalGroup(
            labelClasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelClasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout testClasPanelLayout = new javax.swing.GroupLayout(testClasPanel);
        testClasPanel.setLayout(testClasPanelLayout);
        testClasPanelLayout.setHorizontalGroup(
            testClasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testClasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelClasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(635, Short.MAX_VALUE))
        );
        testClasPanelLayout.setVerticalGroup(
            testClasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testClasPanelLayout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(labelClasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(418, Short.MAX_VALUE))
        );

        test5ScrollPane.setViewportView(testClasPanel);

        testsTabbedPane.addTab("Clasificación", test5ScrollPane);

        jLabel1.setText("Complete los tests que desee realizar ");

        helpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/help.gif"))); // NOI18N
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout introduccionPanelLayout = new javax.swing.GroupLayout(introduccionPanel);
        introduccionPanel.setLayout(introduccionPanelLayout);
        introduccionPanelLayout.setHorizontalGroup(
            introduccionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, introduccionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 301, Short.MAX_VALUE)
                .addComponent(helpButton)
                .addContainerGap())
        );
        introduccionPanelLayout.setVerticalGroup(
            introduccionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, introduccionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(introduccionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(helpButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(introduccionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(testsTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(introduccionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(testsTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleName("GroupTestsJPanel");
    }// </editor-fold>//GEN-END:initComponents

private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
// TODO add your handling code here:
    frameHelp.setVisible(true);
}//GEN-LAST:event_helpButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton helpButton;
    private javax.swing.JPanel introduccionPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel labelClasPanel;
    private javax.swing.JLabel labelInstLabel;
    private javax.swing.JLabel labelInstLabel1;
    private javax.swing.JPanel labelInstPanel;
    private javax.swing.JPanel labelRealPanel;
    private javax.swing.JPanel labelRetPanel;
    private javax.swing.JPanel labelSatisPanel;
    private javax.swing.JScrollPane test1ScrollPane;
    private javax.swing.JScrollPane test2ScrollPane;
    private javax.swing.JScrollPane test3ScrollPane;
    private javax.swing.JScrollPane test4ScrollPane;
    private javax.swing.JScrollPane test5ScrollPane;
    private javax.swing.JPanel testClasPanel;
    private javax.swing.JPanel testInstPanel;
    private javax.swing.JPanel testRealPanel;
    private javax.swing.JPanel testRetPanel;
    private javax.swing.JPanel testSatPanel;
    private javax.swing.JTabbedPane testsTabbedPane;
    // End of variables declaration//GEN-END:variables

public void guardarDatos(){
        
    OntologyTestCase testcase = new OntologyTestCase();
    testresult = new OntologyTestResult();

    String ontologyFisical=MainJPanel.getFisicalOntologyTextField();
    String ontologyURI = MainJPanel.getNamespaceOntologyTextField();
    
    MainJPanel.getCollectionTest().setOntology("file:".concat(ontologyFisical));
    if(ontologyURI.endsWith("#")){
        MainJPanel.getCollectionTest().setNamespace(ontologyURI);
    }else{
        MainJPanel.getCollectionTest().setNamespace(ontologyURI.concat("#"));
    }

    this.asociarInstancias();
    if(instanciacion==true){
        MainJPanel.getCollectionTest().getScenariotest().get(0).setTestName("Instanciación");
    }
    if(retrieval==true){
        MainJPanel.getCollectionTest().getScenariotest().get(1).setTestName("Retrieval");
    }
    if(realizacion==true){
        MainJPanel.getCollectionTest().getScenariotest().get(2).setTestName("Realización");
    }
    if(satisfactibilidad==true){
        MainJPanel.getCollectionTest().getScenariotest().get(3).setTestName("Satisfactibilidad");
    }
    if(clasificacion==true){
        MainJPanel.getCollectionTest().getScenariotest().get(4).setTestName("Clasificación");
    }
    
    if(aux==1){
        JOptionPane.showMessageDialog(frame,"Ambos campos CONSULTA y RESULTADO ESPERADO " +
                "son obligatorios. No puede dejar sólo uno de ellos en blanco",
                "Warning Message",JOptionPane.WARNING_MESSAGE);
    }else{
        Component comp = null;
        int n = JOptionPane.showConfirmDialog(comp, "¿Quiere guardar estos tests " +
                "para futuras pruebas?", "Guardar Tests",JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION){
            String nombreArch=null;
            String nameInstances=null;
    
            nombreArch = JOptionPane.showInputDialog(null,"Introduzca el nombre para el " +
                "archivo con este conjunto de instancias","Nombre del archivo",
                JOptionPane.QUESTION_MESSAGE);
            
            if(nombreArch.endsWith(".xml")){
                nameInstances=nombreArch;
            }else{
                nameInstances=nombreArch.concat(".xml");
            }
            try{    
                XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new 
                            FileOutputStream(nameInstances)));
                e.writeObject(MainJPanel.getCollectionTest());
                e.close();
            }catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            testcase.run(testresult, MainJPanel.getCollectionTest());
            GroupTestsJPanel.setDatosGuardados(true);
        }else{
            testcase.run(testresult, MainJPanel.getCollectionTest());
            GroupTestsJPanel.setDatosGuardados(true); 
        }        
    }    
}
    
public boolean isScenarioEmpty(ScenarioTest scenarioTest){
    
    ArrayList<ClassInstances> classInstances = scenarioTest.getClassInstances();
    ArrayList<PropertyInstances> propertyInstances = scenarioTest.getPropertyInstances();
    ArrayList<QueryOntology> queryTest = scenarioTest.getQueryTest();
    ArrayList<SparqlQueryOntology> sparqlQuerys = scenarioTest.getSparqlQuerys();
    if(classInstances.isEmpty() && propertyInstances.isEmpty() && 
        queryTest.isEmpty() && sparqlQuerys.isEmpty()){
        return true;
     }else{
        return false;
     }
}
    
public void asociarInstancias(){
       
    aux=0;
    String nombreTest = "",descTest = "";
    ArrayList<QueryOntology> queryTest1 = new ArrayList<QueryOntology>();
    ArrayList<QueryOntology> queryTest2 = new ArrayList<QueryOntology>();
    ArrayList<QueryOntology> queryTest3 = new ArrayList<QueryOntology>();
    ArrayList<QueryOntology> queryTest4 = new ArrayList<QueryOntology>();
    ArrayList<QueryOntology> queryTest5 = new ArrayList<QueryOntology>();
    
    JPanel panelInst = this.getTestInstPanel();
    int totalInst = panelInst.getComponentCount();
    JPanel panelClas = this.getTestClasPanel();
    int totalClas = panelClas.getComponentCount();
    JPanel panelReal = this.getTestRealPanel();
    int totalReal = panelReal.getComponentCount();
    JPanel panelRet = this.getTestRetPanel();
    int totalRet = panelRet.getComponentCount();
    JPanel panelSat = this.getTestSatPanel();
    int totalSat = panelSat.getComponentCount();

    for(int i=2;i<totalInst;i++){
        TestInstancesTFJPanel test = (TestInstancesTFJPanel) panelInst.getComponent(i);
        DescripcionJPanel descPanel = (DescripcionJPanel) panelInst.getComponent(0);
        nombreTest = descPanel.getNombreTextField();
        descTest = descPanel.getDescTextArea();
        String query = test.getQuery();
        String resExpT = test.isTestTrue();
        String resExpF = test.isTestFalse();
        AddComentJDialog comentPane = test.getComment();
        String coment = comentPane.getComent();
        if(!query.equals("") && !resExpT.equals(resExpF)){
            QueryOntology testQuery = new QueryOntology(query,resExpT,coment);
            queryTest1.add(testQuery);
            MainJPanel.getCollectionTest().getScenariotest().get(0).setQueryTest(queryTest1);
            instanciacion=true;
        }else if((!query.equals("") && resExpT.equals(resExpF)) || ((query.equals("") && !resExpT.equals(resExpF)))){
            aux=1;
        }
    }
    MainJPanel.getCollectionTest().getScenariotest().get(0).setNombre(nombreTest);
    MainJPanel.getCollectionTest().getScenariotest().get(0).setDescripcion(descTest);
    

    for(int i=2;i<totalRet;i++){
        TestInstancesQueryJPanel test = (TestInstancesQueryJPanel) panelRet.getComponent(i);
        DescripcionJPanel descPanel = (DescripcionJPanel) panelRet.getComponent(0);
        nombreTest = descPanel.getNombreTextField();
        descTest = descPanel.getDescTextArea();
        String query = test.getQuery();
        String queryExp = test.getQueryResult();
        AddComentJDialog comentPane = test.getComment();
        String coment = comentPane.getComent();
        if(!query.equals("") && !queryExp.equals("")){
            QueryOntology testQuery = new QueryOntology(query,queryExp,coment);
            queryTest2.add(testQuery);
            MainJPanel.getCollectionTest().getScenariotest().get(1).setQueryTest(queryTest2);
            retrieval=true;
        }else if((!query.equals("") && queryExp.equals("")) || (query.equals("") && !queryExp.equals(""))){
            aux=1;
        }
    }
    MainJPanel.getCollectionTest().getScenariotest().get(0).setNombre(nombreTest);
    MainJPanel.getCollectionTest().getScenariotest().get(0).setDescripcion(descTest);

    for(int i=2;i<totalReal;i++){
        TestInstancesQueryJPanel test = (TestInstancesQueryJPanel) panelReal.getComponent(i);
        DescripcionJPanel descPanel = (DescripcionJPanel) panelReal.getComponent(0);
        nombreTest = descPanel.getNombreTextField();
        descTest = descPanel.getDescTextArea();
        String query = test.getQuery();
        String queryExp = test.getQueryResult();
        AddComentJDialog comentPane = test.getComment();
        String coment = comentPane.getComent();
        if(!query.equals("") && !queryExp.equals("")){
            QueryOntology testQuery = new QueryOntology(query,queryExp,coment);
            queryTest3.add(testQuery);
            MainJPanel.getCollectionTest().getScenariotest().get(2).setQueryTest(queryTest3);
            realizacion=true;
        }else if((!query.equals("") && queryExp.equals("")) || (query.equals("") && !queryExp.equals(""))){
            aux=1;
        }
    }
    MainJPanel.getCollectionTest().getScenariotest().get(0).setNombre(nombreTest);
    MainJPanel.getCollectionTest().getScenariotest().get(0).setDescripcion(descTest);
    
    for(int i=2;i<totalSat;i++){
        TestInstancesTFJPanel test = (TestInstancesTFJPanel) panelSat.getComponent(i);
        DescripcionJPanel descPanel = (DescripcionJPanel) panelSat.getComponent(0);
        nombreTest = descPanel.getNombreTextField();
        descTest = descPanel.getDescTextArea();
        String query = test.getQuery();
        String resExpT = test.isTestTrue();
        String resExpF = test.isTestFalse();
        AddComentJDialog comentPane = test.getComment();
        String coment = comentPane.getComent();
        if(!query.equals("") && !resExpT.equals(resExpF)){
            QueryOntology testQuery = new QueryOntology(query,resExpT,coment);
            queryTest4.add(testQuery);
            MainJPanel.getCollectionTest().getScenariotest().get(3).setQueryTest(queryTest4);
            satisfactibilidad=true;
        }else if((!query.equals("") && resExpT.equals(resExpF)) || ((query.equals("") && !resExpT.equals(resExpF)))){
            aux=1;
        }
    }
    MainJPanel.getCollectionTest().getScenariotest().get(0).setNombre(nombreTest);
    MainJPanel.getCollectionTest().getScenariotest().get(0).setDescripcion(descTest);
    
    for(int i=2;i<totalClas;i++){
        TestInstancesQueryJPanel test = (TestInstancesQueryJPanel) panelClas.getComponent(i);
        DescripcionJPanel descPanel = (DescripcionJPanel) panelClas.getComponent(0);
        nombreTest = descPanel.getNombreTextField();
        descTest = descPanel.getDescTextArea();
        String query = test.getQuery();
        String queryExp = test.getQueryResult();
        AddComentJDialog comentPane = test.getComment();
        String coment = comentPane.getComent();
        if(!query.equals("") && !queryExp.equals("")){
            QueryOntology testQuery = new QueryOntology(query,queryExp,coment);
            queryTest5.add(testQuery);
            MainJPanel.getCollectionTest().getScenariotest().get(4).setQueryTest(queryTest5);
            clasificacion=true;
        }else if((!query.equals("") && queryExp.equals("")) || (query.equals("") && !queryExp.equals(""))){
            aux=1;
        }
    }
    MainJPanel.getCollectionTest().getScenariotest().get(0).setNombre(nombreTest);
    MainJPanel.getCollectionTest().getScenariotest().get(0).setDescripcion(descTest);
  }
    
public JPanel getTestClasPanel() {
    return testClasPanel;
}

public JPanel getTestInstPanel() {
    return testInstPanel;
}

public JPanel getTestRealPanel() {
    return testRealPanel;
}

public JPanel getTestRetPanel() {
    return testRetPanel;
}

public JPanel getTestSatPanel() {
    return testSatPanel;
}
    
public int getSelectedTabed(){
    return testsTabbedPane.getSelectedIndex();
}

    public javax.swing.JPanel getContentPanel() {
        return contentPanel;
    }

}
