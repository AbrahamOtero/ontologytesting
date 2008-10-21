/*
 * MainApplicationJFrame.java
 *
 * Created on 11 de octubre de 2008, 12:33
 */

package code.google.com.p.ontologytesting.guiNew;

import code.google.com.p.ontologytesting.model.CollectionTest;
import code.google.com.p.ontologytesting.model.ScenarioTest;
import code.google.com.p.ontologytesting.model.ScenarioTest.TipoTest;
import code.google.com.p.ontologytesting.persistence.SaveTest;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author  saruskas
 */
public class MainApplicationJFrame extends javax.swing.JFrame {
    
    private CollectionTest collection;
    private ListAndResultsJPanel panelTest;
    private ControladorTests controlador;
    private ScenarioTest s = new ScenarioTest();
    private String carpetaProyecto,nombreProyecto;
    private SaveTest saveTest = new SaveTest();
    private OpcionesMenu opMenu = new OpcionesMenu();
    private static MainApplicationJFrame mainApp = null;
    
    /** Creates new form MainApplicationJFrame */
    private MainApplicationJFrame() {
        initComponents();
        this.setTitle("EVALUADOR DE ONTOLOGIAS");
        this.setSize(new Dimension(895,720));
        controlador = ControladorTests.getInstance();
        panelTest = ListAndResultsJPanel.getInstance();
        contentTestsJPanel.setLayout(new BorderLayout());
        //panelTest = ListAndResultsJPanel.getInstance();
        //"http://www.owl-ontologies.com/family.owl#"
        //http://nlp.shef.ac.uk/abraxas/ontologies/animals.owl
        //http://www.semanticweb.org/ontologies/2008/1/Ontology1202481514781.owl
        //C:\\Users\\saruskas\\Desktop\\Imple OntologyTestGui\\ontologyTestGUI\\data\\family.owl
        //C:\\Documents and Settings\\sara_garcia\\Escritorio\\PFC\\Imple OntologyTestGui\\ontologyTestGUI\\data\\family.owl
        
          /*PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
          SELECT ?subject ?object 
          WHERE {?subject rdfs:subClassOf ?object }*/
         
    }
 
    private synchronized static void createListAndTestPanel() {
        if (mainApp == null) { 
            mainApp = new MainApplicationJFrame();
        }
    }
 
    public static MainApplicationJFrame getInstance() {
        if (mainApp == null) createListAndTestPanel();
        return mainApp;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentTestsJPanel = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        nuevoProyectoMenuItem = new javax.swing.JMenuItem();
        abrirProyectoMenuItem = new javax.swing.JMenuItem();
        guardarProyectoMenuItem = new javax.swing.JMenuItem();
        guardarProyectoComoMenuItem = new javax.swing.JMenuItem();
        salirMenuItem = new javax.swing.JMenuItem();
        testsMenu = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        nuevoTestInstMenuItem = new javax.swing.JMenuItem();
        nuevoTestRecMenuItem = new javax.swing.JMenuItem();
        nuevoTestRealMenuItem = new javax.swing.JMenuItem();
        nuevoTestSatMenuItem = new javax.swing.JMenuItem();
        nuevoTestClasMenuItem = new javax.swing.JMenuItem();
        nuevoTestSparqlMenuItem = new javax.swing.JMenuItem();
        importarTestsMenuItem = new javax.swing.JMenuItem();
        editarTestsMenuItem = new javax.swing.JMenuItem();
        verTestsMenuItem = new javax.swing.JMenuItem();
        instanciasMenu = new javax.swing.JMenu();
        nuevoInstanciasMenuItem = new javax.swing.JMenuItem();
        importarInstanciasMenuItem = new javax.swing.JMenuItem();
        editarInstanciasMenuItem = new javax.swing.JMenuItem();
        verInstanciasMenuItem = new javax.swing.JMenuItem();
        ejecutarMenu = new javax.swing.JMenu();
        ejecutarTodosMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout contentTestsJPanelLayout = new javax.swing.GroupLayout(contentTestsJPanel);
        contentTestsJPanel.setLayout(contentTestsJPanelLayout);
        contentTestsJPanelLayout.setHorizontalGroup(
            contentTestsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );
        contentTestsJPanelLayout.setVerticalGroup(
            contentTestsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );

        fileMenu.setText("Proyecto");

        nuevoProyectoMenuItem.setText("Nuevo");
        nuevoProyectoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoProyectoMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(nuevoProyectoMenuItem);

        abrirProyectoMenuItem.setText("Abrir");
        fileMenu.add(abrirProyectoMenuItem);

        guardarProyectoMenuItem.setText("Guardar");
        guardarProyectoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarProyectoMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(guardarProyectoMenuItem);

        guardarProyectoComoMenuItem.setText("Guardar Como");
        guardarProyectoComoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarProyectoComoMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(guardarProyectoComoMenuItem);

        salirMenuItem.setText("Salir");
        salirMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(salirMenuItem);

        menuBar.add(fileMenu);

        testsMenu.setText("Tests");

        jMenu3.setText("Nuevo");

        jMenu4.setText("Test Simple");

        nuevoTestInstMenuItem.setText("Test de Instanciación");
        nuevoTestInstMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoTestInstMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(nuevoTestInstMenuItem);

        nuevoTestRecMenuItem.setText("Test de Recuperación");
        nuevoTestRecMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoTestRecMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(nuevoTestRecMenuItem);

        nuevoTestRealMenuItem.setText("Test de Realización");
        nuevoTestRealMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoTestRealMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(nuevoTestRealMenuItem);

        nuevoTestSatMenuItem.setText("Test de Satisfactibilidad");
        nuevoTestSatMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoTestSatMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(nuevoTestSatMenuItem);

        nuevoTestClasMenuItem.setText("Test de Clasificación");
        nuevoTestClasMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoTestClasMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(nuevoTestClasMenuItem);

        jMenu3.add(jMenu4);

        nuevoTestSparqlMenuItem.setText("Test Sparql");
        nuevoTestSparqlMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoTestSparqlMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(nuevoTestSparqlMenuItem);

        testsMenu.add(jMenu3);

        importarTestsMenuItem.setText("Importar");
        importarTestsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importarTestsMenuItemActionPerformed(evt);
            }
        });
        testsMenu.add(importarTestsMenuItem);

        editarTestsMenuItem.setText("Editar");
        editarTestsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarTestsMenuItemActionPerformed(evt);
            }
        });
        testsMenu.add(editarTestsMenuItem);

        verTestsMenuItem.setText("Ver");
        verTestsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verTestsMenuItemActionPerformed(evt);
            }
        });
        testsMenu.add(verTestsMenuItem);

        menuBar.add(testsMenu);

        instanciasMenu.setText("Instancias");

        nuevoInstanciasMenuItem.setText("Nuevo");
        nuevoInstanciasMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoInstanciasMenuItemActionPerformed(evt);
            }
        });
        instanciasMenu.add(nuevoInstanciasMenuItem);

        importarInstanciasMenuItem.setText("Importar");
        importarInstanciasMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importarInstanciasMenuItemActionPerformed(evt);
            }
        });
        instanciasMenu.add(importarInstanciasMenuItem);

        editarInstanciasMenuItem.setText("Editar");
        editarInstanciasMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarInstanciasMenuItemActionPerformed(evt);
            }
        });
        instanciasMenu.add(editarInstanciasMenuItem);

        verInstanciasMenuItem.setText("Ver");
        verInstanciasMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verInstanciasMenuItemActionPerformed(evt);
            }
        });
        instanciasMenu.add(verInstanciasMenuItem);

        menuBar.add(instanciasMenu);

        ejecutarMenu.setText("Ejecutar");

        ejecutarTodosMenuItem.setText("Todos los Tests");
        ejecutarTodosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecutarTodosMenuItemActionPerformed(evt);
            }
        });
        ejecutarMenu.add(ejecutarTodosMenuItem);

        menuBar.add(ejecutarMenu);

        helpMenu.setText("Help");

        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentTestsJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentTestsJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarProyectoComoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarProyectoComoMenuItemActionPerformed
        try {
            boolean guardado = saveTest.saveProject(true);
            if(guardado==true){
                JOptionPane.showMessageDialog(this,"Proyecto guardado",                                                  
                "Confirm Message",JOptionPane.INFORMATION_MESSAGE); 
            }else{
                JOptionPane.showMessageDialog(this,"Error. Proyecto no guardado.",                                                  
                "Error Message",JOptionPane.ERROR_MESSAGE); 
            }
        } catch (FileNotFoundException ex) {
            
        }
        
}//GEN-LAST:event_guardarProyectoComoMenuItemActionPerformed

private void nuevoProyectoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                                      
// TODO add your handling code here:
    //Realmente me crea la collection al crar el proyecto, aqui lo quitaria
    collection = CollectionTest.getInstance();
    collection.setNamespace("http://www.owl-ontologies.com/family.owl#");
    collection.setOntology("C:\\Documents and Settings\\sara_garcia\\Escritorio\\PFC\\Imple OntologyTestGui\\ontologyTestGUI\\data\\family.owl");
    /*NewProjectJDialog newProject = new NewProjectJDialog(this,true);
    newProject.setLocationRelativeTo(this);
    newProject.setVisible(true);
    if(newProject.getProyectoCreado()==true){*/
        this.inicializarContadores();
        instanciasMenu.setEnabled(true);
        testsMenu.setEnabled(true);
        ejecutarMenu.setEnabled(true);
        contentTestsJPanel.add(panelTest,BorderLayout.CENTER);
        this.validate();
    //}

}

private void salirMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirMenuItemActionPerformed
// TODO add your handling code here:
    int n = JOptionPane.showConfirmDialog(this, "¿Desea abandonar la aplicación?", 
                "Salir",JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION){
            System.exit(0);
        } 

}//GEN-LAST:event_salirMenuItemActionPerformed

private void nuevoTestInstMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoTestInstMenuItemActionPerformed
// TODO add your handling code here:
    this.inicializarContadores();
    if(controlador.algunTestSinGuardar()==false){
        controlador.prepararTestInst();
        this.aniadirTestsInstSat(0);
    }else{
        int n = JOptionPane.showConfirmDialog(this, "¿Guardar los cambios realizados al test?", 
                "Guardar Tests",JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION){
                    controlador.prepararTestInst();
                    this.aniadirTestsInstSat(0);
            }else{
                controlador.prepararTestInst();
                this.aniadirTestsInstSat(0);
            }
    }
}//GEN-LAST:event_nuevoTestInstMenuItemActionPerformed

private void nuevoTestRecMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoTestRecMenuItemActionPerformed
// TODO add your handling code here:
    this.inicializarContadores();
    if(controlador.algunTestSinGuardar()==false){
        controlador.prepararTestRet();
        this.aniadirTestsRetClas(1);
    }else{
        int n = JOptionPane.showConfirmDialog(this, "¿Guardar los cambios realizados al test?", 
                "Guardar Tests",JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION){
                    controlador.prepararTestRet();
                    this.aniadirTestsRetClas(1);
            }else{
                controlador.prepararTestRet();
                this.aniadirTestsRetClas(1);
            }
    }
}//GEN-LAST:event_nuevoTestRecMenuItemActionPerformed


private void nuevoTestRealMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoTestRealMenuItemActionPerformed
// TODO add your handling code here:
    this.inicializarContadores();
    if(controlador.algunTestSinGuardar()==false){
        controlador.prepararTestReal();
        this.aniadirTestsReal();
    }else{
        int n = JOptionPane.showConfirmDialog(this, "¿Guardar los cambios realizados al test?", 
                "Guardar Tests",JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION){
                    controlador.prepararTestReal();
                    this.aniadirTestsReal();
            }else{
                controlador.prepararTestReal();
                this.aniadirTestsReal();
            }
    }
}//GEN-LAST:event_nuevoTestRealMenuItemActionPerformed

private void nuevoTestSatMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoTestSatMenuItemActionPerformed
// TODO add your handling code here:
    this.inicializarContadores();
    if(controlador.algunTestSinGuardar()==false){
        controlador.prepararTestSat();
        this.aniadirTestsInstSat(3);
    }else{
        int n = JOptionPane.showConfirmDialog(this, "¿Guardar los cambios realizados al test?", 
                "Guardar Tests",JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION){
                    controlador.prepararTestSat();
                    this.aniadirTestsInstSat(3);
            }else{
                controlador.prepararTestSat();
                this.aniadirTestsInstSat(3);
            }
    }
}//GEN-LAST:event_nuevoTestSatMenuItemActionPerformed


private void nuevoTestClasMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoTestClasMenuItemActionPerformed
// TODO add your handling code here:
    this.inicializarContadores();
    if(controlador.algunTestSinGuardar()==false){
        controlador.prepararTestClas();
        this.aniadirTestsRetClas(4);
    }else{
        int n = JOptionPane.showConfirmDialog(this, "¿Guardar los cambios realizados al test?", 
                "Guardar Tests",JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION){
                    controlador.prepararTestClas();
                    this.aniadirTestsRetClas(4);
            }else{
                controlador.prepararTestClas();
                this.aniadirTestsRetClas(4);
            }
    }

}//GEN-LAST:event_nuevoTestClasMenuItemActionPerformed

private void nuevoTestSparqlMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoTestSparqlMenuItemActionPerformed
// TODO add your handling code here:
    this.inicializarContadores();
    if(controlador.algunTestSinGuardar()==false){
        controlador.prepararTestSparql();
        this.aniadirTestsSparql();
    }else{
        int n = JOptionPane.showConfirmDialog(this, "¿Guardar los cambios realizados al test?", 
                "Guardar Tests",JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION){
                    controlador.prepararTestSparql();
                    this.aniadirTestsSparql();
            }else{
                controlador.prepararTestSparql();
                this.aniadirTestsSparql();
            }
    }
}//GEN-LAST:event_nuevoTestSparqlMenuItemActionPerformed

private void importarTestsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importarTestsMenuItemActionPerformed
// TODO add your handling code here:
    this.importarTestsInstancias(true);
}//GEN-LAST:event_importarTestsMenuItemActionPerformed

private void editarTestsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarTestsMenuItemActionPerformed
// TODO add your handling code here:
    if(CollectionTest.getInstance().getScenariotest().size()==0){
        JOptionPane.showMessageDialog(this,"No tiene ningun test guardado para editar",                                                  
        "Error Message",JOptionPane.ERROR_MESSAGE); 
    }else{
        this.editarVerTestsInstancias(true);
    }
}//GEN-LAST:event_editarTestsMenuItemActionPerformed

private void verTestsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verTestsMenuItemActionPerformed
// TODO add your handling code here:
    if(CollectionTest.getInstance().getScenariotest().size()==0){
        JOptionPane.showMessageDialog(this,"No tiene ningun test guardado para ver",                                                  
        "Error Message",JOptionPane.ERROR_MESSAGE); 
    }else{
        this.editarVerTestsInstancias(true);
    }
}//GEN-LAST:event_verTestsMenuItemActionPerformed

private void nuevoInstanciasMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoInstanciasMenuItemActionPerformed
// TODO add your handling code here:
    JPanel panel = new JPanel();
    AddInstancesClasPropJDialog nuevoInst = new AddInstancesClasPropJDialog(panel, true);
    nuevoInst.setLocationRelativeTo(this);
    nuevoInst.setVisible(true);
    nuevoInst.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
}//GEN-LAST:event_nuevoInstanciasMenuItemActionPerformed

private void importarInstanciasMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importarInstanciasMenuItemActionPerformed
// TODO add your handling code here:
    this.importarTestsInstancias(false);
}//GEN-LAST:event_importarInstanciasMenuItemActionPerformed

private void editarInstanciasMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarInstanciasMenuItemActionPerformed
// TODO add your handling code here:
    if(CollectionTest.getInstance().getInstancias().size()==0){
        JOptionPane.showMessageDialog(this,"No tiene ningun conjunto de instancias guardado para editar",                                                  
        "Error Message",JOptionPane.ERROR_MESSAGE); 
    }else{
        this.editarVerTestsInstancias(false);
    }
}//GEN-LAST:event_editarInstanciasMenuItemActionPerformed

private void verInstanciasMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verInstanciasMenuItemActionPerformed
// TODO add your handling code here:
    if(CollectionTest.getInstance().getInstancias().size()==0){
        JOptionPane.showMessageDialog(this,"No tiene ningun conjunto de instancias guardado para ver",                                                  
        "Error Message",JOptionPane.ERROR_MESSAGE); 
    }else{
        this.editarVerTestsInstancias(false);
    }
}//GEN-LAST:event_verInstanciasMenuItemActionPerformed

private void ejecutarTodosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarTodosMenuItemActionPerformed
// TODO add your handling code here:
    opMenu.ejecutarBateriaTests(CollectionTest.getInstance().getScenariotest());
}//GEN-LAST:event_ejecutarTodosMenuItemActionPerformed

private void guardarProyectoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarProyectoMenuItemActionPerformed
// TODO add your handling code here:
    try {//GEN-LAST:event_guardarProyectoMenuItemActionPerformed
        boolean guardado = saveTest.saveProject(false);
        if(guardado==true){
            JOptionPane.showMessageDialog(this,"Proyecto guardado",                                                  
            "Confirm Message",JOptionPane.INFORMATION_MESSAGE); 
        }else{
            JOptionPane.showMessageDialog(this,"Error. Proyecto no guardado.",                                                  
            "Error Message",JOptionPane.ERROR_MESSAGE); 
        }
    } catch (FileNotFoundException ex) {

    }
}

public void importarTestsInstancias(boolean impTest){
    ImportarTestsJDialog abrirTests = new ImportarTestsJDialog(this,true,CollectionTest.getInstance(),impTest);
    abrirTests.setLocationRelativeTo(this);
    abrirTests.setVisible(true);
    abrirTests.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
}

public void editarVerTestsInstancias(boolean verEditTest){
    ListarTestsInstanciasJPanel listar = new ListarTestsInstanciasJPanel(CollectionTest.getInstance().getScenariotest(),CollectionTest.getInstance().getInstancias(),verEditTest);
    EditarVerTestInstanciasJDialog editarVerTestInst = new EditarVerTestInstanciasJDialog(this,true,listar,verEditTest);
    editarVerTestInst.setLocationRelativeTo(this);
    editarVerTestInst.setVisible(true);
    editarVerTestInst.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
}

public void aniadirTestsInstSat(int tipo){ 
    if(tipo==0){
        s = new ScenarioTest(TipoTest.INST);
    }else if(tipo==3){
        s = new ScenarioTest(TipoTest.SAT);
    }
    panelTest.getTestsPanel().aniadirTest(new TestSimpleInstSat(s));
    this.validate();
}

public void aniadirTestsRetClas(int tipo){ 
    if(tipo==1){
        s = new ScenarioTest(TipoTest.RET);
    }else if(tipo==4){
        s = new ScenarioTest(TipoTest.CLAS);
    }
    panelTest.getTestsPanel().aniadirTest(new TestSimpleRetClas(s));
    this.validate();
}

public void aniadirTestsReal(){ 
    s = new ScenarioTest(TipoTest.REAL);
    panelTest.getTestsPanel().aniadirTest(new TestSimpleReal(s));
    this.validate();
}

public void aniadirTestsSparql(){ 
    s = new ScenarioTest(TipoTest.SPARQL);
    panelTest.getTestsPanel().aniadirTest(new AddSPARQLJPanel(s));
    this.validate();
}


public void inicializarContadores(){
        CreateInstancesJPanel.setContadorClas(0);
        CreateInstancesJPanel.setContadorProp(0);
        TestInstancesQueryJPanel.setContadorReal(0);
        TestInstancesTFJPanel.setContadorInstSat(0);
        TestInstancesTextAreaJPanel.setContadorRetClas(0);
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainApplicationJFrame().setVisible(true);
            }
        });
    }
    
    public String getCarpetaProyecto() {
        return carpetaProyecto;
    }

    public void setCarpetaProyecto(String carpetaProyecto) {
        this.carpetaProyecto = carpetaProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem abrirProyectoMenuItem;
    private javax.swing.JPanel contentTestsJPanel;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem editarInstanciasMenuItem;
    private javax.swing.JMenuItem editarTestsMenuItem;
    private javax.swing.JMenu ejecutarMenu;
    private javax.swing.JMenuItem ejecutarTodosMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem guardarProyectoComoMenuItem;
    private javax.swing.JMenuItem guardarProyectoMenuItem;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem importarInstanciasMenuItem;
    private javax.swing.JMenuItem importarTestsMenuItem;
    private javax.swing.JMenu instanciasMenu;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem nuevoInstanciasMenuItem;
    private javax.swing.JMenuItem nuevoProyectoMenuItem;
    private javax.swing.JMenuItem nuevoTestClasMenuItem;
    private javax.swing.JMenuItem nuevoTestInstMenuItem;
    private javax.swing.JMenuItem nuevoTestRealMenuItem;
    private javax.swing.JMenuItem nuevoTestRecMenuItem;
    private javax.swing.JMenuItem nuevoTestSatMenuItem;
    private javax.swing.JMenuItem nuevoTestSparqlMenuItem;
    private javax.swing.JMenuItem salirMenuItem;
    private javax.swing.JMenu testsMenu;
    private javax.swing.JMenuItem verInstanciasMenuItem;
    private javax.swing.JMenuItem verTestsMenuItem;
    // End of variables declaration//GEN-END:variables

}
