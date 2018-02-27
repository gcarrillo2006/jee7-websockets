package com.limits.surpass.export.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Entity that have profile
 * @author German
 */
@Entity
@Table(name = "profile", schema = "security")
public class Profile implements Serializable {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 4)
	private Short id;
	
	@Column(name = "name", length = 30, nullable = false)
	private String name;
	
	@ManyToMany(targetEntity = User.class, mappedBy = "profileList")
	private Set<User> userList;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "profile_role", joinColumns =
            @JoinColumn(name = "profile_id", referencedColumnName = "id"),
            inverseJoinColumns =
                @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<Role> roleList;
	
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
	 * @return the userList
	 */
	public Set<User> getUserList() {
		return userList;
	}

	/**
	 * @param userList the userList to set
	 */
	public void setUserList(Set<User> userList) {
		this.userList = userList;
	}

	/**
	 * @return the roleList
	 */
	public Set<Role> getRoleList() {
		return roleList;
	}

	/**
	 * @param roleList the roleList to set
	 */
	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}
}