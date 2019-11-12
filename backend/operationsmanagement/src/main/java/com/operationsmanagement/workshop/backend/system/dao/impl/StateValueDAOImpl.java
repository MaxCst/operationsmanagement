package com.operationsmanagement.workshop.backend.system.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.operationsmanagement.workshop.backend.system.dao.StateValueDAO;
import com.operationsmanagement.workshop.backend.system.model.StateValue;

@Repository
public class StateValueDAOImpl implements StateValueDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public StateValue save(StateValue stateValue) {
		stateValue.setId(null);
		stateValue.setActive(true);
		em.persist(stateValue);
		return stateValue;
	}

	@Override
	public void update(StateValue stateValue) {
		em.merge(stateValue);
	}

	@Override
	public void remove(StateValue stateValue) {
		stateValue.setActive(false);
		em.merge(stateValue);
	}

	@Override
	public Optional<StateValue> findStateValueById(Long id) {
		return Optional.ofNullable(em.find(StateValue.class, id));
	}

	@Override
	public Optional<StateValue> findStateValueByCode(String svCode) {
		Optional<StateValue> stateValueOptional = Optional.empty();
		TypedQuery<StateValue> queryResult = em.createQuery(
				"SELECT sv FROM StateValue sv WHERE sv.active = true AND sv.code = :stateValueCode", StateValue.class);
		queryResult.setParameter("stateValueCode", svCode);
		return stateValueOptional.ofNullable(queryResult.getSingleResult());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StateValue> findAll() {
		return em.createQuery("SELECT sv FROM StateValue sv WHERE sv.active = true ORDER BY sv.code").getResultList();
	}

}