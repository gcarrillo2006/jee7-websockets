/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.limits.surpass.export.core;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.limits.surpass.export.model.Product;
import com.limits.surpass.export.model.Reservation;
import com.limits.surpass.export.model.Stock;

/**
 *
 * @author German
 */
@Stateless
@LocalBean
public class ReservationBean {

    @PersistenceContext(unitName = "ExportPU")
    private EntityManager em;

    public List<Reservation> findReservations(Stock stock) {
        TypedQuery<Reservation> query = this.em.createNamedQuery("findReservationsByStock", Reservation.class)
            .setParameter("stock", stock);
        return query.getResultList();
    }

    public List<Reservation> findReservations(Product product) {
        TypedQuery<Reservation> query = this.em.createNamedQuery("findReservationsByStock", Reservation.class)
            .setParameter("product", product);
        return query.getResultList();
    }

    public void persist(Reservation reservation) {
        reservation.setCheckOut(new Date());
        this.em.merge(reservation);
    }

    public void delete(Reservation reservation) {
        this.em.remove(this.em.merge(reservation));
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
}
