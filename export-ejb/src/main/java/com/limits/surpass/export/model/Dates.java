package com.limits.surpass.export.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * Entity that represent a Dates between enterprise
 * @author German
 */

@Entity
@Table(name = "dates", schema = "application")
public class Dates implements Serializable {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 20)
	private Long id;
	
	@Column(name = "aprox_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date aproxDate;
	
	@Column(name = "description", length = 1023)
	private String description;
	
	@Column(name = "notes", length = 1023)
	private String notes;
	
	@Column(name = "priority", length = 10, nullable = false)
	private String priority;
	
	@Column(name = "realized", length = 1)
	private boolean realized;
	
	@ManyToMany(mappedBy = "datesList")
	private Set<Contact> contactList;
	
	/**
	 * Minimal Constructor 
	 */
	public Dates() {
	}

	/**
	 * @param id
	 * @param aproxDate
	 * @param description
	 * @param notes
	 * @param priority
	 * @param realized
	 * @param contactList
	 */
	public Dates(Long id, Date aproxDate, String description, String notes,
			String priority, boolean realized) {
            this.id = id;
            this.aproxDate = aproxDate;
            this.description = description;
            this.notes = notes;
            this.priority = priority;
            this.realized = realized;
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
	 * @return the aproxDate
	 */
	public Date getAproxDate() {
		return aproxDate;
	}
	
	/**
	 * @param aproxDate the aproxDate to set
	 */
	public void setAproxDate(Date date) {
		this.aproxDate = date;
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
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}
	
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}
	
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	/**
	 * @return the realized
	 */
	public boolean isRealized() {
		return realized;
	}
	
	/**
	 * @param realized the realized to set
	 */
	public void setRealized(boolean realized) {
		this.realized = realized;
	}

	/**
	 * @return the contactList
	 */
	public Set<Contact> getContactList() {
		return contactList;
	}

	/**
	 * @param contactList the contactList to set
	 */
	public void setContactList(Set<Contact> contactList) {
		this.contactList = contactList;
	}
}