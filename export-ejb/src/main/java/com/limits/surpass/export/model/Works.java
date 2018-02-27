package com.limits.surpass.export.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity used for store works send's to partners
 * @author German
 */
@Entity
@Table(name = "works", schema = "application")
public class Works implements Serializable {
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 20)
	private Long id;
	
	@Column(name = "send_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date sendDate;
	
	@Column(name = "aprox_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date aproxDate;
	
	@Column(name = "real_date", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date realDate;
	
	@Column(name = "name", length = 60, nullable = false)
	private String name;
	
	@Column(name = "description", length = 255)
	private String description;
	
	@Column(name = "status", length = 10, nullable = true)
	private String status;
	
	// Is the username of the person that send the message
	@Column(name = "send_by", length = 15, nullable = false)
	private String sendBy;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "works_contact")
	private Set<Contact> contactList;
	
	@Column(name = "notes")
	private String notes;
	
	/**
	 * Minimal Constructor
	 */
	public Works() {
	}
	
	/**
	 * @param id
	 * @param sendDate
	 * @param aproxDate
	 * @param realDate
	 * @param name
	 * @param description
	 * @param status
	 * @param sendBy
	 * @param contactList
	 */
	public Works(Long id, Date sendDate, Date aproxDate, Date realDate,
			String name, String description, String status, String sendBy, Set<Contact> contactList) {
            this.id = id;
            this.sendDate = sendDate;
            this.aproxDate = aproxDate;
            this.realDate = realDate;
            this.name = name;
            this.description = description;
            this.status = status;
            this.sendBy = sendBy;
            this.contactList = contactList;
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
	 * @return the sendDate
	 */
	public Date getSendDate() {
		return sendDate;
	}
	
	/**
	 * @param sendDate the sendDate to set
	 */
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
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
	public void setAproxDate(Date aproxDate) {
		this.aproxDate = aproxDate;
	}
	
	/**
	 * @return the realDate
	 */
	public Date getRealDate() {
		return realDate;
	}
	
	/**
	 * @param realDate the realDate to set
	 */
	public void setRealDate(Date realDate) {
		this.realDate = realDate;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * @return the sendBy
	 */
	public String getSendBy() {
		return sendBy;
	}
	
	/**
	 * @param sendBy the sendBy to set
	 */
	public void setSendBy(String sendBy) {
		this.sendBy = sendBy;
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