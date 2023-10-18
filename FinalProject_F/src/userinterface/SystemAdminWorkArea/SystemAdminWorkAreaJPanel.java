/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author srivaishnaviaekkati
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

    
    JPanel userProcessContainer;
    EcoSystem ecosystem;
    private Network network;
    public SystemAdminWorkAreaJPanel(JPanel userProcessContainer,EcoSystem ecosystem,Network network) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.ecosystem=ecosystem;
        this.network=network;
        populateTree();
    }
    
    public void populateTree(){
        DefaultTreeModel model=(DefaultTreeModel)jTree.getModel();
        ArrayList<Network> networkList=ecosystem.getNetworkList();
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> organizationList;
        
        Network network;
        Enterprise enterprise;
        Organization organization;
        
        DefaultMutableTreeNode networks=new DefaultMutableTreeNode("Networks");
        DefaultMutableTreeNode root=(DefaultMutableTreeNode)model.getRoot();
        root.removeAllChildren();
        root.insert(networks, 0);
        
        DefaultMutableTreeNode networkNode;
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;
        
        for(int i=0;i<networkList.size();i++){
            network=networkList.get(i);
            networkNode=new DefaultMutableTreeNode(network.getName());
            networks.insert(networkNode, i);
            
            enterpriseList=network.getEnterpriseDirectory().getEnterpriseList();
            for(int j=0; j<enterpriseList.size();j++){
                enterprise=enterpriseList.get(j);
                enterpriseNode=new DefaultMutableTreeNode(enterprise.getName());
                networkNode.insert(enterpriseNode, j);
                
                organizationList=enterprise.getOrganizationDirectory().getOrganizationList();
                for(int k=0;k<organizationList.size();k++){
                    organization=organizationList.get(i);
                    organizationNode=new DefaultMutableTreeNode(organization.getName());
                    enterpriseNode.insert(organizationNode, k);
                }
            }
        }
        model.reload();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        lblSelectedNode = new javax.swing.JLabel();
        btnManageEnter = new javax.swing.JButton();
        btnMngAdmin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnMngNetwork = new javax.swing.JButton();
        jbtnRepModule = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 65, Short.MAX_VALUE))
        );

        jSplitPane.setLeftComponent(jPanel1);

        jPanel2.setBackground(new java.awt.Color(76, 89, 115));
        jPanel2.setMaximumSize(new java.awt.Dimension(750, 750));
        jPanel2.setMinimumSize(new java.awt.Dimension(750, 750));
        jPanel2.setLayout(null);
        jPanel2.add(lblSelectedNode);
        lblSelectedNode.setBounds(251, 25, 0, 0);

        btnManageEnter.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        btnManageEnter.setText("Manage Enterprise");
        btnManageEnter.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnManageEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageEnterActionPerformed(evt);
            }
        });
        jPanel2.add(btnManageEnter);
        btnManageEnter.setBounds(270, 250, 116, 46);

        btnMngAdmin.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        btnMngAdmin.setText("Manage Enterprise Admin");
        btnMngAdmin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMngAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMngAdminActionPerformed(evt);
            }
        });
        jPanel2.add(btnMngAdmin);
        btnMngAdmin.setBounds(420, 250, 161, 46);

        jLabel1.setFont(new java.awt.Font("Optima", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("System Admin Panel");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(210, 140, 213, 30);

        btnMngNetwork.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        btnMngNetwork.setText("Manage Network");
        btnMngNetwork.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMngNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMngNetworkActionPerformed(evt);
            }
        });
        jPanel2.add(btnMngNetwork);
        btnMngNetwork.setBounds(70, 250, 160, 46);

        jbtnRepModule.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jbtnRepModule.setText("Reporting Module");
        jbtnRepModule.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnRepModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRepModuleActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnRepModule);
        jbtnRepModule.setBounds(250, 350, 167, 50);

        jSplitPane.setRightComponent(jPanel2);

        add(jSplitPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageEnterActionPerformed
        ManageEnterpriseJPanel manageEnterpriseJPanel=new ManageEnterpriseJPanel(userProcessContainer, ecosystem);
        userProcessContainer.add("manageEnterpriseJPanel",manageEnterpriseJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageEnterActionPerformed

    private void btnMngAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMngAdminActionPerformed
        ManageEnterpriseAdminJPanel manageEnterpriseAdminJPanel=new ManageEnterpriseAdminJPanel(userProcessContainer, ecosystem);
        userProcessContainer.add("manageEnterpriseAdminJPanel",manageEnterpriseAdminJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnMngAdminActionPerformed

    private void jTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeValueChanged
        
        DefaultMutableTreeNode selectedNode= (DefaultMutableTreeNode)jTree.getLastSelectedPathComponent();
        if(selectedNode!=null){
            lblSelectedNode.setText(selectedNode.toString());
        }
    }//GEN-LAST:event_jTreeValueChanged

    private void btnMngNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMngNetworkActionPerformed
        // TODO add your handling code here:
        ManageNetworkJPanel manageNetworkJPanel=new ManageNetworkJPanel(userProcessContainer, ecosystem);
        userProcessContainer.add("manageNetworkJPanel",manageNetworkJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnMngNetworkActionPerformed

    private void jbtnRepModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRepModuleActionPerformed
        // TODO add your handling code here:
        DefaultPieDataset PDataset = new DefaultPieDataset();  

        PDataset.setValue("Misconduct Issues" , new Integer(2));   
        PDataset.setValue( "Felony Issues" , new Integer(2));    
        PDataset.setValue( "Theft Issues" , new Integer(1));  
      
        JFreeChart chart = ChartFactory.createPieChart("Pie Chart",PDataset, true,true,true);
        PiePlot pie = (PiePlot) chart.getPlot();
        
        ChartFrame frame = new ChartFrame("Pie Chart",chart);
        frame.setVisible(true);
        frame.setSize(450,500);
    }//GEN-LAST:event_jbtnRepModuleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageEnter;
    private javax.swing.JButton btnMngAdmin;
    private javax.swing.JButton btnMngNetwork;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JTree jTree;
    private javax.swing.JButton jbtnRepModule;
    private javax.swing.JLabel lblSelectedNode;
    // End of variables declaration//GEN-END:variables
}
