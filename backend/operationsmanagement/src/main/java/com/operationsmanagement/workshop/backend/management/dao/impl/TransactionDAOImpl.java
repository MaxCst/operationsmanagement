package com.operationsmanagement.workshop.backend.management.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.operationsmanagement.workshop.backend.management.dao.TransactionDAO;
import com.operationsmanagement.workshop.backend.management.model.Operation;
import com.operationsmanagement.workshop.backend.management.model.Transaction;
import com.operationsmanagement.workshop.backend.system.model.User;

@Repository
public class TransactionDAOImpl implements TransactionDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Transaction save(Transaction transaction) {
		transaction.setId(null);
		transaction.setActive(true);
		em.persist(transaction);
		return transaction;
	}

	@Override
	public Optional<Transaction> findTransactionById(Long id) {
		Optional<Transaction> transactionOptional = Optional.empty();
		return transactionOptional.ofNullable(em.find(Transaction.class, id));
	}

	@Override
	public void update(Transaction transaction) {
		em.merge(transaction);
	}

	@Override
	public void remove(Transaction transaction) {
		transaction.setActive(false);
		em.merge(transaction);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> findAll() {
		return em.createQuery("SELECT t FROM Transaction t WHERE t.active = true ORDER BY t.id").getResultList();
	}

	@Override
	public List<Transaction> findTransactionsByDateRange(Operation operationType, Date startDate, Date endDate) {
		TypedQuery<Transaction> typedQuery = em.createQuery(
				"SELECT t FROM Transaction t WHERE t.operation = :operationType AND t.date >= :startDate AND t.date <= :endDate",
				Transaction.class);
		typedQuery.setParameter("operationType", operationType);
		typedQuery.setParameter("startDate", startDate);
		typedQuery.setParameter("endDate", endDate);
		return typedQuery.getResultList();
	}

	@Override
	public List<Transaction> findTransactionsByDateRangeAndUser(Operation operationType, Date startDate, Date endDate,
			User user) {
		TypedQuery<Transaction> typedQuery = em.createQuery(
				"SELECT t FROM Transaction t WHERE t.operation = :operationType AND t.date >= :startDate AND t.date <= :endDate AND t.user = :user",
				Transaction.class);
		typedQuery.setParameter("operationType", operationType);
		typedQuery.setParameter("startDate", startDate);
		typedQuery.setParameter("endDate", endDate);
		typedQuery.setParameter("user", user);
		return typedQuery.getResultList();
	}

}