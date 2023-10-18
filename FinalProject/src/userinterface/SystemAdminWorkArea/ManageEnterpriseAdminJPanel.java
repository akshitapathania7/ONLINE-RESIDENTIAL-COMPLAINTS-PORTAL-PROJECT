/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Role.PoliceAdminRole;
import Business.Role.HousingAdminRole;
import Business.Role.FacilitiesAdminRole;
import Business.Role.MaintenanceAdminRole;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import utility.Validate;
import utility.Mail;

/**
 *
 * @author srivaishnaviaekkati
 */
public class ManageEnterpriseAdminJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;
     

    /**
     * Creates new form ManageEnterpriseJPanel
     */
    public ManageEnterpriseAdminJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.system = system;
       

        populateTable();
        populateNetworkComboBox();
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tableEnterprise.getModel();

        model.setRowCount(0);
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (UserAccount userAccount : enterprise.getUserAccountDirectory().getUserAccountList()) {
                    Object[] row = new Object[3];
                    row[0] = enterprise.getName();
                    row[1] = network.getName();
                    row[2] = userAccount;

                    model.addRow(row);
                }
            }
        }
    }

    private void populateNetworkComboBox(){
             comboNetwork.removeAllItems();
        if(system.getNetworkList().size()!=0){                     //Checking whether system contains any network
           for (Network network : system.getNetworkList()) {
                comboNetwork.addItem(network);
            }
           
           
        }
        else{
             
             comboUsername.setEnabled(false);
             comboPassword.setEnabled(false);
             btnSubmit.setEnabled(false); 
             comboName.setEnabled(false);              
             comboNetwork.addItem("Please Add Networks");
        }
    }
    
    private void populateEnterpriseComboBox(Network network){
        comboEnterprise.removeAllItems();
        
        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
            comboEnterprise.addItem(enterprise);
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableEnterprise = new javax.swing.JTable();
        ntwLabel = new javax.swing.JLabel();
        comboNetwork = new javax.swing.JComboBox();
        usernameLabel = new javax.swing.JLabel();
        comboUsername = new javax.swing.JTextField();
        enterpriseLabel = new javax.swing.JLabel();
        comboEnterprise = new javax.swing.JComboBox();
        btnSubmit = new javax.swing.JButton();
        PwdLabel = new javax.swing.JLabel();
        comboName = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        comboPassword = new javax.swing.JPasswordField();
        btnBack = new javax.swing.JButton();
        mngEnterLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        comboEmail = new javax.swing.JTextField();

        setBackground(new java.awt.Color(76, 89, 115));
        setMaximumSize(new java.awt.Dimension(750, 750));
        setMinimumSize(new java.awt.Dimension(750, 750));
        setLayout(null);

        tableEnterprise.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tableEnterprise.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Enterprise Name", "Network", "Username"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableEnterprise);

        add(jScrollPane1);
        jScrollPane1.setBounds(50, 140, 620, 95);

        ntwLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ntwLabel.setText("Network");
        add(ntwLabel);
        ntwLabel.setBounds(90, 270, 52, 17);

        comboNetwork.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        comboNetwork.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNetworkActionPerformed(evt);
            }
        });
        add(comboNetwork);
        comboNetwork.setBounds(180, 270, 160, 21);

        usernameLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        usernameLabel.setText("Username");
        add(usernameLabel);
        usernameLabel.setBounds(410, 270, 60, 30);

        comboUsername.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        add(comboUsername);
        comboUsername.setBounds(490, 270, 136, 21);

        enterpriseLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        enterpriseLabel.setText("Enterprise");
        add(enterpriseLabel);
        enterpriseLabel.setBounds(90, 300, 63, 40);

        comboEnterprise.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        comboEnterprise.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEnterpriseActionPerformed(evt);
            }
        });
        add(comboEnterprise);
        comboEnterprise.setBounds(180, 310, 160, 21);

        btnSubmit.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit);
        btnSubmit.setBounds(462, 480, 100, 22);

        PwdLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        PwdLabel.setText("Password");
        add(PwdLabel);
        PwdLabel.setBounds(410, 310, 57, 30);

        comboName.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        add(comboName);
        comboName.setBounds(180, 350, 160, 21);

        nameLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        nameLabel.setText("Name");
        add(nameLabel);
        nameLabel.setBounds(90, 350, 60, 30);

        comboPassword.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        add(comboPassword);
        comboPassword.setBounds(490, 310, 134, 21);

        btnBack.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(133, 480, 100, 22);

        mngEnterLabel.setFont(new java.awt.Font("Optima", 1, 24)); // NOI18N
        mngEnterLabel.setForeground(new java.awt.Color(255, 255, 255));
        mngEnterLabel.setText("Manage Enterprise Admin");
        add(mngEnterLabel);
        mngEnterLabel.setBounds(220, 60, 269, 30);

        emailLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        emailLabel.setText("Email ID");
        add(emailLabel);
        emailLabel.setBounds(410, 350, 55, 30);

        comboEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEmailActionPerformed(evt);
            }
        });
        add(comboEmail);
        comboEmail.setBounds(490, 350, 136, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void comboNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNetworkActionPerformed

        Network network = (Network) comboNetwork.getSelectedItem();
        if (network != null){
            populateEnterpriseComboBox(network);
        }
        
        
    }//GEN-LAST:event_comboNetworkActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
         if(!comboName.getText().equals("") && !comboUsername.getText().isEmpty() && !comboPassword.getText().isEmpty()){
          
        Enterprise enterprise = (Enterprise) comboEnterprise.getSelectedItem();
        
        String username = comboUsername.getText();
        String password = String.valueOf(comboPassword.getPassword());
        String name = comboName.getText();
        String email = comboEmail.getText();
        Employee employee = enterprise.getEmployeeDirectory().createEmployee(name);
       
        if(Validate.validatePassword(password))
        {
        UserAccount account = null;
          if (enterprise.getEnterpriseType() == Enterprise.EnterpriseType.ResidentialHall) {
                account = enterprise.getUserAccountDirectory().createUserAccount(username, password,email ,employee, new HousingAdminRole());
            } 
           else if (enterprise.getEnterpriseType() == Enterprise.EnterpriseType.Police) {
                account = enterprise.getUserAccountDirectory().createUserAccount(username, password,email ,employee, new PoliceAdminRole());
            }
           else if (enterprise.getEnterpriseType() == Enterprise.EnterpriseType.Maintenance) {
                account = enterprise.getUserAccountDirectory().createUserAccount(username, password,email ,employee, new MaintenanceAdminRole());
            }
           else if (enterprise.getEnterpriseType() == Enterprise.EnterpriseType.Facility) {
                account = enterprise.getUserAccountDirectory().createUserAccount(username, password,email ,employee, new FacilitiesAdminRole());
            }
          
          if(!Validate.validateEmail(email))
                            {
                                 JOptionPane.showMessageDialog(null,"Enter valid email id ");
                                 comboEmail.setText("");
                                return;
                            
                            }
          JOptionPane.showMessageDialog(null, "UserAccount created successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
            comboUsername.setText("");
            comboPassword.setText("");
            comboName.setText("");
            comboEmail.setText("");
            populateTable();
            
         }
        else
        {
        
           JOptionPane.showMessageDialog(null,"Please enter valid password");
        
        }
         }
         else{
             JOptionPane.showMessageDialog(null, "Enter all the value", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
         Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void comboEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboEmailActionPerformed

    private void comboEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEnterpriseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboEnterpriseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PwdLabel;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JTextField comboEmail;
    private javax.swing.JComboBox comboEnterprise;
    private javax.swing.JTextField comboName;
    private javax.swing.JComboBox comboNetwork;
    private javax.swing.JPasswordField comboPassword;
    private javax.swing.JTextField comboUsername;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mngEnterLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel ntwLabel;
    private javax.swing.JTable tableEnterprise;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}