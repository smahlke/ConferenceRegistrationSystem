/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.dto;

import java.util.List;
import java.util.Set;
import ooka.model.Message;
import ooka.model.Group;

/**
 *
 * @author Admin
 */
public class UserDto {
    
    public UserDto(){
        
    }
    
    public UserDto(String firstname, String lastname, String username, String password ){
        this.firstname=firstname;
        this.lastname=lastname;
        this.username=username;
        this.password=password;
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
        return userroles;
    }

    public void setUserroles(Set<Group> userroles) {
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
    
    
    private Long id;
        
    /**
     * Der Vorname der Person.
     */
    private String firstname;
    
    /**
     * Der Nachname der Person.
     */
    private String lastname;
    
    /**
     * Die Rolles des Nutzers.
     */
    private Set<Group> userroles;
    
    /**
     * Der Benutzername des Anwenders.
     */
    private String username;
    
    /**
     * Das Kennwort des Anwenders ;-)
     */
    private String password;
    
    /**
     * Die Postbox-Nachrichten für diesen Nutzer.
     */
    private List<Message> messages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "UserDto{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", userroles=" + userroles + ", username=" + username + ", password=" + password + ", messages=" + messages + '}';
    }
    
    
}
