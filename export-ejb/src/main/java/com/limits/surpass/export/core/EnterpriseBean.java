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

import com.limits.surpass.export.model.Enterprise;

/**
 *
 * @author German
 */
@Stateless
@LocalBean
public class EnterpriseBean {

    @PersistenceContext(unitName = "ExportPU")
    private EntityManager em;

    public List<Enterprise> findEnterprises(String name) {
        TypedQuery<Enterprise> query = this.em.createNamedQuery("findEnterprises", Enterprise.class)
            .setParameter("name", name != null ? name.concat("%" ) : "%");
        return query.getResultList();
    }

    public List<Enterprise> findEnterprisesWithBranches(String name) {
        TypedQuery<Enterprise> query = this.em.createNamedQuery("findEnterprisesWithBranches", Enterprise.class)
            .setParameter("name", name != null ? name.concat("%") : "%");
        return query.getResultList();
    }

    public Enterprise findEnterpriseByUsername(String username) {
        TypedQuery<Enterprise> query = this.em.createNamedQuery("findEnterprisesByUsername", Enterprise.class)
            .setParameter("username", username);
        if (query.getResultList().isEmpty()) {
        	return null;
        }
        return query.getSingleResult();
    }

    public Enterprise loadEnterprise(Integer id) {
        return this.em.find(Enterprise.class, id);
    }

    public void persist(Enterprise enterprise) {
        this.em.merge(enterprise);
    }

    public void delete(Enterprise enterprise) {
        this.em.remove(this.em.merge(enterprise));
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
}
