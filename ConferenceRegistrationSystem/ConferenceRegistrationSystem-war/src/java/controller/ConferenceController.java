package controller;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import ooka.dto.ConferenceDto;
import ooka.ejb.ConferenceEJB;
import ooka.ejb.ConferenceEJBLocal;


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

    private ConferenceDto conference;

    public List<ConferenceDto> getConferences() {
        return conferenceEJB.getConferences();
    }

    public void deleteConference(Long idSet) {
        conferenceEJB.deleteConferenceById(idSet);

    }

    public void subscribeToConference(String username, Long id) {
        conferenceEJB.subscribe(username, id);
    }
    
    public void unsubscribeToConference(String username, Long id) {
        conferenceEJB.unsubscribe(username, id);
    }
}
