/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ooka.dto.ConferenceDto;
import ooka.model.Conference;
import ooka.model.Rating;
import ooka.model.User;

/**
 *
 * @author sebastianmahlke
 */
@DeclareRoles({"ORGANIZER", "PARTICIPANT"})
@Stateless
public class ConferenceEJB implements ConferenceEJBLocal {

    @PersistenceContext
    EntityManager em;

    @EJB
    UserEJB userEJB;

    @PermitAll
    @Override
    public List<ConferenceDto> getConferences() {

        List<Conference> conferences = em.createQuery("SELECT c FROM Conference c").getResultList();
        List<ConferenceDto> dtos = new ArrayList<>();

        conferences.forEach(c -> {
            dtos.add(this.entityToDatatransferObject(c));
        });

        return dtos;
    }

    @RolesAllowed({"ORGANIZER"})
    @Override
    public void saveConference(ConferenceDto conferenceDto) {

        if (conferenceDto.getEntityId() != null) {
            em.merge(this.datatransferObjectToEntity(conferenceDto));
            System.out.println("Conference updated: " + conferenceDto.toString());
        } else {
            double organizerRating = this.calculateOrganizerRating(userEJB.getUsername());
            if (conferenceDto.getMaximalParticipants() > 200) {
                if (organizerRating > 3) {
                    em.persist(this.datatransferObjectToEntity(conferenceDto));
                    System.out.println("Conference saved: " + conferenceDto.toString());
                } else {
                    System.out.println("Die Bewertungen des Organisators erlauben leider nicht die Erstellung großer Konferenzen.");
                }
            } else {
                em.persist(this.datatransferObjectToEntity(conferenceDto));
                System.out.println("Conference saved: " + conferenceDto.toString());
            }

        }

    }

    private double calculateOrganizerRating(String username) {
        Query query = this.em.createQuery("select c from Conference c where c.organizer.username = :username", Conference.class).setParameter("username", username);
        List<Conference> conferences = query.getResultList();
        if (!conferences.isEmpty()) {
            double sum = 0L;
            for (Conference c : conferences) {

                sum += c.calculateRatings();
            }

            return sum / conferences.size();
        }
        return 5;
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

    @PermitAll
    @Override
    public ConferenceDto getConferenceDtoById(final Long id) {
        return this.entityToDatatransferObject(em.find(Conference.class, id));
    }

    @RolesAllowed({"ORGANIZER"})
    @Override
    public void deleteConferenceById(final Long id) {
        System.out.println(id);
        em.remove(em.find(Conference.class, id));
    }

    @PermitAll
    @Override
    public void subscribe(String username, Long conferenceId) {
        User user = userEJB.getUserByUsername(username);

        Conference conference = em.find(Conference.class, conferenceId);
        conference.addParticipant(user);

        em.merge(conference);
    }

    @PermitAll
    @Override
    public void unsubscribe(String username, Long conferenceId) {
        User user = userEJB.getUserByUsername(username);

        Conference conference = em.find(Conference.class, conferenceId);
        conference.removeParticipant(user);

        em.merge(conference);
    }

    @PermitAll
    @Override
    public void addConferenceRating(final int rating, final Long conferenceId, final String username) {

        Conference conference = this.getConferenceById(conferenceId);

        User user = this.em.find(User.class, username);

        conference.addRating(user, Rating.getRatingForValue(rating));

        em.merge(conference);
    }
    
    @PermitAll
    @Override
    public Conference getConferenceById(final Long id) {
        return this.em.find(Conference.class, id);
    }

}
