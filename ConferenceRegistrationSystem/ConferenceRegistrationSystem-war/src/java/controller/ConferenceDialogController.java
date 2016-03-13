/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import ooka.dto.ConferenceDto;
import ooka.ejb.ConferenceEJBLocal;
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
    
    private ConferenceDto conference;

    public ConferenceDto getConference() {
        return conference;
    }

    public void setConference(ConferenceDto conference) {
        this.conference = conference;
    }
    
    public void initDialog() {
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", false);
        options.put("modal", true);
        RequestContext.getCurrentInstance().openDialog("conference/workflow/conference", options, null);
    }
    
    public void createConference() {
        this.conference = new ConferenceDto();
        this.initDialog();
    }

    public void editConference(Long idSet) {
        this.conference = conferenceEJB.getConferenceById(idSet);
        this.initDialog();
    }

    public void closeDialog() {
        RequestContext.getCurrentInstance().closeDialog(null);
    }
    
    public void saveDialog() {
        conferenceEJB.saveConference(this.conference);
        RequestContext.getCurrentInstance().closeDialog(null);
    }
}
