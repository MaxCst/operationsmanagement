package com.operationsmanagement.workshop.backend.system.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.operationsmanagement.workshop.backend.system.dto.CategoryRequestDTO;
import com.operationsmanagement.workshop.backend.system.dto.CategoryResponseDTO;
import com.operationsmanagement.workshop.backend.system.dto.CategoryValueRequestDTO;
import com.operationsmanagement.workshop.backend.system.dto.CategoryValueResponseDTO;
import com.operationsmanagement.workshop.backend.system.model.Category;
import com.operationsmanagement.workshop.backend.system.model.CategoryValue;
import com.operationsmanagement.workshop.backend.system.service.CategoriesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "categories")
public class CategoryController {

	@Autowired
	private CategoriesService categoryService;

	private ModelMapper modelMapper = new ModelMapper();

	@PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "save category")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void createCategory(@RequestBody CategoryRequestDTO categoryDTO) {
		Category category = modelMapper.map(categoryDTO, Category.class);
		categoryService.createCategory(category);
	}

	@GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get category by id")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public @ResponseBody CategoryResponseDTO getCategory(@RequestParam Long id) {
		Optional<Category> category = categoryService.findCategoryById(id);
		return modelMapper.map(category.get(), CategoryResponseDTO.class);
	}

	@PostMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "update category")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void updateCategory(@RequestBody CategoryRequestDTO categoryDTO) {
		Category category = modelMapper.map(categoryDTO, Category.class);
		categoryService.updateCategory(category);
	}

	@PostMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "delete category")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void deleteCategory(@RequestParam Long id) {
		categoryService.deleteCategory(id);
	}

	@GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get all categories")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public @ResponseBody List<CategoryResponseDTO> getAllCategory() {
		List<Category> categories = categoryService.findAllCategories();
		List<CategoryResponseDTO> result = new ArrayList<>();
		for (Category c : categories) {
			result.add(modelMapper.map(c, CategoryResponseDTO.class));
		}
		return result;
	}

	@PostMapping(path = "/saveCategoryValue", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "save category value")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void createCategoryValue(@RequestBody CategoryValueRequestDTO categoryValueDTO) {
		CategoryValue categoryValue = modelMapper.map(categoryValueDTO, CategoryValue.class);
		categoryValue.setCategory(categoryService.findCategoryByCode(categoryValueDTO.getCategoryCode()).get());
		categoryService.createCategoryValue(categoryValue);
	}

	@GetMapping(path = "/getCategoryValue", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get category value by id")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public @ResponseBody CategoryValueResponseDTO getCategoryValue(@RequestParam Long id) {
		Optional<CategoryValue> categoryValue = categoryService.findCategoryValueById(id);
		return modelMapper.map(categoryValue.get(), CategoryValueResponseDTO.class);
	}

	@PostMapping(path = "/updateCategoryValue", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "update category value")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void updateCategoryValue(@RequestBody CategoryValueRequestDTO categoryValueDTO) {
		CategoryValue categoryValue = modelMapper.map(categoryValueDTO, CategoryValue.class);
		categoryValue.setCategory(categoryService.findCategoryByCode(categoryValueDTO.getCategoryCode()).get());
		categoryService.updateCategoryValue(categoryValue);
	}

	@PostMapping(path = "/deleteCategoryValue", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "delete category value")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void deleteCategoryValue(@RequestParam Long id) {
		categoryService.deleteCategoryValue(id);
	}

	@GetMapping(path = "/getAllCategoryValue", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get all categories values")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public List<CategoryValueResponseDTO> getAllCategoryValue() {
		List<CategoryValue> categoryValues = categoryService.findAllCategoryValues();
		List<CategoryValueResponseDTO> result = new ArrayList<>();
		for (CategoryValue c : categoryValues) {
			result.add(modelMapper.map(c, CategoryValueResponseDTO.class));
		}
		return result;
	}

}