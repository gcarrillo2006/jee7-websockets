/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.limits.surpass.export.core;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.limits.surpass.export.model.Country;

/**
 *
 * @author German
 */
@Stateless
@LocalBean
public class CountryBean {

    @PersistenceContext(unitName = "ExportPU")
    private EntityManager em;

    public List<Country> findCountries(String name) {
        TypedQuery<Country> query = this.em.createNamedQuery("findCountrys", Country.class)
            .setParameter("name", name != null ? name.concat("%") : "%");
        return query.getResultList();
    }

    public void persist(Country country) {
        this.em.merge(country);
    }

    public void delete(Country country) {
        this.em.remove(this.em.merge(country));
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
}
