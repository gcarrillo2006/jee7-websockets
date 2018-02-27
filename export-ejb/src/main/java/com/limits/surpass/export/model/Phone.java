package com.limits.surpass.export.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entity that manage al phone number of enterprises and contacts
 * @author German
 */
@Entity
@Table(name = "phone", schema = "application")
public class Phone implements Serializable {
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 20)
	private Long id;
	
	@Column(name = "phone_number", length = 30, nullable = false)
	private String phoneNumber;
	
	@Transient
	private String dialPhone;
	
	@Column(name = "line_type", length = 30, nullable = false)
	private LineType lineType;
	
	@Column(name = "phone_extention", length = 12)
	private String phoneExtention;
	
	@ManyToOne(targetEntity = Branch.class, optional = true)
	private Branch branch;
	
	@ManyToOne(targetEntity = Contact.class, optional = true)
	private Contact contact;
	
	/**
	 * Minimal Constructor 
	 */
	public Phone() {
	}

	/**
	 * @param id
	 * @param phoneNumber
	 * @param lineType
	 * @param phoneExtention
	 */
	public Phone(Long id, String phoneNumber, LineType lineType,
			String phoneExtention) {
            this.id = id;
            this.phoneNumber = phoneNumber;
            this.lineType = lineType;
            this.phoneExtention = phoneExtention;
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
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
            return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the lineType
	 */
	public LineType getLineType() {
            return lineType;
	}

	/**
	 * @param lineType the lineType to set
	 */
	public void setLineType(LineType lineType) {
            this.lineType = lineType;
	}

	/**
	 * @return the phoneExtention
	 */
	public String getPhoneExtention() {
            return phoneExtention;
	}

	/**
	 * @param phoneExtention the phoneExtention to set
	 */
	public void setPhoneExtention(String phoneExtention) {
            this.phoneExtention = phoneExtention;
	}

	/**
	 * @return the branch
	 */
	public Branch getBranch() {
            return branch;
	}

	/**
	 * @param branch the branch to set
	 */
	public void setBranch(Branch branch) {
            this.branch = branch;
	}

	/**
	 * @return the contact
	 */
	public Contact getContact() {
            return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
            this.contact = contact;
	}

	/**
	 * @return the dialPhone
	 */
	public String getDialPhone() {
            this.dialPhone = "+";
            int i = this.phoneNumber.indexOf(")");
            this.dialPhone = this.dialPhone.concat(this.phoneNumber.substring(1, i));
            int j = this.phoneNumber.indexOf("-");
            this.dialPhone = this.dialPhone.concat(this.phoneNumber.substring(i+1, j));
            this.dialPhone = this.dialPhone.concat(this.phoneNumber.substring(j+1, this.phoneNumber.length()));
            return dialPhone;
	}

	/**
	 * @param dialPhone the dialPhone to set
	 */
	public void setDialPhone(String dialPhone) {
            this.dialPhone = dialPhone;
	}
}