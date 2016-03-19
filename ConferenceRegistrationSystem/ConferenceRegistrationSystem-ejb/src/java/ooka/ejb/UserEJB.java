/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.ejb;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import ooka.dto.UserDto;
import ooka.model.User;
import ooka.model.Group;

/**
 *
 * @author Admin
 */
@Stateless
@LocalBean
public class UserEJB {

    @PersistenceContext
    EntityManager em;

    @Resource
    SessionContext cxt;

    public void saveUser(UserDto udto) {

        User user = this.datatransferObjectToEntity(udto);
        user.addUserRole(Group.PARTICIPANT);

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String text = user.getPassword();
            md.update(text.getBytes("UTF-8")); // Change this to "UTF-16" if needed
            byte[] digest = md.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            String output = bigInt.toString(16);

            user.setPassword(output);

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
//            Logger.getLogger().log(Level.SEVERE, null, ex);
            System.out.println(ex.getStackTrace());
        }

        em.persist(user);
        System.out.println("Persist");
    }

    private User datatransferObjectToEntity(UserDto dto) {

        User entity = new User();
        entity.setId(dto.getId());
        entity.setFirstname(dto.getFirstname());
        entity.setLastname(dto.getLastname());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    public Boolean checkLoginData(String username, String password) {
        User user = this.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public UserDto entityToDatatransferObject(User entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setFirstname(entity.getFirstname());
        dto.setLastname(entity.getLastname());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        return dto;
    }

    public UserDto getUserDtoByUsername(String username) {
        return this.entityToDatatransferObject(this.getUserByUsername(username));
    }

    public User getUserByUsername(String username) {
        TypedQuery<User> query = em.createQuery("select u from User u where u.username = :username", User.class);
        query.setParameter("username", username);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("User with username " + username + " does not exist!");
            e.printStackTrace();
        }
        return null;
    }

    public String getUsername() {
        Principal p = cxt.getCallerPrincipal();
        return p.getName();
    }

}
