/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.limits.surpass.export.core;

import java.util.ArrayList;
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
public class StockBean {

    @PersistenceContext(unitName = "ExportPU")
    private EntityManager em;

    public List<Stock> findStocks(Product product) {
        TypedQuery<Stock> query = this.em.createNamedQuery("findStocksByProduct", Stock.class)
            .setParameter("product", product);
        return query.getResultList();
    }

    public List<Stock> findStocksByBranch(Integer branchId) {
        TypedQuery<Stock> query = this.em.createQuery("select s from Stock s "
            + "join s.product p join p.branch b where b.id = :branchId", Stock.class)
            .setParameter("branchId", branchId);
        List<Stock> stocks = query.getResultList();
        Integer reservationQuantity;
        if (stocks != null && !stocks.isEmpty()) {
            List<Stock> validStocks = new ArrayList<Stock>();
            for (Stock stock : stocks) {
                //I check if the reservation is not empty or have available stock
                if (stock.getReservationList() == null || stock.getReservationList().isEmpty()) {
                    validStocks.add(stock);
                } else {
                    reservationQuantity = 0;
                    for (Reservation reservation : stock.getReservationList()) {
                        reservationQuantity = reservationQuantity + reservation.getQuantity();
                    }
                    if (stock.getQuantity() > reservationQuantity) {
                        validStocks.add(stock);
                    }
                }
            }
            return validStocks;
        }
        return null;
    }

    public void persist(Stock stock) {
        this.em.merge(stock);
    }

    public void delete(Stock stock) {
        this.em.remove(this.em.merge(stock));
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
}
