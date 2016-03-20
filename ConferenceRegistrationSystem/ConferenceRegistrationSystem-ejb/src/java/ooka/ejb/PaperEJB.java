/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import ooka.dto.PaperDto;
import ooka.dto.UserDto;
import ooka.model.Paper;
import static ooka.model.User_.username;

/**
 *
 * @author Admin
 */
@Stateless
public class PaperEJB implements PaperEJBLocal {
    
    @PersistenceContext
    EntityManager em;
    
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

    @Override
    public void savePaper(PaperDto paperDto) {
        Paper paper = this.datatransferObjectToEntity(paperDto);
        em.persist(paper);       
    }

    @Override
    public void deletePaper(final long paperId) {
        em.remove(em.find(Paper.class, paperId));
    }

    @Override
    public void rejectPaper(final long paperId) {
    }

    @Override
    public void passPaper(final long paperId) {
        
        
    }
    
    private Paper datatransferObjectToEntity(PaperDto dto) {     
        Paper entity = new Paper();
        entity.setAutors(dto.getAutors());
        entity.setId(dto.getId());
        entity.setSpeaker(dto.getSpeaker());
        entity.setTitle(dto.getTitle());
        entity.setPublicationDate(dto.getPublicationDate());
        entity.setSubmiteDate(dto.getSubmiteDate());
        return entity;
    }
    
    private PaperDto entityToDatatransferObject(Paper entity) {
        PaperDto dto = new PaperDto();

        dto.setId(entity.getId());
        dto.setAutors(entity.getAutors());
        dto.setPublicationDate(entity.getPublicationDate());
        dto.setSpeaker(entity.getSpeaker());
        dto.setSubmiteDate(entity.getSubmiteDate());
        dto.setTitle(entity.getTitle());
        dto.setData(entity.getData());
        dto.setReview(entity.getReview());

        return dto;
    }
    
}
