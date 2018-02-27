package com.limits.surpass.export.core;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.limits.surpass.export.generic.AbstractFacade;
import com.limits.surpass.export.model.Login;

/**
 * Clase encargada de manejar el login
 * @author german
 *
 */
@Stateless
public class LoginFacade extends AbstractFacade<Login> {
	
	private static final Logger log = Logger.getLogger("LoginFacade");

	@PersistenceContext(unitName = "ExportPU")
	private EntityManager em;

	public LoginFacade() {
		super(Login.class);
	}

	/**
	 * Método encargado de validar el acceso
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean validateAccess(String username, String password) {
		Login login = null;
		try {
			TypedQuery<Login> query = getEntityManager()
					.createQuery("from Login l where l.username = :username and l.password = :password", Login.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			login = query.getSingleResult();
		} catch (Exception e) {
			log.log(Level.INFO, "Intento de logueo fallido del usuario " + username, e);
		}
		return login != null ? true : false;
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
