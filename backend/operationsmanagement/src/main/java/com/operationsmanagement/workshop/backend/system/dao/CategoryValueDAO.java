package com.operationsmanagement.workshop.backend.system.dao;

import java.util.List;
import java.util.Optional;

import com.operationsmanagement.workshop.backend.system.model.CategoryValue;

public interface CategoryValueDAO {

	public CategoryValue save(CategoryValue categoryValue);

	public Optional<CategoryValue> findCategoryValueById(Long id);

	public Optional<CategoryValue> findCategoryValueByCode(String cvCode);

	public void update(CategoryValue categoryValue);

	public void remove(CategoryValue categoryValue);

	public List<CategoryValue> findAll();

}