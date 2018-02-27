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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * This Entity that stores the branch information of an Enterprise
 * @author German
 */

@Entity
@Table(name = "branch", schema = "application")
@NamedQueries({
	@NamedQuery(name = "findBranchesByEnterpriseId", query = "select b from Branch b "
			+ "where b.enterprise.id = :enterpriseId"),
    @NamedQuery(name = "findBranchesByEnterprise", query = "select b from Branch b "
        + "where b.enterprise = :enterprise and b.name like :name"),
    @NamedQuery(name = "findBranches", query = "select b from Branch b "
        + "where b.name like :name"),
    @NamedQuery(name = "findBranchesByUsername", query = "select b from Contact c "
        + "join c.branch b where c.username = :username")
})
public class Branch implements Serializable {
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;

        @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "enterprise_id", referencedColumnName = "id")
	private Enterprise enterprise;
		
	@Column(name = "name", length = 125)
	private String name;

        @Column(name = "address", length = 511, nullable = false)
	private String address;
	
	@Column(name = "url", length = 255)
	private String url;
	
	@Column(name = "notes", length = 1023)
	private String notes;
	
	@ManyToOne(targetEntity = City.class, optional = false)
	private City city;
	
	@ManyToMany(targetEntity = Business.class)
	@JoinTable(name = "branch_business", joinColumns=
            @JoinColumn(name = "branch_id", referencedColumnName = "id"),
        inverseJoinColumns =
            @JoinColumn(name = "business_id", referencedColumnName = "id"))
	private Set<Business> businessList;
	
	@OneToMany(mappedBy = "branch", fetch = FetchType.EAGER)
	private Set<Phone> phoneList;
	
	@OneToMany(mappedBy = "branch")
	private Set<Product> productList;
	
	@OneToMany(mappedBy = "branch")
	private Set<Contact> contactList;
	
	/**
	 * Minimal Constructor
	 */
	public Branch() {
	}
	
	/**
	 * @param id
	 * @param name
	 * @param address
	 * @param url
	 * @param notes
	 * @param invoiceInformation
	 * @param enterprise
	 * @param city
	 * @param businessList
	 * @param phoneList
	 * @param contactList
	 * @param productList
	 */
	public Branch(Integer id, String name, String address, String url,
			String notes, InvoiceInformation invoiceInformation,
			City city, Set<Business> businessList,
			Set<Phone> phoneList, Set<Contact> contactList,
			Set<Product> productList) {
		this.id = id;
                this.name = name;
                this.address = address;
		this.url = url;
		this.notes = notes;
		this.city = city;
		this.businessList = businessList;
		this.phoneList = phoneList;
		this.productList = productList;
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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * @return the businessList
	 */
	public Set<Business> getBusinessList() {
		return businessList;
	}

	/**
	 * @param businessList the businessList to set
	 */
	public void setBusinessList(Set<Business> businessList) {
		this.businessList = businessList;
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
	 * @return the productList
	 */
	public Set<Product> getProductList() {
		return productList;
	}

	/**
	 * @param productList the productList to set
	 */
	public void setProductList(Set<Product> productList) {
		this.productList = productList;
	}
}