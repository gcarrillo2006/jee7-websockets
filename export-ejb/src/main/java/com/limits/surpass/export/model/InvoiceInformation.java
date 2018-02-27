package com.limits.surpass.export.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * Entity that contains an invoice information
 * @author German
 *
 */

@Entity
@Table(name = "invoice_information", schema = "application")
public class InvoiceInformation implements Serializable {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private Integer id;
	
	/**
	 * Its like a RUC in equator
	 */
	@Column(name = "invoice_information", length = 20, nullable = false)
	private String invoiceInformation;
	
	/**
	 * Defines if its a legal person or natural
	 */
	@Column(name = "type", length = 7)
	private PersonType type;
	
	/**
	 * Defines a provider or a client
	 */
	@Column(name = "provider", length = 1)
	private boolean provider;
	
	@OneToOne(optional = true)
	private Enterprise enterprise;
	
	@OneToOne(optional = true)
	private Contact contact;

	/**
	 * Minimal Constructor 
	 */
	public InvoiceInformation() {
	}

	/**
	 * @param id
	 * @param invoiceInformation
	 * @param type
	 * @param provider
	 * @param enterprise
	 * @param branch
	 * @param contact
	 */
	public InvoiceInformation(Integer id, String invoiceInformation, PersonType type,
			boolean provider, Enterprise enterprise,Contact contact) {
            this.id = id;
            this.invoiceInformation = invoiceInformation;
            this.type = type;
            this.provider = provider;
            this.enterprise = enterprise;
            this.contact = contact;
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
	 * @return the invoiceInformation
	 */
	public String getInvoiceInformation() {
            return invoiceInformation;
	}

	/**
	 * @param invoiceInformation the invoiceInformation to set
	 */
	public void setInvoiceInformation(String invoiceInformation) {
            this.invoiceInformation = invoiceInformation;
	}

	/**
	 * @return the type
	 */
	public PersonType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(PersonType type) {
		this.type = type;
	}

	/**
	 * @return the enterprise
	 */
	public Enterprise getEnterprise() {
            return enterprise;
	}

	/**
	 * @param enterprise the enterprise to set
	 */
	public void setEnterprise(Enterprise enterprise) {
            this.enterprise = enterprise;
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
	 * @return the provider
	 */
	public boolean isProvider() {
            return provider;
	}

	/**
	 * @param provider the provider to set
	 */
	public void setProvider(boolean provider) {
            this.provider = provider;
	}
}