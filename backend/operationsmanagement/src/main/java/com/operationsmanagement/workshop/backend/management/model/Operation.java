package com.operationsmanagement.workshop.backend.management.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.operationsmanagement.workshop.backend.system.model.CategoryValue;
import com.operationsmanagement.workshop.backend.system.model.StateValue;

@Entity
@Table(name = "operation")
public class Operation implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operation_generator")
	@SequenceGenerator(name = "operation_generator", sequenceName = "operation_seq")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column
	private String code;

	@Column
	private String name;

	@Column
	private Boolean active;

	@OneToMany(mappedBy = "operation", fetch = FetchType.EAGER)
	private Set<Transaction> transactions;

	@ManyToMany
	@JoinTable(name = "operation_state_value", joinColumns = @JoinColumn(name = "operation_id"), inverseJoinColumns = @JoinColumn(name = "value_id"))
	private Set<StateValue> stateValues;

	@ManyToMany
	@JoinTable(name = "operation_category_value", joinColumns = @JoinColumn(name = "operation_id"), inverseJoinColumns = @JoinColumn(name = "value_id"))
	private Set<CategoryValue> categoryValues;

	// Constructores

	public Operation() {
		super();
	}

	public Operation(String code) {
		super();
		this.code = code;
	}

	public Operation(Long id, String code, String name, Boolean active, Set<Transaction> transactions,
			Set<StateValue> stateValues, Set<CategoryValue> categoryValues) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.active = active;
		this.transactions = transactions;
		this.stateValues = stateValues;
		this.categoryValues = categoryValues;
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
		Operation other = (Operation) obj;
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

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Set<StateValue> getStateValues() {
		return stateValues;
	}

	public void setStateValues(Set<StateValue> stateValues) {
		this.stateValues = stateValues;
	}

	public Set<CategoryValue> getCategoryValues() {
		return categoryValues;
	}

	public void setCategoryValues(Set<CategoryValue> categoryValues) {
		this.categoryValues = categoryValues;
	}

	// Metodos de dominio

	public void addTransaction(Transaction t) {
		this.transactions.add(t);
	}

	public void removeTransaction(Transaction t) {
		this.transactions.remove(t);
	}

	public void addStateValue(StateValue sv) {
		this.stateValues.add(sv);
	}

	public void removeStateValue(StateValue sv) {
		this.stateValues.remove(sv);
	}

	public void addCategoryValue(CategoryValue cv) {
		this.categoryValues.add(cv);
	}

	public void removeCategoryValue(CategoryValue cv) {
		this.categoryValues.remove(cv);
	}

}
