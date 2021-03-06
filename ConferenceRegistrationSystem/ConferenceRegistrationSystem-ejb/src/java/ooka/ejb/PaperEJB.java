/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import ooka.dto.ConferenceDto;
import ooka.dto.PaperDto;
import ooka.model.Conference;
import ooka.model.Paper;
import ooka.model.Review;

/**
 *
 * @author Admin
 */
@Stateless
public class PaperEJB implements PaperEJBLocal {
    
    @PersistenceContext
    EntityManager em;
    
    @EJB
    ConferenceEJBLocal conferenceEJB;
    
    @EJB
    UserEJB  userEJB;
    
    
    @PermitAll
    @Override
    public List<PaperDto> getMyPapers(String username){
        List<Paper> papers;
        TypedQuery<Paper> query = em.createQuery("select p from Paper p where p.speaker.username = :username", Paper.class);
        query.setParameter("username", username);
        papers = query.getResultList();       
        List<PaperDto> dtos = new ArrayList<>();

        papers.forEach(p->{
          dtos.add(this.entityToDatatransferObject(p));
        });
        
        return dtos;
    }

    @PermitAll
    @Override
    public void savePaper(PaperDto paperDto) {
        Paper paper = this.datatransferObjectToEntity(paperDto);
        Conference conference = conferenceEJB.getConferenceById(paperDto.getConferenceId());
        
        conference.addPaper(paper);
        
        em.persist(paper);
        em.merge(conference);
    }
    
    @PermitAll
    @Override
    public void deletePaper(final long paperId) {
        List<Conference> conferences =conferenceEJB.getConferenceEntities();
        Paper paper= em.find(Paper.class, paperId);
        
                for (Conference dto : conferences) {
             
                    for (Paper p : dto.getPaper()) {
             
                       if( p.getId().equals(paperId)){
                          dto.getPaper().remove(paper);
                          em.merge(dto);
                       }
                    }
            }  

        em.remove(paper);
    }

    @PermitAll
    @Override
    public void rejectPaper(final long paperId) {
         Paper p=em.find(Paper.class, paperId);
         p.setReview(Review.REJECT);
         em.merge(p);
    }

    @PermitAll
    @Override
    public void passPaper(final long paperId) {
 
         Paper p=em.find(Paper.class, paperId);
         p.setReview(Review.PASS);
         em.merge(p);
         
    }
    
    private Paper datatransferObjectToEntity(PaperDto dto) {     
        Paper entity = new Paper();
        entity.setAutors(dto.getAutors());
        entity.setId(dto.getId());
        entity.setSpeaker(dto.getSpeaker());
        entity.setTitle(dto.getTitle());
        entity.setPublicationDate(dto.getPublicationDate());
        entity.setSubmitDate(dto.getSubmiteDate());
        return entity;
    }
    
    private PaperDto entityToDatatransferObject(Paper entity) {
        PaperDto dto = new PaperDto();

        dto.setId(entity.getId());
        dto.setAutors(entity.getAutors());
        dto.setPublicationDate(entity.getPublicationDate());
        dto.setSpeaker(entity.getSpeaker());
        dto.setSubmiteDate(entity.getSubmitDate());
        dto.setTitle(entity.getTitle());
        dto.setData(entity.getData());
        dto.setReview(entity.getReview());

        return dto;
    }
    
@PermitAll
@Override
    public List<PaperDto> getPaperDTOsByConference(Long conferenceId) {
        Query query = this.em.createQuery("SELECT c.papers FROM Conference c WHERE c.id = :id").setParameter("id", conferenceId);
        List<PaperDto> dtos = new ArrayList<>();

        List<Paper> entities = query.getResultList();

            for (Paper p : entities) {
                if (p!=null)
                dtos.add(this.entityToDatatransferObject(p));
            }
        
        return dtos;
    }
    
    public void setReviewer(final Long paperId, String username){
        Paper p= this.em.find(Paper.class, paperId);   
        p.setReviewer(userEJB.getUserByUsername(username));
        p.setReview(Review.IN_PROCESS);
        em.merge(p);  
    }
    
    public List<PaperDto> getReviewPapers(String username){
        Query query = this.em.createQuery("SELECT p FROM Paper p WHERE p.reviewer.username = :username").setParameter("username", username);
        List<Paper> papers = query.getResultList();
        List<PaperDto> dtos = new ArrayList<>();
        
        
                for (Paper p : papers) {
                if (p!=null)
                dtos.add(this.entityToDatatransferObject(p));
            }

        
        return dtos;
    }
}
