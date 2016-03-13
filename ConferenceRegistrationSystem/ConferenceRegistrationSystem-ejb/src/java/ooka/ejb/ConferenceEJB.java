/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.ejb;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import ooka.dto.ConferenceDto;
import ooka.model.Message;

/**
 *
 * @author sebastianmahlke
 */
@Stateless
public class ConferenceEJB implements ConferenceEJBLocal {
    
    @PersistenceContext
    EntityManager em;
    
//    @PersistenceUnit
//    EntityManagerFactory emf;
    
    private Set<ConferenceDto> cons = new HashSet<>();
    
    public ConferenceEJB() {
        
        ConferenceDto c1 = new ConferenceDto();
        c1.setEntityId(1L);
        c1.setName("JavaLand");
        c1.setLocation("Phantasialand");
        c1.setStart(new Date());
        c1.setEnd(new Date());
        c1.setMaximalParticipants(200L);
        cons.add(c1);
        
        ConferenceDto c2 = new ConferenceDto();
        c2.setEntityId(2L);
        c2.setName("Oracle Conference");
        c2.setLocation("Nürnberg");
        c2.setStart(new Date());
        c2.setEnd(new Date());
        c2.setMaximalParticipants(1500L);
        cons.add(c2);
    }

    @Override
    public Set<ConferenceDto> getConferences() {
        return this.cons;
    }

    @Override
    public void saveConference(ConferenceDto conferenceDto) {
        Message m = new Message();
        m.setSubject("yeeaahh");
        m.setId(2L);
        em.persist(m);
        conferenceDto.setEntityId(3L);
        this.cons.add(conferenceDto);
        
        System.out.println("Conference saved: " + conferenceDto.toString());
    }

    @Override
    public ConferenceDto getConferenceById(final Long id) {
        //TODO: Query DB
        for (ConferenceDto dto : this.cons ) {
            if (dto.getEntityId().equals(id)) {
                return dto;
            }
        }

        return null;
    }
    
}
