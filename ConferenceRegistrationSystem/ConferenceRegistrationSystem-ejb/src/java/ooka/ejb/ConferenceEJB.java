/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.ejb;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.ejb.Stateless;
import ooka.dto.ConferenceDto;
import ooka.model.Conference;

/**
 *
 * @author sebastianmahlke
 */
@Stateless
public class ConferenceEJB implements ConferenceEJBLocal {
   
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Set<ConferenceDto> getConferences() {
        Set<ConferenceDto> cons = new HashSet<>();
        ConferenceDto c1 = new ConferenceDto();
        c1.setName("JavaLand");
        c1.setLocation("Phantasialand");
        c1.setStart(new Date());
        c1.setEnd(new Date());
        c1.setMaximalParticipants(200L);
        cons.add(c1);
        ConferenceDto c2 = new ConferenceDto();
        c2.setName("Oracle Conference");
        c2.setLocation("Nürnberg");
                c2.setStart(new Date());
        c2.setEnd(new Date());
        c2.setMaximalParticipants(1500L);
        cons.add(c2);
        return cons;
    }
}
