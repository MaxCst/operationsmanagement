package com.operationsmanagement.workshop.backend.management.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.operationsmanagement.workshop.backend.management.dao.OperationDAO;
import com.operationsmanagement.workshop.backend.management.model.Operation;

@Repository
public class OperationDAOImpl implements OperationDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Operation save(Operation operation) {
		operation.setId(null);
		operation.setActive(true);
		em.persist(operation);
		return operation;
	}

	@Override
	public Optional<Operation> findOperationById(Long id) {
		Optional<Operation> operationOptional = Optional.empty();
		return operationOptional.ofNullable(em.find(Operation.class, id));
	}

	@Override
	public Optional<Operation> findOperationByCode(String operationCode) {
		Optional<Operation> operationOptional = Optional.empty();
		TypedQuery<Operation> queryResult = em.createQuery(
				"SELECT o FROM Operation o WHERE o.active = true AND o.code = :operationCode", Operation.class);
		queryResult.setParameter("operationCode", operationCode);
		return operationOptional.ofNullable(queryResult.getSingleResult());
	}

	@Override
	public void update(Operation operation) {
		em.merge(operation);
	}

	@Override
	public void remove(Operation operation) {
		operation.setActive(false);
		em.merge(operation);

	}

	@Override
	public List<Operation> findAll() {
		return em.createQuery("SELECT o FROM Operation o WHERE o.active = true ORDER BY o.code").getResultList();
	}

}