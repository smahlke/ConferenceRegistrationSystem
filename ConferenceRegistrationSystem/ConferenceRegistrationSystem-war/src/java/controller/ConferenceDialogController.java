/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import ooka.dto.ConferenceDto;
import ooka.ejb.ConferenceEJBLocal;
import ooka.ejb.UserEJB;
import ooka.model.User;
import org.primefaces.context.RequestContext;

/**
 *
 * @author sebastianmahlke
 */
@ManagedBean(name = "conferenceDialogController")
@SessionScoped
public class ConferenceDialogController {

    @EJB
    ConferenceEJBLocal conferenceEJB;

    @EJB
    UserEJB userEJB;

    private ConferenceDto conference;

    private Integer rating;

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public ConferenceDto getConference() {
        return conference;
    }

    public void setConference(ConferenceDto conference) {
        this.conference = conference;
    }

    public void initDialog(String url) {
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", false);
        options.put("modal", true);
        RequestContext.getCurrentInstance().openDialog(url, options, null);
    }

    public void createConference() {
        this.conference = new ConferenceDto();
        this.initDialog("conference/workflow/conference");
    }

    public void editConference(Long idSet) {
        this.conference = conferenceEJB.getConferenceById(idSet);
        this.initDialog("conference/workflow/conference");
    }

    public void closeDialog() {
        RequestContext.getCurrentInstance().closeDialog(null);
    }

    public void saveDialog() {
        if (this.conferenceDtoHasValidationErrors(this.conference)) {
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "Pflichtanganben fehlen ", "Bitte befüllen Sie alle Felder."));
        } else {
            User u = userEJB.getUserByUsername(userEJB.getUsername());
            this.conference.setOrganizer(u);
            this.conference.addParticipant(u);
            conferenceEJB.saveConference(this.conference);
            RequestContext.getCurrentInstance().closeDialog(null);
        }
    }

    public void rateDialog(Long conferenceID) {
        // ggf. bisherige Bewertung holen
        this.conference = new ConferenceDto();
        this.conference.setEntityId(conferenceID);
        this.rating = 0;
        this.initDialog("rating");
    }

    public void rate(String username) {
        this.conferenceEJB.addConferenceRating(this.rating, this.conference.getEntityId(), username);
        RequestContext.getCurrentInstance().closeDialog(null);
    }

    public void showInfo(Long conferenceId) {
        this.conference = conferenceEJB.getConferenceById(conferenceId);
        this.initDialog("conference/info");
    }

    private boolean conferenceDtoHasValidationErrors(ConferenceDto conference) {
        if (conference.getName() == null || conference.getName().equals("")) {
            return true;
        }
        if (conference.getLocation() == null || conference.getLocation().equals("")) {
            return true;
        }
        if (conference.getStart() == null) {
            return true;
        }
        if (conference.getEnd() == null) {
            return true;
        }
        if (conference.getMaximalParticipants() == null || conference.getMaximalParticipants() < 1) {
            return true;
        }
        return false;
    }
}
