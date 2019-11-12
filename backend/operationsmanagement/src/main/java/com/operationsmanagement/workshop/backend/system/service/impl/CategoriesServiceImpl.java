package com.operationsmanagement.workshop.backend.system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.operationsmanagement.workshop.backend.system.dao.CategoryDAO;
import com.operationsmanagement.workshop.backend.system.dao.CategoryValueDAO;
import com.operationsmanagement.workshop.backend.system.model.Category;
import com.operationsmanagement.workshop.backend.system.model.CategoryValue;
import com.operationsmanagement.workshop.backend.system.service.CategoriesService;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private CategoryValueDAO categoryValueDAO;

	@Override
	@Transactional(readOnly = false)
	public Category createCategory(Category category) {
		return categoryDAO.save(category);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Category> findCategoryById(Long id) {
		return categoryDAO.findCategoryById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Category> findCategoryByCode(String categoryCode) {
		return categoryDAO.findCategoryByCode(categoryCode);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateCategory(Category category) {
		Category toBeUpdated = categoryDAO.findCategoryById(category.getId()).get();

		toBeUpdated.setActive(category.getActive());
		toBeUpdated.setCategoryValues(category.getCategoryValues());
		toBeUpdated.setCode(category.getCode());
		toBeUpdated.setName(category.getName());

		categoryDAO.update(category);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteCategory(Long id) {
		Category toBeRemoved = categoryDAO.findCategoryById(id).get();
		categoryDAO.remove(toBeRemoved);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Category> findAllCategories() {
		return categoryDAO.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public CategoryValue createCategoryValue(CategoryValue categoryValue) {
		return categoryValueDAO.save(categoryValue);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<CategoryValue> findCategoryValueById(Long id) {
		return categoryValueDAO.findCategoryValueById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<CategoryValue> findCategoryValueByCode(String cvCode) {
		return categoryValueDAO.findCategoryValueByCode(cvCode);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateCategoryValue(CategoryValue categoryValue) {
		CategoryValue toBeUpdated = categoryValueDAO.findCategoryValueById(categoryValue.getId()).get();

		toBeUpdated.setActive(categoryValue.getActive());
		toBeUpdated.setCode(categoryValue.getCode());
		toBeUpdated.setName(categoryValue.getName());
		toBeUpdated.setCategory(categoryValue.getCategory());

		categoryValueDAO.update(categoryValue);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteCategoryValue(Long id) {
		CategoryValue toBeRemoved = categoryValueDAO.findCategoryValueById(id).get();
		categoryValueDAO.remove(toBeRemoved);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CategoryValue> findAllCategoryValues() {
		return categoryValueDAO.findAll();
	}

}