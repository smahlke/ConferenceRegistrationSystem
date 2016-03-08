/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;

/**
 *
 * @author sebastianmahlke
 */
@ManagedBean(name = "viewController")
public class ViewController {
    
    
        /**
     * Views
     */
    public void viewConferenceCreation() {
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", false);

        RequestContext.getCurrentInstance().openDialog("conference-modal", options, null);
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "What we do in life", "Echoes in eternity.");
//         
//        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
}
