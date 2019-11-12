package com.operationsmanagement.workshop.backend.system.dto;

import java.io.Serializable;
import java.util.Set;

public class UserResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private Long id;
	private String email;
	private String code;
	private String name;
	private Boolean active;
	private Set<RoleResponseDTO> roles;

	// Constructores

	public UserResponseDTO() {
		super();
	}

	public UserResponseDTO(Long id, String email, String code, Boolean active, String name,
			Set<RoleResponseDTO> roles) {
		super();
		this.id = id;
		this.email = email;
		this.code = code;
		this.name = name;
		this.active = active;
		this.roles = roles;
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
		UserResponseDTO other = (UserResponseDTO) obj;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
