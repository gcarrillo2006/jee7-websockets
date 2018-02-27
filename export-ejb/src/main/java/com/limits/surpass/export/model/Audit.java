package com.limits.surpass.export.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="audit", schema = "control")
public class Audit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="aud_id")
	private Long id;
	
	@Column(name="aud_username")
	private String username;
	
	@Column(name="aud_entity")
	private String entity;
	
	@Column(name="aud_java_column")
	private String column;
	
	@Column(name="aud_old_Data")
	private String oldData;
	
	@Column(name="aud_new_Data")
	private String newData;
	
	@Column(name="aud_modification_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar modificationDate;
	
	/**
	 * Minimal Constructor
	 */
	public Audit() {
	}

	/**
	 * @param id
	 * @param username
	 * @param entity
	 * @param column
	 * @param oldData
	 * @param newData
	 * @param modificationDate
	 */
	public Audit(Long id, String username, String entity, String column,
			String oldData, String newData, Calendar modificationDate) {
		this.id = id;
		this.username = username;
		this.entity = entity;
		this.column = column;
		this.oldData = oldData;
		this.newData = newData;
		this.modificationDate = modificationDate;
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
	 * @return the entity
	 */
	public String getEntity() {
		return entity;
	}

	/**
	 * @param entity the entity to set
	 */
	public void setEntity(String entity) {
		this.entity = entity;
	}

	/**
	 * @return the column
	 */
	public String getColumn() {
		return column;
	}

	/**
	 * @param column the column to set
	 */
	public void setColumn(String column) {
		this.column = column;
	}

	/**
	 * @return the oldData
	 */
	public String getOldData() {
		return oldData;
	}

	/**
	 * @param oldData the oldData to set
	 */
	public void setOldData(String oldData) {
		this.oldData = oldData;
	}

	/**
	 * @return the newData
	 */
	public String getNewData() {
		return newData;
	}

	/**
	 * @param newData the newData to set
	 */
	public void setNewData(String newData) {
		this.newData = newData;
	}

	/**
	 * @return the modificationDate
	 */
	public Calendar getModificationDate() {
		return modificationDate;
	}

	/**
	 * @param modificationDate the modificationDate to set
	 */
	public void setModificationDate(Calendar modificationDate) {
		this.modificationDate = modificationDate;
	}
}
