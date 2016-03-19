/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author sebastianmahlke
 */

@Entity
public class User implements Serializable {
    
    public User(){
        
    }

    public User(String firstname, String lastname, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }
    

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<Userrole> getUserroles() {
        return userroles;
    }

    public void setUserroles(Set<Userrole> userroles) {
        this.userroles = userroles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
        /**
     * Der Vorname der Person.
     */
    @Column
    private String firstname;

    
    /**
     * Der Nachname der Person.
     */
    @Column
    private String lastname;
    
    /**
     * Die Rolles des Nutzers.
     */
    private Set<Userrole> userroles;
    
    /**
     * Der Benutzername des Anwenders.
     */
    @Column(unique = true)
    private String username;
    
    /**
     * Das Kennwort des Anwenders ;-)
     */
    @Column
    private String password;
    
    /**
     * Die Postbox-Nachrichten für diesen Nutzer.
     */
    private List<Message> messages;

}
