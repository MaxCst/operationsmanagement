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

import com.operationsmanagement.workshop.backend.management.dto.TransactionRequestDTO;
import com.operationsmanagement.workshop.backend.management.dto.TransactionResponseDTO;
import com.operationsmanagement.workshop.backend.management.model.Transaction;
import com.operationsmanagement.workshop.backend.management.service.OperationsService;
import com.operationsmanagement.workshop.backend.management.service.TransactionsService;
import com.operationsmanagement.workshop.backend.system.model.CategoryValue;
import com.operationsmanagement.workshop.backend.system.model.StateValue;
import com.operationsmanagement.workshop.backend.system.service.CategoriesService;
import com.operationsmanagement.workshop.backend.system.service.StatesService;
import com.operationsmanagement.workshop.backend.system.service.UsersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "transactions")
public class TransactionController {

	@Autowired
	TransactionsService transactionsService;

	@Autowired
	OperationsService operationsService;

	@Autowired
	StatesService statesService;

	@Autowired
	CategoriesService categoriesService;

	@Autowired
	UsersService usersService;

	private ModelMapper modelMapper = new ModelMapper();

	@PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "save transaction")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void createTransaction(@RequestBody TransactionRequestDTO transactionDTO) {
		Transaction transaction = getTransactionFromDTO(transactionDTO);
		transactionsService.createTransaction(transaction);
	}

	private Transaction getTransactionFromDTO(TransactionRequestDTO transactionDTO) {
		Transaction transaction = modelMapper.map(transactionDTO, Transaction.class);

		transaction.setOperation(operationsService.findOperationByCode(transactionDTO.getOperationCode()).get());
		transaction.setUser(usersService.findUserByCode(transactionDTO.getUserCode()).get());

		transaction.setStateValues(new HashSet<StateValue>());
		for (String svCode : transactionDTO.getStateValuesCodes()) {
			transaction.getStateValues().add(statesService.findStateValueByCode(svCode).get());
		}

		transaction.setCategoryValues(new HashSet<CategoryValue>());
		for (String cvCode : transactionDTO.getCategoryValuesCodes()) {
			transaction.getCategoryValues().add(categoriesService.findCategoryValueByCode(cvCode).get());
		}

		transaction.setCategoryValues(new HashSet<CategoryValue>());
		for (String cvCode : transactionDTO.getCategoryValuesCodes()) {
			transaction.getCategoryValues().add(categoriesService.findCategoryValueByCode(cvCode).get());
		}
		return transaction;
	}

	@GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get transaction by id")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public @ResponseBody TransactionResponseDTO getTransaction(@RequestParam Long id) {
		Optional<Transaction> transaction = transactionsService.findTransactionById(id);
		return modelMapper.map(transaction.get(), TransactionResponseDTO.class);
	}

	@PostMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "update transaction")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void updateTransaction(@RequestBody TransactionRequestDTO transactionDTO) {
		Transaction transaction = getTransactionFromDTO(transactionDTO);
		transactionsService.updateTransaction(transaction);
	}

	@PostMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "delete transaction")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void deleteTransaction(@RequestParam Long id) {
		Transaction transaction = transactionsService.findTransactionById(id).get();
		transactionsService.deleteTransaction(transaction);
	}

	@GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get all transactions")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public @ResponseBody List<TransactionResponseDTO> getAllTransactions() {
		List<Transaction> transactions = transactionsService.findAllTransactions();
		List<TransactionResponseDTO> result = new ArrayList<>();
		for (Transaction t : transactions) {
			result.add(modelMapper.map(t, TransactionResponseDTO.class));
		}
		return result;
	}

}