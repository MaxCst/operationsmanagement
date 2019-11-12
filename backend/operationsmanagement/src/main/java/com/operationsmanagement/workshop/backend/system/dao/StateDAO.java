package com.operationsmanagement.workshop.backend.system.dao;

import java.util.List;
import java.util.Optional;

import com.operationsmanagement.workshop.backend.system.model.State;

public interface StateDAO {

	public State save(State state);

	public Optional<State> findStateById(Long id);

	public Optional<State> findStateByCode(String stateCode);

	public void update(State state);

	public void remove(State state);

	public List<State> findAll();

}