package com.limits.surpass.export.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Entity that manager roles 
 * @author German
 */
@Entity
@Table(name = "role", schema = "security")
public class Role implements Serializable {
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private Integer id;
	
	@Column(name = "name", length = 30, nullable = false)
	private String name;
	
	@ManyToMany(targetEntity = Profile.class, mappedBy = "roleList")
	private Set<Profile> profileList;
	
	/**
	 * Minimal Constructor 
	 */
	public Role() {
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
	 * @return the profileList
	 */
	public Set<Profile> getProfileList() {
		return profileList;
	}

	/**
	 * @param profileList the profileList to set
	 */
	public void setProfileList(Set<Profile> profileList) {
		this.profileList = profileList;
	}
}