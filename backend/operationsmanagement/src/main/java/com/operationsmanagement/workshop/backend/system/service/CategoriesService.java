package com.operationsmanagement.workshop.backend.system.service;

import java.util.List;
import java.util.Optional;

import com.operationsmanagement.workshop.backend.system.model.Category;
import com.operationsmanagement.workshop.backend.system.model.CategoryValue;

public interface CategoriesService {

	// Categories

	public Category createCategory(Category category);

	public Optional<Category> findCategoryById(Long id);

	public Optional<Category> findCategoryByCode(String categoryCode);

	public void updateCategory(Category category);

	public void deleteCategory(Long id);

	// Categories Values

	public CategoryValue createCategoryValue(CategoryValue categoryValue);

	public Optional<CategoryValue> findCategoryValueById(Long id);

	public Optional<CategoryValue> findCategoryValueByCode(String cvCode);

	public void updateCategoryValue(CategoryValue categoryValue);

	public void deleteCategoryValue(Long id);

	// View Support Services 

	public List<Category> findAllCategories();

	public List<CategoryValue> findAllCategoryValues();	

}