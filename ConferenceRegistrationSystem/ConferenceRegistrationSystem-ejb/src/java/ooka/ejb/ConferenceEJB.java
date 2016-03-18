/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.ejb;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ooka.dto.ConferenceDto;
import ooka.model.Conference;

/**
 *
 * @author sebastianmahlke
 */
@Stateless
public class ConferenceEJB implements ConferenceEJBLocal {
    
    @PersistenceContext
    EntityManager em;
    
    @Override
    public List<ConferenceDto> getConferences() {
        
        List<Conference> conferences =  em.createQuery("SELECT c FROM Conference c").getResultList();
        List<ConferenceDto> dtos = new ArrayList<>();
        
        conferences.forEach(c -> {
            dtos.add(this.entityToDatatransferObject(c));
        });
        
        return dtos;
    }

    @Override
    public void saveConference(ConferenceDto conferenceDto) {
        
        if (conferenceDto.getEntityId() != null) {
            em.merge(this.datatransferObjectToEntity(conferenceDto));
        } else {
            em.persist(this.datatransferObjectToEntity(conferenceDto));

        }

        System.out.println("Conference saved: " + conferenceDto.toString());
    }
    
    private Conference datatransferObjectToEntity(ConferenceDto dto) {
        
        Conference entity = new Conference();
        
        // Update oder Create?
        if (dto.getEntityId() != null) {
            entity.setId(dto.getEntityId());
        }
                
        entity.setName(dto.getName());
        entity.setLocation(dto.getLocation());
        entity.setMaximalParticipants(dto.getMaximalParticipants());
        entity.setOrganizer(dto.getOrganizer());
        entity.setPaper(dto.getPaper());
        entity.setParticipants(dto.getParticipants());
        entity.setReviews(dto.getReviews());
        
        entity.setStartDate(dto.getStart());
        entity.setEndDate(dto.getEnd());
        
        return entity;
    }

    private ConferenceDto entityToDatatransferObject(Conference entity) {
        ConferenceDto dto = new ConferenceDto();

        dto.setEntityId(entity.getId()); 
        dto.setName(entity.getName());
        dto.setLocation(entity.getLocation());
        dto.setMaximalParticipants(entity.getMaximalParticipants());
        dto.setOrganizer(entity.getOrganizer());
        dto.setPaper(entity.getPaper());
        dto.setParticipants(entity.getParticipants());
        dto.setReviews(entity.getReviews());
        dto.setStart(entity.getStartDate());
        dto.setEnd(entity.getEndDate());

        return dto;
    }
    
    @Override
    public ConferenceDto getConferenceById(final Long id) {
        return this.entityToDatatransferObject(em.find(Conference.class, id));
    }
    
    public void deleteConferenceById(final Long id){
        System.out.println(id);
        em.remove(em.find(Conference.class, id));
}
} 
