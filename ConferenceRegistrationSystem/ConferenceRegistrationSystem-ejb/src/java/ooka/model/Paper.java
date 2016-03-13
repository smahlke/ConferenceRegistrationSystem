/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Eine Publikation.
 * 
 * @author sebastianmahlke
 */
public class Paper implements Serializable {
    
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
}
