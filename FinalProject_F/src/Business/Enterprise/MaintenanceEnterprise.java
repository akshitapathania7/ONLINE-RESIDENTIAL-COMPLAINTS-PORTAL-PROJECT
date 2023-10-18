/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author srivaishnaviaekkati
 */

public class MaintenanceEnterprise extends Enterprise {
    public MaintenanceEnterprise(String name){
        super(name,Enterprise.EnterpriseType.Maintenance);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
     @Override
      public ArrayList<Organization.Type> getOrganizations() {
        ArrayList<Organization.Type> orgs = new ArrayList();      
        orgs.add(Organization.Type.Miscellaneous);
        
        return orgs;
      }
}
