package com.operationsmanagement.workshop.backend.system.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "category_value")
public class CategoryValue implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_value_generator")
	@SequenceGenerator(name = "category_value_generator", sequenceName = "category_value_seq")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column
	private String code;

	@Column
	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Category category;

	@Column
	private Boolean active;

	// Constructores

	public CategoryValue() {
		super();
	}

	public CategoryValue(Long id, String code, String name, Category category, Boolean active) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.category = category;
		this.active = active;
	}

	// Equals and Hashcode

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
		CategoryValue other = (CategoryValue) obj;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
