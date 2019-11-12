package com.operationsmanagement.workshop.backend.system.controller;

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

import com.operationsmanagement.workshop.backend.system.dto.StateRequestDTO;
import com.operationsmanagement.workshop.backend.system.dto.StateResponseDTO;
import com.operationsmanagement.workshop.backend.system.dto.StateValueRequestDTO;
import com.operationsmanagement.workshop.backend.system.dto.StateValueResponseDTO;
import com.operationsmanagement.workshop.backend.system.model.State;
import com.operationsmanagement.workshop.backend.system.model.StateValue;
import com.operationsmanagement.workshop.backend.system.service.StatesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/states", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "states")
public class StateController {

	@Autowired
	private StatesService stateService;

	private ModelMapper modelMapper = new ModelMapper();

	@PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "save state")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void createState(@RequestBody StateRequestDTO stateDTO) {
		State state = modelMapper.map(stateDTO, State.class);
		stateService.createState(state);
	}

	@GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get state by id")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public @ResponseBody StateResponseDTO getState(@RequestParam Long id) {
		Optional<State> state = stateService.findStateById(id);
		return modelMapper.map(state.get(), StateResponseDTO.class);
	}

	@PostMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "update state")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void updateState(@RequestBody StateRequestDTO stateDTO) {
		State state = modelMapper.map(stateDTO, State.class);
		stateService.updateState(state);
	}

	@PostMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "delete state")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void deleteState(@RequestParam Long id) {
		stateService.deleteState(id);
	}

	@GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get all states")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public @ResponseBody List<StateResponseDTO> getAllState() {
		List<State> states = stateService.findAllStates();
		List<StateResponseDTO> result = new ArrayList<>();
		for (State c : states) {
			result.add(modelMapper.map(c, StateResponseDTO.class));
		}
		return result;
	}

	@PostMapping(path = "/saveStateValue", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "save state value")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void createStateValue(@RequestBody StateValueRequestDTO stateValueDTO) {
		StateValue stateValue = getStateValueFromDTO(stateValueDTO);
		stateService.createStateValue(stateValue);
	}

	@GetMapping(path = "/getStateValue", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get state value by id")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public @ResponseBody StateValueResponseDTO getStateValue(@RequestParam Long id) {
		Optional<StateValue> stateValue = stateService.findStateValueById(id);
		return modelMapper.map(stateValue.get(), StateValueResponseDTO.class);
	}

	private StateValue getStateValueFromDTO(StateValueRequestDTO stateValueDTO) {

		StateValue stateValue = modelMapper.map(stateValueDTO, StateValue.class);

		stateValue.setState(stateService.findStateByCode(stateValueDTO.getStateCode()).get());

		stateValue.setParent(stateService.findStateValueByCode(stateValueDTO.getParentCode()).get());

		stateValue.setNextStateValues(new HashSet<StateValue>());
		for (String svCode : stateValueDTO.getNextStateValueCodes()) {
			stateValue.getNextStateValues().add(stateService.findStateValueByCode(svCode).get());
		}

		stateValue.setPreviousStateValues(new HashSet<StateValue>());
		for (String svCode : stateValueDTO.getPreviousStateValueCodes()) {
			stateValue.getPreviousStateValues().add(stateService.findStateValueByCode(svCode).get());
		}

		return stateValue;
	}

	@PostMapping(path = "/updateStateValue", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "update state value")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void updateStateValue(@RequestBody StateValueRequestDTO stateValueDTO) {
		StateValue stateValue = getStateValueFromDTO(stateValueDTO);
		stateService.updateStateValue(stateValue);
	}

	@PostMapping(path = "/deleteStateValue", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "delete state value")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void deleteStateValue(@RequestParam Long id) {
		stateService.deleteStateValue(id);
	}

	@GetMapping(path = "/getAllStateValue", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get all states values")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public List<StateValueResponseDTO> getAllStateValue() {
		List<StateValue> stateValues = stateService.findAllStateValues();
		List<StateValueResponseDTO> result = new ArrayList<>();
		for (StateValue sv : stateValues) {
			result.add(modelMapper.map(sv, StateValueResponseDTO.class));
		}
		return result;
	}

}