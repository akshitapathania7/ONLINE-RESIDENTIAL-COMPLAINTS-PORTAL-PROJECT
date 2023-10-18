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
            
            organizatiocbox.removeAllItems();
            if (enterprise.getOrganizationDirectory() == null) {
                enterprise.setOrganizationDirectory(new OrganizationDirectory());
            }
            if (enterprise.getOrganizationDirectory().getOrganizationList().size() > 0) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    organizatiocbox.addItem(organization);
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
            
            employeecbox.removeAllItems();
            if (organization.getEmployeeDirectory() == null) {
                organization.setEmployeeDirectory(new EmployeeDirectory());
            }
            if (organization.getEmployeeDirectory().getEmployeeList().size() > 0) {
              
                for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()) {
                    employeecbox.addItem(employee);
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
            
            rolecbox.removeAllItems();
            if (organization.getSupportedRole() != null) {
                
                for (Role role : organization.getSupportedRole()) {
                    rolecbox.addItem(role);
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
            
            DefaultTableModel model = (DefaultTableModel) usertble.getModel();

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
                        ((DefaultTableModel) usertble.getModel()).addRow(row);
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

        createUserbtn = new javax.swing.JButton();
        nameJTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usertble = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        passwordJTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        employeecbox = new javax.swing.JComboBox();
        backbtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        organizatiocbox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        rolecbox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        emailtxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(76, 89, 115));
        setMaximumSize(new java.awt.Dimension(750, 750));
        setMinimumSize(new java.awt.Dimension(750, 750));
        setLayout(null);

        createUserbtn.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        createUserbtn.setText("Create");
        createUserbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        createUserbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserbtnActionPerformed(evt);
            }
        });
        add(createUserbtn);
        createUserbtn.setBounds(450, 510, 120, 22);

        nameJTxt.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        nameJTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameJTxtActionPerformed(evt);
            }
        });
        add(nameJTxt);
        nameJTxt.setBounds(520, 360, 146, 24);

        jLabel1.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Name");
        add(jLabel1);
        jLabel1.setBounds(410, 360, 80, 18);

        usertble.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        usertble.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(usertble);
        if (usertble.getColumnModel().getColumnCount() > 0) {
            usertble.getColumnModel().getColumn(0).setResizable(false);
            usertble.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(50, 110, 640, 150);

        jLabel2.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        add(jLabel2);
        jLabel2.setBounds(410, 430, 70, 18);

        passwordJTxt.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        passwordJTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordJTxtFocusLost(evt);
            }
        });
        add(passwordJTxt);
        passwordJTxt.setBounds(520, 430, 146, 24);

        jLabel3.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Employee");
        add(jLabel3);
        jLabel3.setBounds(60, 360, 70, 18);

        employeecbox.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        employeecbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(employeecbox);
        employeecbox.setBounds(180, 370, 146, 24);

        backbtn.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        backbtn.setText("<< Back");
        backbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });
        add(backbtn);
        backbtn.setBounds(160, 510, 80, 22);

        jLabel5.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Organization");
        add(jLabel5);
        jLabel5.setBounds(60, 310, 90, 18);

        organizatiocbox.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        organizatiocbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizatiocbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizatiocboxActionPerformed(evt);
            }
        });
        add(organizatiocbox);
        organizatiocbox.setBounds(180, 310, 146, 24);

        jLabel4.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Role");
        add(jLabel4);
        jLabel4.setBounds(60, 420, 40, 18);

        rolecbox.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        rolecbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(rolecbox);
        rolecbox.setBounds(180, 420, 146, 24);
        add(jLabel6);
        jLabel6.setBounds(478, 265, 0, 0);

        jLabel7.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email ID");
        add(jLabel7);
        jLabel7.setBounds(410, 300, 70, 18);

        emailtxt.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        emailtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailtxtActionPerformed(evt);
            }
        });
        add(emailtxt);
        emailtxt.setBounds(520, 300, 146, 24);

        jLabel8.setFont(new java.awt.Font("Optima", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Residential Hall Manage User Account");
        add(jLabel8);
        jLabel8.setBounds(170, 40, 420, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void createUserbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserbtnActionPerformed
         
            String email = emailtxt.getText();
            String userName = nameJTxt.getText();
            String password = passwordJTxt.getText();
            if (employeecbox.getSelectedItem() != null) {
                if (!((userName.equals("")))) {
                    if (!(password.equals(""))) {
                        if(!email.equals("")){
                         if (EcoSystem.checkIfUsernameIsUnique(userName,net)) {
                            
                            Organization organization = (Organization) organizatiocbox.getSelectedItem();
                            Employee employee = (Employee) employeecbox.getSelectedItem();
                            Role role = (Role) rolecbox.getSelectedItem();
                            if (!Validate.validatePassword(password)) {
                                JOptionPane.showMessageDialog(null, "Password should Contain \n"
                                        + "       - At least one digit\n"
                                        + "       - At least one lower case letter\n"
                                        + "       - At least one upper case letter\n"
                                        + "       - At least one special character(!@#$%^&+=~|?)\n"
                                        + "       - no whitespace allowed in the entire string\n"
                                        + "       - at least eight characters");
                                passwordJTxt.setText("");
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
                            nameJTxt.setText("");
                            passwordJTxt.setText("");
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
        
    }//GEN-LAST:event_createUserbtnActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backbtnActionPerformed

    private void organizatiocboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizatiocboxActionPerformed
        Organization organization = (Organization) organizatiocbox.getSelectedItem();
        if (organization != null){
            populateEmployeeComboBox(organization);
            populateRoleComboBox(organization);
        }
    }//GEN-LAST:event_organizatiocboxActionPerformed

    private void passwordJTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordJTxtFocusLost
        // TODO add your handling code here:
       
        
        
    }//GEN-LAST:event_passwordJTxtFocusLost

    private void emailtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailtxtActionPerformed

    private void nameJTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameJTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameJTxtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JButton createUserbtn;
    private javax.swing.JTextField emailtxt;
    private javax.swing.JComboBox employeecbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTxt;
    private javax.swing.JComboBox organizatiocbox;
    private javax.swing.JTextField passwordJTxt;
    private javax.swing.JComboBox rolecbox;
    private javax.swing.JTable usertble;
    // End of variables declaration//GEN-END:variables
}
