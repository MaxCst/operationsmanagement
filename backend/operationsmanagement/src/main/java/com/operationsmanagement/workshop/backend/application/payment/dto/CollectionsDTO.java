package com.operationsmanagement.workshop.backend.application.payment.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class CollectionsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	private Long collectTransaction;
	private BigDecimal amount;

	// Constructores

	public CollectionsDTO() {
		super();
	}

	public CollectionsDTO(Long collectTransaction, BigDecimal amount) {
		super();
		this.collectTransaction = collectTransaction;
		this.amount = amount;
	}

	// Getters & Setters

	public Long getCollectTransaction() {
		return collectTransaction;
	}

	public void setCollectTransaction(Long collectTransaction) {
		this.collectTransaction = collectTransaction;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
