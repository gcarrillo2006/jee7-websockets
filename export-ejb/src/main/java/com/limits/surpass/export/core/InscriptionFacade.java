package com.limits.surpass.export.core;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.limits.surpass.export.generic.AbstractFacade;
import com.limits.surpass.export.model.Inscription;

/**
 * Clase encargada de manejar la lógica de negocio de las inscripciones
 * @author german
 *
 */
@Stateless
public class InscriptionFacade extends AbstractFacade<Inscription> {

	@PersistenceContext(unitName = "ExportPU")
	private EntityManager em;
	
	public InscriptionFacade() {
		super(Inscription.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
