/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import ooka.ejb.ConferenceEJB;

/**
 *
 * @author sebastianmahlke
 */
@ManagedBean
@SessionScoped
public class ConferenceController {

    @EJB
    ConferenceEJB conferenceEJB;
    
    /**
     * Creates a new instance of ConferenceController
     */
    public ConferenceController() {
    }
    
    public String getText() {
        return this.conferenceEJB.getConference().getName();
    }
}
