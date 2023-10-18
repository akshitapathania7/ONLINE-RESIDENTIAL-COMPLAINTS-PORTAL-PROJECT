/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ResidentialHall.AdminRole;

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
public class ResidentialHallManageUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ResidentialHallManageUserAccountJPanel
     */
    private JPanel container;
    private Enterprise enterprise;
Network net;
    public ResidentialHallManageUserAccountJPanel(JPanel container, Enterprise enterprise,Network net) {
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
            
            organizationJCB.removeAllItems();
            if (enterprise.getOrganizationDirectory() == null) {
                enterprise.setOrganizationDirectory(new OrganizationDirectory());
            }
            if (enterprise.getOrganizationDirectory().getOrganizationList().size() > 0) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    organizationJCB.addItem(organization);
                }
            } else {
                JOptionPane.showMessageDialog(null,"NO Organization is Available");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Sorry for convenience! Please try again later");
        }
    }
    
    public void populateEmployeeComboBox(Organization organization){
         try {
            
            employeeJCB.removeAllItems();
            if (organization.getEmployeeDirectory() == null) {
                organization.setEmployeeDirectory(new EmployeeDirectory());
            }
            if (organization.getEmployeeDirectory().getEmployeeList().size() > 0) {
              
                for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()) {
                    employeeJCB.addItem(employee);
                }

            } else {
                JOptionPane.showMessageDialog(null,"NO Employee is present for this Organization");
            }
        } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,"Sorry for convenience! Please try again later");

        }
    }
    
    private void populateRoleComboBox(Organization organization){
       try {
            
            roleJCB.removeAllItems();
            if (organization.getSupportedRole() != null) {
                
                for (Role role : organization.getSupportedRole()) {
                    roleJCB.addItem(role);
                }
            } else {
                  JOptionPane.showMessageDialog(null,"No Organization Available");
            }
        } catch (Exception ex) {
                         JOptionPane.showMessageDialog(null,"Sorry for convenience! Please try again later");

        }
    }

    public void popData() {

         try {
            
            DefaultTableModel model = (DefaultTableModel) userJT.getModel();

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
                        ((DefaultTableModel) userJT.getModel()).addRow(row);
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

        createUserJBtn = new javax.swing.JButton();
        nameJTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userJT = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        passwordJTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        employeeJCB = new javax.swing.JComboBox();
        backjBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        organizationJCB = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        roleJCB = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        emailTF = new javax.swing.JTextField();
        jLResHallMngUserAc = new javax.swing.JLabel();

        setBackground(new java.awt.Color(76, 89, 115));
        setMaximumSize(new java.awt.Dimension(750, 750));
        setMinimumSize(new java.awt.Dimension(750, 750));
        setLayout(null);

        createUserJBtn.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        createUserJBtn.setText("Create");
        createUserJBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        createUserJBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJBtnActionPerformed(evt);
            }
        });
        add(createUserJBtn);
        createUserJBtn.setBounds(450, 510, 43, 22);

        nameJTF.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        nameJTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameJTFActionPerformed(evt);
            }
        });
        add(nameJTF);
        nameJTF.setBounds(520, 360, 146, 24);

        jLabel1.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Name");
        add(jLabel1);
        jLabel1.setBounds(410, 360, 80, 18);

        userJT.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        userJT.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(userJT);
        if (userJT.getColumnModel().getColumnCount() > 0) {
            userJT.getColumnModel().getColumn(0).setResizable(false);
            userJT.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(50, 110, 640, 150);

        jLabel2.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        add(jLabel2);
        jLabel2.setBounds(410, 430, 70, 18);

        passwordJTF.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        passwordJTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordJTFFocusLost(evt);
            }
        });
        add(passwordJTF);
        passwordJTF.setBounds(520, 430, 146, 24);

        jLabel3.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Employee");
        add(jLabel3);
        jLabel3.setBounds(60, 360, 70, 18);

        employeeJCB.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        employeeJCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(employeeJCB);
        employeeJCB.setBounds(180, 370, 146, 24);

        backjBtn.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        backjBtn.setText("<< Back");
        backjBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backjBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjBtnActionPerformed(evt);
            }
        });
        add(backjBtn);
        backjBtn.setBounds(160, 510, 54, 22);

        jLabel5.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Organization");
        add(jLabel5);
        jLabel5.setBounds(60, 310, 90, 18);

        organizationJCB.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        organizationJCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJCBActionPerformed(evt);
            }
        });
        add(organizationJCB);
        organizationJCB.setBounds(180, 310, 146, 24);

        jLabel4.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Role");
        add(jLabel4);
        jLabel4.setBounds(60, 420, 40, 18);

        roleJCB.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        roleJCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(roleJCB);
        roleJCB.setBounds(180, 420, 146, 24);
        add(jLabel6);
        jLabel6.setBounds(478, 265, 0, 0);

        jLabel7.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email ID");
        add(jLabel7);
        jLabel7.setBounds(410, 300, 70, 18);

        emailTF.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        emailTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTFActionPerformed(evt);
            }
        });
        add(emailTF);
        emailTF.setBounds(520, 300, 146, 24);

        jLResHallMngUserAc.setFont(new java.awt.Font("Optima", 1, 24)); // NOI18N
        jLResHallMngUserAc.setForeground(new java.awt.Color(255, 255, 255));
        jLResHallMngUserAc.setText("Residential Hall Manage User Account");
        add(jLResHallMngUserAc);
        jLResHallMngUserAc.setBounds(170, 40, 420, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void createUserJBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJBtnActionPerformed
         
            String email = emailTF.getText();
            String userName = nameJTF.getText();
            String password = passwordJTF.getText();
            if (employeeJCB.getSelectedItem() != null) {
                if (!((userName.equals("")))) {
                    if (!(password.equals(""))) {
                        if(!email.equals("")){
                         if (EcoSystem.checkIfUsernameIsUnique(userName,net)) {
                            
                            Organization organization = (Organization) organizationJCB.getSelectedItem();
                            Employee employee = (Employee) employeeJCB.getSelectedItem();
                            Role role = (Role) roleJCB.getSelectedItem();
                            if (!Validate.validatePassword(password)) {
                                JOptionPane.showMessageDialog(null, "Password should Contain \n"
                                        + "       - At least one digit\n"
                                        + "       - At least one lower case letter\n"
                                        + "       - At least one upper case letter\n"
                                        + "       - At least one special character(!@#$%^&+=~|?)\n"
                                        + "       - no whitespace allowed in the entire string\n"
                                        + "       - at least eight characters");
                                passwordJTF.setText("");
                                return;
                            }
                            if(!Validate.validateEmail(email))
                            {
                                 JOptionPane.showMessageDialog(null,"Enter valid email id ");
                                 emailTF.setText("");
                                return;
                            
                            }
                           

                            organization.getUserAccountDirectory().createUserAccount(userName, password,email ,employee, role);
                            JOptionPane.showMessageDialog(null, "Account created succesfull");
                            nameJTF.setText("");
                            passwordJTF.setText("");
                            popData();
                       } else {
                            JOptionPane.showMessageDialog(null, "Please enter unique username", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                        else{
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
        
    }//GEN-LAST:event_createUserJBtnActionPerformed

    private void backjBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjBtnActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backjBtnActionPerformed

    private void organizationJCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJCBActionPerformed
        Organization organization = (Organization) organizationJCB.getSelectedItem();
        if (organization != null){
            populateEmployeeComboBox(organization);
            populateRoleComboBox(organization);
        }
    }//GEN-LAST:event_organizationJCBActionPerformed

    private void passwordJTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordJTFFocusLost
        // TODO add your handling code here:
       
        
        
    }//GEN-LAST:event_passwordJTFFocusLost

    private void emailTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTFActionPerformed

    private void nameJTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameJTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameJTFActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjBtn;
    private javax.swing.JButton createUserJBtn;
    private javax.swing.JTextField emailTF;
    private javax.swing.JComboBox employeeJCB;
    private javax.swing.JLabel jLResHallMngUserAc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTF;
    private javax.swing.JComboBox organizationJCB;
    private javax.swing.JTextField passwordJTF;
    private javax.swing.JComboBox roleJCB;
    private javax.swing.JTable userJT;
    // End of variables declaration//GEN-END:variables
}
