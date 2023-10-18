/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.FelonyRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author srivaishnaviaekkati
 */
public class FelonyOrganization extends Organization {

    public FelonyOrganization() {
        super(Organization.Type.Felony.getValue());
        
        
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
      ArrayList<Role> roles = new ArrayList();
        roles.add(new FelonyRole());
        return roles;
    }

   
    
    
    
    
    
    
    
}
