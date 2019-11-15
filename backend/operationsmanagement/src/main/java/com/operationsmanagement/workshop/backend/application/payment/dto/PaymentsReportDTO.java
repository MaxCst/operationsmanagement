package com.operationsmanagement.workshop.backend.application.payment.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PaymentsReportDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private Long paymentRequest;
	private Date date;
	private String customer;
	private BigDecimal debt;
	private BigDecimal pendingDebt;
	private String paymentStatus;
	private CollectionsDTO collections;

	// Constructores

	public PaymentsReportDTO() {
		super();
	}

	public PaymentsReportDTO(Long paymentRequest, Date date, String customer, BigDecimal debt, BigDecimal pendingDebt,
			String paymentStatus, CollectionsDTO collections) {
		super();
		this.paymentRequest = paymentRequest;
		this.date = date;
		this.customer = customer;
		this.debt = debt;
		this.pendingDebt = pendingDebt;
		this.paymentStatus = paymentStatus;
		this.collections = collections;
	}

	// Equals & HashCode

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paymentRequest == null) ? 0 : paymentRequest.hashCode());
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
		PaymentsReportDTO other = (PaymentsReportDTO) obj;
		if (paymentRequest == null) {
			if (other.paymentRequest != null)
				return false;
		} else if (!paymentRequest.equals(other.paymentRequest))
			return false;
		return true;
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

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public CollectionsDTO getCollections() {
		return collections;
	}

	public void setCollections(CollectionsDTO collections) {
		this.collections = collections;
	}

}
