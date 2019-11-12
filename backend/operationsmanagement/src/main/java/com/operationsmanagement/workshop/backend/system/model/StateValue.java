package com.operationsmanagement.workshop.backend.system.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "state_value")
public class StateValue implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "state_value_generator")
	@SequenceGenerator(name = "state_value_generator", sequenceName = "state_value_seq")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "state_id")
	private State state;

	@Column
	private String code;

	@Column
	private String name;

	@Column
	private Boolean active;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_id")
	private StateValue parent;

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	private Set<StateValue> nextStateValues;

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	private Set<StateValue> previousStateValues;

	// Constructores

	public StateValue() {
		super();
	}

	public StateValue(String code) {
		super();
		this.code = code;
	}

	public StateValue(Long id, State state, String code, String name, Boolean active, StateValue parent,
			Set<StateValue> nextStateValues, Set<StateValue> previousStateValues) {
		super();
		this.id = id;
		this.state = state;
		this.code = code;
		this.name = name;
		this.active = active;
		this.parent = parent;
		this.nextStateValues = nextStateValues;
		this.previousStateValues = previousStateValues;
	}

	// Equals & HashCode

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StateValue other = (StateValue) obj;
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

	public Set<StateValue> getNextStateValues() {
		return nextStateValues;
	}

	public void setNextStateValues(Set<StateValue> nextStateValues) {
		this.nextStateValues = nextStateValues;
	}

	public Set<StateValue> getPreviousStateValues() {
		return previousStateValues;
	}

	public void setPreviousStateValues(Set<StateValue> previousStateValues) {
		this.previousStateValues = previousStateValues;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public StateValue getParent() {
		return parent;
	}

	public void setParent(StateValue parent) {
		this.parent = parent;
	}

}