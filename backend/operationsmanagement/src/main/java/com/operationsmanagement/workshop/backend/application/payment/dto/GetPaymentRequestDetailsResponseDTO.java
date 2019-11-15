package com.operationsmanagement.workshop.backend.application.payment.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GetPaymentRequestDetailsResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private Long paymentRequest;
	private Date date;
	private String customer;
	private BigDecimal debt;
	private BigDecimal pendingDebt;

	// Constructores

	public GetPaymentRequestDetailsResponseDTO() {
		super();
	}

	public GetPaymentRequestDetailsResponseDTO(Long paymentRequest, Date date, String customer, BigDecimal debt,
			BigDecimal pendingDebt) {
		super();
		this.paymentRequest = paymentRequest;
		this.date = date;
		this.customer = customer;
		this.debt = debt;
		this.pendingDebt = pendingDebt;
	}

	// Getters & Setters

	public Long getPaymentRequest() {
		return paymentRequest;
	}

	public void setPaymentRequest(Long paymentRequest) {
		this.paymentRequest = paymentRequest;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public BigDecimal getDebt() {
		return debt;
	}

	public void setDebt(BigDecimal debt) {
		this.debt = debt;
	}

	public BigDecimal getPendingDebt() {
		return pendingDebt;
	}

	public void setPendingDebt(BigDecimal pendingDebt) {
		this.pendingDebt = pendingDebt;
	}

}
