/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.dto;

import java.util.Date;
import java.util.Set;
import ooka.model.Paper;
import ooka.model.User;

/**
 *
 * @author sebastianmahlke
 */
public class ConferenceDto {
    
    public ConferenceDto() {
        
    }
    
    public ConferenceDto(String name, String location, Date startDate, Date endDate, Long maxParticipants, User organizer) {
        this.name = name;
        this.location = location;
        this.start = startDate;
        this.end = endDate;
        this.maximalParticipants = maxParticipants;
    }
    
    private Long entityId;
    
    /**
     * Name der Konferenz.
     */
    private String name;
    
    /**
     * Ort der Konferenz.
     */
    private String location;
    
    /**
     * Startdatum der Konferenz.
     */
    private Date start;
    
    /**
     * Enddatum der Konferenz.
     */
    private Date end;
    
    /**
     * Teilnehmer der Konferenz.
     */
    private Set<User> participants;
    
    /**
     * Maximale Anzahl an Teilnehmern.
     */
    private Long maximalParticipants;
    
    /**
     * Eingereichte Publikationen.
     */
    private Set<Paper> paper;
    
    /**
     * Konferenzveranstalter.
     */
    private User organizer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Set<User> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<User> participants) {
        this.participants = participants;
    }

    public Long getMaximalParticipants() {
        return maximalParticipants;
    }

    public void setMaximalParticipants(Long maximalParticipants) {
        this.maximalParticipants = maximalParticipants;
    }

    public Set<Paper> getPaper() {
        return paper;
    }

    public void setPaper(Set<Paper> paper) {
        this.paper = paper;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }
    
    
}
