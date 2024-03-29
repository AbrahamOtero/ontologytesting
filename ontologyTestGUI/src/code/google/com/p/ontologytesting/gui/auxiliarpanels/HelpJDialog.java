/*
 * HelpJDialog.java
 *
 * Created on 25 de junio de 2008, 12:28
 */

package code.google.com.p.ontologytesting.gui.auxiliarpanels;

import java.awt.Font;

/**
 *
 * @author  sara.garcia
 */
public class HelpJDialog extends javax.swing.JDialog {

    /** Creates new form HelpJDialog */
    public HelpJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setModal(true);
        String help = generarTextoAyuda();
        helpEditorPane.setContentType("text/html");
        helpEditorPane.setText(help);
        helpEditorPane.setFont(new Font("Arial",1,11));
        helpEditorPane.setEditable(false);
        helpEditorPane.setCaretPosition(0);
        this.setTitle("Documentación de Ayuda");
    }

    private String generarTextoAyuda() {
        String help="<html>" +
                "Los tests que están disponibles en la aplicación se describen a continuación:<br><br>"+
                "<h><b>Test de Instanciación</h></b><br><br>" +
                "Este test consiste en deducir si, dado un individuo, " +
                "éste pertenece a una clase.<br><br>" +
                "Ejemplo:<br>" +
                "<b>Consulta: </b>Wife,marry <br> <b>Resultado esperado: </b>True<br><br>" +
                "En este caso el test no fallaría, ya que el individuo " +
                "'marry' aparece definido como Wife en el conjunto de instancias " +
                "de la ontología. <br><br>" +
                "<h><b>Test de Recuperación</h></b><br><br>" +
                "Este test deduce, dada una clase, todos los individuos que " +
                "pertenecen a dicha clase (todos los individuos que son instancias " +
                "de ese concepto).<br><br>" +
                "Ejemplo:<br>" +
                "<b>Consulta: </b>Wife <br> <b>Resultado esperado: </b>marry,lee<br><br>" +
                "En este caso el test no fallaría, ya que para la clase 'Wife', " +
                "todos los individuos que le pertenecen son los contemplados: " +
                "'marry,lee'.<br><br>" +
                "<h><b>Test de Realización</h></b><br><br>" +
                "Este test deduce, dado un individuo, cual es la clase más exacta " +
                "o específica a la que pertenece (dado un individuo, encuentra el concepto " +
                "más específico que lo contiene).<br><br>" +
                "Ejemplo:<br>" +
                "<b>Consulta: </b>marry <br> <b>Resultado esperado: </b>Wife<br><br>" +
                "En este caso el test no fallaría, ya que la clase mas específica que " +
                "contiene al individuo 'marry' es 'Wife'.<br><br>" +
                "<h><b>Test de Satisfactibilidad</h></b><br><br>" +
                "Este test consiste en deducir si una nueva clase puede ser añadida a la " +
                "ontología sin que entre en conflicto con el conjunto de instancias " +
                "ya definido para esa ontología.<br><br>" +
                "Ejemplo:<br>" +
                "<b>Consulta: </b>sara,Wife <br> <b>Resultado esperado: </b>True<br><br>" +
                "En este caso el test no fallaría, ya que el individuo " +
                "'sara' no estaba definido aún en la ontología. <br><br>" +
                "<h><b>Test de clasificación</h></b><br><br>" +
                "Este test deduce, dado un individuo, todas las clases a las que pertenece.<br><br>" +
                "Ejemplo:<br>" +
                "<b>Consulta: </b>marry <br> <b>Resultado esperado: </b>Wife,Female,Person<br><br>" +
                "En este caso el test no fallaría, ya que todas las clases a las que puede " +
                "pertenecer 'marry' son las especificadas. <br><br>" +
                "<h><b>Test Sparl</h></b><br><br>" +
                "Este test ejecuta una consulta Sparql válida. " +
                "Para más información acerca del lenguaje SPARQL visite:<br>" +
                "http://www.w3.org/TR/rdf-sparql-query/<br>" +
                "<br><br>" +
                "</html>";
        return help;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPane = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        helpEditorPane = new code.google.com.p.ontologytesting.gui.JEditorPaneCopyPaste();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        helpEditorPane.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jScrollPane1.setViewportView(helpEditorPane);

        closeButton.setText("Cerrar");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE))
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(349, 349, 349)
                        .addComponent(closeButton)))
                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
// TODO add your handling code here:
    this.setVisible(false);//GEN-LAST:event_closeButtonActionPerformed
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel contentPane;
    private javax.swing.JEditorPane helpEditorPane;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
