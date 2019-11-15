package com.operationsmanagement.workshop.backend.application.payment.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CreatePaymentRequestRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private String user;
	private String customer;
	private Date date;
	private BigDecimal debt;

	// Constructor

	public CreatePaymentRequestRequestDTO() {
		super();
	}

	public CreatePaymentRequestRequestDTO(String user, String customer, Date date, BigDecimal debt) {
		super();
		this.user = user;
		this.customer = customer;
		this.date = date;
		this.debt = debt;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getDebt() {
		return debt;
	}

	public void setDebt(BigDecimal debt) {
		this.debt = debt;
	}

}
