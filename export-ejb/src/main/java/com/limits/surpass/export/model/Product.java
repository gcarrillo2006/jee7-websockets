package com.limits.surpass.export.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.Transient;


/**
 * Entity that manage all products
 * @author German
 */
@Entity
@Table(name = "product", schema = "application")
@NamedQueries({
    @NamedQuery(name = "findProductsByBranch", query = "select p from Product p "
        + "where p.branch = :branch and p.name like :name"),
    @NamedQuery(name = "findProducts", query = "select p from Product p "
        + "where p.name like :name")
})
public class Product implements Serializable {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private Integer id;
	
	@Column(name = "code", length = 15)
	private String code;
	
	@Column(name = "name", length = 120, nullable = false)
	private String name;
	
	@Column(name = "description", length = 123)
	private String description;
	
	@Column(name = "image")
	private byte[] image;
	
	@Column(name = "mime_type", length = 30)
	private String mimeType;
	
	@Column(name = "unitary_cost", precision = 2, length = 10, nullable = true)
	private BigDecimal unitaryCost;
	
	@Column(name = "unitary_price", precision = 2, length = 10, nullable = false)
	private BigDecimal unitaryPrice;
	
	@ManyToOne
	@JoinColumn(name = "catalog_id", referencedColumnName = "id")
	private Catalog catalog;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "branch_id", referencedColumnName = "id")
	private Branch branch;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "product_characteristic", joinColumns =
            @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns =
                @JoinColumn(name = "characteristic_id", referencedColumnName = "id"))
	private Set<Characteristic> characteristicList;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "product_tax", joinColumns =
            @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns =
                @JoinColumn(name = "tax_id", referencedColumnName = "id"))
	private Set<Tax> taxList;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Set<Stock> stockList;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Set<Reservation> reservationList;
	
	@Transient
	private Integer stock;
	
	/**
	 * Minimal Constructor
	 */
	public Product() {
	}
	
	/**
	 * @param id
	 * @param code
	 * @param name
	 * @param description
	 * @param image
	 * @param mimeType
	 * @param unitaryCost
	 * @param unitaryPrice
	 * @param catalog
	 * @param branch
	 * @param characteristicList
	 * @param taxList
	 * @param productMap
	 * @param stockList
	 */
	public Product(Integer id, String code, String name, String description,
			byte[] image, String mimeType, BigDecimal unitaryCost,
			BigDecimal unitaryPrice, Catalog catalog, Branch branch,
			Set<Characteristic> characteristicList, Set<Tax> taxList,
			Set<Stock> stockList) {
            this.id = id;
            this.code = code;
            this.name = name;
            this.description = description;
            this.image = image;
            this.mimeType = mimeType;
            this.unitaryCost = unitaryCost;
            this.unitaryPrice = unitaryPrice;
            this.catalog = catalog;
            this.branch = branch;
            this.characteristicList = characteristicList;
            this.taxList = taxList;
            this.stockList = stockList;
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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}

	/**
	 * @return the mimeType
	 */
	public String getMimeType() {
		return mimeType;
	}

	/**
	 * @param mimeType the mimeType to set
	 */
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	/**
	 * @return the unitaryCost
	 */
	public BigDecimal getUnitaryCost() {
		return unitaryCost;
	}

	/**
	 * @param unitaryCost the unitaryCost to set
	 */
	public void setUnitaryCost(BigDecimal unitaryCost) {
		this.unitaryCost = unitaryCost;
	}

	/**
	 * @return the unitaryPrice
	 */
	public BigDecimal getUnitaryPrice() {
		return unitaryPrice;
	}

	/**
	 * @param unitaryPrice the unitaryPrice to set
	 */
	public void setUnitaryPrice(BigDecimal unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}

	/**
	 * @return the catalogs
	 */
	public Catalog getCatalog() {
		return catalog;
	}

	/**
	 * @param catalog the catalogs to set
	 */
	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
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
	 * @return the taxList
	 */
	public Set<Tax> getTaxList() {
		return taxList;
	}

	/**
	 * @param taxList the taxList to set
	 */
	public void setTaxList(Set<Tax> taxList) {
		this.taxList = taxList;
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
	 * @return the characteristicList
	 */
	public Set<Characteristic> getCharacteristicList() {
		return characteristicList;
	}

	/**
	 * @param characteristicList the characteristicList to set
	 */
	public void setCharacteristicList(Set<Characteristic> characteristicList) {
		this.characteristicList = characteristicList;
	}

	/**
	 * @return the reservationList
	 */
	public Set<Reservation> getReservationList() {
		return reservationList;
	}

	/**
	 * @param reservationList the reservationList to set
	 */
	public void setReservationList(Set<Reservation> reservationList) {
		this.reservationList = reservationList;
	}

	/**
	 * @return the cumulative stock
	 */
	public Integer getStock() {
		return stock;
	}

	/**
	 * @param stock the stock calculated
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
}
