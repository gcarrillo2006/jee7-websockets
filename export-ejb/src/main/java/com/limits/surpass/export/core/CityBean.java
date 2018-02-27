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

import com.limits.surpass.export.model.City;
import com.limits.surpass.export.model.Country;

/**
 *
 * @author German
 */
@Stateless
@LocalBean
public class CityBean {

    @PersistenceContext(unitName = "ExportPU")
    private EntityManager em;

    public List<City> findCities(Country country, String name) {
        TypedQuery<City> query = this.em.createNamedQuery("findCitiesByCountry", City.class)
            .setParameter("country", country)
            .setParameter("name", name != null ? name.concat("%") : "%");
        return query.getResultList();
    }

    public List<City> findCities(String name) {
        TypedQuery<City> query = this.em.createNamedQuery("findCities", City.class)
                .setParameter("name", name != null ? name.concat("%") : "%");
        return query.getResultList();
    }

    public City loadCity(Short id) {
        return this.em.find(City.class, id);
    }

    public void persist(City city) {
        this.em.merge(city);
    }

    public void delete(City city) {
        this.em.remove(this.em.merge(city));
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
}
