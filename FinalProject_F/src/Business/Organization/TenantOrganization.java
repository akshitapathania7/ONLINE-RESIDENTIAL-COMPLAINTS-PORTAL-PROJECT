/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Role.Role;
import Business.Role.TenantRole;
import java.util.ArrayList;

/**
 *
 * @author srivaishnaviaekkati
 */
public class TenantOrganization extends Organization
 {
     public TenantOrganization() {
        super(Organization.Type.Tenant.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new TenantRole());
        return roles;
    }
}


