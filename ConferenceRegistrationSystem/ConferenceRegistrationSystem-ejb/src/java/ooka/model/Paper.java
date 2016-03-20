/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Eine Publikation.
 * 
 * @author sebastianmahlke
 */
@Entity
public class Paper implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /**
     * Der Titel der Publikation.
     */
    private String title;
    
    /**
     * Der eingereichte User sowie Redner.
     */
    private User speaker;
    
    /**
     * Die Autoren.
     */
    private String autors;
    
    /**
     * Veröffentlichtkeitsdatum.
     */
    private Date publicationDate;
    
    /**
     * Gutachten der Publikation.
     */
    private Review review;
    
    /**
     * Die Publikation.
     */
    private byte[] data;
    
    
    /**
     * Datum der Einreichung
     */

    private Date submiteDate;
    
    public Paper() {
    }

    public Paper(String title, String autors) {
        this.title = title;
        this.autors = autors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getSpeaker() {
        return speaker;
    }

    public void setSpeaker(User speaker) {
        this.speaker = speaker;
    }

    public String getAutors() {
        return autors;
    }

    public void setAutors(String autors) {
        this.autors = autors;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Date getSubmiteDate() {
        return submiteDate;
    }

    public void setSubmiteDate(Date submiteDate) {
        this.submiteDate = submiteDate;
    }

    
    
    @Override
    public String toString() {
        return "Paper{" + "id=" + id + ", title=" + title + ", speaker=" + speaker + ", autors=" + autors + ", publicationDate=" + publicationDate + ", review=" + review + ", data=" + data + '}';
    }
    
    
    
}
