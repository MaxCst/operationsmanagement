package com.operationsmanagement.workshop.backend.management.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class TransactionRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private Long id;
	private Date date;
	private byte[] data;
	private Boolean active;
	private Set<String> stateValuesCodes;
	private Set<String> categoryValuesCodes;
	private String operationCode;
	private String userCode;

	// Constructores

	public TransactionRequestDTO() {
		super();
	}

	public TransactionRequestDTO(Long id, Date date, byte[] data, Boolean active, Set<String> stateValuesCodes,
			Set<String> categoryValuesCodes, String operationCode, String userCode) {
		super();
		this.id = id;
		this.date = date;
		this.data = data;
		this.active = active;
		this.stateValuesCodes = stateValuesCodes;
		this.categoryValuesCodes = categoryValuesCodes;
		this.operationCode = operationCode;
		this.userCode = userCode;
	}

	// Equals & HashCode

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionRequestDTO other = (TransactionRequestDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	// Getters & Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Set<String> getStateValuesCodes() {
		return stateValuesCodes;
	}

	public void setStateValuesCodes(Set<String> stateValuesCodes) {
		this.stateValuesCodes = stateValuesCodes;
	}

	public Set<String> getCategoryValuesCodes() {
		return categoryValuesCodes;
	}

	public void setCategoryValuesCodes(Set<String> categoryValuesCodes) {
		this.categoryValuesCodes = categoryValuesCodes;
	}

	public String getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

}
