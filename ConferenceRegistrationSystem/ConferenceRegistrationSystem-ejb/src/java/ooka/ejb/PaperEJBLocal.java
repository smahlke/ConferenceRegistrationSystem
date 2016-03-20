/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.ejb;

import java.util.List;
import javax.ejb.Local;
import ooka.dto.PaperDto;
import ooka.model.User;

/**
 *
 * @author Admin
 */
@Local
public interface PaperEJBLocal {

    void savePaper(PaperDto paper);

    void deletePaper(long paperId);

    void rejectPaper(long paperId);

    void passPaper(long paperId);
    
    public List<PaperDto> getMyPapers(String username);
 
}
