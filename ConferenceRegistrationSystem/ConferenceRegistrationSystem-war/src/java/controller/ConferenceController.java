package controller;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import ooka.dto.ConferenceDto;
import ooka.ejb.ConferenceEJBLocal;
import ooka.model.Conference;

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

    public Set<ConferenceDto> getConferences(){
        return conferenceEJB.getConferences();
    }
    
    public void deleteConference(String name) {
        System.out.println(name);
    }
    
}
