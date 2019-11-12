package com.operationsmanagement.workshop.backend.management.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.operationsmanagement.workshop.backend.system.model.CategoryValue;
import com.operationsmanagement.workshop.backend.system.model.Role;
import com.operationsmanagement.workshop.backend.system.model.StateValue;

@Entity
@Table(name = "view")
public class View implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "view_generator")
	@SequenceGenerator(name = "view_generator", sequenceName = "view_seq")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column
	private String code;

	@Column
	private String name;

	@Column
	private Boolean active;

	@ManyToMany
	@JoinTable(name = "view_role", joinColumns = @JoinColumn(name = "view_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	@ManyToMany
	@JoinTable(name = "view_category_value", joinColumns = @JoinColumn(name = "view_id"), inverseJoinColumns = @JoinColumn(name = "value_id"))
	private Set<CategoryValue> categoryValues;

	@ManyToMany
	@JoinTable(name = "view_state_value", joinColumns = @JoinColumn(name = "view_id"), inverseJoinColumns = @JoinColumn(name = "value_id"))
	private Set<StateValue> stateValues;

	// Constructores

	public View() {
		super();
	}

	public View(Long id, String code, String name, Boolean active, Set<Role> roles, Set<CategoryValue> categoryValues,
			Set<StateValue> stateValues) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.active = active;
		this.roles = roles;
		this.categoryValues = categoryValues;
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
		View other = (View) obj;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<CategoryValue> getCategoryValues() {
		return categoryValues;
	}

	public void setCategoryValues(Set<CategoryValue> categoryValues) {
		this.categoryValues = categoryValues;
	}

	public Set<StateValue> getStateValues() {
		return stateValues;
	}

	public void setStateValues(Set<StateValue> stateValues) {
		this.stateValues = stateValues;
	}

}
