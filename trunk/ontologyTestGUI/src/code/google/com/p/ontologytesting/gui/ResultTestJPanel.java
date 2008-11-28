/*
 * resultTestJPanel.java
 *
 * Created on 25 de septiembre de 2008, 12:10
 */

package code.google.com.p.ontologytesting.gui;

import code.google.com.p.ontologytesting.gui.auxiliarclasess.ButtonTabComponent;
import code.google.com.p.ontologytesting.gui.auxiliarclasess.TreeResults;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;


/**
 *
 * @author  sara.garcia
 */
public class ResultTestJPanel extends javax.swing.JPanel {

    private static ResultTestJPanel result = null;
    private JPanel panelResult;
    int numCom = 0;
 
    private ResultTestJPanel() {
       initComponents();
    }
 
    private synchronized static void createListAndResultPanel() {
        if (result == null) { 
            result = new ResultTestJPanel();
        }
    }

    public static ResultTestJPanel getInstance() {
        if (result == null) createListAndResultPanel();
        return result;
    }
    
    
    public void aniadirResultado(JScrollPane result){
        panelResult = new JPanel();
        panelResult.setLayout(new BoxLayout(panelResult, BoxLayout.Y_AXIS));
        getResultsTabbedPane().add(TreeResults.getTestSeleccionado(),panelResult);
        initTabComponent(getResultsTabbedPane().getTabCount()-1);
        panelResult.add(result);
        getResultsTabbedPane().setSelectedIndex(getResultsTabbedPane().getTabCount()-1);
        getResultsTabbedPane().setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
        panelResult.validate();    
    }
    
    private void initTabComponent(int i) {
        getResultsTabbedPane().setTabComponentAt(i,new ButtonTabComponent(getResultsTabbedPane(),true,false));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        resultsTabbedPane = new javax.swing.JTabbedPane();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(resultsTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(resultsTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane resultsTabbedPane;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTabbedPane getResultsTabbedPane() {
        return resultsTabbedPane;
    }



}
