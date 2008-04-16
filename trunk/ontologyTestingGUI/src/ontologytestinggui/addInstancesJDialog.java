/*
 * addInstancesJDialog.java
 *
 * Created on 15 de abril de 2008, 12:24
 */

package ontologytestinggui;

import java.awt.Component;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author  sara_garcia
 */
public class addInstancesJDialog extends javax.swing.JDialog {
    public Component frame;
    public JFileChooser filechooser = new JFileChooser();

    /** Creates new form addInstancesJDialog */
    public addInstancesJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        instancesPanel = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        asociarInst = new javax.swing.JButton();
        cancelarInst = new javax.swing.JButton();
        limpiarInst = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel17.setText("Introduzca las instancias que deseea añadir para realizar sus pruebas:");

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Instancias de Clase"
            }
        ));
        jScrollPane11.setViewportView(jTable11);

        jTable12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Instancias de Propiedad"
            }
        ));
        jScrollPane12.setViewportView(jTable12);

        asociarInst.setText("Asociar");
        asociarInst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asociarInstActionPerformed(evt);
            }
        });

        cancelarInst.setText("Cancelar");
        cancelarInst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarInstActionPerformed(evt);
            }
        });

        limpiarInst.setText("Limpiar");

        javax.swing.GroupLayout instancesPanelLayout = new javax.swing.GroupLayout(instancesPanel);
        instancesPanel.setLayout(instancesPanelLayout);
        instancesPanelLayout.setHorizontalGroup(
            instancesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 813, Short.MAX_VALUE)
            .addGroup(instancesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(instancesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(instancesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(instancesPanelLayout.createSequentialGroup()
                            .addComponent(limpiarInst)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cancelarInst)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(asociarInst)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(instancesPanelLayout.createSequentialGroup()
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        instancesPanelLayout.setVerticalGroup(
            instancesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
            .addGroup(instancesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(instancesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(instancesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(instancesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(asociarInst)
                        .addComponent(cancelarInst))
                    .addComponent(limpiarInst))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 833, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(instancesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(instancesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void asociarInstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asociarInstActionPerformed
// TODO add your handling code here:
   int n = JOptionPane.showConfirmDialog(frame, "¿Quiere guardar este conjunto de" +
           " instancias para futuras pruebas?", "Guardar Instancias",
           JOptionPane.YES_NO_OPTION);
    
   if (n == JOptionPane.YES_OPTION) {  
    int returnVal = filechooser.showSaveDialog(frame);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = filechooser.getSelectedFile();
        file.setWritable(true);
        try
        {
            FileWriter fichero = new FileWriter(file.getPath());
            PrintWriter pw = new PrintWriter(fichero);
            //Escribir las instancias
            //pw.println("Linea ");
            pw.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        //log.append("Saving: " + file.getName() + ".");
    } else {
        //log.append("Save command cancelled by user.");
    }
    } else if (n == JOptionPane.NO_OPTION) {     
    } else {    
    }
}//GEN-LAST:event_asociarInstActionPerformed

private void cancelarInstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarInstActionPerformed
// TODO add your handling code here:
    dispose();
}//GEN-LAST:event_cancelarInstActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton asociarInst;
    private javax.swing.JButton cancelarInst;
    private javax.swing.JPanel instancesPanel;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable12;
    private javax.swing.JButton limpiarInst;
    // End of variables declaration//GEN-END:variables

}
