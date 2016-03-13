/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 *
 * @author sebastianmahlke
 */
public class User implements Serializable {
    
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
    private Set<Userrole> userroles;
    
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

}
