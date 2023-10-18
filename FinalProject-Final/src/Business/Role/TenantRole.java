/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.CanteenOrganization;
import Business.Organization.Organization;
import Business.Organization.TenantOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.ResidentialHall.Tenant.TenantWorkAreaJPanel;

/**
 *
 * @author srivaishnaviaekkati
 */
public class TenantRole extends Role{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,Network network) {
        return new TenantWorkAreaJPanel(userProcessContainer, account, (TenantOrganization)organization, enterprise,business,network);
    }
    
      @Override
    public String toString(){
        return RoleType.Tenant.getValue();
    }
}
