/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import ooka.dto.PaperDto;
import ooka.dto.UserDto;
import ooka.ejb.PaperEJB;
import ooka.ejb.PaperEJBLocal;
import ooka.ejb.UserEJB;
import ooka.model.Paper;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Admin
 */
@ManagedBean(name = "paperDialogController")
@SessionScoped
public class PaperDialogController implements Serializable{
    
    @EJB
    PaperEJBLocal paperEJB;
    
    @EJB
    UserEJB userEJB;
    
    private PaperDto paper;
    
    private Map<String,String> usersInConference;
    String selectedUser;

    public PaperDto getPaper() {
        return paper;
    }
    
    
    public void createPaper(Long conferenceId) {
        this.paper = new PaperDto();
        this.paper.setConferenceId(conferenceId);
        this.initDialog("paper");
    }
    
    public void savePaper(){
        this.paper.setSpeaker(userEJB.getUserByUsername(userEJB.getUsername()));
        this.paper.setSubmiteDate(new Date());
        paperEJB.savePaper(this.paper);
        RequestContext.getCurrentInstance().closeDialog(null);
    }
    
    public void initDialog(String url) {
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", false);
        options.put("modal", true);
        RequestContext.getCurrentInstance().openDialog(url, options, null);
    }
    
    public List<PaperDto> getPaperByConference(Long conferenceId) {
        return this.paperEJB.getPaperDTOsByConference(conferenceId);
    }

    public String getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(String selectedUser) {
        this.selectedUser = selectedUser;
    }
    



    public void setReviewer(final Long paperId){
       paperEJB.setReviewer(paperId, this.selectedUser); 
    }
        public Map<String,String> getUsersInConference(){
            if(usersInConference==null){
                
                List <UserDto> users= userEJB.getUserDtos();
                
                 usersInConference = new HashMap<>();
                     for(UserDto u : users){
                                 usersInConference.put(u.getUsername(),u.getUsername());
                     }
                        
                
            }
            return usersInConference;
        }
        
         public void rejectPaper(final long paperId) {
             this.paperEJB.rejectPaper(paperId);
         }
         
          public void passPaper(final long paperId) {
               this.paperEJB.passPaper(paperId);
          }
}
