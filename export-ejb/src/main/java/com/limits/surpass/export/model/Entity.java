package com.limits.surpass.export.model;

import java.io.Serializable;
/**
 * Class that represents an entity on the interface
 * @author german
 *
 */

public class Entity implements Serializable {
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;

	private String object;
	
	private Operation operation;
	
	private Long id;

	/**
	 * @return the object
	 */
	public String getObject() {
		return object;
	}

	/**
	 * @param object the object to set
	 */
	public void setObject(String object) {
		this.object = object;
	}

	/**
	 * @return the operation
	 */
	public Operation getOperation() {
		return operation;
	}

	/**
	 * @param operation the operation to set
	 */
	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
}
