/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Police.Admin;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Employee.EmployeeDirectory;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import utility.Validate;

/**
 *
 * @author srivaishnaviaekkati
 */
public class PoliceManageUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PoliceManageUserAccountJPanel
     */
    private JPanel container;
    private Enterprise enterprise;
    Network net;

    public PoliceManageUserAccountJPanel(JPanel container, Enterprise enterprise,Network net) {
        initComponents();
        this.enterprise = enterprise;
        this.container = container;
        this.net=net;

        popOrganizationComboBox();
       // employeeJComboBox.removeAllItems();
        popData();
    }

    public void popOrganizationComboBox() {
        try {
            
            organizcbox.removeAllItems();
            if (enterprise.getOrganizationDirectory() == null) {
                enterprise.setOrganizationDirectory(new OrganizationDirectory());
            }
            if (enterprise.getOrganizationDirectory().getOrganizationList().size() > 0) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    organizcbox.addItem(organization);
                }
            } else {
                JOptionPane.showMessageDialog(null,"NO Organization is Available");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Sorry for convenience! Please try again later");
        }
    }
    
     public void populateEmployeeComboBox(Organization organization) {
        try {
            
            emplcbox.removeAllItems();
            if (organization.getEmployeeDirectory() == null) {
                organization.setEmployeeDirectory(new EmployeeDirectory());
            }
            if (organization.getEmployeeDirectory().getEmployeeList().size() > 0) {
               
                for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()) {
                    emplcbox.addItem(employee);
                }

            } else {
                JOptionPane.showMessageDialog(null,"NO Employee is present for this Organization");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Sorry for convenience! Please try again later");
        }
    }
    
     private void populateRoleComboBox(Organization e) {
        try {
            
            roleJComboBox.removeAllItems();
            if (e.getSupportedRole() != null) {
               
                for (Role role : e.getSupportedRole()) {
                    roleJComboBox.addItem(role);
                }
            } else {
                JOptionPane.showMessageDialog(null,"NO Roles are Available in this organization");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Sorry for convenience! Please try again later");
        }
    }
    

    public void popData() {

          try {
            
            DefaultTableModel model = (DefaultTableModel) tbl.getModel();

            model.setRowCount(0);
            if (enterprise.getOrganizationDirectory() == null) {
                enterprise.setOrganizationDirectory(new OrganizationDirectory());
            }
            if (enterprise.getOrganizationDirectory().getOrganizationList().size() > 0) {
                
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if(organization.getUserAccountDirectory()== null){
                        organization.setUserAccountDirectory(new UserAccountDirectory());
                    }
                    for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                        Object row[] = new Object[2];
                        row[0] = ua;
                        row[1] = ua.getRole();
                        ((DefaultTableModel) tbl.getModel()).addRow(row);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null,"NO Organization is Available");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Sorry for convenience! Please try again later");
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

        createUserJButton = new javax.swing.JButton();
        nameJTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        passwordJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        emplcbox = new javax.swing.JComboBox();
        backjButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        organizcbox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        roleJComboBox = new javax.swing.JComboBox();
        lblwarning = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        emailtxtfield = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(76, 89, 115));
        setForeground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(750, 750));
        setMinimumSize(new java.awt.Dimension(750, 750));
        setLayout(null);

        createUserJButton.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        createUserJButton.setText("Create");
        createUserJButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        createUserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButtonActionPerformed(evt);
            }
        });
        add(createUserJButton);
        createUserJButton.setBounds(493, 500, 110, 22);

        nameJTextField.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        add(nameJTextField);
        nameJTextField.setBounds(500, 290, 140, 24);

        jLabel1.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Name");
        add(jLabel1);
        jLabel1.setBounds(390, 300, 70, 18);

        tbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl);
        if (tbl.getColumnModel().getColumnCount() > 0) {
            tbl.getColumnModel().getColumn(0).setResizable(false);
            tbl.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(40, 80, 660, 138);

        jLabel2.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        add(jLabel2);
        jLabel2.setBounds(400, 340, 57, 18);

        passwordJTextField.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        passwordJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordJTextFieldFocusLost(evt);
            }
        });
        add(passwordJTextField);
        passwordJTextField.setBounds(500, 330, 140, 24);

        jLabel3.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Employee");
        add(jLabel3);
        jLabel3.setBounds(90, 340, 70, 18);

        emplcbox.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        emplcbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(emplcbox);
        emplcbox.setBounds(200, 340, 146, 24);

        backjButton1.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        backjButton1.setText("<< Back");
        backjButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });
        add(backjButton1);
        backjButton1.setBounds(70, 500, 112, 22);

        jLabel5.setFont(new java.awt.Font("Optima", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Police Manage User Accounts");
        add(jLabel5);
        jLabel5.setBounds(220, 30, 350, 17);

        organizcbox.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        organizcbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizcbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizcboxActionPerformed(evt);
            }
        });
        add(organizcbox);
        organizcbox.setBounds(200, 300, 146, 24);

        jLabel4.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Role");
        add(jLabel4);
        jLabel4.setBounds(120, 380, 40, 18);

        roleJComboBox.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        roleJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(roleJComboBox);
        roleJComboBox.setBounds(200, 380, 146, 24);
        add(lblwarning);
        lblwarning.setBounds(392, 237, 0, 0);

        jLabel6.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Email id");
        add(jLabel6);
        jLabel6.setBounds(400, 380, 60, 18);

        emailtxtfield.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        emailtxtfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailtxtfieldActionPerformed(evt);
            }
        });
        add(emailtxtfield);
        emailtxtfield.setBounds(500, 370, 146, 24);

        jLabel7.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Organization");
        add(jLabel7);
        jLabel7.setBounds(80, 300, 90, 18);
    }// </editor-fold>//GEN-END:initComponents

    private void createUserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButtonActionPerformed
       
            String email = emailtxtfield.getText();
            String userName = nameJTextField.getText();
            String password = String.valueOf(passwordJTextField.getText());
            if (emplcbox.getSelectedItem() != null) {
                if (!((userName.equals("")))) {
                    if (!(password.equals(""))) {
                        if(!email.equals("")){
                       if (EcoSystem.checkIfUsernameIsUnique(userName,net)) {
                            
                            Organization organization = (Organization) organizcbox.getSelectedItem();
                            Employee employee = (Employee) emplcbox.getSelectedItem();
                            Role role = (Role) roleJComboBox.getSelectedItem();
                            if (!Validate.validatePassword(password)) {
                                JOptionPane.showMessageDialog(null, "Password should Contain \n"
                                        + "       - At least one digit\n"
                                        + "       - At least one lower case letter\n"
                                        + "       - At least one upper case letter\n"
                                        + "       - At least one special character(!@#$%^&+=~|?)\n"
                                        + "       - no whitespace allowed in the entire string\n"
                                        + "       - at least eight characters");
                                passwordJTextField.setText("");
                                return;
                            }
                            if(!Validate.validateEmail(email))
                            {
                                 JOptionPane.showMessageDialog(null,"Enter valid email id ");
                                 emailtxtfield.setText("");
                                return;
                            
                            }
                            

                            organization.getUserAccountDirectory().createUserAccount(userName, password,email ,employee, role);
                            JOptionPane.showMessageDialog(null, "Account created succesfull");
                            nameJTextField.setText("");
                            passwordJTextField.setText("");
                            emailtxtfield.setText("");
                            popData();
                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter unique username", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    }else{
                            JOptionPane.showMessageDialog(null, "Enter value for email", "Warning", JOptionPane.WARNING_MESSAGE);
                        }}
                        else {
                        JOptionPane.showMessageDialog(null, "Enter value for password", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Enter value for username", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No Employee available", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        
    }//GEN-LAST:event_createUserJButtonActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backjButton1ActionPerformed

    private void organizcboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizcboxActionPerformed
        Organization organization = (Organization) organizcbox.getSelectedItem();
        if (organization != null){
            populateEmployeeComboBox(organization);
            populateRoleComboBox(organization);
        }
    }//GEN-LAST:event_organizcboxActionPerformed

    private void passwordJTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordJTextFieldFocusLost
        // TODO add your handling code here:
               
    }//GEN-LAST:event_passwordJTextFieldFocusLost

    private void emailtxtfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailtxtfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailtxtfieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton createUserJButton;
    private javax.swing.JTextField emailtxtfield;
    private javax.swing.JComboBox emplcbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblwarning;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox organizcbox;
    private javax.swing.JTextField passwordJTextField;
    private javax.swing.JComboBox roleJComboBox;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables
}
