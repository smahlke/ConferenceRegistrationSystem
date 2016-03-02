/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.model;

import java.util.Date;

/**
 *
 * @author sebastianmahlke
 */
public class Message {
    
    /**
     * Der Betreff der Nachricht.
     */
    private String subject;
    
    /**
     * Das Versendedatum der Nachricht.
     */
    private Date date;
    
    /**
     * Der Text der Nachricht.
     */
    private String text;
    
}
