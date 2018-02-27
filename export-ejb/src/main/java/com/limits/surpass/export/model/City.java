package com.limits.surpass.export.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity that stores a city information
 * @author German
 *
 */

@Entity
@Table(name = "city", schema = "application")
@NamedQueries({
    @NamedQuery(name = "findCitiesByCountry", query = "select c from City c "
        + "where c.state.country = :country and c.name like :name"),
    @NamedQuery(name = "findCitiesByState", query = "select c from City c "
            + "where c.state = :state and c.name like :name"),
    @NamedQuery(name = "findCities", query = "select c from City c "
        + "where c.name like :name")
})
public class City implements Serializable {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 5)
	private Short id;
	
	@ManyToOne(targetEntity = State.class, optional = false)
	private State state;
	
	@Column(name = "name", length = 60, nullable = false)
	private String name;
	
	/**
	 * Minimal Constructor
	 */
	public City() {
	}

	/**
	 * @param id
	 * @param state
	 * @param name
	 */
	public City(Short id, State state, String name) {
		this.id = id;
		this.state = state;
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
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
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
}