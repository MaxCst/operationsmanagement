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
@Table(name = "state")
public class State implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "state_generator")
	@SequenceGenerator(name = "state_generator", sequenceName = "state_seq")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column
	private String code;

	@Column
	private String name;

	@Column
	private Boolean active;

	@OneToMany(mappedBy = "state", fetch = FetchType.LAZY)
	private Set<StateValue> stateValues;

	// Constructores

	public State() {
		super();
	}

	public State(Long id, String code, String name, Boolean active, Set<StateValue> stateValues) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.active = active;
		this.stateValues = stateValues;
	}

	// Equals & hashcode

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Set<StateValue> getStateValues() {
		return stateValues;
	}

	public void setStateValues(Set<StateValue> stateValues) {
		this.stateValues = stateValues;
	}

	// Metodos de dominio

	public void addStateValue(StateValue sv) {
		this.stateValues.add(sv);
	}

	public void removeStateValue(StateValue sv) {
		this.stateValues.remove(sv);
	}

}