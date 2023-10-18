/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CanteenRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author srivaishnaviaekkati
 */
public class CanteenOrganization extends Organization{

    public CanteenOrganization() {
        super(Organization.Type.Canteen.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CanteenRole());
        return roles;
    }
     
}