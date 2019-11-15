package com.operationsmanagement.workshop.backend.application.payment.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.operationsmanagement.workshop.backend.application.commons.dto.CustomerRequestDTO;
import com.operationsmanagement.workshop.backend.application.payment.dto.CreatePaymentRequestRequestDTO;
import com.operationsmanagement.workshop.backend.application.payment.dto.CreatePaymentRequestResponseDTO;
import com.operationsmanagement.workshop.backend.application.payment.dto.GetPaymentRequestDetailsRequestDTO;
import com.operationsmanagement.workshop.backend.application.payment.dto.GetPaymentRequestDetailsResponseDTO;
import com.operationsmanagement.workshop.backend.application.payment.dto.PaymentsReportDTO;
import com.operationsmanagement.workshop.backend.application.payment.dto.PaymentsReportRequestDTO;
import com.operationsmanagement.workshop.backend.application.payment.dto.PaymentsReportResponseDTO;
import com.operationsmanagement.workshop.backend.application.payment.dto.PendingPaymentRequestsReportRequestDTO;
import com.operationsmanagement.workshop.backend.application.payment.dto.PendingPaymentRequestsReportResponseDTO;
import com.operationsmanagement.workshop.backend.application.payment.dto.ProcessPaymentsResponseDTO;
import com.operationsmanagement.workshop.backend.application.payment.dto.SendPaymentRequestDTO;
import com.operationsmanagement.workshop.backend.application.payment.dto.SendPaymentResponseDTO;
import com.operationsmanagement.workshop.backend.application.payment.service.PaymentService;
import com.operationsmanagement.workshop.backend.management.model.Transaction;
import com.operationsmanagement.workshop.backend.management.model.View;
import com.operationsmanagement.workshop.backend.management.model.code.OperationType;
import com.operationsmanagement.workshop.backend.management.model.code.PaymentStatus;
import com.operationsmanagement.workshop.backend.management.service.OperationsService;
import com.operationsmanagement.workshop.backend.management.service.TransactionsService;
import com.operationsmanagement.workshop.backend.management.service.ViewsService;
import com.operationsmanagement.workshop.backend.system.exception.BusinessException;
import com.operationsmanagement.workshop.backend.system.model.StateValue;
import com.operationsmanagement.workshop.backend.system.model.code.RoleType;
import com.operationsmanagement.workshop.backend.system.model.enums.GeneralResponseEnum;
import com.operationsmanagement.workshop.backend.system.service.StatesService;
import com.operationsmanagement.workshop.backend.system.service.UsersService;
import com.operationsmanagement.workshop.backend.system.util.JsonObjectMapper;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private TransactionsService transactionsService;

	@Autowired
	private OperationsService operationsService;

	@Autowired
	private UsersService usersService;

	@Autowired
	private StatesService statesService;

	@Autowired
	private ViewsService viewsService;

	@Override
	@Transactional(readOnly = false, rollbackFor = BusinessException.class)
	public CreatePaymentRequestResponseDTO createPaymentRequest(CreatePaymentRequestRequestDTO createPaymentDTO)
			throws BusinessException {

		CreatePaymentRequestResponseDTO createPaymentRequestResponseDTO = new CreatePaymentRequestResponseDTO();

		// Check if user is allowed to perform this operation

		usersService.checkRole(createPaymentDTO.getUser(), RoleType.Adm);

		// Build Transaction

		Transaction transaction = new Transaction();

		// Set Transaction's Operation

		try {
			transaction
					.setOperation(operationsService.findOperationByCode(OperationType.PaymentOperation.name()).get());
		} catch (Exception e) {
			throw new BusinessException("Error al establecer la operación");
		}

		// Set Transaction's User

		try {
			transaction.setUser(usersService.findUserByCode(createPaymentDTO.getUser()).get());
		} catch (Exception e) {
			throw new BusinessException("Error al establecer el usuario");
		}

		// Set Transaction's Data

		try {
			transaction.setData(JsonObjectMapper.toJson(createPaymentDTO).getBytes());
		} catch (Exception e) {
			throw new BusinessException("Error al serializar datos");
		}

		// Set Transaction's Date

		transaction.setDate(new Date());

		// Set Transaction's status

		try {
			transaction.setStateValues(new HashSet<StateValue>());
			transaction.getStateValues()
					.add(statesService.findStateValueByCode(PaymentStatus.PendingPayment.name()).get());
		} catch (Exception e) {
			throw new BusinessException("Error al establecer estado inicial de transacción");
		}

		// Create Transaction

		try {
			transactionsService.createTransaction(transaction);
		} catch (Exception e) {
			throw new BusinessException("Error al crear la transacción");
		}

		// Prepare and Return Result

		createPaymentRequestResponseDTO.setPaymentId(transaction.getId());

		return createPaymentRequestResponseDTO;

	}

	@Override
	public ProcessPaymentsResponseDTO processPayments(CustomerRequestDTO processPaymentsDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentsReportResponseDTO paymentsReport(PaymentsReportRequestDTO getPaymentsReportDTO)
			throws BusinessException {

		PaymentsReportResponseDTO paymentsReportResponseDTO = new PaymentsReportResponseDTO();
		paymentsReportResponseDTO.setPaymentsReport(new ArrayList<PaymentsReportDTO>());

		// Get View Instance to obtain "allowed roles" and "view designs information"
		// (format and view type)

		View paymentsReportStandardView = viewsService.findViewByCode(getPaymentsReportDTO.getViewType()).get();

		// Check if user is allowed to perform this operation

		usersService.checkRole(getPaymentsReportDTO.getUser(), RoleType.Mgr);

		// Get transactions information

		List<Transaction> transactions = transactionsService.findTransactionsByDateRange(
				operationsService.findOperationByCode(OperationType.PaymentOperation.name()).get(),
				getPaymentsReportDTO.getStartDate(), getPaymentsReportDTO.getEndDate());

		// Fill results

		for (Transaction t : transactions) {

			PaymentsReportDTO paymentsReportDTO = new PaymentsReportDTO();

			paymentsReportDTO.setPaymentRequest(t.getId());

			paymentsReportDTO.setDate(t.getDate());

			try {
				CreatePaymentRequestRequestDTO createPaymentRequestRequestDTO = (CreatePaymentRequestRequestDTO) JsonObjectMapper
						.fromJson(new String(t.getData()), CreatePaymentRequestRequestDTO.class);
				paymentsReportDTO.setCustomer(createPaymentRequestRequestDTO.getCustomer());
				paymentsReportDTO.setDebt(createPaymentRequestRequestDTO.getDebt());

			} catch (Exception e) {
				throw new BusinessException("Error al deserializar datos");
			}

			// TODO el resto de la implementacion con el resto de los datos del Json

			paymentsReportResponseDTO.getPaymentsReport().add(paymentsReportDTO);

		}
		return paymentsReportResponseDTO;
	}

	@Override
	public PendingPaymentRequestsReportResponseDTO pendingPaymentRequestsReport(
			PendingPaymentRequestsReportRequestDTO pendingPaymentRequestsReportDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetPaymentRequestDetailsResponseDTO getPaymentRequestDetails(
			GetPaymentRequestDetailsRequestDTO getPaymentRequestDetailsDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = BusinessException.class)
	public SendPaymentResponseDTO sendPayment(SendPaymentRequestDTO sendPaymentDTO) throws BusinessException {

		SendPaymentResponseDTO sendPaymentResponseDTO = new SendPaymentResponseDTO();

		// Get original paymentRequestTransaction

		Transaction paymentRequestTransaction = null;

		try {
			paymentRequestTransaction = transactionsService.findTransactionById(sendPaymentDTO.getPaymentRequest())
					.get();
		} catch (Exception e) {
			throw new BusinessException("Error al obtener transacción de paymentRequest");
		}

		// Checks if user is allowed to perform this operation

		usersService.checkRole(sendPaymentDTO.getUser(), RoleType.Usr);

		// Checks if the paymentRequest Transaction is a PaymentOperation Operation Type

		operationsService.checkOperationType(paymentRequestTransaction, OperationType.PaymentOperation);

		// Change paymentRequestTransaction state to PaymentInProgress

		paymentRequestTransaction
				.addStateValue(statesService.findStateValueByCode(PaymentStatus.PaymentInProgress.name()).get());

		// Build a new CollectOperation Transaction

		Transaction newCollectTransaction = new Transaction();

		// Set new Transaction's parent association

		try {
			newCollectTransaction.setParent(paymentRequestTransaction);
		} catch (Exception e) {
			throw new BusinessException(
					"Error al establecer asociación con transaccion original de tipo Payment Operation");
		}

		// Set new Transaction's operation

		try {
			newCollectTransaction
					.setOperation(operationsService.findOperationByCode(OperationType.CollectOperation.name()).get());
		} catch (Exception e) {
			throw new BusinessException("Error al establecer la operación");
		}

		// Set new Transaction's user

		try {
			newCollectTransaction.setUser(usersService.findUserByCode(sendPaymentDTO.getUser()).get());
		} catch (Exception e) {
			throw new BusinessException("Error al establecer el usuario");
		}

		// Set new Transaction's date

		newCollectTransaction.setDate(new Date());

		// Set new Transaction's Data

		try {
			newCollectTransaction.setData(JsonObjectMapper.toJson(sendPaymentDTO).getBytes());
		} catch (Exception e) {
			throw new BusinessException("Error al serializar datos");
		}

		// Create New Collection Transaction

		try {
			transactionsService.createTransaction(newCollectTransaction);
		} catch (Exception e) {
			throw new BusinessException("Error al crear la transacción");
		}

		// Prepare and Return Result

		sendPaymentResponseDTO.setCollectTransaction(newCollectTransaction.getId());
		sendPaymentResponseDTO.setDate(newCollectTransaction.getDate());
		sendPaymentResponseDTO.setAmount(sendPaymentDTO.getAmount());
		sendPaymentResponseDTO.setCustomer(sendPaymentDTO.getUser());

		try {
			CreatePaymentRequestRequestDTO createPaymentRequestRequestDTO = (CreatePaymentRequestRequestDTO) JsonObjectMapper
					.fromJson(new String(paymentRequestTransaction.getData()), CreatePaymentRequestRequestDTO.class);

			BigDecimal debt = createPaymentRequestRequestDTO.getDebt();
			debt = debt.subtract(sendPaymentDTO.getAmount());
			sendPaymentResponseDTO.setDebt(debt);

			sendPaymentResponseDTO.setResult(GeneralResponseEnum.OK.name());

		} catch (Exception e) {
			throw new BusinessException("Error al deserializar datos");
		}

		return sendPaymentResponseDTO;

	}

}
