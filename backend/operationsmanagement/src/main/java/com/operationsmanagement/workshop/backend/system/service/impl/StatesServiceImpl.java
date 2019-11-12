package com.operationsmanagement.workshop.backend.system.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.operationsmanagement.workshop.backend.system.dao.StateDAO;
import com.operationsmanagement.workshop.backend.system.dao.StateValueDAO;
import com.operationsmanagement.workshop.backend.system.model.State;
import com.operationsmanagement.workshop.backend.system.model.StateValue;
import com.operationsmanagement.workshop.backend.system.service.StatesService;

@Service
public class StatesServiceImpl implements StatesService {

	@Autowired
	private StateDAO stateDAO;

	@Autowired
	private StateValueDAO stateValueDAO;

	@Override
	@Transactional(readOnly = false)
	public State createState(State state) {
		return stateDAO.save(state);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<State> findStateById(Long id) {
		return stateDAO.findStateById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<State> findStateByCode(String stateCode) {
		return stateDAO.findStateByCode(stateCode);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateState(State state) {
		State toBeUpdated = stateDAO.findStateById(state.getId()).get();

		toBeUpdated.setActive(state.getActive());
		toBeUpdated.setCode(state.getCode());
		toBeUpdated.setName(state.getName());

		stateDAO.update(toBeUpdated);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteState(Long id) {
		State toBeRemoved = stateDAO.findStateById(id).get();
		stateDAO.remove(toBeRemoved);
	}

	@Override
	@Transactional(readOnly = true)
	public List<State> findAllStates() {
		return stateDAO.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public StateValue createStateValue(StateValue stateValue) {
		return stateValueDAO.save(stateValue);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<StateValue> findStateValueById(Long id) {
		return stateValueDAO.findStateValueById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public Optional<StateValue> findStateValueByCode(String svCode) {
		return stateValueDAO.findStateValueByCode(svCode);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateStateValue(StateValue stateValue) {
		stateValueDAO.save(stateValue);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteStateValue(Long id) {
		StateValue toBeRemoved = stateValueDAO.findStateValueById(id).get();
		stateValueDAO.remove(toBeRemoved);
	}

	@Override
	@Transactional(readOnly = true)
	public List<StateValue> findAllStateValues() {
		return stateValueDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public StateValue getValueByState(Set<StateValue> source, State state) {
		for (StateValue sv : source) {
			if (sv.getState().equals(state)) {
				return sv;
			}
		}
		return null;
	}

}