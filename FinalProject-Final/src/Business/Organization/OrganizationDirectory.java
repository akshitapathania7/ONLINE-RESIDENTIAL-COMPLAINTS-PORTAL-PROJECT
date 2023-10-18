/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author srivaishnaviaekkati
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Canteen.getValue())){
            organization = new CanteenOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Supervisor.getValue())){
            organization = new SupervisorOrganization();
            organizationList.add(organization);
        }
        
         else if (type.getValue().equals(Type.Tenant.getValue())){
           organization = new TenantOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Felony.getValue())){
           organization = new FelonyOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Miscellaneous.getValue())){
           organization = new MiscellaneousOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Misconduct.getValue())){
           organization = new MisconductOrganization();
            organizationList.add(organization);
        }
        
        else if (type.getValue().equals(Type.Theft.getValue())){
           organization = new TheftOrganization();
            organizationList.add(organization);
        }
        
        return organization;
    }
}