package com.operationsmanagement.workshop.backend.system.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.operationsmanagement.workshop.backend.system.dao.StateDAO;
import com.operationsmanagement.workshop.backend.system.model.State;

@Repository
public class StateDAOImpl implements StateDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public State save(State state) {
		state.setId(null);
		state.setActive(true);
		em.persist(state);
		return state;
	}

	@Override
	public Optional<State> findStateById(Long id) {
		return Optional.ofNullable(em.find(State.class, id));
	}

	@Override
	public Optional<State> findStateByCode(String code) {
		Optional<State> stateOptional = Optional.empty();
		TypedQuery<State> queryResult = em
				.createQuery("SELECT s FROM State s WHERE s.active = true AND s.code = :stateCode", State.class);
		queryResult.setParameter("stateCode", code);
		return stateOptional.ofNullable(queryResult.getSingleResult());
	}

	@Override
	public void update(State state) {
		em.merge(state);
	}

	@Override
	public void remove(State state) {
		state.setActive(false);
		em.merge(state);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<State> findAll() {
		return em.createQuery("SELECT s FROM State s WHERE s.active = true ORDER BY s.code").getResultList();
	}

}