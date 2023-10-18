/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author srivaishnaviaekkati
 */
public class ResidentialHallEnterprise extends Enterprise {
    public ResidentialHallEnterprise(String name){
        super(name,Enterprise.EnterpriseType.ResidentialHall);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
     @Override
      public ArrayList<Type> getOrganizations() {
        ArrayList<Type> orgs = new ArrayList();
        orgs.add(Organization.Type.Supervisor);
        orgs.add(Organization.Type.Miscellaneous);
        orgs.add(Organization.Type.Tenant);
        
        return orgs;
      }
}

