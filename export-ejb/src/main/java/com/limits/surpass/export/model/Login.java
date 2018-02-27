package com.limits.surpass.export.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the login database table.
 * 
 */
@Entity
@Table(name ="login", schema = "security")
@NamedQuery(name="Login.findAll", query="SELECT l FROM Login l")
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="log_id")
	private Integer id;

	@Column(name="log_password")
	private String password;

	@Column(name="log_username")
	private String username;
	
	@OneToOne(optional=true, cascade=CascadeType.ALL)
	@JoinColumn(name="ins_id", referencedColumnName="ins_id")
	private Inscription inscription;

	public Login() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Inscription getInscription() {
		return this.inscription;
	}

	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}