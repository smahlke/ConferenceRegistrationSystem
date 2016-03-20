/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import ooka.dto.UserDto;
import ooka.ejb.UserEJB;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Admin
 */
@ManagedBean(name = "userDialogController")
@SessionScoped
public class UserDialogController {

    @EJB
    private UserEJB userEJB;

    private UserDto user;

    public UserDto getUser() {
        return user;
    }

    public void registerDialog() {
        this.user = new UserDto();
        this.redirect("register.xhtml");
    }

    public void closeDialog() {
        RequestContext.getCurrentInstance().closeDialog(null);
    }
    
    public void loginDialog() {
        this.redirect("login.xhtml");
    }

    public void saveDialog() {
        userEJB.saveUser(this.user);
        this.redirect("login.xhtml");
    }
    
    private void redirect(String url) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(UserDialogController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
