/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.TheftRole;
import java.util.ArrayList;

/**
 *
 * @author srivaishnaviaekkati
 */
public class TheftOrganization extends Organization {

    public TheftOrganization()  {
        super(Organization.Type.Theft.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new TheftRole());
        return roles;
    }
}
