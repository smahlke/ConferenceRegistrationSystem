/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.ejb;

import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Local;
import ooka.dto.PaperDto;
import ooka.model.Paper;

/**
 *
 * @author Admin
 */
@Local
public interface PaperEJBLocal {

    @PermitAll
    void savePaper(PaperDto paper);
    
    @PermitAll
    void deletePaper(long paperId);
    
    @PermitAll
    void rejectPaper(long paperId);
    
    @PermitAll
    void passPaper(long paperId);
        
    @PermitAll
    public List<PaperDto> getMyPapers(String username);
     
    @PermitAll
    public List<PaperDto> getPaperDTOsByConference(Long conferenceId);
    
    @PermitAll
     public void setReviewer(final Long paperId, String username);
     
     @PermitAll
     public List <PaperDto> getReviewPapers(String username);
}
