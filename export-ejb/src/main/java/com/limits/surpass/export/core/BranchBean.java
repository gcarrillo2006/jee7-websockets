/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.limits.surpass.export.core;

import java.util.List;
import java.util.Optional;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.limits.surpass.export.model.Branch;
import com.limits.surpass.export.model.Enterprise;

/**
 *
 * @author German
 */
@Stateless
@LocalBean
public class BranchBean {

    @PersistenceContext(unitName = "ExportPU")
    private EntityManager em;
    
    public Optional<Branch> findBranchByUsername(String username) {
        TypedQuery<Branch> query = this.em.createNamedQuery("findBranchesByUsername", Branch.class)
            .setParameter("username", username);
        return Optional.ofNullable(query.getSingleResult());
    }
    
    public List<Branch> findBranches(Integer enterpriseId) {
    	TypedQuery<Branch> query = this.em.createNamedQuery("findBranchesByEnterpriseId", Branch.class)
    		.setParameter("enterpriseId", enterpriseId);
    	return query.getResultList();
    }
    
    public List<Branch> findBranches(Enterprise enterprise, String name) {
        TypedQuery<Branch> query = this.em.createNamedQuery("findBranchesByEnterprise", Branch.class)
            .setParameter("enterprise", enterprise)
            .setParameter("name", name != null ? name.concat("%") : "%");
        return query.getResultList();
    }

    public List<Branch> findBranches(String name) {
        TypedQuery<Branch> query = this.em.createNamedQuery("findBranches", Branch.class)
            .setParameter("name", name != null ? name.concat("%") : "%");
        return query.getResultList();
    }

    public Branch loadBranch(Integer id) {
        return this.em.find(Branch.class, id);
    }

    public void persist(Branch branch) {
        this.em.merge(branch);
    }

    public void delete(Branch branch) {
        this.em.remove(this.em.merge(branch));
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
}
