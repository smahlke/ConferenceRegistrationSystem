/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author sebastianmahlke
 */
@Entity
public class ConferenceRating implements Serializable {
    
    public ConferenceRating() {
        
    }
    
    public ConferenceRating(User user, Rating rating) {
        this.user = user;
        this.rating = rating;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
        
    private User user;
    
    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Override
    public String toString() {
        return "ConferenceRating{" + "id=" + id + ", user=" + user + ", rating=" + rating + '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
