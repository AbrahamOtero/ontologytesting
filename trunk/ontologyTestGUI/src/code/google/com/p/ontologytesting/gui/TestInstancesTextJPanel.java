/*
 * TestInstancesTextJPanel.java
 *
 * Created on 29 de julio de 2008, 20:51
 */

package code.google.com.p.ontologytesting.gui;


/**
 *
 * @author  saruskas
 */
public class TestInstancesTextJPanel extends javax.swing.JPanel {

    /** Creates new form TestInstancesTextJPanel */
    public TestInstancesTextJPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane16 = new javax.swing.JScrollPane();
        consultaTextArea = new javax.swing.JTextArea();
        jScrollPane17 = new javax.swing.JScrollPane();
        resultadoEsperadoTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        comentTextArea = new javax.swing.JTextArea();

        consultaTextArea.setColumns(20);
        consultaTextArea.setRows(5);
        jScrollPane16.setViewportView(consultaTextArea);

        resultadoEsperadoTextArea.setColumns(20);
        resultadoEsperadoTextArea.setRows(5);
        jScrollPane17.setViewportView(resultadoEsperadoTextArea);

        jLabel1.setText("                        CONSULTA                                                      RESULTADO ESPERADO                                            COMENTARIO");

        comentTextArea.setColumns(20);
        comentTextArea.setRows(5);
        jScrollPane18.setViewportView(comentTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane16, jScrollPane17, jScrollPane18});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane16, jScrollPane17, jScrollPane18});

    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea comentTextArea;
    private javax.swing.JTextArea consultaTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JTextArea resultadoEsperadoTextArea;
    // End of variables declaration//GEN-END:variables

    public String getConsultaTextArea() {
        return consultaTextArea.getText();
    }

    public void setConsultaTextArea(String aconsultaTextArea) {
        consultaTextArea.setText(aconsultaTextArea);
    }

    public String getResultadoEsperadoTextArea() {
        return resultadoEsperadoTextArea.getText();
    }

    public void setResultadoEsperadoTextArea(String aresultadoEsperadoTextArea) {
        resultadoEsperadoTextArea.setText(aresultadoEsperadoTextArea);
    }

    public String getComentTextArea() {
        return comentTextArea.getText();
    }

    public void setComentTextArea(String acomentTextArea) {
        comentTextArea.setText(acomentTextArea);
    }

}
