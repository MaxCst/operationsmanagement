package com.operationsmanagement.workshop.backend.management.controller;

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

import com.operationsmanagement.workshop.backend.management.dto.OperationRequestDTO;
import com.operationsmanagement.workshop.backend.management.dto.OperationResponseDTO;
import com.operationsmanagement.workshop.backend.management.model.Operation;
import com.operationsmanagement.workshop.backend.management.service.OperationsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/operations", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "operations")
public class OperationController {

	@Autowired
	private OperationsService operationsService;

	private ModelMapper modelMapper = new ModelMapper();

	@PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "save operation")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void createOperation(@RequestBody OperationRequestDTO operationDTO) {
		Operation operation = modelMapper.map(operationDTO, Operation.class);
		operationsService.createOperation(operation);
	}

	@GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get operation by id")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public @ResponseBody OperationResponseDTO getOperation(@RequestParam Long id) {
		Optional<Operation> operation = operationsService.findOperationById(id);
		return modelMapper.map(operation.get(), OperationResponseDTO.class);
	}

	@PostMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "update operation")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void updateOperation(@RequestBody OperationRequestDTO operationDTO) {
		Operation operation = modelMapper.map(operationDTO, Operation.class);
		operationsService.updateOperation(operation);
	}

	@PostMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "delete operation")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void deleteOperation(@RequestParam Long id) {
		operationsService.deleteOperation(id);
	}

	@GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get all operations")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public @ResponseBody List<OperationResponseDTO> getAllOperation() {
		List<Operation> operations = operationsService.findAllOperations();
		List<OperationResponseDTO> result = new ArrayList<>();
		for (Operation o : operations) {
			result.add(modelMapper.map(o, OperationResponseDTO.class));
		}
		return result;
	}

}