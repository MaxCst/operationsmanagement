package com.operationsmanagement.workshop.backend.system.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CategoryValueResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private Long id;
	private String code;
	private String name;
	private Boolean active;
	@JsonIgnore
	private CategoryResponseDTO category;

	// Constructores

	public CategoryValueResponseDTO() {
		super();
	}

	public CategoryValueResponseDTO(Long id, CategoryResponseDTO category, String code, String name, Boolean active) {
		super();
		this.id = id;
		this.category = category;
		this.code = code;
		this.name = name;
		this.active = active;
	}

	// Equals & Hashcode

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
		CategoryValueResponseDTO other = (CategoryValueResponseDTO) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	// Getters & setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CategoryResponseDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryResponseDTO category) {
		this.category = category;
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

}