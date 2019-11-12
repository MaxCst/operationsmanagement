package com.operationsmanagement.workshop.backend.system.dto;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class StateResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private Long id;
	private String code;
	private String name;
	private Boolean active;
	@JsonBackReference
	private Set<StateValueResponseDTO> stateValues;

	// Constructores

	public StateResponseDTO() {
		super();
	}

	public StateResponseDTO(Long id, String code, String name, Boolean active, StateResponseDTO state,
			Set<StateValueResponseDTO> stateValues) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.active = active;
		this.stateValues = stateValues;
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
		StateResponseDTO other = (StateResponseDTO) obj;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
