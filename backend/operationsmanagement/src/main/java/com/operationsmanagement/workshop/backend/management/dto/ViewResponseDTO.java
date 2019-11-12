package com.operationsmanagement.workshop.backend.management.dto;

import java.io.Serializable;
import java.util.Set;

import com.operationsmanagement.workshop.backend.system.dto.CategoryValueResponseDTO;
import com.operationsmanagement.workshop.backend.system.dto.RoleResponseDTO;
import com.operationsmanagement.workshop.backend.system.dto.StateValueResponseDTO;

public class ViewResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private Long id;
	private String code;
	private Boolean active;
	private String name;
	private Set<RoleResponseDTO> roles;
	private Set<StateValueResponseDTO> stateValues;
	private Set<CategoryValueResponseDTO> categoryValues;

	// Constructores

	public ViewResponseDTO() {
		super();
	}

	public ViewResponseDTO(Long id, String code, Boolean active, String name, Set<RoleResponseDTO> roles,
			Set<StateValueResponseDTO> stateValues, Set<CategoryValueResponseDTO> categoryValues) {
		super();
		this.id = id;
		this.code = code;
		this.active = active;
		this.name = name;
		this.roles = roles;
		this.stateValues = stateValues;
		this.categoryValues = categoryValues;
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
		ViewResponseDTO other = (ViewResponseDTO) obj;
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

	public Set<RoleResponseDTO> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleResponseDTO> roles) {
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
