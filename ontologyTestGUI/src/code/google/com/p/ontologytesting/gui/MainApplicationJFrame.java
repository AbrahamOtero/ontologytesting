/*
 * MainApplicationJFrame.java
 *
 * Created on 11 de octubre de 2008, 12:33
 */

package code.google.com.p.ontologytesting.gui;

import code.google.com.p.ontologytesting.gui.auxiliarpanels.*;
import code.google.com.p.ontologytesting.gui.menupanels.*;
import code.google.com.p.ontologytesting.gui.instances.*;
import code.google.com.p.ontologytesting.gui.auxiliarclasess.*;
import code.google.com.p.ontologytesting.gui.tests.*;
import code.google.com.p.ontologytesting.model.*;
import code.google.com.p.ontologytesting.model.ScenarioTest.TipoTest;
import code.google.com.p.ontologytesting.model.reasonerinterfaz.ExceptionReadOntology;
import code.google.com.p.ontologytesting.persistence.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

/**
 *
 * @author  saruskas
 */
public class MainApplicationJFrame extends javax.swing.JFrame{
    
    private ListAndResultsJPanel panelTest;
    private ControladorTests controlador;
    private ScenarioTest s = new ScenarioTest();
    private String carpetaProyecto,nombreProyecto;
    private IOManagerImplementation persist = new IOManagerImplementation();
    private static MainApplicationJFrame mainApp = null;
    private boolean proyectoGuardado=false;
    private AniadirPanelDeAviso panelAviso;
    private FileChooserSelector utils;
    private XMLDecoder decoder;
    private CollectionTest collection;
    private TestSimpleInstSat testInstSat;
    private TestSimpleReal testReal;
    private TestSimpleRetClas testRetClas;
    private AddSPARQLJPanel testSparql;
    private JPanel panelActual;
    private ProgressControlJDialog progres;
    private ExecuteTest execTest;
    
    /** Creates new form MainApplicationJFrame */
    private MainApplicationJFrame() {
        initComponents();
        panelAviso = new AniadirPanelDeAviso();
        this.setTitle("EVALUADOR DE ONTOLOGIAS");
        this.setSize(new Dimension(910,750));
        controlador = ControladorTests.getInstance();
        panelTest = ListAndResultsJPanel.getInstance();
        contentTestsJPanel.setLayout(new BorderLayout());
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
        selecTestMenuItem = new javax.swing.JMenuItem();
        ejecutarTodosMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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

        fileMenu.setText("Archivo");

        nuevoProyectoMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/document-new.png"))); // NOI18N
        nuevoProyectoMenuItem.setText("Nuevo");
        nuevoProyectoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoProyectoMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(nuevoProyectoMenuItem);

        abrirProyectoMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/document-open.png"))); // NOI18N
        abrirProyectoMenuItem.setText("Abrir");
        abrirProyectoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirProyectoMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(abrirProyectoMenuItem);

        guardarProyectoMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/document-save.png"))); // NOI18N
        guardarProyectoMenuItem.setText("Guardar");
        guardarProyectoMenuItem.setEnabled(false);
        guardarProyectoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarProyectoMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(guardarProyectoMenuItem);

        guardarProyectoComoMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/document-save-as.png"))); // NOI18N
        guardarProyectoComoMenuItem.setText("Guardar Como");
        guardarProyectoComoMenuItem.setEnabled(false);
        guardarProyectoComoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarProyectoComoMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(guardarProyectoComoMenuItem);

        salirMenuItem.setText("Salir");
        salirMenuItem.setEnabled(false);
        salirMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(salirMenuItem);

        menuBar.add(fileMenu);

        testsMenu.setText("Tests");
        testsMenu.setEnabled(false);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/document-new.png"))); // NOI18N
        jMenu3.setText("Nuevo");

        jMenu4.setText("Test Simple");

        nuevoTestInstMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/flag_blue.gif"))); // NOI18N
        nuevoTestInstMenuItem.setText("Test de Instanciación");
        nuevoTestInstMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoTestInstMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(nuevoTestInstMenuItem);

        nuevoTestRecMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/flag_green.gif"))); // NOI18N
        nuevoTestRecMenuItem.setText("Test de Recuperación");
        nuevoTestRecMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoTestRecMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(nuevoTestRecMenuItem);

        nuevoTestRealMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/flag_orange.gif"))); // NOI18N
        nuevoTestRealMenuItem.setText("Test de Realización");
        nuevoTestRealMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoTestRealMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(nuevoTestRealMenuItem);

        nuevoTestSatMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/flag_red.gif"))); // NOI18N
        nuevoTestSatMenuItem.setText("Test de Satisfactibilidad");
        nuevoTestSatMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoTestSatMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(nuevoTestSatMenuItem);

        nuevoTestClasMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/flag_white.gif"))); // NOI18N
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

        importarTestsMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/go-jump.png"))); // NOI18N
        importarTestsMenuItem.setText("Importar");
        importarTestsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importarTestsMenuItemActionPerformed(evt);
            }
        });
        testsMenu.add(importarTestsMenuItem);

        editarTestsMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/page_edit.png"))); // NOI18N
        editarTestsMenuItem.setText("Editar");
        editarTestsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarTestsMenuItemActionPerformed(evt);
            }
        });
        testsMenu.add(editarTestsMenuItem);

        verTestsMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/document-print-preview.png"))); // NOI18N
        verTestsMenuItem.setText("Ver");
        verTestsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verTestsMenuItemActionPerformed(evt);
            }
        });
        testsMenu.add(verTestsMenuItem);

        menuBar.add(testsMenu);

        instanciasMenu.setText("Instancias");
        instanciasMenu.setEnabled(false);

        nuevoInstanciasMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/document-new.png"))); // NOI18N
        nuevoInstanciasMenuItem.setText("Nuevo");
        nuevoInstanciasMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoInstanciasMenuItemActionPerformed(evt);
            }
        });
        instanciasMenu.add(nuevoInstanciasMenuItem);

        importarInstanciasMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/go-jump.png"))); // NOI18N
        importarInstanciasMenuItem.setText("Importar");
        importarInstanciasMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importarInstanciasMenuItemActionPerformed(evt);
            }
        });
        instanciasMenu.add(importarInstanciasMenuItem);

        editarInstanciasMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/page_edit.png"))); // NOI18N
        editarInstanciasMenuItem.setText("Editar");
        editarInstanciasMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarInstanciasMenuItemActionPerformed(evt);
            }
        });
        instanciasMenu.add(editarInstanciasMenuItem);

        verInstanciasMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/document-print-preview.png"))); // NOI18N
        verInstanciasMenuItem.setText("Ver");
        verInstanciasMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verInstanciasMenuItemActionPerformed(evt);
            }
        });
        instanciasMenu.add(verInstanciasMenuItem);

        menuBar.add(instanciasMenu);

        ejecutarMenu.setText("Ejecutar");
        ejecutarMenu.setEnabled(false);

        selecTestMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/document-print-preview.png"))); // NOI18N
        selecTestMenuItem.setText("Seleccionar test");
        selecTestMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecTestMenuItemActionPerformed(evt);
            }
        });
        ejecutarMenu.add(selecTestMenuItem);

        ejecutarTodosMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/google/com/p/ontologytesting/images/applications-system.png"))); // NOI18N
        ejecutarTodosMenuItem.setText("Todos los Tests");
        ejecutarTodosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecutarTodosMenuItemActionPerformed(evt);
            }
        });
        ejecutarMenu.add(ejecutarTodosMenuItem);

        menuBar.add(ejecutarMenu);

        helpMenu.setText("Ayuda");

        contentsMenuItem.setText("Contenidos");
        contentsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentsMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setText("Acerca de");
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
    utils = new FileChooserSelector();
    boolean res = utils.fileChooser(false, true, false);
    if(res == true){
        this.guardarProyecto(true, FileChooserSelector.getPathSelected());
    }         
}//GEN-LAST:event_guardarProyectoComoMenuItemActionPerformed

private void nuevoProyectoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                                      
// TODO add your handling code here:
    NewProjectJDialog newProject = new NewProjectJDialog(this,true);
    newProject.setLocationRelativeTo(this);
    newProject.setVisible(true);
    if(newProject.getProyectoCreado()==true){
        this.inicializarContadores();
        guardarProyectoComoMenuItem.setEnabled(true);
        guardarProyectoMenuItem.setEnabled(true);
        instanciasMenu.setEnabled(true);
        testsMenu.setEnabled(true);
        ejecutarMenu.setEnabled(true);
        salirMenuItem.setEnabled(true);
        contentTestsJPanel.add(panelTest,BorderLayout.CENTER);
        IOManagerImplementation.setEsNuevo(true);
        this.validate();
    }
}

private void salirMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirMenuItemActionPerformed
// TODO add your handling code here:
    int n = JOptionPane.showConfirmDialog(this, "¿Guardar el Proyecto?", 
                "Salir",JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION){
            this.guardarProyecto(false, null);
            this.dispose();
            System.exit(0);
        }else{
            this.dispose();
            System.exit(0);
        }
}//GEN-LAST:event_salirMenuItemActionPerformed

private void nuevoTestInstMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoTestInstMenuItemActionPerformed
// TODO add your handling code here:
    s = new ScenarioTest(TipoTest.INST);
    aniadirNuevoTest(s);
}//GEN-LAST:event_nuevoTestInstMenuItemActionPerformed

private void nuevoTestRecMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoTestRecMenuItemActionPerformed
// TODO add your handling code here:
    s = new ScenarioTest(TipoTest.RET);
    aniadirNuevoTest(s);
}//GEN-LAST:event_nuevoTestRecMenuItemActionPerformed


private void nuevoTestRealMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoTestRealMenuItemActionPerformed
// TODO add your handling code here:
    s = new ScenarioTest(TipoTest.REAL);
    aniadirNuevoTest(s);
}//GEN-LAST:event_nuevoTestRealMenuItemActionPerformed

private void nuevoTestSatMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoTestSatMenuItemActionPerformed
// TODO add your handling code here:
    s = new ScenarioTest(TipoTest.SAT);
    aniadirNuevoTest(s);
}//GEN-LAST:event_nuevoTestSatMenuItemActionPerformed


private void nuevoTestClasMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoTestClasMenuItemActionPerformed
// TODO add your handling code here:
    s = new ScenarioTest(TipoTest.CLAS);
    aniadirNuevoTest(s);
}//GEN-LAST:event_nuevoTestClasMenuItemActionPerformed

private void nuevoTestSparqlMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoTestSparqlMenuItemActionPerformed
// TODO add your handling code here:
    s = new ScenarioTest(TipoTest.SPARQL);
    aniadirNuevoTest(s);
}//GEN-LAST:event_nuevoTestSparqlMenuItemActionPerformed

private void importarTestsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importarTestsMenuItemActionPerformed
// TODO add your handling code here:
    this.importarTestsInstancias(true);
}//GEN-LAST:event_importarTestsMenuItemActionPerformed

private void editarTestsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarTestsMenuItemActionPerformed
// TODO add your handling code here:
    boolean res = listaTestsInstanciasVacia(true); 
    if(res==true){
        this.editarVerTestsInstancias(true);
    }
}//GEN-LAST:event_editarTestsMenuItemActionPerformed

private void verTestsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verTestsMenuItemActionPerformed
// TODO add your handling code here:
    boolean res = listaTestsInstanciasVacia(true); 
    if(res==true){
        this.editarVerTestsInstancias(true);
    }
}//GEN-LAST:event_verTestsMenuItemActionPerformed

private void nuevoInstanciasMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoInstanciasMenuItemActionPerformed
// TODO add your handling code here:
    Instancias inst = new Instancias();
    cargarInstancia(inst,"Nueva Instancia");
}//GEN-LAST:event_nuevoInstanciasMenuItemActionPerformed

private void importarInstanciasMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importarInstanciasMenuItemActionPerformed
// TODO add your handling code here:
    this.importarTestsInstancias(false);
}//GEN-LAST:event_importarInstanciasMenuItemActionPerformed

private void editarInstanciasMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarInstanciasMenuItemActionPerformed
// TODO add your handling code here:
    boolean res = listaTestsInstanciasVacia(false); 
    if(res==true){
        this.editarVerTestsInstancias(false);
    }
}//GEN-LAST:event_editarInstanciasMenuItemActionPerformed

private void verInstanciasMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verInstanciasMenuItemActionPerformed
// TODO add your handling code here:
    boolean res = listaTestsInstanciasVacia(false); 
    if(res==true){
        this.editarVerTestsInstancias(false);
    }
}//GEN-LAST:event_verInstanciasMenuItemActionPerformed

private void ejecutarTodosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarTodosMenuItemActionPerformed
// TODO add your handling code here:
    if(CollectionTest.getInstance().getScenariotest().size()>0){
        try{
            TreeResults.setTestSeleccionado("Todos los Tests");
            execTest = new ExecuteTest(CollectionTest.getInstance().getScenariotest());  
            progres = new ProgressControlJDialog(execTest);
            JProgressBar progresBar = progres.getProgressBar();
            progresBar.setValue(0);
            execTest.addPropertyChangeListener(new ProgressListener(progresBar,progres,true));
            execTest.execute();
            progres.setVisible(true);         
        }catch(ExceptionReadOntology ex){
            panelAviso.errorAction("Error ejecutando los tests",this);  
        }
    }else{
        panelAviso.errorAction("Su lista de tests está vacía",this);  
    }
}//GEN-LAST:event_ejecutarTodosMenuItemActionPerformed

private void guardarProyectoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarProyectoMenuItemActionPerformed
// TODO add your handling code here:
    this.guardarProyecto(false, null);
}//GEN-LAST:event_guardarProyectoMenuItemActionPerformed

private void abrirProyectoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirProyectoMenuItemActionPerformed
// TODO add your handling code here: 
    AbrirProyectoJDialog abrirP = new AbrirProyectoJDialog(MainApplicationJFrame.getInstance(), true);
    try {
        utils = new FileChooserSelector();
        boolean res = utils.fileChooser(true, true, false);
        if(res == true){
            this.setCarpetaProyecto(FileChooserSelector.getPathSelected());
            this.setNombreProyecto(nombreProyecto);
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(FileChooserSelector.getPathSelected())));
            collection = (CollectionTest) decoder.readObject();
            persist.prepareProject(collection);
            abrirP.setNamespaceText(CollectionTest.getInstance().getNamespace());
            abrirP.getUbicacionFisicaTextField().setText(CollectionTest.getInstance().getOntology());
            abrirP.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            abrirP.setLocationRelativeTo(MainApplicationJFrame.getInstance());
            abrirP.setVisible(true);
            if(abrirP.isProyectoCargado()==true){
                this.inicializarContadores();
                guardarProyectoComoMenuItem.setEnabled(true);
                guardarProyectoMenuItem.setEnabled(true);
                instanciasMenu.setEnabled(true);
                testsMenu.setEnabled(true);
                ejecutarMenu.setEnabled(true);
                salirMenuItem.setEnabled(true);
                contentTestsJPanel.add(panelTest,BorderLayout.CENTER);
                ControladorTests.getInstance().inicializarGuardados();
                ControladorTests.getInstance().inicializarSeleccionados();
                IOManagerImplementation.setEsNuevo(false);
                this.validate();
            }
        }
    } catch (FileNotFoundException ex) {
        panelAviso.errorAction("No se encontró el archivo especificado", MainApplicationJFrame.getInstance());
    } catch (ClassCastException ex) {
        panelAviso.errorAction("Proyecto no válido", MainApplicationJFrame.getInstance());
    } catch (NoSuchElementException ex) {
        panelAviso.errorAction("Proyecto no válido", MainApplicationJFrame.getInstance());
    }
}//GEN-LAST:event_abrirProyectoMenuItemActionPerformed

private void selecTestMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecTestMenuItemActionPerformed
// TODO add your handling code here:
    boolean res = listaTestsInstanciasVacia(true); 
    if(res==true){
        ListarTestsInstanciasJPanel listar = new ListarTestsInstanciasJPanel(CollectionTest.getInstance().getScenariotest(),CollectionTest.getInstance().getInstancias(),true);
        EjecutarTestJDialog ejecutarTest = new EjecutarTestJDialog(this,true,listar);
        ejecutarTest.setLocationRelativeTo(this);
        ejecutarTest.setVisible(true);
        ejecutarTest.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}//GEN-LAST:event_selecTestMenuItemActionPerformed

private void contentsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentsMenuItemActionPerformed
// TODO add your handling code here:
    HelpJDialog help = new HelpJDialog(this,true);
    help.setLocationRelativeTo(this);
    help.setVisible(true);
}//GEN-LAST:event_contentsMenuItemActionPerformed

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
// TODO add your handling code here:
    int n = JOptionPane.showConfirmDialog(this, "¿Desea abandonar la aplicación?",//GEN-LAST:event_formWindowClosing
            "Salir",JOptionPane.YES_NO_OPTION);
    if (n == JOptionPane.YES_OPTION){
        this.dispose();
        System.exit(0);
    } 
}
    
private void guardarProyecto(boolean como, String fichero){
    IOManagerImplementation manager = new IOManagerImplementation(como,this.getCarpetaProyecto(),this.getNombreProyecto(),fichero);
    IOSwingWorker sw = new IOSwingWorker(manager);
    progres = new ProgressControlJDialog(sw);
    JProgressBar progresBar = progres.getProgressBar();
    sw.addPropertyChangeListener(new ProgressListener(progresBar,progres,false));
    progresBar.setIndeterminate(true);
    sw.execute();
    progres.setVisible(true); 
}

public class IOSwingWorker extends SwingWorker<Boolean, Void>{
        
    private IOManagerImplementation iomanager;

    private IOSwingWorker(IOManagerImplementation iomanager) {
        this.iomanager=iomanager;
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        boolean res=false;
        res = saveTest(iomanager);
        return res;
    }

    private boolean saveTest(IOManagerImplementation iomanager){ 
        boolean res=false;
        try {
            res = iomanager.saveProject(iomanager.getComo(), iomanager.getCarpetaProy(), iomanager.getNombreProy(), iomanager.getFichero());
        } catch (FileNotFoundException ex) {
        }
        return res;
    }

    @Override
    protected void done() {
        boolean res = false;
        AniadirPanelDeAviso panelAviso = new AniadirPanelDeAviso();
        if(this.isCancelled()==false){
            Toolkit.getDefaultToolkit().beep();
            try {
                res = get();
            } catch (Exception ignore) {
                ignore.printStackTrace();
            }
            if(res==true){
                panelAviso.confirmAction("Proyecto guardado", MainApplicationJFrame.getInstance());
                MainApplicationJFrame.getInstance().setProyectoGuardado(true);
                progres.setVisible(false);
            }else{
                panelAviso.errorAction("Proyecto no guardado",MainApplicationJFrame.getInstance()); 
                progres.setVisible(false);
            }
        }
    }
}

public void importarTestsInstancias(boolean impTest){
    ImportarTestsInstJDialog abrirTests = new ImportarTestsInstJDialog(this,true,impTest);
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

public boolean listaTestsInstanciasVacia(boolean test){
    if(test==true){
        if(CollectionTest.getInstance().getScenariotest().size()==0){
            panelAviso.errorAction("Su lista de tests está vacía",this);  
        }else return true;
    }else{
        if(CollectionTest.getInstance().getInstancias().size()==0){
            panelAviso.errorAction("Su lista de instancias está vacía",this);  
        }else return true;
    }
    return false;
}

public void aniadirNuevoTest(ScenarioTest s){
    this.inicializarContadores();
    int type = 0;
    if(s.getTipoTest().name().equals("INST")){
        type = 0;
    }else if(s.getTipoTest().name().equals("SAT")){
        type = 3;
    }else if(s.getTipoTest().name().equals("RET") ){
        type = 1;
    }else if(s.getTipoTest().name().equals("CLAS")){
        type = 4;
    }else if(s.getTipoTest().name().equals("REAL")){
        type = 2;
    }else if(s.getTipoTest().name().equals("SPARQL")){
        type = 5;
    }
    controlador.prepararTest(s.getTipoTest().name());
    cargarTest(type,s);
}

public void cargarInstancia(Instancias inst, String msg){
    Instancias instancias = new Instancias(inst);
    AddInstancesClasPropJPanel nuevoInst = new AddInstancesClasPropJPanel(instancias);
    panelTest.getTestsPanel().aniadirTest(nuevoInst,msg);
    setPanelActual(nuevoInst);
}

public void cargarInstancia(ScenarioTest scenario, String msg){
    AddInstancesClasPropJPanel nuevoInst = new AddInstancesClasPropJPanel(scenario);
    panelTest.getTestsPanel().aniadirTest(nuevoInst,msg);
    setPanelActual(nuevoInst);
}

public void cargarTest(int type,ScenarioTest s){
    String testName="";
    if(type==0 || type==3){
        testInstSat = new TestSimpleInstSat(s);
        if(s.getNombre().equals("") && type==0){
            testName="Nuevo Instanciación";
        }else if(s.getNombre().equals("") && type==3){
            testName="Nuevo Satisfactibilidad";
        }else testName=s.getNombre();
        testInstSat.setScenarioActual(new ScenarioTest(s));
        panelTest.getTestsPanel().aniadirTest(testInstSat,testName);
        setPanelActual(testInstSat);
    }else if(type==1 || type==4){
        if(s.getNombre().equals("") && type==1){
            testName="Nuevo Recuperación";
        }else if(s.getNombre().equals("") && type==4){
            testName="Nuevo Clasificación";
        }else testName=s.getNombre();
        testRetClas = new TestSimpleRetClas(s);
        testRetClas.setScenarioActual(new ScenarioTest(s));
        panelTest.getTestsPanel().aniadirTest(testRetClas,testName);
        setPanelActual(testRetClas);
    }else if(type==2){
        if(s.getNombre().equals("")){
            testName="Nuevo Realización";
        }else testName=s.getNombre();
         testReal = new TestSimpleReal(s);
         testReal.setScenarioActual(new ScenarioTest(s));
         panelTest.getTestsPanel().aniadirTest(testReal,testName);
         setPanelActual(testReal);
    }else if(type==5){
        if(s.getNombre().equals("")){
            testName="Nuevo SPARQL";
        }else testName=s.getNombre();
        testSparql = new AddSPARQLJPanel(s);
        testSparql.setScenarioActual(new ScenarioTest(s));
        panelTest.getTestsPanel().aniadirTest(testSparql,testName);
        setPanelActual(testSparql);
    }
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
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ignore) {
                }
                MainApplicationJFrame main = MainApplicationJFrame.getInstance();
                main.setIconImage (new ImageIcon("./src/code/google/com/p/ontologytesting/images/ontologyBB.jpg").getImage());
                main.setLocationRelativeTo(null);
                main.setVisible(true);
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

    public boolean isProyectoGuardado() {
        return proyectoGuardado;
    }

    public void setProyectoGuardado(boolean proyectoGuardado) {
        this.proyectoGuardado = proyectoGuardado;
    }
    
    public JPanel getPanelActual() {
        return panelActual;
    }

    public void setPanelActual(JPanel panelActual) {
        this.panelActual = panelActual;
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
    private javax.swing.JMenuItem selecTestMenuItem;
    private javax.swing.JMenu testsMenu;
    private javax.swing.JMenuItem verInstanciasMenuItem;
    private javax.swing.JMenuItem verTestsMenuItem;
    // End of variables declaration//GEN-END:variables

}
