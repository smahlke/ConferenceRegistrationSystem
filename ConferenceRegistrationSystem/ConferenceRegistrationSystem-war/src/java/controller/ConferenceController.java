package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import ooka.dto.ConferenceDto;
import ooka.ejb.ConferenceEJBLocal;
import org.primefaces.context.RequestContext;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sebastianmahlke
 */
@ManagedBean
@SessionScoped
public class ConferenceController implements Serializable {

    @EJB
    ConferenceEJBLocal conferenceEJB;

    public List<ConferenceDto> getConferences() {
        return conferenceEJB.getConferences();
    }

    public void deleteConference(Long idSet) {
        conferenceEJB.deleteConferenceById(idSet);
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "Konferenz gelöscht", "Die Konferenz mit der ID " + idSet + " wurde gelöscht."));
        this.refreshPage();
    }

    public void subscribeToConference(String username, Long id) {
        conferenceEJB.subscribe(username, id);
        this.refreshPage();
    }

    public void unsubscribeToConference(String username, Long id) {
        conferenceEJB.unsubscribe(username, id);
        this.refreshPage();
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
