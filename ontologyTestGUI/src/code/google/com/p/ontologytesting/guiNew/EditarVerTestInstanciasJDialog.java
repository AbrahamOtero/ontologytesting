/*
 * EditarVerTestInstanciasJDialog.java
 *
 * Created on 21 de octubre de 2008, 11:33
 */

package code.google.com.p.ontologytesting.guiNew;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author  sara.garcia
 */
public class EditarVerTestInstanciasJDialog extends javax.swing.JDialog {

    private ListarTestsInstanciasJPanel listarTestInst = new ListarTestsInstanciasJPanel();
    private OpcionesMenu opMenu = new OpcionesMenu();
    private boolean isTest=false;
    private JPanel panel = new JPanel();
    
    /** Creates new form EditarVerTestInstanciasJDialog */
    public EditarVerTestInstanciasJDialog(java.awt.Frame parent, boolean modal, ListarTestsInstanciasJPanel listarTestInst,boolean isTest) {
        super(parent, modal);
        initComponents();
        this.setListarTestInst(listarTestInst);
        this.setLocationRelativeTo(this.getParent());
        contentPanel.setLayout(new FlowLayout());
        contentPanel.add(listarTestInst);
        this.setTitle("Editar/Ver Test o Instancias");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        contentPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cancelarButton = new javax.swing.JButton();
        editarButton = new javax.swing.JButton();
        verButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Editar/Ver Tests o Instancias");

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 227, Short.MAX_VALUE)
        );

        jLabel2.setText("Seleccione el Test que desee editar o ver:");

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        editarButton.setText("Editar");
        editarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarButtonActionPerformed(evt);
            }
        });

        verButton.setText("Ver");
        verButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(contentPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(verButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelarButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarButton)
                    .addComponent(editarButton)
                    .addComponent(verButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void verButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verButtonActionPerformed
// TODO add your handling code here:
    SeeTestJDialog seeTest;
    if(this.getIsTest()==true){
        seeTest = opMenu.verTest(this.getListarTestInst().getScenarioSelect());//GEN-LAST:event_verButtonActionPerformed
    }else{
        seeTest = opMenu.verInstancias(this.getListarTestInst().getInstanciaSelect());
    }
    seeTest.setLocationRelativeTo(this);
    seeTest.setVisible(true);
}

private void editarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarButtonActionPerformed
// TODO add your handling code here:
    if(this.getIsTest()==true){//GEN-LAST:event_editarButtonActionPerformed
        opMenu.editarTest(this.getListarTestInst().getScenarioSelect());                                            
    }else{
        AddInstancesClasPropJDialog editInst = new AddInstancesClasPropJDialog(panel, false, this.getListarTestInst().getInstanciaSelect());
        editInst.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        editInst.setVisible(true);
    }
}

private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
// TODO add your handling code here:
    this.setVisible(false);//GEN-LAST:event_cancelarButtonActionPerformed
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarButton;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton editarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton verButton;
    // End of variables declaration//GEN-END:variables

    public ListarTestsInstanciasJPanel getListarTestInst() {
        return listarTestInst;
    }

    public void setListarTestInst(ListarTestsInstanciasJPanel listarTestInst) {
        this.listarTestInst = listarTestInst;
    }

    public boolean getIsTest() {
        return isTest;
    }

    public void setIsTest(boolean isTest) {
        this.isTest = isTest;
    }

}
