package com.limits.surpass.export.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.limits.surpass.export.converter.GenderConverter;


/**
 * The persistent class for the inscription database table.
 * 
 */
@Entity
@Table(name = "inscription", schema = "security")
@NamedQuery(name="Inscription.findAll", query="SELECT i FROM Inscription i")
public class Inscription implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ins_id")
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="ins_birth_date")
	private Date birthDate;

	@Column(name="ins_first_name")
	private String firstName;

	@Convert(converter = GenderConverter.class)
	@Column(name="ins_gender")
	private Gender gender;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_inscription_date")
	private Date inscriptionDate;

	@Column(name="ins_last_name")
	private String lastName;

	public Inscription() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getInscriptionDate() {
		return this.inscriptionDate;
	}

	public void setInscriptionDate(Date inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}