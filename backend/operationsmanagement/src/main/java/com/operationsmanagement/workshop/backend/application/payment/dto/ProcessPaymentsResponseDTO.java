package com.operationsmanagement.workshop.backend.application.payment.dto;

import java.io.Serializable;

public class ProcessPaymentsResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private String resultStatus;
	private int numberProcessed;

	// Constructores

	public ProcessPaymentsResponseDTO() {
		super();
	}

	public ProcessPaymentsResponseDTO(String resultStatus, int numberProcessed) {
		super();
		this.resultStatus = resultStatus;
		this.numberProcessed = numberProcessed;
	}

	// Getters & Setters

	public String getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}

	public int getNumberProcessed() {
		return numberProcessed;
	}

	public void setNumberProcessed(int numberProcessed) {
		this.numberProcessed = numberProcessed;
	}

}
