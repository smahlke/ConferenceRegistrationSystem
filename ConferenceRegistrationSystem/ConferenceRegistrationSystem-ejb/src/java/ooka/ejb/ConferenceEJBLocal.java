/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.ejb;

import javax.ejb.Local;
import ooka.model.Conference;

/**
 *
 * @author sebastianmahlke
 */
@Local
public interface ConferenceEJBLocal {

    Conference getConference();
    
}
