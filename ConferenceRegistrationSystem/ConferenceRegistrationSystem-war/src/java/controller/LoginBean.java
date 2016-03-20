/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import ooka.ejb.UserEJB;
import ooka.model.User;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    @EJB
    UserEJB userEJB;

    private User principal = null;

    private String username;
    private String password;

    public void login() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
        try {
            //Login per Servlet 3.0
            request.login(username, password);
            // Der Principal entspricht dem Usernamen
            Principal p = request.getUserPrincipal();

            principal = userEJB.getUserByUsername(p.getName());
            
           fc.getApplication().getNavigationHandler().handleNavigation(fc, null, "/private/conference.table.xhtml");    

        } catch (ServletException e) {
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "An Error Occured: Login failed", null));
            e.printStackTrace();
        }
//        try {
//            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
//        } catch (IOException ex) {
//            Logger.getLogger(UserDialogController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void logout() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        fc.getApplication().getNavigationHandler().handleNavigation(fc, null, "/login.xhtml");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getPrincipal() {
        return principal;
    }

    public void setPrincipal(User principal) {
        this.principal = principal;
    }
}