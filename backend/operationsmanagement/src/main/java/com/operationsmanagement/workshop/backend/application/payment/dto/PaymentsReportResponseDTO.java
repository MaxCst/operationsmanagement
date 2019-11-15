package com.operationsmanagement.workshop.backend.application.payment.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class PaymentsReportResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private List<PaymentsReportDTO> paymentsReport;

	// Constructores

	public PaymentsReportResponseDTO() {
		super();
	}

	public PaymentsReportResponseDTO(List<PaymentsReportDTO> paymentsReport) {
		super();
		this.paymentsReport = paymentsReport;
	}
	
	// Getters & Setters
	
	public List<PaymentsReportDTO> getPaymentsReport() {
		return paymentsReport;
	}

	public void setPaymentsReport(List<PaymentsReportDTO> paymentsReport) {
		this.paymentsReport = paymentsReport;
	}

}
