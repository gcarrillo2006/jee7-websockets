package com.limits.surpass.export.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Entity that manage all the parameters of the application
 * @author German
 */

@Entity
@Table(name = "parameters", schema = "security")
public class Parameters implements Serializable {
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "name", length = 30, nullable = false)
	private String name;
	
	@Column(name = "value", length = 30, nullable = false)
	private String value;
	
	/**
	 * Minimal Constructor 
	 */
	public Parameters() {
		
	}

	/**
	 * @return the name
	 */
	public String getName() {
            return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
            this.name = name;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
            return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
            this.value = value;
	}
}