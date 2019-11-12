package com.operationsmanagement.workshop.backend.system.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_generator")
	@SequenceGenerator(name = "category_generator", sequenceName = "category_seq")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column
	private String code;

	@Column
	private String name;

	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private Set<CategoryValue> categoryValues;

	@Column
	private Boolean active;

	// Constructores

	public Category() {
		super();
	}

	public Category(Long id, String code, String name, Set<CategoryValue> categoryValues, Boolean active) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.categoryValues = categoryValues;
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
		Category other = (Category) obj;
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

	public Set<CategoryValue> getCategoryValues() {
		return categoryValues;
	}

	public void setCategoryValues(Set<CategoryValue> categoryValues) {
		this.categoryValues = categoryValues;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	// Metodos de dominio

	public void addCategoryValue(CategoryValue cv) {
		this.categoryValues.add(cv);
	}

	public void removeCategoryValue(CategoryValue cv) {
		this.categoryValues.remove(cv);
	}

}
