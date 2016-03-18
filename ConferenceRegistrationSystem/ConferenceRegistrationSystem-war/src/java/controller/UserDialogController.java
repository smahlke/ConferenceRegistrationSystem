/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
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
    UserEJB userEJB;

    SessionContext ctx;

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

    public void saveDialog() {
        userEJB.saveUser(this.user);
        this.loginDialog();
    }

    public void loginDialog() {
        this.user = new UserDto();
        this.redirect("login.xhtml");
    }

    public void login() {
        if (this.userEJB.checkLoginData(this.user.getUsername(), this.user.getPassword())) {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                    .getExternalContext().getSession(false);
            session.setAttribute("username", this.user.getUsername());
            this.redirect("conference.table.xhtml");
        } else {
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "Inkorrekt Username / Password", "Inkorrekt Username or Password"));
        }
    }

    public void logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                    .getExternalContext().getSession(false);
            session.setAttribute("username", null);
        this.redirect("index.xhtml");
    }
    
    private void redirect(String url) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(UserDialogController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
