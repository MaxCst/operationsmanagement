package com.operationsmanagement.workshop.backend.management.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.operationsmanagement.workshop.backend.management.dao.ViewDAO;
import com.operationsmanagement.workshop.backend.management.model.View;

@Repository
public class ViewDAOImpl implements ViewDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public View save(View view) {
		view.setId(null);
		view.setActive(true);
		em.persist(view);
		return view;
	}

	@Override
	public Optional<View> findViewById(Long id) {
		Optional<View> viewOptional = Optional.empty();
		return viewOptional.ofNullable(em.find(View.class, id));
	}

	@Override
	public Optional<View> findViewByCode(String code) {
		Optional<View> viewOptional = Optional.empty();
		TypedQuery<View> queryResult = em
				.createQuery("SELECT v FROM View v WHERE v.active = true AND v.code = :viewCode", View.class);
		queryResult.setParameter("viewCode", code);
		return viewOptional.ofNullable(queryResult.getSingleResult());
	}

	@Override
	public void update(View view) {
		em.merge(view);
	}

	@Override
	public void remove(View view) {
		view.setActive(false);
		em.merge(view);
	}

	@Override
	public List<View> findAll() {
		return em.createQuery("SELECT v FROM View v WHERE v.active = true ORDER BY v.code").getResultList();
	}

}