package com.operationsmanagement.workshop.backend.application.commons.dto;

import java.io.Serializable;

public class CustomerRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private String user;
	private String customer;

	// Constructores

	public CustomerRequestDTO() {
		super();
	}

	public CustomerRequestDTO(String user, String customer) {
		super();
		this.user = user;
		this.customer = customer;
	}

	// Getters & Setters

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

}
