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

import com.limits.surpass.export.model.Branch;
import com.limits.surpass.export.model.Contact;
import com.limits.surpass.export.model.Enterprise;

/**
 *
 * @author German
 */
@Stateless
@LocalBean
public class ContactBean {

    @PersistenceContext(unitName = "ExportPU")
    private EntityManager em;

    public List<Contact> findContacts(Enterprise enterprise, String name) {
        TypedQuery<Contact> query = this.em.createNamedQuery("findContactsByEnterprise", Contact.class)
            .setParameter("enterprise", enterprise)
            .setParameter("name", name);
        return query.getResultList();
    }

    public List<Contact> findContacts(Branch branch, String name) {
        TypedQuery<Contact> query = this.em.createNamedQuery("findContactsByBranch", Contact.class)
            .setParameter("branch", branch)
            .setParameter("name", name);
        return query.getResultList();
    }

    public Contact loadContact(String username) {
        return this.em.find(Contact.class, username);
    }

    public void persist(Contact contact) {
        this.em.merge(contact);
    }

    public void delete(Contact contact) {
        this.em.remove(this.em.merge(contact));
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
}
