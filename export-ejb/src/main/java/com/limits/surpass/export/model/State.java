package com.limits.surpass.export.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity that stores a state information
 * @author German
 *
 */

@Entity
@Table(name = "state", schema = "application")
@NamedQueries({
    @NamedQuery(name = "findStatesByCountry", query = "select s from State s "
        + "where s.country = :country and s.name like :name"),
    @NamedQuery(name = "findStates", query = "select s from State s "
        + "where s.name like :name")
})
public class State implements Serializable {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 5)
	private Short id;
	
	@ManyToOne(targetEntity = Country.class, optional = false)
	private Country country;
	
	@Column(name = "name", length = 60, nullable = false)
	private String name;
	

	@OneToMany(mappedBy = "state")
	private Set<City> cityList;
	
	/**
	 * Minimal Constructor
	 */
	public State() {
	}

	/**
	 * @param id
	 * @param country
	 * @param name
	 * @param cityList
	 */
	public State(Short id, Country country, String name,  Set<City> cityList) {
		this.id = id;
		this.country = country;
		this.name = name;
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
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
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
	 * @return the cityList
	 */
	public Set<City> getCityList() {
		return cityList;
	}

	/**
	 * @param cityList the cityList to set
	 */
	public void setStateList(Set<City> cityList) {
		this.cityList = cityList;
	}
}