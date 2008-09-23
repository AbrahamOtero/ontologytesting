/*
 * MainApplication.java
 *
 * Created on 11 de septiembre de 2008, 16:32
 */

package code.google.com.p.ontologytesting.guiNew;

import code.google.com.p.ontologytesting.exceptions.ExceptionReadOntology;
import code.google.com.p.ontologytesting.controller.*;
import code.google.com.p.ontologytesting.model.*;
import code.google.com.p.ontologytesting.persistence.SaveTest;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author  saruskas
 */
public class MainApplication extends javax.swing.JFrame {

    private static CollectionTest collection;
    private AddOntologyJDialog ontologia;
    private JFileChooser filechooser;
    private MenuOperations menuOp;
    private static String proyecto,nombreProyecto;
    private Component frame;
    private XMLDecoder decoder;
    private AddInstancesClasPropJDialog addInst;
    private OntologyTestCase testcase;
    private ResultTests resultTests;
    private OntologyTestResult testresult;
    private SeeTestJDialog seeTest;
    private SaveTest saveTest;
    private HelpJDialog helpDialog;
    

    /** Creates new form MainApplication */
    public MainApplication() {
        initComponents();
        this.setTitle("EVALUADOR DE ONTOLOGIAS");
        this.setSize(new Dimension(895,720));
        ControladorTests.inicializarGuardados();
        ControladorTests.inicializarSeleccionados();
        contentTestsJPanel.setLayout(new BorderLayout());
        collection = new CollectionTest();
        //"http://www.owl-ontologies.com/family.owl#"
        //http://nlp.shef.ac.uk/abraxas/ontologies/animals.owl
        //http://www.semanticweb.org/ontologies/2008/1/Ontology1202481514781.owl
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
        proyectoMenu = new javax.swing.JMenu();
        nuevoProyecto = new javax.swing.JMenuItem();
        abrirProyecto = new javax.swing.JMenuItem();
        guardarProyecto = new javax.swing.JMenuItem();
        guardarProyectoComo = new javax.swing.JMenuItem();
        salirProyecto = new javax.swing.JMenuItem();
        testsSimplesMenu = new javax.swing.JMenu();
        nuevoTestSimple = new javax.swing.JMenu();
        nuevoTestInst = new javax.swing.JMenuItem();
        nuevoTestRec = new javax.swing.JMenuItem();
        nuevoTestReal = new javax.swing.JMenuItem();
        nuevoTestSat = new javax.swing.JMenuItem();
        nuevoTestCla = new javax.swing.JMenuItem();
        importarTestSimple = new javax.swing.JMenuItem();
        editarTestSimple = new javax.swing.JMenuItem();
        verTestMenuItem = new javax.swing.JMenuItem();
        testsSparqlMenu = new javax.swing.JMenu();
        nuevoTestSparql = new javax.swing.JMenuItem();
        importarTestSparql = new javax.swing.JMenuItem();
        editarTestSparql = new javax.swing.JMenuItem();
        verTestSparql = new javax.swing.JMenuItem();
        instanciasMenu = new javax.swing.JMenu();
        nuevoInstancias = new javax.swing.JMenuItem();
        importarInstancias = new javax.swing.JMenuItem();
        editarInstancias = new javax.swing.JMenuItem();
        verInstancias = new javax.swing.JMenuItem();
        ejecutarMenu = new javax.swing.JMenu();
        ejectuarTests = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        tiposDeTestsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout contentTestsJPanelLayout = new javax.swing.GroupLayout(contentTestsJPanel);
        contentTestsJPanel.setLayout(contentTestsJPanelLayout);
        contentTestsJPanelLayout.setHorizontalGroup(
            contentTestsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 682, Short.MAX_VALUE)
        );
        contentTestsJPanelLayout.setVerticalGroup(
            contentTestsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        proyectoMenu.setText("Proyecto");

        nuevoProyecto.setText("Nuevo");
        nuevoProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoProyectoActionPerformed(evt);
            }
        });
        proyectoMenu.add(nuevoProyecto);

        abrirProyecto.setText("Abrir");
        abrirProyecto.setEnabled(false);
        abrirProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirProyectoActionPerformed(evt);
            }
        });
        proyectoMenu.add(abrirProyecto);

        guardarProyecto.setText("Guardar");
        guardarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarProyectoActionPerformed(evt);
            }
        });
        proyectoMenu.add(guardarProyecto);

        guardarProyectoComo.setText("Guardar como");
        guardarProyectoComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarProyectoComoActionPerformed(evt);
            }
        });
        proyectoMenu.add(guardarProyectoComo);

        salirProyecto.setText("Salir");
        salirProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirProyectoActionPerformed(evt);
            }
        });
        proyectoMenu.add(salirProyecto);

        menuBar.add(proyectoMenu);

        testsSimplesMenu.setText("Tests Simples");
        testsSimplesMenu.setEnabled(false);

        nuevoTestSimple.setText("Nuevo");

        nuevoTestInst.setText("Test de Instanciación");
        nuevoTestInst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoTestInstActionPerformed(evt);
            }
        });
        nuevoTestSimple.add(nuevoTestInst);

        nuevoTestRec.setText("Test de Recuperación");
        nuevoTestRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoTestRecActionPerformed(evt);
            }
        });
        nuevoTestSimple.add(nuevoTestRec);

        nuevoTestReal.setText("Test de Realización");
        nuevoTestReal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoTestRealActionPerformed(evt);
            }
        });
        nuevoTestSimple.add(nuevoTestReal);

        nuevoTestSat.setText("Test de Satisfactibilidad");
        nuevoTestSat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoTestSatActionPerformed(evt);
            }
        });
        nuevoTestSimple.add(nuevoTestSat);

        nuevoTestCla.setText("Test de Clasificación");
        nuevoTestCla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoTestClaActionPerformed(evt);
            }
        });
        nuevoTestSimple.add(nuevoTestCla);

        testsSimplesMenu.add(nuevoTestSimple);

        importarTestSimple.setText("Importar");
        importarTestSimple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importarTestSimpleActionPerformed(evt);
            }
        });
        testsSimplesMenu.add(importarTestSimple);

        editarTestSimple.setText("Editar");
        editarTestSimple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarTestSimpleActionPerformed(evt);
            }
        });
        testsSimplesMenu.add(editarTestSimple);

        verTestMenuItem.setText("Ver");
        verTestMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verTestMenuItemActionPerformed(evt);
            }
        });
        testsSimplesMenu.add(verTestMenuItem);

        menuBar.add(testsSimplesMenu);

        testsSparqlMenu.setText("Tests SPARQL");
        testsSparqlMenu.setEnabled(false);

        nuevoTestSparql.setText("Nuevo");
        nuevoTestSparql.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoTestSparqlActionPerformed(evt);
            }
        });
        testsSparqlMenu.add(nuevoTestSparql);

        importarTestSparql.setText("Importar");
        importarTestSparql.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importarTestSparqlActionPerformed(evt);
            }
        });
        testsSparqlMenu.add(importarTestSparql);

        editarTestSparql.setText("Editar");
        editarTestSparql.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarTestSparqlActionPerformed(evt);
            }
        });
        testsSparqlMenu.add(editarTestSparql);

        verTestSparql.setText("Ver");
        testsSparqlMenu.add(verTestSparql);

        menuBar.add(testsSparqlMenu);

        instanciasMenu.setText("Instancias");
        instanciasMenu.setEnabled(false);

        nuevoInstancias.setText("Nuevo");
        nuevoInstancias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoInstanciasActionPerformed(evt);
            }
        });
        instanciasMenu.add(nuevoInstancias);

        importarInstancias.setText("Importar");
        importarInstancias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importarInstanciasActionPerformed(evt);
            }
        });
        instanciasMenu.add(importarInstancias);

        editarInstancias.setText("Editar");
        editarInstancias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarInstanciasActionPerformed(evt);
            }
        });
        instanciasMenu.add(editarInstancias);

        verInstancias.setText("Ver");
        verInstancias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verInstanciasActionPerformed(evt);
            }
        });
        instanciasMenu.add(verInstancias);

        menuBar.add(instanciasMenu);

        ejecutarMenu.setText("Ejecutar");
        ejecutarMenu.setEnabled(false);

        ejectuarTests.setText("Todos los Test");
        ejectuarTests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejectuarTestsActionPerformed(evt);
            }
        });
        ejecutarMenu.add(ejectuarTests);

        menuBar.add(ejecutarMenu);

        helpMenu.setText("Help");

        tiposDeTestsMenuItem.setText("Tipos de Test");
        tiposDeTestsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiposDeTestsMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(tiposDeTestsMenuItem);

        aboutMenuItem.setText("About");
        aboutMenuItem.setEnabled(false);
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

    private void salirProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirProyectoActionPerformed
        System.exit(0);
}//GEN-LAST:event_salirProyectoActionPerformed

private void nuevoProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoProyectoActionPerformed
// TODO add your handling code here:
    filechooser = new JFileChooser();
    filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
    int option = filechooser.showOpenDialog(this);
      if (option == JFileChooser.APPROVE_OPTION) {
        setProyecto(filechooser.getSelectedFile().getAbsolutePath());
        setNombreProyecto(filechooser.getSelectedFile().getName());
        collection = new CollectionTest();
        Auxiliar.inicializarContadores();
        ontologia = new AddOntologyJDialog(this,true);
        ontologia.setVisible(true);
        if(ontologia.getOntologiaAsociada()==true){
            this.getInstanciasMenu().setEnabled(true);
            this.getTestsSimplesMenu().setEnabled(true);
            this.getTestsSparqlMenu().setEnabled(true);
            this.getEjecutarMenu().setEnabled(true);
        }
      }
}//GEN-LAST:event_nuevoProyectoActionPerformed

private void nuevoTestInstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoTestInstActionPerformed
// TODO add your handling code here:
    Auxiliar.inicializarContadores();
    menuOp = new MenuOperations();
    if(ControladorTests.algunTestSinGuardar()==false){
        ControladorTests.inicializarGuardados();
        ControladorTests.inicializarSeleccionados();
        ControladorTests.setTestInstGuardado(false);
        ControladorTests.setTestInstSelect(true);
        menuOp.aniadirTestsInst();
    }else{
        int n = JOptionPane.showConfirmDialog(this, "¿Guardar los cambios realizados al test?", 
                "Guardar Tests",JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION){
                if(Auxiliar.guardarAntesDeSeguir()){
                    ControladorTests.inicializarGuardados();
                    ControladorTests.inicializarSeleccionados();
                    ControladorTests.setTestInstGuardado(false);
                    ControladorTests.setTestInstSelect(true);
                    menuOp.aniadirTestsInst();
                }
            }else{
                ControladorTests.inicializarGuardados();
                ControladorTests.inicializarSeleccionados();
                ControladorTests.setTestInstGuardado(false);
                ControladorTests.setTestInstSelect(true);
                menuOp.aniadirTestsInst();
            }
    }
}//GEN-LAST:event_nuevoTestInstActionPerformed

private void importarTestSimpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importarTestSimpleActionPerformed
// TODO add your handling code here:        
    menuOp = new MenuOperations();
    try{
        if(menuOp.importarTest()){
            JOptionPane.showMessageDialog(this,"El test se ha importado correctamente",
            "Information Message",JOptionPane.INFORMATION_MESSAGE);
        }
    }catch(FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this,"No se ha importado el test",//GEN-LAST:event_importarTestSimpleActionPerformed
            "Error Message",JOptionPane.ERROR_MESSAGE);
    }catch(ClassCastException ce){
        JOptionPane.showMessageDialog(this,"El archivo no es compatible con la accion que " +
        "desea realizar","Error Message",JOptionPane.ERROR_MESSAGE);
    }
}                                                  

private void editarTestSimpleActionPerformed(java.awt.event.ActionEvent evt) {                                                 
    Auxiliar.inicializarContadores();
    menuOp = new MenuOperations();
    try {
        menuOp.editarTests();
    }catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(this,"No se puede abrir el test para su edición",                                                  
        "Error Message",JOptionPane.ERROR_MESSAGE);
    }catch(ClassCastException ce){
        JOptionPane.showMessageDialog(this,"El archivo no es compatible con la accion que " +
        "desea realizar","Error Message",JOptionPane.ERROR_MESSAGE);
    } 
}                                                

private void importarTestSparqlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importarTestSparqlActionPerformed
// TODO add your handling code here:
   menuOp = new MenuOperations();
    try{
        if(menuOp.importarTest()){
            JOptionPane.showMessageDialog(this,"El test se ha importado correctamente",
            "Information Message",JOptionPane.INFORMATION_MESSAGE);
        }
    }catch(FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this,"No se ha importado el test",                                                  
            "Error Message",JOptionPane.ERROR_MESSAGE);
    }catch(ClassCastException ce){
            JOptionPane.showMessageDialog(this,"El archivo no es compatible con la accion que " +
            "desea realizar","Error Message",JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_importarTestSparqlActionPerformed

private void nuevoInstanciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoInstanciasActionPerformed
// TODO add your handling code here:
    Auxiliar.inicializarContadores();
    int sel = ControladorTests.testSeleccionado();
    addInst = new AddInstancesClasPropJDialog(this,true,sel);
    addInst.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    addInst.setVisible(true);
}//GEN-LAST:event_nuevoInstanciasActionPerformed

private void importarInstanciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importarInstanciasActionPerformed
// TODO add your handling code here:
    menuOp = new MenuOperations();
    menuOp.importarInstancias();
}//GEN-LAST:event_importarInstanciasActionPerformed

private void editarInstanciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarInstanciasActionPerformed
// TODO add your handling code here:
    menuOp = new MenuOperations();
    Auxiliar.inicializarContadores();
    menuOp.editarInstancias();
}//GEN-LAST:event_editarInstanciasActionPerformed

private void verInstanciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verInstanciasActionPerformed
// TODO add your handling code here:
    filechooser = new JFileChooser(MainApplication.getProyecto());                                               
    int option = filechooser.showOpenDialog(frame);
    if (option == JFileChooser.APPROVE_OPTION) {
        File selectedFile = filechooser.getSelectedFile();
        String nameFile = selectedFile.getPath();
        try {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(nameFile)));
            Instancias inst = (Instancias) decoder.readObject();
            seeTest = new SeeTestJDialog(this, false, inst);
            seeTest.setVisible(true);
        }catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this,"No se pudo abrir el archivo",                                                  
            "Error Message",JOptionPane.ERROR_MESSAGE);
        }catch(ClassCastException ce){
            JOptionPane.showMessageDialog(this,"El archivo no es compatible con la accion que " +
            "desea realizar","Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }  
}//GEN-LAST:event_verInstanciasActionPerformed

private void nuevoTestRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoTestRecActionPerformed
// TODO add your handling code here:
    menuOp = new MenuOperations();
    Auxiliar.inicializarContadores();
    if(ControladorTests.algunTestSinGuardar()==false){
        ControladorTests.inicializarGuardados();
        ControladorTests.inicializarSeleccionados();
        ControladorTests.setTestRetGuardado(false);
        ControladorTests.setTestRetSelect(true);
        menuOp.aniadirTestsRet();
    }else{
        int n = JOptionPane.showConfirmDialog(this, "¿Guardar los cambios realizados al test?", 
                "Guardar Tests",JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION){
                if(Auxiliar.guardarAntesDeSeguir()){
                    ControladorTests.inicializarGuardados();
                    ControladorTests.inicializarSeleccionados();
                    ControladorTests.setTestRetGuardado(false);
                    ControladorTests.setTestRetSelect(true);
                    menuOp.aniadirTestsRet();
                }
            }else{
                ControladorTests.inicializarGuardados();
                ControladorTests.inicializarSeleccionados();
                ControladorTests.setTestRetGuardado(false);
                ControladorTests.setTestRetSelect(true);
                menuOp.aniadirTestsRet();
            }
    }
}//GEN-LAST:event_nuevoTestRecActionPerformed

private void nuevoTestRealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoTestRealActionPerformed
// TODO add your handling code here:
    menuOp = new MenuOperations();
    Auxiliar.inicializarContadores();
    if(ControladorTests.algunTestSinGuardar()==false || getContentTestsJPanel().getComponentCount()==0){
        ControladorTests.inicializarGuardados();
        ControladorTests.inicializarSeleccionados();
        ControladorTests.setTestRealGuardado(false);
        ControladorTests.setTestRealSelect(true);
        menuOp.aniadirTestsReal();
    }else{
        int n = JOptionPane.showConfirmDialog(this, "¿Guardar los cambios realizados al test?", 
                "Guardar Tests",JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION){
                if(Auxiliar.guardarAntesDeSeguir()){
                    ControladorTests.inicializarGuardados();
                    ControladorTests.inicializarSeleccionados();
                    ControladorTests.setTestRealGuardado(false);
                    ControladorTests.setTestRealSelect(true);
                    menuOp.aniadirTestsReal();
                }
            }else{
                ControladorTests.inicializarGuardados();
                ControladorTests.inicializarSeleccionados();
                ControladorTests.setTestRealGuardado(false);
                ControladorTests.setTestRealSelect(true);
                menuOp.aniadirTestsReal();
            }
    }
}//GEN-LAST:event_nuevoTestRealActionPerformed

private void nuevoTestSatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoTestSatActionPerformed
// TODO add your handling code here:
    menuOp = new MenuOperations();
    Auxiliar.inicializarContadores();
    if(ControladorTests.algunTestSinGuardar()==false || getContentTestsJPanel().getComponentCount()==0){
        ControladorTests.inicializarGuardados();
        ControladorTests.inicializarSeleccionados();
        ControladorTests.setTestSatGuardado(false);
        ControladorTests.setTestSatSelect(true);
        menuOp.aniadirTestsSat();
    }else{
        int n = JOptionPane.showConfirmDialog(this, "¿Guardar los cambios realizados al test?", 
                "Guardar Tests",JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION){
                if(Auxiliar.guardarAntesDeSeguir()){
                    ControladorTests.inicializarGuardados();
                    ControladorTests.inicializarSeleccionados();
                    ControladorTests.setTestSatGuardado(false);
                    ControladorTests.setTestSatSelect(true);
                    menuOp.aniadirTestsSat();
                }
            }else{
                ControladorTests.inicializarGuardados();
                ControladorTests.inicializarSeleccionados();
                ControladorTests.setTestSatGuardado(false);
                ControladorTests.setTestSatSelect(true);
                menuOp.aniadirTestsSat();
            }
    }
}//GEN-LAST:event_nuevoTestSatActionPerformed

private void nuevoTestClaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoTestClaActionPerformed
// TODO add your handling code here:
    menuOp = new MenuOperations();
    Auxiliar.inicializarContadores();
    if(ControladorTests.algunTestSinGuardar()==false || getContentTestsJPanel().getComponentCount()==0){
        ControladorTests.inicializarGuardados();
        ControladorTests.inicializarSeleccionados();
        ControladorTests.setTestClasGuardado(false);
        ControladorTests.setTestClasSelect(true);
        menuOp.aniadirTestsClas();
    }else{
        int n = JOptionPane.showConfirmDialog(this, "¿Guardar los cambios realizados al test?", 
                "Guardar Tests",JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION){
                if(Auxiliar.guardarAntesDeSeguir()){
                    ControladorTests.inicializarGuardados();
                    ControladorTests.inicializarSeleccionados();
                    ControladorTests.setTestClasGuardado(false);
                    ControladorTests.setTestClasSelect(true);
                    menuOp.aniadirTestsClas();
                }
            }else{
                ControladorTests.inicializarGuardados();
                ControladorTests.inicializarSeleccionados();
                ControladorTests.setTestClasGuardado(false);
                ControladorTests.setTestClasSelect(true);
                menuOp.aniadirTestsClas();
            }
    }
}//GEN-LAST:event_nuevoTestClaActionPerformed

private void ejectuarTestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejectuarTestsActionPerformed
// TODO add your handling code here:
    if(MainApplication.getCollection().getScenariotest().size()==0){
        JOptionPane.showMessageDialog(this,"No tiene ningun test para ejecutar",
        "Warning Message",JOptionPane.WARNING_MESSAGE);
    }else{
            try{
	testcase = new OntologyTestCase();//GEN-LAST:event_ejectuarTestsActionPerformed
            resultTests = new ResultTests();
            testresult = new OntologyTestResult();
            testcase.run(testresult, MainApplication.getCollection());
            JPanel panel = new TreeResults(testresult);
            resultTests.getContentPanelResults().add(panel);
            resultTests.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            resultTests.setVisible(true);
            resultTests.validate();
        } catch (ExceptionReadOntology ex) {
            new ExceptionReadOntology("La ontologia introducida no es valida." +
            "\nSolo pueden realizarse tests sobre documentos owl consistentes");
        }
    }
}
    
private void verTestMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verTestMenuItemActionPerformed
// TODO add your handling code here:
    filechooser = new JFileChooser(MainApplication.getProyecto());//GEN-LAST:event_verTestMenuItemActionPerformed
    int option = filechooser.showOpenDialog(frame);
    if (option == JFileChooser.APPROVE_OPTION) {
        File selectedFile = filechooser.getSelectedFile();
        String nameFile = selectedFile.getPath();
        try {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(nameFile)));
            ScenarioTest s = (ScenarioTest) decoder.readObject();
            seeTest = new SeeTestJDialog(this, false, s);
            seeTest.setVisible(true);
        }catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this,"No se pudo abrir el archivo",                                                  
            "Error Message",JOptionPane.ERROR_MESSAGE);
        }catch(ClassCastException ce){
            JOptionPane.showMessageDialog(this,"El archivo no es compatible con la accion que " +
            "desea realizar","Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }
}
private void nuevoTestSparqlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoTestSparqlActionPerformed
// TODO add your handling code here:
    menuOp = new MenuOperations();
if(ControladorTests.algunTestSinGuardar()==false || getContentTestsJPanel().getComponentCount()==0){//GEN-LAST:event_nuevoTestSparqlActionPerformed
    ControladorTests.inicializarGuardados();
    ControladorTests.inicializarSeleccionados();
    ControladorTests.setTestSparqlGuardado(false);
    ControladorTests.setTestSparqlSelect(true);
    menuOp.aniadirTestsSparql();
}else{
    int n = JOptionPane.showConfirmDialog(this, "¿Guardar los cambios realizados al test?", 
            "Guardar Tests",JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION){
            if(Auxiliar.guardarAntesDeSeguir()){
                ControladorTests.inicializarGuardados();
                ControladorTests.inicializarSeleccionados();
                ControladorTests.setTestClasGuardado(false);
                ControladorTests.setTestClasSelect(true);
                menuOp.aniadirTestsSparql();
            }
        }else{
            ControladorTests.inicializarGuardados();
            ControladorTests.inicializarSeleccionados();
            ControladorTests.setTestClasGuardado(false);
            ControladorTests.setTestClasSelect(true);
            menuOp.aniadirTestsSparql();
        }
}
}

private void editarTestSparqlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarTestSparqlActionPerformed
// TODO add your handling code here:
    menuOp = new MenuOperations();
    try {//GEN-LAST:event_editarTestSparqlActionPerformed
        menuOp.editarTests();
    }catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(this,"No se puede abrir el test para su edición",                                                  
        "Error Message",JOptionPane.ERROR_MESSAGE);
    }catch(ClassCastException ce){
        JOptionPane.showMessageDialog(this,"El archivo no es compatible con la accion que " +
        "desea realizar","Error Message",JOptionPane.ERROR_MESSAGE);
    } 
}

private void guardarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarProyectoActionPerformed
// TODO add your handling code here:
    saveTest = new SaveTest();//GEN-LAST:event_guardarProyectoActionPerformed
    try {
        saveTest.saveProject();
        JOptionPane.showMessageDialog(this,"El proyecto se ha guardado",
        "Information Message",JOptionPane.INFORMATION_MESSAGE);
    } catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(this,"No se pudo guardar el proyecto",                                                  
        "Error Message",JOptionPane.ERROR_MESSAGE);
    }
}

private void abrirProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirProyectoActionPerformed
// TODO add your handling code here:
//GEN-LAST:event_abrirProyectoActionPerformed
    menuOp = new MenuOperations();
    try{
        boolean result = menuOp.openProject();
        if(result==true){
            JOptionPane.showMessageDialog(this,"El proyecto se ha importado",
            "Information Message",JOptionPane.INFORMATION_MESSAGE);
        }
    }catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(this,"No se puede abrir el proyecto",                                                  
        "Error Message",JOptionPane.ERROR_MESSAGE);
    }catch(ClassCastException ce){
        JOptionPane.showMessageDialog(this,"El archivo no es compatible con la accion que " +
        "desea realizar","Error Message",JOptionPane.ERROR_MESSAGE);
    } 
}
private void tiposDeTestsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiposDeTestsMenuItemActionPerformed
// TODO add your handling code here:
//GEN-LAST:event_tiposDeTestsMenuItemActionPerformed
    helpDialog = new HelpJDialog(this,false);
    helpDialog.setVisible(true);
}

private void guardarProyectoComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarProyectoComoActionPerformed
// TODO add your handling code here:
    saveTest = new SaveTest();//GEN-LAST:event_guardarProyectoComoActionPerformed
    try {
        boolean result = saveTest.saveProjectAs();
        if(result==true){
            JOptionPane.showMessageDialog(this,"El proyecto ha sido guardado",
            "Information Message",JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(this,"No se pudo guardar el proyecto",                                                  
        "Error Message",JOptionPane.ERROR_MESSAGE);
    }
}                                                   

                                     
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainApplication().setVisible(true);
            }
        });
    }
    
    public static CollectionTest getCollection() {
        return collection;
    }
    
    public static void setCollection(CollectionTest coll) {
        collection = coll;
    }
    
    public javax.swing.JMenu getInstanciasMenu() {
        return instanciasMenu;
    }

    public javax.swing.JMenu getTestsSimplesMenu() {
        return testsSimplesMenu;
    }

    public javax.swing.JMenu getTestsSparqlMenu() {
        return testsSparqlMenu;
    }
    
    public static javax.swing.JPanel getContentTestsJPanel() {
        return contentTestsJPanel;
    }
    
    public static String getProyecto() {
        return proyecto;
    }

    public static void setProyecto(String aProyecto) {
        proyecto = aProyecto;
    }
    
    public javax.swing.JMenu getEjecutarMenu() {
        return ejecutarMenu;
    }
    
    public static String getNombreProyecto() {
        return nombreProyecto;
    }

    public static void setNombreProyecto(String aNombreProyecto) {
        nombreProyecto = aNombreProyecto;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem abrirProyecto;
    private static javax.swing.JPanel contentTestsJPanel;
    private javax.swing.JMenuItem editarInstancias;
    private javax.swing.JMenuItem editarTestSimple;
    private javax.swing.JMenuItem editarTestSparql;
    private javax.swing.JMenuItem ejectuarTests;
    private javax.swing.JMenu ejecutarMenu;
    private javax.swing.JMenuItem guardarProyecto;
    private javax.swing.JMenuItem guardarProyectoComo;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem importarInstancias;
    private javax.swing.JMenuItem importarTestSimple;
    private javax.swing.JMenuItem importarTestSparql;
    private javax.swing.JMenu instanciasMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem nuevoInstancias;
    private javax.swing.JMenuItem nuevoProyecto;
    private javax.swing.JMenuItem nuevoTestCla;
    private javax.swing.JMenuItem nuevoTestInst;
    private javax.swing.JMenuItem nuevoTestReal;
    private javax.swing.JMenuItem nuevoTestRec;
    private javax.swing.JMenuItem nuevoTestSat;
    private javax.swing.JMenu nuevoTestSimple;
    private javax.swing.JMenuItem nuevoTestSparql;
    private javax.swing.JMenu proyectoMenu;
    private javax.swing.JMenuItem salirProyecto;
    private javax.swing.JMenu testsSimplesMenu;
    private javax.swing.JMenu testsSparqlMenu;
    private javax.swing.JMenuItem tiposDeTestsMenuItem;
    private javax.swing.JMenuItem verInstancias;
    private javax.swing.JMenuItem verTestMenuItem;
    private javax.swing.JMenuItem verTestSparql;
    // End of variables declaration//GEN-END:variables

}
