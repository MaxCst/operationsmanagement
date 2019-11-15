package com.operationsmanagement.workshop.backend.application.payment.dto;

import java.io.Serializable;
import java.util.Date;

public class PendingPaymentRequestsReportRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private String user;
	private Date startDate;
	private Date endDate;

	// Constructores

	public PendingPaymentRequestsReportRequestDTO() {
		super();
	}

	public PendingPaymentRequestsReportRequestDTO(String user, Date startDate, Date endDate) {
		super();
		this.user = user;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	// Getters & Setters

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
