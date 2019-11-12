package com.operationsmanagement.workshop.backend.system.dto;

import java.io.Serializable;
import java.util.Set;

public class StateValueRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private Long id;
	private String code;
	private String name;
	private Boolean active;
	private String stateCode;
	private String parentCode;
	private Set<String> nextStateValueCodes;
	private Set<String> previousStateValueCodes;

	// Constructores

	public StateValueRequestDTO() {
		super();
	}

	public StateValueRequestDTO(Long id, String code, String name, Boolean active, String stateCode, String parentCode,
			Set<String> nextStateValueCodes, Set<String> previousStateValueCodes) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.active = active;
		this.stateCode = stateCode;
		this.parentCode = parentCode;
		this.nextStateValueCodes = nextStateValueCodes;
		this.previousStateValueCodes = previousStateValueCodes;
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
		StateValueRequestDTO other = (StateValueRequestDTO) obj;
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

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public Set<String> getNextStateValueCodes() {
		return nextStateValueCodes;
	}

	public void setNextStateValueCodes(Set<String> nextStateValueCodes) {
		this.nextStateValueCodes = nextStateValueCodes;
	}

	public Set<String> getPreviousStateValueCodes() {
		return previousStateValueCodes;
	}

	public void setPreviousStateValueCodes(Set<String> previousStateValueCodes) {
		this.previousStateValueCodes = previousStateValueCodes;
	}

}
