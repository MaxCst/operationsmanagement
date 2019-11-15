package com.operationsmanagement.workshop.backend.application.payment.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class SendPaymentRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private String user;
	private Long paymentRequest;
	private String paymentMethodType;
	private BigDecimal amount;

	// Constructores

	public SendPaymentRequestDTO() {
		super();
	}

	public SendPaymentRequestDTO(String user, Long paymentRequest, String paymentMethodType, BigDecimal amount) {
		super();
		this.user = user;
		this.paymentRequest = paymentRequest;
		this.paymentMethodType = paymentMethodType;
		this.amount = amount;
	}

	// Getters & Setters

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Long getPaymentRequest() {
		return paymentRequest;
	}

	public void setPaymentRequest(Long paymentRequest) {
		this.paymentRequest = paymentRequest;
	}

	public String getPaymentMethodType() {
		return paymentMethodType;
	}

	public void setPaymentMethodType(String paymentMethodType) {
		this.paymentMethodType = paymentMethodType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
