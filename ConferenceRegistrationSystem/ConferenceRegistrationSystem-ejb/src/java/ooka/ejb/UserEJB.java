/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ooka.dto.UserDto;
import ooka.model.User;

/**
 *
 * @author Admin
 */
@Stateless
@LocalBean
public class UserEJB {
    
    @PersistenceContext
    EntityManager em;
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void saveUser(UserDto udto) {    
        em.persist(this.datatransferObjectToEntity(udto));
        System.out.println("Persist");
    }
    
    private User datatransferObjectToEntity(UserDto dto) {
        
        User entity = new User();
                
        entity.setFirstname(dto.getFirstname());
        entity.setLastname(dto.getLastname());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());      
        return entity;
    }
}
