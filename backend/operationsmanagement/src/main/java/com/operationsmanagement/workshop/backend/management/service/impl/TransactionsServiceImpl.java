package com.operationsmanagement.workshop.backend.management.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.operationsmanagement.workshop.backend.management.dao.TransactionDAO;
import com.operationsmanagement.workshop.backend.management.model.Operation;
import com.operationsmanagement.workshop.backend.management.model.Transaction;
import com.operationsmanagement.workshop.backend.management.service.TransactionsService;
import com.operationsmanagement.workshop.backend.system.model.User;

@Service
public class TransactionsServiceImpl implements TransactionsService {

	@Autowired
	private TransactionDAO transactionDAO;

	@Override
	@Transactional(readOnly = false)
	public Transaction createTransaction(Transaction transaction) {
		return transactionDAO.save(transaction);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Transaction> findTransactionById(Long id) {
		return transactionDAO.findTransactionById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateTransaction(Transaction transaction) {
		Transaction toBeUpdated = transactionDAO.findTransactionById(transaction.getId()).get();

		toBeUpdated.setActive(transaction.getActive());
		toBeUpdated.setData(transaction.getData());
		toBeUpdated.setDate(transaction.getDate());
		toBeUpdated.setCategoryValues(transaction.getCategoryValues());
		toBeUpdated.setOperation(transaction.getOperation());
		toBeUpdated.setStateValues(transaction.getStateValues());
		toBeUpdated.setUser(transaction.getUser());

		transactionDAO.update(toBeUpdated);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteTransaction(Transaction transaction) {
		transactionDAO.remove(transaction);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Transaction> findAllTransactions() {
		return transactionDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Transaction> findTransactionsByDateRange(Operation operationType, Date startDate, Date endDate) {
		return transactionDAO.findTransactionsByDateRange(operationType, startDate, endDate);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Transaction> findTransactionsByDateRangeAndUser(Operation operationType, Date startDate, Date endDate,
			User user) {
		return transactionDAO.findTransactionsByDateRangeAndUser(operationType, startDate, endDate, user);
	}

}