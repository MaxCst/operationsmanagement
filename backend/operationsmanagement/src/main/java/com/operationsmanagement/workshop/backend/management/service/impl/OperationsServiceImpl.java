package com.operationsmanagement.workshop.backend.management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.operationsmanagement.workshop.backend.management.dao.OperationDAO;
import com.operationsmanagement.workshop.backend.management.dao.TransactionDAO;
import com.operationsmanagement.workshop.backend.management.model.Operation;
import com.operationsmanagement.workshop.backend.management.model.Transaction;
import com.operationsmanagement.workshop.backend.management.model.code.OperationType;
import com.operationsmanagement.workshop.backend.management.service.OperationsService;
import com.operationsmanagement.workshop.backend.management.service.TransactionsService;
import com.operationsmanagement.workshop.backend.system.exception.BusinessException;

@Service
public class OperationsServiceImpl implements OperationsService {

	@Autowired
	private TransactionsService transactionsService;

	@Autowired
	private OperationDAO operationDAO;

	@Autowired
	private TransactionDAO transactionDAO;

	@Override
	@Transactional(readOnly = false)
	public Operation createOperation(Operation operation) {
		return operationDAO.save(operation);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Operation> findOperationById(Long id) {
		return operationDAO.findOperationById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Operation> findOperationByCode(String operationCode) {
		return operationDAO.findOperationByCode(operationCode);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateOperation(Operation operation) {
		Operation toBeUpdated = operationDAO.findOperationById(operation.getId()).get();

		toBeUpdated.setActive(operation.getActive());
		toBeUpdated.setCode(operation.getCode());
		toBeUpdated.setName(operation.getName());

		operationDAO.update(toBeUpdated);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteOperation(Long id) {
		Operation toBeDeleted = operationDAO.findOperationById(id).get();
		operationDAO.remove(toBeDeleted);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Operation> findAllOperations() {
		return operationDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public void checkOperationType(Long transactionId, OperationType operationType) throws BusinessException {
		Transaction transaction = transactionsService.findTransactionById(transactionId).get();
		if (!transaction.getOperation().equals(findOperationByCode(operationType.name()).get())) {
			throw new BusinessException("El tipo de operacion de la transaccion no es validad para este proceso");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public void checkOperationType(Transaction transaction, OperationType operationType) throws BusinessException {
		if (!transaction.getOperation().equals(findOperationByCode(operationType.name()).get())) {
			throw new BusinessException("El tipo de operacion de la transaccion no es validad para este proceso");
		}
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteAllTransactions(Operation operation) {
		for (Transaction transaction : operation.getTransactions()) {
			transactionDAO.remove(transaction);
		}
	}

	@Override
	@Transactional(readOnly = false)
	public Operation copyOperationBasedOn(Operation source) {
		Operation target = new Operation();

		target.setCode(source.getCode() + "_copy");
		target.setName(source.getName() + "(copy)");
		target.setStateValues(source.getStateValues());
		target.setCategoryValues(source.getCategoryValues());

		target = this.operationDAO.save(target);

		return target;
	}

	@Override
	@Transactional(readOnly = true)
	public void initializeOperation(Operation operation) {
	}

}