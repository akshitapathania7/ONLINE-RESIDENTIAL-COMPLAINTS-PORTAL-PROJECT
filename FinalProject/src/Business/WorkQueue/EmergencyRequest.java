 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Organization.Organization;

/**
 *
 * @author srivaishnaviaekkati
 */
public class EmergencyRequest extends StatusRequest{
    private String location;
    private Organization.Type emergencytype;
    private String email;

    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Organization.Type getEmergencytype() {
        return emergencytype;
    }

    public void setEmergencytype(Organization.Type emergencytype) {
        this.emergencytype = emergencytype;
    }

    
    
    @Override
    public String toString() {
        return this.location;
    }
    
}
