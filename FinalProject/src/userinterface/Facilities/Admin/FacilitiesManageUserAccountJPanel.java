/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Facilities.Admin;

//import userinterface.ResidentialHall.AdminRole.*;
import userinterface.Facilities.Admin.*;
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
public class FacilitiesManageUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ResidentialHallManageUserAccountJPanel
     */
    private JPanel container;
    private Enterprise enterprise;
Network net;
    public FacilitiesManageUserAccountJPanel(JPanel container, Enterprise enterprise,Network net) {
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
            
            organizationcombo.removeAllItems();
            if (enterprise.getOrganizationDirectory() == null) {
                enterprise.setOrganizationDirectory(new OrganizationDirectory());
            }
            if (enterprise.getOrganizationDirectory().getOrganizationList().size() > 0) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    organizationcombo.addItem(organization);
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
            
            employeecombo.removeAllItems();
            if (organization.getEmployeeDirectory() == null) {
                organization.setEmployeeDirectory(new EmployeeDirectory());
            }
            if (organization.getEmployeeDirectory().getEmployeeList().size() > 0) {
              
                for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()) {
                    employeecombo.addItem(employee);
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
            
            rolecombo.removeAllItems();
            if (organization.getSupportedRole() != null) {
                
                for (Role role : organization.getSupportedRole()) {
                    rolecombo.addItem(role);
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
            
            DefaultTableModel model = (DefaultTableModel) usertbl.getModel();

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
                        ((DefaultTableModel) usertbl.getModel()).addRow(row);
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

        createbtn = new javax.swing.JButton();
        nametxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usertbl = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        passwordtxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        employeecombo = new javax.swing.JComboBox();
        backbtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        organizationcombo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        rolecombo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        emailtxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(76, 89, 115));
        setMaximumSize(new java.awt.Dimension(750, 750));
        setMinimumSize(new java.awt.Dimension(750, 750));
        setLayout(null);

        createbtn.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        createbtn.setText("Create");
        createbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        createbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createbtnActionPerformed(evt);
            }
        });
        add(createbtn);
        createbtn.setBounds(530, 540, 130, 22);

        nametxt.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        add(nametxt);
        nametxt.setBounds(520, 360, 150, 24);

        jLabel1.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Name");
        add(jLabel1);
        jLabel1.setBounds(370, 360, 69, 18);

        usertbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        usertbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(usertbl);
        if (usertbl.getColumnModel().getColumnCount() > 0) {
            usertbl.getColumnModel().getColumn(0).setResizable(false);
            usertbl.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(40, 150, 657, 179);

        jLabel2.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        add(jLabel2);
        jLabel2.setBounds(370, 400, 57, 18);

        passwordtxt.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        passwordtxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordtxtFocusLost(evt);
            }
        });
        add(passwordtxt);
        passwordtxt.setBounds(520, 400, 150, 24);

        jLabel3.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Employee");
        add(jLabel3);
        jLabel3.setBounds(50, 410, 60, 18);

        employeecombo.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        employeecombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(employeecombo);
        employeecombo.setBounds(130, 410, 146, 24);

        backbtn.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        backbtn.setText("<< Back");
        backbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });
        add(backbtn);
        backbtn.setBounds(120, 530, 132, 22);

        jLabel5.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Organization");
        add(jLabel5);
        jLabel5.setBounds(50, 360, 81, 18);

        organizationcombo.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        organizationcombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationcomboActionPerformed(evt);
            }
        });
        add(organizationcombo);
        organizationcombo.setBounds(130, 360, 146, 24);

        jLabel4.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Role");
        add(jLabel4);
        jLabel4.setBounds(50, 450, 28, 18);

        rolecombo.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        rolecombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(rolecombo);
        rolecombo.setBounds(130, 450, 146, 24);
        add(jLabel6);
        jLabel6.setBounds(677, 214, 0, 0);

        jLabel7.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email ID");
        add(jLabel7);
        jLabel7.setBounds(370, 440, 53, 18);

        emailtxt.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        emailtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailtxtActionPerformed(evt);
            }
        });
        add(emailtxt);
        emailtxt.setBounds(520, 440, 146, 24);

        jLabel8.setFont(new java.awt.Font("Optima", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Facilities Manage UserAccounts");
        add(jLabel8);
        jLabel8.setBounds(186, 60, 334, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void createbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createbtnActionPerformed
         
            String email = emailtxt.getText();
            String userName = nametxt.getText();
            String password = passwordtxt.getText();
            if (employeecombo.getSelectedItem() != null) {
                if (!((userName.equals("")))) {
                    if (!(password.equals(""))) {
                        if(!email.equals("")){
                         if (EcoSystem.checkIfUsernameIsUnique(userName,net)) {
                            
                            Organization organization = (Organization) organizationcombo.getSelectedItem();
                            Employee employee = (Employee) employeecombo.getSelectedItem();
                            Role role = (Role) rolecombo.getSelectedItem();
                            if (!Validate.validatePassword(password)) {
                                JOptionPane.showMessageDialog(null, "Password should Contain \n"
                                        + "       - At least one digit\n"
                                        + "       - At least one lower case letter\n"
                                        + "       - At least one upper case letter\n"
                                        + "       - At least one special character(!@#$%^&+=~|?)\n"
                                        + "       - no whitespace allowed in the entire string\n"
                                        + "       - at least eight characters");
                                passwordtxt.setText("");
                                return;
                            }
                            if(!Validate.validateEmail(email))
                            {
                                 JOptionPane.showMessageDialog(null,"Enter valid email id ");
                                 emailtxt.setText("");
                                return;
                            
                            }
                           

                            organization.getUserAccountDirectory().createUserAccount(userName, password,email ,employee, role);
                            JOptionPane.showMessageDialog(null, "Account created succesfull");
                            nametxt.setText("");
                            passwordtxt.setText("");
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
        
    }//GEN-LAST:event_createbtnActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backbtnActionPerformed

    private void organizationcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationcomboActionPerformed
        Organization organization = (Organization) organizationcombo.getSelectedItem();
        if (organization != null){
            populateEmployeeComboBox(organization);
            populateRoleComboBox(organization);
        }
    }//GEN-LAST:event_organizationcomboActionPerformed

    private void passwordtxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordtxtFocusLost
        // TODO add your handling code here:
       
        
        
    }//GEN-LAST:event_passwordtxtFocusLost

    private void emailtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailtxtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JButton createbtn;
    private javax.swing.JTextField emailtxt;
    private javax.swing.JComboBox employeecombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nametxt;
    private javax.swing.JComboBox organizationcombo;
    private javax.swing.JTextField passwordtxt;
    private javax.swing.JComboBox rolecombo;
    private javax.swing.JTable usertbl;
    // End of variables declaration//GEN-END:variables
}
