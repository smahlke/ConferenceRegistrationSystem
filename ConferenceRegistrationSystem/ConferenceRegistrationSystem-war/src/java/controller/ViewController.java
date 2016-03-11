/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author sebastianmahlke
 */
@ManagedBean(name = "viewController")
@SessionScoped
public class ViewController {
    
    
    /**
     * Views
     */
    public void viewConferenceCreation() {
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", false);
        options.put("modal", true);

        RequestContext.getCurrentInstance().openDialog("conference/workflow/conference", options, null);
    }
    
    public void closeDialog() {
        RequestContext.getCurrentInstance().closeDialog(null);
    }
    
    public void saveDialog() {
        RequestContext.getCurrentInstance().closeDialog(null);
    }
    
    public void onConferenceSave(SelectEvent event) {
        
        Object obj = event.getObject();
        System.out.println(obj);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Car Selected", obj.toString());
         
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
