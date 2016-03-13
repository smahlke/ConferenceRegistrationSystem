/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.ejb;

import java.util.Set;
import javax.ejb.Local;
import ooka.dto.ConferenceDto;

/**
 *
 * @author sebastianmahlke
 */
@Local
public interface ConferenceEJBLocal {

    Set getConferences();

    void saveConference(ConferenceDto conferenceDto);

    ConferenceDto getConferenceById(final Long id);
    
    
    
}
