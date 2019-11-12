package com.operationsmanagement.workshop.backend.management.dto;

import java.io.Serializable;
import java.util.Set;

public class ViewRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private Long id;
	private String code;
	private Boolean active;
	private String name;
	private Set<String> rolesCodes;
	private Set<String> stateValuesCodes;
	private Set<String> categoryValuesCodes;

	// Constructores

	public ViewRequestDTO() {
		super();
	}

	public ViewRequestDTO(Long id, String code, Boolean active, String name, Set<String> rolesCodes,
			Set<String> stateValuesCodes, Set<String> categoryValuesCodes) {
		super();
		this.id = id;
		this.code = code;
		this.active = active;
		this.name = name;
		this.rolesCodes = rolesCodes;
		this.stateValuesCodes = stateValuesCodes;
		this.categoryValuesCodes = categoryValuesCodes;
	}

	// Equals & HashCode

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		ViewRequestDTO other = (ViewRequestDTO) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getRolesCodes() {
		return rolesCodes;
	}

	public void setRolesCodes(Set<String> rolesCodes) {
		this.rolesCodes = rolesCodes;
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

}
