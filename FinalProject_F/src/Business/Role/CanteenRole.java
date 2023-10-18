/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.CanteenOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.ResidentialHall.Tenant.TenantWorkAreaJPanel;
import javax.swing.JPanel;
import userinterface.Facilities.Canteen.CanteenWorkAreaJPanel;

/**  
 *
 * @author srivaishnaviaekkati
 */
public class CanteenRole extends Role{

    @Override  //
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,Network network) {
   return new CanteenWorkAreaJPanel(userProcessContainer, account,(CanteenOrganization) organization, enterprise,business,network);
    }
      @Override 
    public String toString(){
        return Role.RoleType.Canteen.getValue();
    }
    
}
