package com.limits.surpass.export.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Entity that matches all the characteristics of a product
 * @author German
 *
 */
@Entity
@Table(name = "characteristic", schema = "application")
public class Characteristic implements Serializable {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 4)
	private Short id;
	
	@Column(name = "name", length = 10)
	private String name;
	
	@Column(name = "characteristic", length = 10, precision = 2, nullable = false)
	private BigDecimal characteristic;
	
	@Column(name = "unit", length = 5, nullable = false)
	private String unit;

	/**
	 * Minimal Constructor
	 */
	public Characteristic() {
	}

	/**
	 * @param id
	 * @param name
	 * @param characteristic
	 * @param unit
	 */
	public Characteristic(Short id, String name, BigDecimal characteristic,
			String unit) {
		this.id = id;
		this.name = name;
		this.characteristic = characteristic;
		this.unit = unit;
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
	 * @return the characteristic
	 */
	public BigDecimal getCharacteristic() {
		return characteristic;
	}

	/**
	 * @param characteristic the characteristic to set
	 */
	public void setCharacteristic(BigDecimal characteristic) {
		this.characteristic = characteristic;
	}

	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}	
}