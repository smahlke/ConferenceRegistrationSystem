/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.model;

/**
 *
 * @author sebastianmahlke
 */
public enum Review {
    
    PASS("Genehmigt"),
    REJECT("Abgelehnt"),
    IN_PROCESS("In Bearbeitung"),
    NOT_ASSIGNED("Nicht zugewiesen");
    
    String description = "";
    
    Review(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
