/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import ooka.dto.ConferenceDto;
import ooka.dto.UserDto;
import ooka.ejb.ConferenceEJBLocal;
import ooka.ejb.UserEJB;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Admin
 */
@ManagedBean(name = "RegisterDialogController")
@SessionScoped
public class RegisterDialogController {
    
    @EJB
    UserEJB UserEJB;
    
    private UserDto User;
    
    public UserDto getUser() {
        return User;
    }
    
    public void createUser(){
        this.User = new UserDto();
        initDialog();
    } 
    
        public void initDialog() {
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", false);
        options.put("modal", true);
        RequestContext.getCurrentInstance().openDialog("register", options, null);
    }
        
        public void closeDialog() {
        RequestContext.getCurrentInstance().closeDialog(null);
    }
        
    public void saveDialog() {
        UserEJB.saveUser(this.User);
        RequestContext.getCurrentInstance().closeDialog(null);
    }
}
