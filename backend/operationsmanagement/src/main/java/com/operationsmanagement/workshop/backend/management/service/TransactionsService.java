package com.operationsmanagement.workshop.backend.management.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.operationsmanagement.workshop.backend.management.model.Operation;
import com.operationsmanagement.workshop.backend.management.model.Transaction;
import com.operationsmanagement.workshop.backend.system.model.User;

public interface TransactionsService {

	// Transactions CRUD Services

	public Transaction createTransaction(Transaction transaction);

	public Optional<Transaction> findTransactionById(Long id);

	public void updateTransaction(Transaction transaction);

	public void deleteTransaction(Transaction transaction);

	public List<Transaction> findAllTransactions();

	// View Support Services 

	public List<Transaction> findTransactionsByDateRange(Operation operationType, Date startDate, Date endDate);

	public List<Transaction> findTransactionsByDateRangeAndUser(Operation operationType, Date startDate, Date endDate,
			User user);

}
