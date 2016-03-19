/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.ejb;

import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Local;
import ooka.dto.ConferenceDto;

/**
 *
 * @author sebastianmahlke
 */
@DeclareRoles({"ORGANIZER", "PARTICIPANT"})
@Local
public interface ConferenceEJBLocal {

    @PermitAll
    List<ConferenceDto> getConferences();

    @RolesAllowed({"ORGANIZER"})
    void saveConference(ConferenceDto conferenceDto);

    @PermitAll
    ConferenceDto getConferenceById(final Long id);
    
    @PermitAll
    void deleteConferenceById(final Long id);
    
    @PermitAll
    public void unsubscribe(String username, Long conferenceId);

    @PermitAll    
    public void subscribe(String username, Long conferenceId);

    @PermitAll    
    void rateConference(final int rating, final Long conferenceId, final Long userId);

}
