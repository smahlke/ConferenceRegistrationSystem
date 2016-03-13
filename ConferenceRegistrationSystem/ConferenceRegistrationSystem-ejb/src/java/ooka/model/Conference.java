package ooka.model;

import java.io.Serializable;
import static java.util.Calendar.DATE;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebastianmahlke
 */
//@Entity
public class Conference implements Serializable {
    
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public Conference() {
        
    }
    
    public Conference(String name, String location, Date startDate, Date endDate, Long maxParticipants, User organizer) {
        this.name = name;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maximalParticipants = maxParticipants;
        this.organizer = organizer;
    }
    
    /**
     * Name der Konferenz.
     */
//    @Column(name = "name")
    private String name;
    
    /**
     * Ort der Konferenz.
     */
    private String location;
    
    /**
     * Startdatum der Konferenz.
     */
//    @Temporal(TemporalType.DATE)
    private Date startDate;
    
    /**
     * Enddatum der Konferenz.
     */
//    @Temporal(TemporalType.DATE)
    private Date endDate;
    
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
