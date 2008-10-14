/*
 * listAndTestsJPanel.java
 *
 * Created on 25 de septiembre de 2008, 11:39
 */

package code.google.com.p.ontologytesting.guiNew;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author  sara.garcia
 */
public class ListAndTestsJPanel extends javax.swing.JPanel {

    private static ListAndTestsJPanel listAndTest = null;
 
    private ListAndTestsJPanel() {
        initComponents();
        this.listTestPanel.setLayout(new BorderLayout());
        this.testsPanel.setLayout(new FlowLayout());
        this.splitPane.setDividerLocation(235);
    }
 
    private synchronized static void createListAndTestPanel() {
        if (listAndTest == null) { 
            listAndTest = new ListAndTestsJPanel();
        }
    }
 
    public static ListAndTestsJPanel getInstance() {
        if (listAndTest == null) createListAndTestPanel();
        return listAndTest;
    }
    
    public void aniadirTest(JPanel panel){
        if(this.testsPanel.getComponentCount()>0){
            this.testsPanel.remove(0);
        }
        this.testsPanel.add(panel,BorderLayout.CENTER); 
        this.validate();
    }
    
    public void aniadirLista(ListarTestsJPanel lista){
         this.listTestPanel.add(lista,BorderLayout.CENTER); 
         this.validate();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitPane = new javax.swing.JSplitPane();
        listTestPanel = new javax.swing.JPanel();
        testsPanel = new javax.swing.JPanel();

        splitPane.setOneTouchExpandable(true);

        javax.swing.GroupLayout listTestPanelLayout = new javax.swing.GroupLayout(listTestPanel);
        listTestPanel.setLayout(listTestPanelLayout);
        listTestPanelLayout.setHorizontalGroup(
            listTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 129, Short.MAX_VALUE)
        );
        listTestPanelLayout.setVerticalGroup(
            listTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        splitPane.setLeftComponent(listTestPanel);

        javax.swing.GroupLayout testsPanelLayout = new javax.swing.GroupLayout(testsPanel);
        testsPanel.setLayout(testsPanelLayout);
        testsPanelLayout.setHorizontalGroup(
            testsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
        );
        testsPanelLayout.setVerticalGroup(
            testsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        splitPane.setRightComponent(testsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel listTestPanel;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JPanel testsPanel;
    // End of variables declaration//GEN-END:variables


}
