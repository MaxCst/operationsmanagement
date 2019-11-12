package com.operationsmanagement.workshop.backend.system.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.operationsmanagement.workshop.backend.system.dao.CategoryDAO;
import com.operationsmanagement.workshop.backend.system.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Category save(Category category) {
		category.setId(null);
		category.setActive(true);
		em.persist(category);
		return category;
	}

	@Override
	public Optional<Category> findCategoryById(Long id) {
		Optional<Category> categoryOptional = Optional.empty();
		return categoryOptional.ofNullable(em.find(Category.class, id));
	}

	@Override
	public Optional<Category> findCategoryByCode(String code) {
		Optional<Category> categoryOptional = Optional.empty();
		TypedQuery<Category> queryResult = em.createQuery(
				"SELECT c FROM Category c WHERE c.active = true AND c.code = :categoryCode", Category.class);
		queryResult.setParameter("categoryCode", code);
		return categoryOptional.ofNullable(queryResult.getSingleResult());
	}

	@Override
	public void update(Category category) {
		em.merge(category);
	}

	@Override
	public void remove(Category category) {
		category.setActive(false);
		em.merge(category);
	}

	@Override
	public List<Category> findAll() {
		return em.createQuery("SELECT s FROM Category s WHERE s.active = true ORDER BY s.code").getResultList();
	}

}