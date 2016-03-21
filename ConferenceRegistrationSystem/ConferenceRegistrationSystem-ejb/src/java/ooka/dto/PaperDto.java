/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.dto;

import java.util.Date;
import ooka.model.Review;
import ooka.model.User;

/**
 *
 * @author Admin
 */
public class PaperDto {

    public PaperDto() {
    }

    public PaperDto(String title, User speaker, String autors) {
        this.title = title;
        this.speaker = speaker;
        this.autors = autors;
    }
       
    
    private Long id;
    
    private Long conferenceId;
    
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

    public Long getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(Long conferenceId) {
        this.conferenceId = conferenceId;
    }
    
    

    @Override
    public String toString() {
        return "PaperDto{" + "id=" + id + ", title=" + title + ", speaker=" + speaker + ", autors=" + autors + ", publicationDate=" + publicationDate + ", review=" + review + ", data=" + data + '}';
    }

    
}
