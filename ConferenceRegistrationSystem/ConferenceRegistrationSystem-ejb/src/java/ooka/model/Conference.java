package ooka.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebastianmahlke
 */
public class Conference implements Serializable {
    
    public Conference() {
        
    }
    
    public Conference(String name, String location, Date startDate, Date endDate, Long maxParticipants, User organizer) {
        this.name = name;
        this.location = location;
        this.start = startDate;
        this.end = endDate;
        this.maximalParticipants = maxParticipants;
        this.organizer = organizer;
    }
    
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
    
    /**
     * Bewertungen von Teilnehmern.
     */
    private Set<Review> reviews;

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

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
    
    
}
