package com.limits.surpass.export.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity that manage all catalogs
 * @author German
 */

@Entity
@Table(name = "catalog", schema = "application")
public class Catalog implements Serializable {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private Integer id;
	
	@Column(name = "name", length = 120, nullable = false)
	private String name;
	
	@Column(name = "scientific_name", length = 120)
	private String scientificName;
	
	@ManyToMany
	@JoinTable(name = "catalog_business", joinColumns =
        @JoinColumn(name = "catalog_id", referencedColumnName = "id"),
        inverseJoinColumns =
            @JoinColumn(name = "business_id", referencedColumnName = "id"))
	private Set<Business> businessList;
	
	@OneToMany(mappedBy = "catalog")
	private Set<Product> productList;

	/**
	 * Minimal Constructor 
	 */
	public Catalog() {
	}

	/**
	 * @param id
	 * @param name
	 * @param scientificName
	 * @param businessList
	 * @param productList
	 */
	public Catalog(Integer id, String name, String scientificName,
			Set<Business> businessList, Set<Product> productList) {
		this.id = id;
		this.name = name;
		this.scientificName = scientificName;
		this.businessList = businessList;
		this.productList = productList;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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
	 * @return the scientificName
	 */
	public String getScientificName() {
		return scientificName;
	}
	
	/**
	 * @param scientificName the scientificName to set
	 */
	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
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

	/**
	 * @return the productList
	 */
	public Set<Product> getProductList() {
		return productList;
	}

	/**
	 * @param productList the productList to set
	 */
	public void setProductList(Set<Product> productList) {
		this.productList = productList;
	}
}
