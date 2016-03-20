/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.faces.bean.ManagedBean;
import ooka.dto.PaperDto;
import ooka.ejb.PaperEJB;
import ooka.ejb.PaperEJBLocal;

/**
 *
 * @author Admin
 */
@ManagedBean(name = "paperController")
@Stateless
@LocalBean
public class PaperController {

    @EJB
    PaperEJBLocal paperEjb;
    public void deletePaper(final long paperId) {
        paperEjb.deletePaper(paperId);
    }

    public List<PaperDto> getMyPapers(String username) {  
        return paperEjb.getMyPapers(username);
    }

    public List <PaperDto> getReviewPapers() {
        
        return null;
    }
    
      


}
