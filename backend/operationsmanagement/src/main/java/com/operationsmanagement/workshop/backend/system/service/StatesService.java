package com.operationsmanagement.workshop.backend.system.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.operationsmanagement.workshop.backend.system.model.State;
import com.operationsmanagement.workshop.backend.system.model.StateValue;

public interface StatesService {

	// States

	public State createState(State state);

	public Optional<State> findStateById(Long id);

	public Optional<State> findStateByCode(String stateCode);

	public void updateState(State state);

	public void deleteState(Long id);

	public List<State> findAllStates();

	// Values

	public StateValue createStateValue(StateValue stateValue);

	public Optional<StateValue> findStateValueById(Long id);

	public Optional<StateValue> findStateValueByCode(String svCode);

	public void updateStateValue(StateValue stateValue);

	public void deleteStateValue(Long id);

	public List<StateValue> findAllStateValues();

	public StateValue getValueByState(Set<StateValue> source, State state);

}