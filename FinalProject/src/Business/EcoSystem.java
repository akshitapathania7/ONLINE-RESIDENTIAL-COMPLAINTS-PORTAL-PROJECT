/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.PoliceAdminRole;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.Role.HousingAdminRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author srivaishnaviaekkati
 */
public class EcoSystem extends Organization{
    
    private static EcoSystem business;

    

   
    private ArrayList<Network> networkList;
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }
    
    public Network createAndAddNetwork(){
        Network network=new Network();
        networkList.add(network);
        return network;
    }
   // @Override
    //public ArrayList<Role> getSupportedRole() {
      //  ArrayList<Role> roleList=new ArrayList<Role>();
       // roleList.add(new SystemAdminRole());
        //return roleList;
    //}
     @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new PoliceAdminRole());
        roleList.add(new HousingAdminRole());
        
        return roleList;
    }
    private EcoSystem(){
        super(null);
        networkList=new ArrayList<Network>();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    
    public static boolean checkIfUsernameIsUnique(String username,Network net) {

        //  if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
       
            
       
           
                for (Enterprise enterprise : net.getEnterpriseDirectory().getEnterpriseList()) {
                    for (UserAccount ua : enterprise.getUserAccountDirectory().getUserAccountList()) {
                        if (ua.getUsername().equalsIgnoreCase(username)) {
                            return false;
                        }
                    }
                   

                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                            if (ua.getUsername().equalsIgnoreCase(username)) {
                                return false;
                            }
                        }
                    }
                }
            
            
            

        return true;
    }
    
   
}
