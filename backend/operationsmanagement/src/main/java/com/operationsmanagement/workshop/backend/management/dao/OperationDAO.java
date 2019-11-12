package com.operationsmanagement.workshop.backend.management.dao;

import java.util.List;
import java.util.Optional;

import com.operationsmanagement.workshop.backend.management.model.Operation;

public interface OperationDAO {

	public Operation save(Operation operation);

	public Optional<Operation> findOperationById(Long id);

	public Optional<Operation> findOperationByCode(String operationCode);

	public void update(Operation operation);

	public void remove(Operation operation);

	public List<Operation> findAll();

}