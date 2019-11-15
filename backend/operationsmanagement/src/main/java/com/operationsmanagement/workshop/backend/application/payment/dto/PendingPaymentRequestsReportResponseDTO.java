package com.operationsmanagement.workshop.backend.application.payment.dto;

import java.io.Serializable;
import java.util.Set;

public class PendingPaymentRequestsReportResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private Set<PaymentRequestsDTO> pendingPaymentRequestsReport;

	// Constructores

	public PendingPaymentRequestsReportResponseDTO() {
		super();
	}

	public PendingPaymentRequestsReportResponseDTO(Set<PaymentRequestsDTO> pendingPaymentRequestsReport) {
		super();
		this.pendingPaymentRequestsReport = pendingPaymentRequestsReport;
	}

	// Getters & setters

	public Set<PaymentRequestsDTO> getPendingPaymentRequestsReport() {
		return pendingPaymentRequestsReport;
	}

	public void setPendingPaymentRequestsReport(Set<PaymentRequestsDTO> pendingPaymentRequestsReport) {
		this.pendingPaymentRequestsReport = pendingPaymentRequestsReport;
	}

}
