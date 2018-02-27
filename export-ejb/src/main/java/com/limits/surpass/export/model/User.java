package com.limits.surpass.export.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/**
 * Entity that manage the users
 * @author German
 */

@Entity
@Table(name = "user", schema = "security")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value = "0")
@NamedQueries({
    @NamedQuery(name = "findUser", query = "select u from User u "
        + "where u.username = :username and u.password = :password")
})
public class User implements Serializable {
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "username", length = 15, nullable = false, unique = true)
	private String username;
	
	@Column(name = "passwd", length = 30, nullable = false)
	private String password;
	
	@Column(name = "email", length = 255, nullable = false)
	private String email;
	
	@Column(name = "active")
	private Boolean active;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_profile", joinColumns =
		@JoinColumn(name = "user_username", referencedColumnName = "username"),
		inverseJoinColumns =
            @JoinColumn(name = "profile_id", referencedColumnName = "id"))
	private Set<Profile> profileList;
	
	/**
	 * Minimal Constructor
	 */
	public User() {
	}

	/**
	 * @param username
	 * @param password
	 * @param email
	 * @param profileList
	 */
	public User(String username, String password, String email, Set<Profile> profileList) {
            this.username = username;
            this.password = password;
            this.email = email;
            this.profileList = profileList;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}	
}