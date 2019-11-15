package com.operationsmanagement.workshop.backend.application.payment.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SendPaymentResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private Long collectTransaction;
	private Date date;
	private String customer;
	private BigDecimal amount;
	private BigDecimal debt;
	private String result;

	// Constructores

	public SendPaymentResponseDTO() {
		super();
	}

	public SendPaymentResponseDTO(Long collectTransaction, Date date, String customer, BigDecimal amount,
			BigDecimal debt, String result) {
		super();
		this.collectTransaction = collectTransaction;
		this.date = date;
		this.customer = customer;
		this.amount = amount;
		this.debt = debt;
		this.result = result;
	}

	// Getters & Setters

	public Long getCollectTransaction() {
		return collectTransaction;
	}

	public void setCollectTransaction(Long collectTransaction) {
		this.collectTransaction = collectTransaction;
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getDebt() {
		return debt;
	}

	public void setDebt(BigDecimal debt) {
		this.debt = debt;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
