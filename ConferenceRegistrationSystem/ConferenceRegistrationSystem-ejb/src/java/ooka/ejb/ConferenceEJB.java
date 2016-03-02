/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooka.ejb;

import javax.ejb.Stateless;
import ooka.model.Conference;

/**
 *
 * @author sebastianmahlke
 */
@Stateless
public class ConferenceEJB implements ConferenceEJBLocal {

    @Override
    public Conference getConference() {
        Conference c = new Conference();
        c.setName("asdf");
        return c;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
