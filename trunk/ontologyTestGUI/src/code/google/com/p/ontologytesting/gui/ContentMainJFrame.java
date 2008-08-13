/*
 * ContentMainJFrame.java
 *
 * Created on 25 de junio de 2008, 1:27
 */

package code.google.com.p.ontologytesting.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import code.google.com.p.ontologytesting.model.Instancias;
import code.google.com.p.ontologytesting.model.ValidarConsultas;

/**
 *
 * @author  sara.garcia
 */
public class ContentMainJFrame extends javax.swing.JFrame {

    public static ArrayList getPaginas() {
        return paginas;
    }
    public static void setPaginas(ArrayList aPaginas) {
        paginas = aPaginas;
    }
    public static int getActual() {
        return actual;
    }
    public static void setActual(int aActual) {
        actual = aActual;
    }
    private static boolean heVueltoGroupTest=false,heVueltoSparql=false;
    private static ArrayList<Instancias> instancias = new ArrayList<Instancias>();
    public static boolean isHeVueltoGroupTest() {
        return heVueltoGroupTest;
    }
    public static void setHeVueltoGroupTest(boolean aHeVueltoGroupTest) {
        heVueltoGroupTest = aHeVueltoGroupTest;
    }
    public static boolean isHeVueltoSparql() {
        return heVueltoSparql;
    }
    public static void setHeVueltoSparql(boolean aHeVueltoSparql) {
        heVueltoSparql = aHeVueltoSparql;
    }
    private static MainJPanel mainPanel;
    private static GroupTestsJPanel groupTests;
    public static ArrayList<Instancias> getInstancias() {
        return instancias;
    }
    public static void setInstancias(int index,Instancias aInstancias) {
        instancias.set(index, aInstancias);
    }
    private JFrame frame;
    private AddInstancesClasPropJDialog addInstances = new AddInstancesClasPropJDialog(frame,true,8,0);
    private AddSPARQLJPanel sparql;
    private ConfigurationJPanel configurar;
    private static ArrayList paginas = new ArrayList();
    private static int actual=0;
    private static boolean botonAnte=false;
    
    /** Creates new form ContentMainJFrame */
    public ContentMainJFrame() {
        initComponents();
        mainPanel = new MainJPanel();
        groupTests = new GroupTestsJPanel(8);
        this.setGroupTests(groupTests);
        for (int i = 0; i <= 5; i++) {
            instancias.add(new Instancias());
        }
        contentPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setTitle("EVALUADOR DE ONTOLOGÍAS");
        this.setSize(new Dimension(980,700));
        contentPanel.add(mainPanel);
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
        jSeparator1 = new javax.swing.JSeparator();
        siguienteButton = new javax.swing.JButton();
        anteriorButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 951, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
        );

        siguienteButton.setText("Siguiente >>");
        siguienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteButtonActionPerformed(evt);
            }
        });

        anteriorButton.setText("<< Anterior");
        anteriorButton.setEnabled(false);
        anteriorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(741, 741, 741)
                .addComponent(anteriorButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(siguienteButton)
                .addGap(18, 18, 18))
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(547, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siguienteButton)
                    .addComponent(anteriorButton))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(70, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void siguienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteButtonActionPerformed
// TODO add your handling code here:
    completarArrayOrden();
    String ontologyFisical=MainJPanel.getFisicalOntologyTextField();
    if(ContentMainJFrame.getActual()==0){
            if(MainJPanel.getFisicalOntologyTextField().equals("") || 
                    MainJPanel.getNamespaceOntologyTextField().equals("")){
                JOptionPane.showMessageDialog(frame,"Ambos campos ubicación " +
                        "física y namespace son obligatorios","Warning Message",JOptionPane.WARNING_MESSAGE);
            }else if(!ontologyFisical.endsWith(".owl")){
                JOptionPane.showMessageDialog(frame,"La ontología introdcida no es válida, por favor, " +
                "compruebe que es correcta.","Warning Message",JOptionPane.WARNING_MESSAGE);
            }else{
            if(paginas.get(0).equals(1)){
                getContentPanel().remove(getMainPanel());
                getContentPanel().add(getGroupTests());
                AddSPARQLJPanel.setSeleccionado(false);
                anteriorButton.setEnabled(true);
                ContentMainJFrame.setActual(1);
                this.validate();
            }else if(paginas.get(1).equals(1)){
                sparql = new AddSPARQLJPanel();
                AddSPARQLJPanel.setSPARQLQuery("" +
                        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                        "SELECT ?subject ?object " +
                        "FROM <data/family.owl> " +
                        "WHERE " +
                        "{?subject rdfs:subClassOf ?object }");
                    getContentPanel().remove(getMainPanel());
                    getContentPanel().add(sparql);
                AddSPARQLJPanel.setSeleccionado(true);
                anteriorButton.setEnabled(true);
                ContentMainJFrame.setActual(2);
                this.validate();
            }else if(paginas.get(2).equals(1)){
                getContentPanel().remove(getMainPanel());
                getContentPanel().add(addInstances.getContentPanel());
                anteriorButton.setEnabled(true);
                AddSPARQLJPanel.setSeleccionado(false);
                ContentMainJFrame.setActual(3);
                this.validate();
            }else if(paginas.get(3).equals(1)){
                configurar = new ConfigurationJPanel();
                getContentPanel().remove(getMainPanel());
                getContentPanel().add(configurar);
                anteriorButton.setEnabled(true);
                AddSPARQLJPanel.setSeleccionado(false);
                ContentMainJFrame.setActual(4);
                this.validate();
            }else{
                JOptionPane.showMessageDialog(frame,"Debe seleccionar alguna " +
                        "opción para continuar","Warning Message",JOptionPane.WARNING_MESSAGE);
            }
            }
    }else{
        if(ContentMainJFrame.getActual()==1){
            getGroupTests().guardarDatos();
            ValidarConsultas validar = new ValidarConsultas();
            if(GroupTestsJPanel.getNoHayInstancias()==false){
                if(getGroupTests().getNombreTestsValidos()==true && 
                    getGroupTests().getTestsValidos()==true && 
                    GroupTestsJPanel.getTestYaExiste()==false){
                    getContentPanel().remove(getGroupTests());
                    getContentPanel().add(GroupTestsJPanel.getPanelTree());
                    ContentMainJFrame.setActual(4);
                    this.validate();
                }else if(getGroupTests().getTestsValidos()==false){
                    JOptionPane.showMessageDialog(frame,"El formato de los datos marcados en rojo" +
                        "no es correcto.\nPor favor, consulte la ayuda acerca del formato " +
                        "de las consultas y el resultado.","Warning Message",JOptionPane.WARNING_MESSAGE);
                    if(GroupTestsJPanel.getActualSubTabInst()==0){
                        if(validar.comprovarErrorEnAyudaInst()==false){
                            ContentMainJFrame.setActual(1);
                        }
                    }else{
                        if(validar.comprovarErrorQuerysInst()==false){
                            ContentMainJFrame.setActual(1);
                        }
                    }
                    if(GroupTestsJPanel.getActualSubTabRet()==0){
                        if(validar.comprovarErrorEnAyudaRet()==false){
                            ContentMainJFrame.setActual(1);
                        }
                    }else{
                        if(validar.comprovarErrorQuerysRet()==false){
                            ContentMainJFrame.setActual(1);
                        }
                    }
                    if(GroupTestsJPanel.getActualSubTabReal()==0){
                        if(validar.comprovarErrorEnAyudaReal()==false){
                            ContentMainJFrame.setActual(1);
                        }
                    }else{
                        if(validar.comprovarErrorQuerysReal()==false){
                            ContentMainJFrame.setActual(1);
                        }
                    }
                    if(GroupTestsJPanel.getActualSubTabSat()==0){
                        if(validar.comprovarErrorEnAyudaSat()==false){
                            ContentMainJFrame.setActual(1);
                        }
                    }else{
                        if(validar.comprovarErrorQuerysSat()==false){
                            ContentMainJFrame.setActual(1);
                        }
                    }
                    if(GroupTestsJPanel.getActualSubTabClas()==0){
                        if(validar.comprovarErrorEnAyudaClas()==false){
                            ContentMainJFrame.setActual(1);
                        } 
                    }else{
                        if(validar.comprovarErrorQuerysClas()==false){
                            ContentMainJFrame.setActual(1);
                        }
                    }                
            }else if(getGroupTests().getNombreTestsValidos()==false){
                JOptionPane.showMessageDialog(frame,"El nombre de los tests es " +
                 "obligatorio.","Warning Message",JOptionPane.WARNING_MESSAGE);
                this.setGroupTests(getGroupTests());
               ContentMainJFrame.setActual(1);
            }else if(GroupTestsJPanel.getTestYaExiste()==true){
                JOptionPane.showMessageDialog(frame,"Ya existe un test con ese nombre, por favor," +
                        "introduzca uno nuevo","Warning Message",JOptionPane.WARNING_MESSAGE);
                this.setGroupTests(getGroupTests());
                ContentMainJFrame.setActual(1);
            }
        }else{
            ContentMainJFrame.setActual(1);
        }
        }else if(ContentMainJFrame.getActual()==2){ 
                getGroupTests().guardarDatos();
                getContentPanel().remove(sparql);
                getContentPanel().add(GroupTestsJPanel.getPanelTree());
                ContentMainJFrame.setActual(4);
                this.validate();
        }else if(ContentMainJFrame.getActual()==3){
                getContentPanel().remove(addInstances.getContentPanel());
                getContentPanel().add(GroupTestsJPanel.getPanelTree());
                //groupTests.guardarDatos();
                ContentMainJFrame.setActual(4);
                this.validate();
        }else if(ContentMainJFrame.getActual()==4){
            //Esto en la pagina de configuracion
        }
    }
    setBotonAnte(false);
}//GEN-LAST:event_siguienteButtonActionPerformed

public void completarArrayOrden(){
    
    if(MainJPanel.getNewTestState()==true){
        paginas.add(0, 1);
    }else{
        paginas.add(0, 0);
    }
    if(MainJPanel.getSparqlState()==true){
        paginas.add(1, 1);
    }else{
        paginas.add(1, 0);
    }
    if(MainJPanel.getNewInstancesState()==true){
        paginas.add(2, 1);
    }else{
        paginas.add(2, 0);
    }
    if(MainJPanel.getConfigurarState()==true){
        paginas.add(3,1);
    }else{
        paginas.add(3,0);
    }
}

private void anteriorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorButtonActionPerformed
// TODO add your handling code here:
    completarArrayOrden();
    if(ContentMainJFrame.getActual()==0){
        anteriorButton.setEnabled(false);
    }else{
        if(ContentMainJFrame.getActual()==1){
                getContentPanel().remove(getGroupTests());
                getContentPanel().add(getMainPanel());
                anteriorButton.setEnabled(false);
                ContentMainJFrame.setActual(0);
                this.validate();
        }else if(ContentMainJFrame.getActual()==2){            
                getContentPanel().remove(sparql);
                getContentPanel().add(getMainPanel());
                anteriorButton.setEnabled(false);
                ContentMainJFrame.setActual(0);
                this.validate();   
        }else if(ContentMainJFrame.getActual()==3){
                getContentPanel().remove(addInstances.getContentPanel());
                getContentPanel().add(getMainPanel());
                anteriorButton.setEnabled(false);
                ContentMainJFrame.setActual(0);
                this.validate(); 
        }else if(ContentMainJFrame.getActual()==4){
            if(paginas.get(2).equals(1)){
                getContentPanel().remove(GroupTestsJPanel.getPanelTree());
                getContentPanel().add(addInstances.getContentPanel());
                anteriorButton.setEnabled(true);
                ContentMainJFrame.setActual(3);
                this.validate();
            }else if(paginas.get(1).equals(1)){
                ContentMainJFrame.setHeVueltoSparql(true);
                getContentPanel().remove(GroupTestsJPanel.getPanelTree());
                getContentPanel().add(sparql);
                AddSPARQLJPanel.setSeleccionado(true);
                anteriorButton.setEnabled(true);
                ContentMainJFrame.setActual(2);
                this.validate();
            }else if(paginas.get(0).equals(1)){
                ContentMainJFrame.setHeVueltoGroupTest(true);
                getContentPanel().remove(GroupTestsJPanel.getPanelTree());
                getContentPanel().add(getGroupTests());
                anteriorButton.setEnabled(true);
                this.validate();
                AddSPARQLJPanel.setSeleccionado(false);
                ContentMainJFrame.setActual(1);    
                setBotonAnte(true);
            }
        }
    }
}//GEN-LAST:event_anteriorButtonActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ContentMainJFrame().setVisible(true);
            }
        });    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anteriorButton;
    private static javax.swing.JPanel contentPanel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton siguienteButton;
    // End of variables declaration//GEN-END:variables

    public GroupTestsJPanel getGroupTests() {
        return groupTests;
    }

    public void setGroupTests(GroupTestsJPanel groupTests) {
        ContentMainJFrame.groupTests = groupTests;
    }
    public static javax.swing.JPanel getContentPanel() {
        return contentPanel;
    }
    public static MainJPanel getMainPanel() {
        MainJPanel.actualizarEstado();
        return mainPanel;
    }
    public static boolean getBotonAnte() {
        return botonAnte;
    }
    public static void setBotonAnte(boolean abotonAnte) {
        botonAnte = abotonAnte;
    }
    
    /*for(int i=1; i<panelAyudaInst.getComponentCount();i++){
                    TestInstancesTFJPanel test = (TestInstancesTFJPanel) panelAyudaInst.getComponent(i);
                    test.getQueryTextField().setForeground(Color.BLACK);
                }
                for(int i=1; i<panelAyudaRet.getComponentCount();i++){
                    TestInstancesTextAreaJPanel test = (TestInstancesTextAreaJPanel) panelAyudaRet.getComponent(i);
                    test.getQueryTextField().setForeground(Color.BLACK);
                    test.getResultTextArea().setForeground(Color.BLACK); 
                }
                for(int i=1; i<panelAyudaReal.getComponentCount();i++){
                    TestInstancesQueryJPanel test = (TestInstancesQueryJPanel) panelAyudaReal.getComponent(i);
                    test.getQueryTextField().setForeground(Color.BLACK);
                    test.getResultTextField().setForeground(Color.BLACK);
                }
                for(int i=1; i<panelAyudaSat.getComponentCount();i++){
                    TestInstancesTFJPanel test = (TestInstancesTFJPanel) panelAyudaSat.getComponent(i);
                    test.getQueryTextField().setForeground(Color.BLACK);
                }
                for(int i=1; i<panelAyudaClas.getComponentCount();i++){
                    TestInstancesTextAreaJPanel test = (TestInstancesTextAreaJPanel) panelAyudaClas.getComponent(i);
                    test.getQueryTextField().setForeground(Color.BLACK);
                    test.getResultTextArea().setForeground(Color.BLACK);
                }*/
}

