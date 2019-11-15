package com.operationsmanagement.workshop.backend.application.payment.dto;

import java.io.Serializable;

public class CreatePaymentRequestResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private Long paymentId;

	// Constructores

	public CreatePaymentRequestResponseDTO() {
		super();
	}

	public CreatePaymentRequestResponseDTO(Long paymentId) {
		super();
		this.paymentId = paymentId;
	}

	// Getters & Setters

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

}
