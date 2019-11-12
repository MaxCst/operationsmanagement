package com.operationsmanagement.workshop.backend.management.service;

import java.util.List;
import java.util.Optional;

import com.operationsmanagement.workshop.backend.management.model.Operation;
import com.operationsmanagement.workshop.backend.management.model.Transaction;
import com.operationsmanagement.workshop.backend.management.model.code.OperationType;
import com.operationsmanagement.workshop.backend.system.exception.BusinessException;

public interface OperationsService {

	// Operations

	public Operation createOperation(Operation operation);

	public Optional<Operation> findOperationById(Long id);

	public Optional<Operation> findOperationByCode(String operationCode);

	public void updateOperation(Operation operation);

	public void deleteOperation(Long id);

	public List<Operation> findAllOperations();

	// Operation services

	public void checkOperationType(Long paymentId, OperationType paymentoperation) throws BusinessException;

	public void checkOperationType(Transaction transaction, OperationType operation) throws BusinessException;

	public void deleteAllTransactions(Operation operation);

	public Operation copyOperationBasedOn(Operation operation);

	public void initializeOperation(Operation operation);

}