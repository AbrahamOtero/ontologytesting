/*
 * ProgressControlJDialog.java
 *
 * Created on 18 de noviembre de 2008, 19:57
 */

package code.google.com.p.ontologytesting.gui.auxiliarpanels;

import code.google.com.p.ontologytesting.gui.MainApplicationJFrame;
import code.google.com.p.ontologytesting.gui.MainApplicationJFrame.IOSwingWorker;
import code.google.com.p.ontologytesting.gui.MainApplicationJFrame.SwingWorkerOntology;
import code.google.com.p.ontologytesting.gui.auxiliarclasess.ExecuteTest;
import code.google.com.p.ontologytesting.gui.auxiliarclasess.LoadOntology;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

/**
 *
 * @author  saruskas
 */
public class ProgressControlJDialog extends javax.swing.JDialog {

    private ExecuteTest execTest;
    private LoadOntology loadOnto;
    private IOSwingWorker sw;
    private SwingWorkerOntology ontoSw;
    private boolean execSelec=false,load=false,save=false,read=false;
    
    /** Creates new form ProgressControlJDialog */
    public ProgressControlJDialog(ExecuteTest execTest) {
        initComponents();
        URL image = this.getClass().getResource("images/ontology.jpg"); 
        this.setIconImage (new ImageIcon(image).getImage());
        this.validate();
        this.setModal(true);
        this.execTest=execTest;
        this.execSelec=true;
        texto.setText("Ejecutando los tests...");
        this.setTitle("Ejecutando");
        this.setLocationRelativeTo(MainApplicationJFrame.getInstance());
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }
    
    public ProgressControlJDialog(LoadOntology loadOnto) {
        initComponents();
        this.setModal(true);
        this.loadOnto=loadOnto;
        this.load=true;
        this.setTitle("Cargando");
        texto.setText("Cargando proyecto...");
        this.setLocationRelativeTo(MainApplicationJFrame.getInstance());
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }
    
    public ProgressControlJDialog(IOSwingWorker sw) {
        initComponents();
        this.setModal(true);
        this.sw=sw;
        this.save=true;
        this.setTitle("Guardando");
        texto.setText("Guardando el proyecto...");
        this.setLocationRelativeTo(MainApplicationJFrame.getInstance());
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }
    
    public ProgressControlJDialog(SwingWorkerOntology sw) {
        initComponents();
        this.setModal(true);
        this.ontoSw=sw;
        this.read=true;
        this.setTitle("Visualizar Ontología");
        texto.setText("Cargando ontología...");
        this.setLocationRelativeTo(MainApplicationJFrame.getInstance());
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressBar = new javax.swing.JProgressBar();
        texto = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(cancelButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(texto)
                .addGap(18, 18, 18)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelButton)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
// TODO add your handling code here:
    this.dispose();//GEN-LAST:event_cancelButtonActionPerformed
    this.setVisible(false);
    if(this.execSelec==true){
        this.execTest.cancel(true); 
    }else if(this.load==true){
        this.loadOnto.cancel(true);
    }else if(this.save==true){
        this.sw.cancel(true);
    }else if(this.read==true){
        this.ontoSw.cancel(true);
    }
}

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
// TODO add your handling code here:
    this.dispose();//GEN-LAST:event_formWindowClosing
    this.setVisible(false);
    if(this.execSelec==true){
        this.execTest.cancel(true); 
    }else if(this.load==true){
        this.loadOnto.cancel(true);
    }else if(this.save==true){
        this.sw.cancel(true);
    }else if(this.read==true){
        this.ontoSw.cancel(true);
    } 
}

public javax.swing.JProgressBar getProgressBar() {
    return progressBar;
}

public void setProgressBar(javax.swing.JProgressBar progressBar) {
    this.progressBar = progressBar;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel texto;
    // End of variables declaration//GEN-END:variables

}
