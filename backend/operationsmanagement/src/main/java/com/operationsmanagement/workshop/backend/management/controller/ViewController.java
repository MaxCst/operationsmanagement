package com.operationsmanagement.workshop.backend.management.controller;

import java.util.ArrayList;
import java.util.HashSet;
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

import com.operationsmanagement.workshop.backend.management.dto.ViewRequestDTO;
import com.operationsmanagement.workshop.backend.management.dto.ViewResponseDTO;
import com.operationsmanagement.workshop.backend.management.model.Transaction;
import com.operationsmanagement.workshop.backend.management.model.View;
import com.operationsmanagement.workshop.backend.management.service.TransactionsService;
import com.operationsmanagement.workshop.backend.management.service.ViewsService;
import com.operationsmanagement.workshop.backend.system.model.CategoryValue;
import com.operationsmanagement.workshop.backend.system.model.Role;
import com.operationsmanagement.workshop.backend.system.model.StateValue;
import com.operationsmanagement.workshop.backend.system.service.CategoriesService;
import com.operationsmanagement.workshop.backend.system.service.StatesService;
import com.operationsmanagement.workshop.backend.system.service.UsersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/views", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "views")
public class ViewController {

	@Autowired
	private ViewsService viewsService;

	@Autowired
	private CategoriesService categoriesService;

	@Autowired
	private StatesService statesService;

	@Autowired
	private UsersService usersService;

	private ModelMapper modelMapper = new ModelMapper();

	@PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "save view")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void createView(@RequestBody ViewRequestDTO viewDTO) {
		View view = getViewFromDTO(viewDTO);
		viewsService.createView(view);
	}

	private View getViewFromDTO(ViewRequestDTO viewDTO) {
		View view = modelMapper.map(viewDTO, View.class);

		view.setCategoryValues(new HashSet<CategoryValue>());
		for (String cvCode : viewDTO.getCategoryValuesCodes()) {
			CategoryValue categoryValue = categoriesService.findCategoryValueByCode(cvCode).get();
			view.getCategoryValues().add(categoryValue);
		}

		view.setStateValues(new HashSet<StateValue>());
		for (String svCode : viewDTO.getStateValuesCodes()) {
			StateValue stateValue = statesService.findStateValueByCode(svCode).get();
			view.getStateValues().add(stateValue);
		}

		view.setRoles(new HashSet<Role>());
		for (String uCode : viewDTO.getRolesCodes()) {
			Role role = usersService.findRoleByCode(uCode).get();
			view.getRoles().add(role);
		}

		return view;
	}

	@GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get view by id")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public @ResponseBody ViewResponseDTO getView(@RequestParam Long id) {
		Optional<View> view = viewsService.findViewById(id);
		return modelMapper.map(view.get(), ViewResponseDTO.class);
	}

	@PostMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "update view")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void updateview(@RequestBody ViewRequestDTO viewDTO) {
		View view = getViewFromDTO(viewDTO);
		viewsService.updateView(view);
	}

	@PostMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "delete view")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void deleteView(@RequestParam Long id) {
		View view = viewsService.findViewById(id).get();
		viewsService.deleteView(view);
	}

	@GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get all views")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public @ResponseBody List<ViewResponseDTO> getAllViews() {
		List<View> views = viewsService.findAllViews();
		List<ViewResponseDTO> result = new ArrayList<>();
		for (View v : views) {
			result.add(modelMapper.map(v, ViewResponseDTO.class));
		}
		return result;
	}
}
