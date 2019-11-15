package com.operationsmanagement.workshop.backend.application.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.operationsmanagement.workshop.backend.application.commons.dto.CustomerRequestDTO;
import com.operationsmanagement.workshop.backend.application.payment.dto.CreatePaymentRequestRequestDTO;
import com.operationsmanagement.workshop.backend.application.payment.dto.CreatePaymentRequestResponseDTO;
import com.operationsmanagement.workshop.backend.application.payment.dto.GetPaymentRequestDetailsRequestDTO;
import com.operationsmanagement.workshop.backend.application.payment.dto.GetPaymentRequestDetailsResponseDTO;
import com.operationsmanagement.workshop.backend.application.payment.dto.PaymentsReportRequestDTO;
import com.operationsmanagement.workshop.backend.application.payment.dto.PaymentsReportResponseDTO;
import com.operationsmanagement.workshop.backend.application.payment.dto.PendingPaymentRequestsReportRequestDTO;
import com.operationsmanagement.workshop.backend.application.payment.dto.PendingPaymentRequestsReportResponseDTO;
import com.operationsmanagement.workshop.backend.application.payment.dto.ProcessPaymentsResponseDTO;
import com.operationsmanagement.workshop.backend.application.payment.dto.SendPaymentRequestDTO;
import com.operationsmanagement.workshop.backend.application.payment.dto.SendPaymentResponseDTO;
import com.operationsmanagement.workshop.backend.application.payment.service.PaymentService;
import com.operationsmanagement.workshop.backend.system.exception.BusinessException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/payment", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "service that implements payment application")
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@PostMapping(path = "/createPaymentRequest", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "create payment request")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public @ResponseBody CreatePaymentRequestResponseDTO createPaymentRequest(
			@RequestBody CreatePaymentRequestRequestDTO createPaymentDTO) throws BusinessException {
		return paymentService.createPaymentRequest(createPaymentDTO);
	}

	@PostMapping(path = "/processPayments", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "process payments")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public @ResponseBody ProcessPaymentsResponseDTO processPayments(
			@RequestBody CustomerRequestDTO processPaymentsDTO) {
		return paymentService.processPayments(processPaymentsDTO);
	}

	@PostMapping(path = "/paymentsReport", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "payments report")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public @ResponseBody PaymentsReportResponseDTO paymentsReport(
			@RequestBody PaymentsReportRequestDTO paymentsReportDTO) throws BusinessException {
		return paymentService.paymentsReport(paymentsReportDTO);
	}

	@PostMapping(path = "/pendingPaymentRequestsReport", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "pending payment requests report")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public @ResponseBody PendingPaymentRequestsReportResponseDTO pendingPaymentRequestsReport(
			@RequestBody PendingPaymentRequestsReportRequestDTO pendingPaymentRequestsReportDTO) {
		return paymentService.pendingPaymentRequestsReport(pendingPaymentRequestsReportDTO);
	}

	@PostMapping(path = "/getPaymentRequestDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get payment request details")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public @ResponseBody GetPaymentRequestDetailsResponseDTO getPaymentRequestDetails(
			@RequestBody GetPaymentRequestDetailsRequestDTO getPaymentRequestDetailsDTO) {
		return paymentService.getPaymentRequestDetails(getPaymentRequestDetailsDTO);
	}

	@PostMapping(path = "/sendPayment", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "send payment")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public @ResponseBody SendPaymentResponseDTO sendPayment(@RequestBody SendPaymentRequestDTO sendPaymentDTO)
			throws BusinessException {
		return paymentService.sendPayment(sendPaymentDTO);
	}

}
