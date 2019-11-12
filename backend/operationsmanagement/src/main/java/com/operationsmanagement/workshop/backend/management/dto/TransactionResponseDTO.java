package com.operationsmanagement.workshop.backend.management.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.operationsmanagement.workshop.backend.system.dto.CategoryValueResponseDTO;
import com.operationsmanagement.workshop.backend.system.dto.StateValueResponseDTO;
import com.operationsmanagement.workshop.backend.system.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class TransactionResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private Long id;
	private Date date;
	private byte[] data;
	private Boolean active;
	private Set<StateValueResponseDTO> stateValues;
	private Set<CategoryValueResponseDTO> categoryValues;
	@JsonIgnore
	private OperationResponseDTO operation;
	private User user;

	// Constructores

	public TransactionResponseDTO() {
		super();
	}

	public TransactionResponseDTO(Long id, Date date, byte[] data, Boolean active,
			Set<StateValueResponseDTO> stateValues, Set<CategoryValueResponseDTO> categoryValues,
			OperationResponseDTO operation, User user) {
		super();
		this.id = id;
		this.date = date;
		this.data = data;
		this.active = active;
		this.stateValues = stateValues;
		this.categoryValues = categoryValues;
		this.operation = operation;
		this.user = user;
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
		TransactionResponseDTO other = (TransactionResponseDTO) obj;
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

	public OperationResponseDTO getOperation() {
		return operation;
	}

	public void setOperation(OperationResponseDTO operation) {
		this.operation = operation;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Set<StateValueResponseDTO> getStateValues() {
		return stateValues;
	}

	public void setStateValues(Set<StateValueResponseDTO> stateValues) {
		this.stateValues = stateValues;
	}

	public Set<CategoryValueResponseDTO> getCategoryValues() {
		return categoryValues;
	}

	public void setCategoryValues(Set<CategoryValueResponseDTO> categoryValues) {
		this.categoryValues = categoryValues;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
