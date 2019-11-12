package com.operationsmanagement.workshop.backend.system.dao;

import java.util.List;
import java.util.Optional;

import com.operationsmanagement.workshop.backend.system.model.StateValue;

public interface StateValueDAO {

	public StateValue save(StateValue stateValue);

	public Optional<StateValue> findStateValueById(Long id);

	public Optional<StateValue> findStateValueByCode(String svCode);

	public void update(StateValue stateValue);

	public void remove(StateValue stateValue);

	public List<StateValue> findAll();

}