package com.operationsmanagement.workshop.backend.system.dao;

import java.util.List;
import java.util.Optional;

import com.operationsmanagement.workshop.backend.system.model.Category;

public interface CategoryDAO {

	public Category save(Category category);

	public Optional<Category> findCategoryById(Long id);

	public Optional<Category> findCategoryByCode(String code);

	public void update(Category category);

	public void remove(Category category);

	public List<Category> findAll();

}