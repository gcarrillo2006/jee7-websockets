/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.limits.surpass.export.core;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.limits.surpass.export.model.Branch;
import com.limits.surpass.export.model.Product;

/**
 *
 * @author German
 */
@Stateless
@LocalBean
@Remote(ProductRemote.class)
public class ProductBean implements ProductRemote {

    @PersistenceContext(unitName = "ExportPU")
    private EntityManager em;

    public List<Product> findProducts(Branch branch, String name) {
        TypedQuery<Product> query = this.em.createNamedQuery("findProductsByBranch", Product.class)
            .setParameter("branch", branch)
            .setParameter("name", name != null ? name.concat("%") : "%");
        return query.getResultList();
    }

    public List<Product> findProducts(String name) {
        TypedQuery<Product> query = this.em.createNamedQuery("findProducts", Product.class)
            .setParameter("name", name != null ? name.concat("%") : "%");
        return query.getResultList();
    }

    public void persist(Product product) {
        this.em.merge(product);
    }

    public void delete(Product product) {
        this.em.remove(this.em.merge(product));
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
}
