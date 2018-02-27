package com.limits.surpass.export.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
/**
 * Entity that represents a Contact
 * @author German
 */

@Entity
@Table(name = "contact", schema = "application")
@PrimaryKeyJoinColumn(name = "username")
@DiscriminatorValue(value = "1")
@NamedQueries({
    @NamedQuery(name = "findContactsByEnterprise", query = "select c from Contact c "
        + "where c.enterprise = :enterprise and (c.firstName like :name or c.lastName like :name)"),
    @NamedQuery(name = "findContactsByBranch", query = "select c from Contact c "
        + "where c.branch = :branch and (c.firstName like :name or c.lastName like :name)")
})
public class Contact extends User implements Serializable {
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "responsability", length = 123)
	private String responsability;
	
	@Column(name = "first_name", length = 60, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 60, nullable = false)
	private String lastName;
	
	@Column(name = "gender", length = 10, nullable = false)
	private Gender gender;
	
	@Column(name = "skype", length = 45)
	private String skype;
	
	@Column(name = "address", length = 511)
	private String address;	
	
	@Column(name = "notes", length = 1023)
	private String notes;
	
	@OneToOne(mappedBy = "contact", optional = true)
	private InvoiceInformation invoiceInformation;
	
	@OneToMany(mappedBy = "contact", fetch = FetchType.EAGER)
	private Set<Phone> phoneList;	

	@ManyToMany(targetEntity = Dates.class)
	@JoinTable(name = "contact_dates", joinColumns=
		 	@JoinColumn(name = "contact_username", referencedColumnName = "username"),
        inverseJoinColumns=
        	@JoinColumn(name = "dates_id", referencedColumnName = "id"))
	private Set<Dates> datesList;
	
	@ManyToOne(targetEntity = Enterprise.class, optional = true)
	@JoinColumn(name = "enterprise_id", referencedColumnName = "id")
	private Enterprise enterprise;
	
	@ManyToOne(targetEntity = Branch.class, optional = true)
	@JoinColumn(name = "branch_id", referencedColumnName = "id")
	private Branch branch;
		
	/**
	 * Minimal Constructor
	 */
	public Contact() {
            super();
	}

	/**
	 * @param id
	 * @param responsability
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param skype
	 * @param address
	 * @param notes
	 * @param phoneList
	 * @param enterprise
	 * @param branch
	 */
	public Contact(String responsability, String firstName,
			String lastName, Gender gender, String skype, String address,
			String notes,Set<Phone> phoneList, Enterprise enterprise) {
		this.responsability = responsability;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.skype = skype;
		this.address = address;
		this.notes = notes;
		this.phoneList = phoneList;
		this.enterprise = enterprise;
	}

	/**
	 * @return the responsability
	 */
	public String getResponsability() {
		return responsability;
	}

	/**
	 * @param responsability the responsability to set
	 */
	public void setResponsability(String responsability) {
		this.responsability = responsability;
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
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the skype
	 */
	public String getSkype() {
		return skype;
	}

	/**
	 * @param skype the skype to set
	 */
	public void setSkype(String skype) {
		this.skype = skype;
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
	 * @return the invoiceInformation
	 */
	public InvoiceInformation getInvoiceInformation() {
		return invoiceInformation;
	}

	/**
	 * @param invoiceInformation the invoiceInformation to set
	 */
	public void setInvoiceInformation(InvoiceInformation invoiceInformation) {
		this.invoiceInformation = invoiceInformation;
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
	 * @return the phoneList
	 */
	public Set<Phone> getPhoneList() {
		return phoneList;
	}

	/**
	 * @param phoneList the phoneList to set
	 */
	public void setPhoneList(Set<Phone> phoneList) {
		this.phoneList = phoneList;
	}

	/**
	 * @return the datesList
	 */
	public Set<Dates> getDatesList() {
		return datesList;
	}

	/**
	 * @param datesList the datesList to set
	 */
	public void setDatesList(Set<Dates> datesList) {
		this.datesList = datesList;
	}
}
