/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import ooka.ejb.UserEJB;
import ooka.model.User;

/**
 *
 * @author sebastianmahlke
 */
@ManagedBean
public class UserController {
    
    @EJB
    UserEJB userEJB;
    
    public List<User> getAllUsers() {
        return userEJB.getUsers();
    }
    
    public void setAsOrganizer(String username) {
        
        this.userEJB.addUserroleOrganizer(username);
        
    }
    
    public boolean isOrganizer(String username) {
        return this.userEJB.hasRoleOrganizer(username);
    }
    
}
