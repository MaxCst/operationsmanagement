package com.operationsmanagement.workshop.backend.system.dto;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class StateValueResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private Long id;
	private String code;
	private String name;
	private Boolean active;
	@JsonManagedReference
	private StateResponseDTO state;
	private StateValueResponseDTO parent;
	private Set<StateValueResponseDTO> nextStateValues;
	private Set<StateValueResponseDTO> previousStateValues;

	// Constructores

	public StateValueResponseDTO() {
		super();
	}

	public StateValueResponseDTO(Long id, String code, String name, Boolean active, StateValueResponseDTO parent,
			Set<StateValueResponseDTO> nextStateValues, Set<StateValueResponseDTO> previousStateValues) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.active = active;
		this.parent = parent;
		this.nextStateValues = nextStateValues;
		this.previousStateValues = previousStateValues;
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
		StateValueResponseDTO other = (StateValueResponseDTO) obj;
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

	public Set<StateValueResponseDTO> getNextStateValues() {
		return nextStateValues;
	}

	public void setNextStateValues(Set<StateValueResponseDTO> nextStateValues) {
		this.nextStateValues = nextStateValues;
	}

	public Set<StateValueResponseDTO> getPreviousStateValues() {
		return previousStateValues;
	}

	public void setPreviousStateValues(Set<StateValueResponseDTO> previousStateValues) {
		this.previousStateValues = previousStateValues;
	}

	public StateValueResponseDTO getParent() {
		return parent;
	}

	public void setParent(StateValueResponseDTO parent) {
		this.parent = parent;
	}

	public StateResponseDTO getState() {
		return state;
	}

	public void setState(StateResponseDTO state) {
		this.state = state;
	}

}
