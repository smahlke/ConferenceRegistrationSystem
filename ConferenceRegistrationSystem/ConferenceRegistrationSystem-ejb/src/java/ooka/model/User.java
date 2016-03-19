/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author sebastianmahlke
 */

@Entity
@Table(name="USERS")
public class User implements Serializable {
    
    public User(){
        
    }

    public User(String firstname, String lastname, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

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
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Set<Group> groups = new HashSet<>();
    
    /**
     * Der Benutzername des Anwenders.
     */
    @Id
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

    
    public void addUserRole(Group role) {
        this.groups.add(role);
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

    public Set<Group> getUserroles() {
        return groups;
    }

    public void setUserroles(Set<Group> userroles) {
        this.groups = userroles;
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
}
