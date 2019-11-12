package com.operationsmanagement.workshop.backend.system.dto;

import java.io.Serializable;

public class RoleRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private Long id;
	private String code;
	private Boolean active;
	private String name;

	// Constructores

	public RoleRequestDTO() {
		super();
	}

	public RoleRequestDTO(Long id, String code, Boolean active, String name) {
		super();
		this.id = id;
		this.code = code;
		this.active = active;
		this.name = name;
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
		RoleRequestDTO other = (RoleRequestDTO) obj;
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

}
