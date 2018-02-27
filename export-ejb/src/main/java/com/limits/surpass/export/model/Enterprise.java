package com.limits.surpass.export.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Entity that represent an Enterprise
 * @author German
 */

@Entity
@Table(name = "enterprise", schema = "application")
@NamedQueries({
    @NamedQuery(name = "findEnterprises", query = "select e from Enterprise e "
        + "where e.name like :name"),
    @NamedQuery(name = "findEnterprisesWithBranches", query = "select e from Enterprise e "
        + "join fetch e.branchList where e.name like :name"),
    @NamedQuery(name = "findEnterprisesByUsername", query = "select e from Contact c "
        + "join c.enterprise e where c.username = :username")
})
@XmlRootElement
public class Enterprise implements Serializable {
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private Integer id;
	
	@Column(name = "name", length = 60, nullable = false)
	private String name;
	
	@Column(name = "notes", length = 1023)
	private String notes;
	
	@OneToOne(mappedBy = "enterprise", optional = true)
	private InvoiceInformation invoiceInformation;
	
	@ManyToOne(targetEntity = Activity.class, optional = true)
	private Activity activity;
	
	@OneToMany(mappedBy = "enterprise")
	private Set<Contact> contactList;
	
	@OneToMany(mappedBy = "enterprise")
	private Set<Branch> branchList;
	
	@Column(name = "priority", length = 3)
	private Short priority;
	
	@Transient
	private Set<Phone> phoneList;
	
	@Transient
	private Set<Stock> stockList;
	
	@ManyToOne(targetEntity = GroupEnterprise.class, optional = true)
	private GroupEnterprise groupEnterprise;
	
	/**
	 * Minimal Constructor
	 */
	public Enterprise() {
	}

	/**
	 * @param id
	 * @param name
	 * @param notes
	 * @param invoiceInformation
	 * @param activity
	 * @param branchList
	 * @param contactList
	 * @param priority
	 */
	public Enterprise(Integer id, String name, String notes,
			InvoiceInformation invoiceInformation, Activity activity,
			Set<Contact> contactList, Short priority) {
            this.id = id;
            this.name = name;
            this.notes = notes;
            this.invoiceInformation = invoiceInformation;
            this.activity = activity;
            this.contactList = contactList;
            this.priority = priority;
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
	 * @return the activity
	 */
	public Activity getActivity() {
            return activity;
	}

	/**
	 * @param activity the activity to set
	 */
	public void setActivity(Activity activity) {
            this.activity = activity;
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
	 * @return the priority
	 */
	public Short getPriority() {
            return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(Short priority) {
            this.priority = priority;
	}

	/**
	 * @return the groupEnterprise
	 */
	public GroupEnterprise getGroupEnterprise() {
            return groupEnterprise;
	}

	/**
	 * @param groupEnterprise the groupEnterprise to set
	 */
	public void setGroupEnterprise(GroupEnterprise groupEnterprise) {
            this.groupEnterprise = groupEnterprise;
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
	 * @return the stockList
	 */
	public Set<Stock> getStockList() {
            return stockList;
	}

	/**
	 * @param stockList the stockList to set
	 */
	public void setStockList(Set<Stock> stockList) {
            this.stockList = stockList;
	}

	/**
	 * @return the branchList
	 */
	public Set<Branch> getBranchList() {
            return branchList;
	}

	/**
	 * @param branchList the branchList to set
	 */
	public void setBranchList(Set<Branch> branchList) {
            this.branchList = branchList;
	}
	
	public String toString() {
		return "Enterprise [id="+id+", name="+name+", notes="+notes+", invoiceInformation="
					+invoiceInformation+", activity="+activity+", priority="+priority+"]";
	}
}