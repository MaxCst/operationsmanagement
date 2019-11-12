package com.operationsmanagement.workshop.backend.management.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.operationsmanagement.workshop.backend.management.model.Operation;
import com.operationsmanagement.workshop.backend.management.model.Transaction;
import com.operationsmanagement.workshop.backend.system.model.User;

public interface TransactionDAO {

	public Transaction save(Transaction transaction);

	public Optional<Transaction> findTransactionById(Long id);

	public void update(Transaction transaction);

	public void remove(Transaction transaction);

	public List<Transaction> findAll();

	public List<Transaction> findTransactionsByDateRange(Operation operationType, Date startDate, Date endDate);

	public List<Transaction> findTransactionsByDateRangeAndUser(Operation operationType, Date startDate, Date endDate,
			User user);

}