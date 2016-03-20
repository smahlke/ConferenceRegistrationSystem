/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import ooka.dto.UserDto;
import ooka.ejb.UserEJB;
import ooka.model.Group;
import ooka.model.User;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    @EJB
    UserEJB userEJB;

    @PostConstruct
    public void persistOrganizer() {
        User admin = userEJB.getUserByUsername("admin");
        if (admin == null) {
            UserDto organizer = new UserDto();
            organizer.setFirstname("admin");
            organizer.setLastname("admin");
            organizer.setUsername("admin");
            organizer.setPassword("admin");
            organizer.addUserrole(Group.ORGANIZER);
            userEJB.saveUser(organizer);
        }
    }
    
    private User principal = null;

    private String username;
    private String password;

    public void login() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
        try {
            request.logout();
            request.login(username, password);
            Principal p = request.getUserPrincipal();

            principal = userEJB.getUserByUsername(p.getName());
            
           fc.getApplication().getNavigationHandler().handleNavigation(fc, null, "/private/conference.table.xhtml");    

        } catch (ServletException e) {
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "An Error Occured: Login failed", null));
            e.printStackTrace();
        }
    }

    public void logout() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
                HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
        try {
            request.logout();
        } catch (ServletException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        fc.getApplication().getNavigationHandler().handleNavigation(fc, null, "/index.xhtml");
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
