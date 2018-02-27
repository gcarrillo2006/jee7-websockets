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
 * Entity that represents the business activity
 * for Example: Productor, Comercializator, Client, etc.
 * @author German
 */

@Entity
@Table(name = "activity", schema = "application")
public class Activity implements Serializable {
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 4)
	private Short id;
	
	@Column(name = "name", length = 30 ,nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "activity")
	private Set<Enterprise> enterpriseList;
	
	/**
	 * Minimal Constructor 
	 */
	public Activity() {
	}

	/**
	 * @param id
	 * @param name
	 * @param enterpriseList
	 */
	public Activity(Short id, String name, Set<Enterprise> enterpriseList) {
		this.id = id;
		this.name = name;
		this.enterpriseList = enterpriseList;
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
	 * @return the enterpriseList
	 */
	public Set<Enterprise> getEnterpriseList() {
		return enterpriseList;
	}

	/**
	 * @param enterpriseList the enterpriseList to set
	 */
	public void setEnterpriseList(Set<Enterprise> enterpriseList) {
		this.enterpriseList = enterpriseList;
	}
}