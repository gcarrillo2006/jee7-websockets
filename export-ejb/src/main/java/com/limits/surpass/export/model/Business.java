package com.limits.surpass.export.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * This Entity stores the business activity
 * for Example: Flower market, Shrimp market, Banano market, etc.
 * @author German
 */

@Entity
@Table(name = "business", schema = "application")
public class Business implements Serializable {
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 20)
	private Short id;
	
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	
	@ManyToOne(targetEntity = Sector.class, optional = false)
	private Sector sector;
	
	@ManyToMany(mappedBy = "businessList")
	private Set<Branch> branchList;
	
	@ManyToMany(mappedBy = "businessList")
	private Set<Catalog> catalogList;
	
	/**
	 * Minimal Constructor 
	 */
	public Business() {
	}

	/**
	 * @param id
	 * @param name
	 * @param businessSector
	 * @param sector
	 */
	public Business(Short id, String name, Sector sector) {
		this.id = id;
		this.name = name;
		this.sector = sector;
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
	 * @return the sector
	 */
	public Sector getSector() {
		return sector;
	}

	/**
	 * @param sector the sector to set
	 */
	public void setSector(Sector sector) {
		this.sector = sector;
	}

	/**
	 * @return the branchList
	 */
	public Set<Branch> getBranchList() {
		return branchList;
	}

	/**
	 * @param branchList the branchList to set
	 */
	public void setBranchList(Set<Branch> branchList) {
		this.branchList = branchList;
	}

	/**
	 * @return the catalogList
	 */
	public Set<Catalog> getCatalogList() {
		return catalogList;
	}

	/**
	 * @param catalogList the catalogList to set
	 */
	public void setCatalogList(Set<Catalog> catalogList) {
		this.catalogList = catalogList;
	}
}