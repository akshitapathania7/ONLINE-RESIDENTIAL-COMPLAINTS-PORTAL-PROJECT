/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author srivaishnaviaekkati
 */
public class StatusQueue {
    
    private ArrayList<StatusRequest> statusRequestList;

    public StatusQueue() {
        statusRequestList = new ArrayList();
    }

    public ArrayList<StatusRequest> getStatusRequestList() {
        return statusRequestList;
    }
}