package com.limits.surpass.export.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="sales", schema="application")
public class Sales {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sal_id")
	private Integer id;
	
	@Column(name="sal_first_name")
	private String firstName;
	
	@Column(name="sal_last_name")
	private String lastName;
	
	@Column(name="sal_birth_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthDate;
	
	@Column(name="sal_address")
	private String address;
	
	@OneToMany
	private Set<Phone> phones;
	
	@Column(name="sal_title")
	private String title;
	
	@OneToOne(targetEntity=User.class)
	private User user;
	
	/**
	 * Minimal Constructor
	 */
	public Sales() {
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 * @param address
	 * @param phones
	 * @param title
	 */
	public Sales(Integer id, String firstName, String lastName,
			Date birthDate, String address, Set<Phone> phones, String title, User user) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.address = address;
		this.phones = phones;
		this.title = title;
		this.user = user;
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}
	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the phones
	 */
	public Set<Phone> getPhones() {
		return phones;
	}
	/**
	 * @param phones the phones to set
	 */
	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
