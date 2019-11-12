package com.operationsmanagement.workshop.backend.management.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.operationsmanagement.workshop.backend.system.model.CategoryValue;
import com.operationsmanagement.workshop.backend.system.model.StateValue;
import com.operationsmanagement.workshop.backend.system.model.User;

@Entity
@Table(name = "transaction")
public class Transaction implements Serializable, Comparable<Transaction> {

	private static final long serialVersionUID = 1L;

	// Atributos

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_generator")
	@SequenceGenerator(name = "transaction_generator", sequenceName = "transaction_seq")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_id")
	private Transaction parent;

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	private Set<Transaction> children;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "operation_id")
	private Operation operation;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	@Column
	private Date date;

	@Type(type = "org.hibernate.type.BinaryType")
	@Column
	private byte[] data;

	@Column
	private Boolean active;

	@ManyToMany
	@JoinTable(name = "transaction_state_value", joinColumns = @JoinColumn(name = "transaction_id"), inverseJoinColumns = @JoinColumn(name = "value_id"))
	private Set<StateValue> stateValues;

	@ManyToMany
	@JoinTable(name = "transaction_category_value", joinColumns = @JoinColumn(name = "transaction_id"), inverseJoinColumns = @JoinColumn(name = "value_id"))
	private Set<CategoryValue> categoryValues;

	// Constructores

	public Transaction() {
		super();
	}

	public Transaction(Long id) {
		super();
		this.id = id;
	}

	public Transaction(Long id, Operation operation, User user, Date date, byte[] data, Boolean active,
			Set<StateValue> stateValues, Set<CategoryValue> categoryValues, Transaction parent,
			Set<Transaction> children) {
		super();
		this.id = id;
		this.operation = operation;
		this.user = user;
		this.date = date;
		this.data = data;
		this.active = active;
		this.stateValues = stateValues;
		this.categoryValues = categoryValues;
		this.parent = parent;
		this.children = children;
	}

	// Equals & HashCode

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Transaction other = (Transaction) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	// Comparator

	@Override
	public int compareTo(Transaction o) {
		if (this.id.equals(o.id)) {
			return 0;
		} else if (this.id > o.id) {
			return 1;
		} else {
			return -1;
		}
	}

	// Getters & Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
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

	public Set<CategoryValue> getCategoryValues() {
		return categoryValues;
	}

	public void setCategoryValues(Set<CategoryValue> categoryValues) {
		this.categoryValues = categoryValues;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Transaction getParent() {
		return parent;
	}

	public void setParent(Transaction parent) {
		this.parent = parent;
	}

	public Set<Transaction> getChildren() {
		return children;
	}

	public void setChildren(Set<Transaction> children) {
		this.children = children;
	}

	// Metodos de dominio

	public void addCategoryValue(CategoryValue cv) {
		this.categoryValues.add(cv);
	}

	public void removeCategoryValue(CategoryValue cv) {
		this.categoryValues.remove(cv);
	}

	public void addStateValue(StateValue newStateValue) {
		// If stateValues is null then return
		if (stateValues == null) {
			return;
		}
		// Clear all states values related to the new StateValue.
		// In this way we have only one value of an specific state at a time
		for (StateValue sv : this.stateValues) {
			if (sv.getState().equals(newStateValue.getState())) {
				this.stateValues.remove(sv);
			}
		}
		// Set new stateValue
		this.stateValues.add(newStateValue);
	}

	public void removeStateValue(StateValue sv) {
		this.stateValues.remove(sv);
	}

}