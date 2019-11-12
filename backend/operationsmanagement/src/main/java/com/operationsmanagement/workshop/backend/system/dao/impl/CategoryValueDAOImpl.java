package com.operationsmanagement.workshop.backend.system.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.operationsmanagement.workshop.backend.system.dao.CategoryValueDAO;
import com.operationsmanagement.workshop.backend.system.model.CategoryValue;

@Repository
public class CategoryValueDAOImpl implements CategoryValueDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public CategoryValue save(CategoryValue categoryValue) {
		categoryValue.setId(null);
		categoryValue.setActive(true);
		em.persist(categoryValue);
		return categoryValue;
	}

	@Override
	public void update(CategoryValue categoryValue) {
		em.merge(categoryValue);
	}

	@Override
	public void remove(CategoryValue categoryValue) {
		categoryValue.setActive(false);
		em.merge(categoryValue);
	}

	@Override
	public Optional<CategoryValue> findCategoryValueById(Long id) {
		Optional<CategoryValue> categoryValueOptional = Optional.empty();
		return categoryValueOptional.ofNullable(em.find(CategoryValue.class, id));
	}

	@Override
	public Optional<CategoryValue> findCategoryValueByCode(String cvCode) {
		Optional<CategoryValue> categoryValueOptional = Optional.empty();
		TypedQuery<CategoryValue> queryResult = em.createQuery(
				"SELECT cv FROM CategoryValue cv WHERE cv.active = true AND cv.code = :categoryValueCode",
				CategoryValue.class);
		queryResult.setParameter("categoryValueCode", cvCode);
		return categoryValueOptional.ofNullable(queryResult.getSingleResult());
	}

	@Override
	public List<CategoryValue> findAll() {
		return em.createQuery("SELECT s FROM CategoryValue s WHERE s.active = true ORDER BY s.code").getResultList();
	}

}