package com.operationsmanagement.workshop.backend.application.payment.dto;

import java.io.Serializable;
import java.util.Date;

public class PaymentsReportRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private String user;
	private String customer;
	private Date startDate;
	private Date endDate;
	private String status;
	private String viewType;

	// Constructores

	public PaymentsReportRequestDTO() {
		super();
	}

	public PaymentsReportRequestDTO(String user, String customer, Date startDate, Date endDate, String status,
			String viewType) {
		super();
		this.user = user;
		this.customer = customer;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.viewType = viewType;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getViewType() {
		return viewType;
	}

	public void setViewType(String viewType) {
		this.viewType = viewType;
	}
	
}
