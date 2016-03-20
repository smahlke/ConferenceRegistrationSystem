/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import ooka.ejb.UserEJB;
import ooka.model.User;
import org.primefaces.context.RequestContext;

/**
 *
 * @author sebastianmahlke
 */
@ManagedBean
public class UserController {

    @EJB
    private UserEJB userEJB;

    public List<User> getAllUsers() {
        return userEJB.getUsers();
    }

    public void setAsOrganizer(String username) {
        this.userEJB.addUserroleOrganizer(username);
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "Rolle Organisator zugewiesen", "Dieser Nutzer darf nun Konferenzen erstellen."));
        this.refreshPage();
    }

    public boolean isOrganizer(String username) {
        return this.userEJB.hasRoleOrganizer(username);
    }

    public void refreshPage() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
            ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
        } catch (IOException ex) {
            Logger.getLogger(ConferenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
