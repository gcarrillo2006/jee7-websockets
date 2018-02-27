package com.limits.surpass.export.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity that manage enconomic sector for example
 * FOOD, PHARMA, etc
 * @author German
 *
 */
@Entity
@Table(name = "sector", schema = "application")
public class Sector implements Serializable {
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 6)
	private Short id;
	
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "sector")
	private Set<Business> businessList;
	
	/**
	 * Minimal Constructor
	 */
	public Sector() {
	}

	/**
	 * @param id
	 * @param name
	 * @param businessList
	 */
	public Sector(Short id, String name, Set<Business> businessList) {
            this.id = id;
            this.name = name;
            this.businessList = businessList;
	}

	/**
	 * @return the id
	 */
	public Short getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Short id) {
		this.id = id;
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
	 * @return the businessList
	 */
	public Set<Business> getBusinessList() {
		return businessList;
	}

	/**
	 * @param businessList the businessList to set
	 */
	public void setBusinessList(Set<Business> businessList) {
		this.businessList = businessList;
	}
}