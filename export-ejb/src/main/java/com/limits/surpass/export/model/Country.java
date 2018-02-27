package com.limits.surpass.export.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * Entity that represents a country
 * @author German
 */

@Entity
@Table(name = "country", schema = "application")
@NamedQueries({
    @NamedQuery(name = "findCountrys", query = "select c from Country c "
        + "where c.name like :name")
})
public class Country implements Serializable {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 4)
	private Short id;
	
	@Column(name = "name", length = 60, nullable = false)
	private String name;
	
	@Column(name = "iso_code", length = 3)
	private String isoCode;
	
	@OneToMany(mappedBy = "country")
	private Set<State> stateList;

	/**
	 * Minimal Constructor 
	 */
	public Country() {
	}

	/**
	 * @param id
	 * @param name
	 * @param isoCode
	 * @param stateList
	 */
	public Country(Short id, String name, String isoCode, Set<State> stateList) {
		this.id = id;
		this.name = name;
		this.isoCode = isoCode;
		this.stateList = stateList;
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
	 * @return the isoCode
	 */
	public String getIsoCode() {
		return isoCode;
	}

	/**
	 * @param isoCode the isoCode to set
	 */
	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	/**
	 * @return the stateList
	 */
	public Set<State> getStateList() {
		return stateList;
	}

	/**
	 * @param stateList the stateList to set
	 */
	public void setStateList(Set<State> stateList) {
		this.stateList = stateList;
	}
}