
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import ooka.model.Conference;
import ooka.model.Konferenz;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebastianmahlke
 */
@ManagedBean
@SessionScoped
public class ConferenceCDI implements Serializable {
    
    private Set<Konferenz> conferences = new HashSet<>();
    
    public ConferenceCDI() {
        System.out.println("ConferenceCDI created");
        this.conferences.add(new Konferenz());
    }
    
    public String getText() {
        return "test";
    }
    
    public Set<Konferenz> getConferences() {
        System.out.println("getConferences() invoked");
        return this.conferences;
        
    }
    
    
}
