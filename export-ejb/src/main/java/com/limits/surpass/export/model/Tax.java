package com.limits.surpass.export.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * Entity used form manage tax information
 * @author German
 */

@Entity
@Table(name = "tax", schema = "application")
public class Tax implements Serializable {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 20)
	private Long id;
	
	@Column(name = "name", length = 60, nullable = false)
	private String name;
	
	@Column(name = "description", length = 255)
	private String description;
	
	@Column(name = "percentage", precision = 2, length = 21, nullable = true)
	private BigDecimal percentage;
	
	@Column(name = "static_value", precision = 2, length = 21, nullable = true)
	private BigDecimal staticValue;

	@ManyToOne(targetEntity = City.class, optional = false)
	private City city;
	 
	public Tax() {
	}

	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param percentage
	 * @param staticValue
	 */
	public Tax(Long id, String name, String description, BigDecimal percentage,
			BigDecimal staticValue) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.percentage = percentage;
            this.staticValue = staticValue;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the percentage
	 */
	public BigDecimal getPercentage() {
		return percentage;
	}

	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}

	/**
	 * @return the staticValue
	 */
	public BigDecimal getStaticValue() {
		return staticValue;
	}

	/**
	 * @param staticValue the staticValue to set
	 */
	public void setStaticValue(BigDecimal staticValue) {
		this.staticValue = staticValue;
	}

	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}	
}
