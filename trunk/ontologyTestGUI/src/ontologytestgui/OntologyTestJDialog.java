/*
 * OntologyTestJDialog.java
 *
 * Created on 2 de junio de 2008, 9:36
 */

package ontologytestgui;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author  sara.garcia
 */
public class OntologyTestJDialog extends javax.swing.JDialog {

    public GroupTestsJPanel groupTest = new GroupTestsJPanel(25);
    static final int desktopWidth = 1000;
    static final int desktopHeight = 800;
    
    /** Creates new form OntologyTestJDialog */
    public OntologyTestJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(desktopWidth,desktopHeight);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(groupTest,BorderLayout.CENTER);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator = new javax.swing.JSeparator();
        sigButton = new javax.swing.JButton();
        antButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        sigButton.setText("Siguiente");
        sigButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sigButtonActionPerformed(evt);
            }
        });

        antButton.setText("Anterior");
        antButton.setEnabled(false);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 895, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 603, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(725, 725, 725)
                .addComponent(antButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sigButton)
                .addContainerGap())
            .addComponent(jSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {antButton, sigButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sigButton)
                    .addComponent(antButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void sigButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sigButtonActionPerformed
// TODO add your handling code here:
    GroupTestsJPanel group = (GroupTestsJPanel) mainPanel.getComponent(0);
    JPanel panelGroup = group.getTest1Panel();
    int totalGroupComp = panelGroup.getComponentCount();
    for(int j=0; j<totalGroupComp;j++){
       TestInstancesTFJPanel test = (TestInstancesTFJPanel) panelGroup.getComponent(j);
       String query = test.getQuery();
       Boolean expect = test.isTestTrue();
       AddComentJFrame comentPane = test.getComment();
       String coment = comentPane.getComent();
       System.out.println(query+expect+coment);
    }
    /*for(int i=0; i<totalClas; i++){
        CreateInstancesJPanel panelInst = (CreateInstancesJPanel) clasPanel.getComponent(i);
        String query = panelInst.getQuery();
        AddComentJFrame comentPane = panelInst.getComment();
        String coment = comentPane.getComent();
            ClassInstances cI = new ClassInstances(query,coment);
            clasInst.add(cI);
    }*/
}//GEN-LAST:event_sigButtonActionPerformed

    
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OntologyTestJDialog dialog = new OntologyTestJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton antButton;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton sigButton;
    // End of variables declaration//GEN-END:variables

}
