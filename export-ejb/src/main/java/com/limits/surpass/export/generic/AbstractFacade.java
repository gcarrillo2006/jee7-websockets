package com.limits.surpass.export.generic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * Clase para definir un comportamiento general de las operaciones de negocio
 * 
 * @author german
 *
 */
public abstract class AbstractFacade<T> {

	private Class<T> entity;

	public AbstractFacade(Class<T> entity) {
		this.entity = entity;
	}

	protected abstract EntityManager getEntityManager();

	public String save(T entity) throws Exception {
		getEntityManager().persist(entity);
		return "El registro de " + entity.getClass().getSimpleName() + " fue exitoso";
	}

	public String update(T entity) throws Exception {
		getEntityManager().merge(entity);
		return "La Actualización de " + entity.getClass().getSimpleName() + " fue exitosa";
	}

	public T findById(Integer id) {
		return getEntityManager().find(entity, id);
	}

	public List<T> findAll() throws Exception {
		TypedQuery<T> query = getEntityManager().createNamedQuery(entity.getSimpleName() + ".findAll", entity);
		return query.getResultList();
	}
}
