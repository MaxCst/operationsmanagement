package com.operationsmanagement.workshop.backend.application.payment.dto;

import java.io.Serializable;

public class GetPaymentRequestDetailsRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private String user;
	private Long paymentRequest;

	// Constructores

	public GetPaymentRequestDetailsRequestDTO() {
		super();
	}

	public GetPaymentRequestDetailsRequestDTO(String user, Long paymentRequest) {
		super();
		this.user = user;
		this.paymentRequest = paymentRequest;
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

}
