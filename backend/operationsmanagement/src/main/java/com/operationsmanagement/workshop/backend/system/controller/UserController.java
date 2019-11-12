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

import com.operationsmanagement.workshop.backend.system.dto.RoleRequestDTO;
import com.operationsmanagement.workshop.backend.system.dto.RoleResponseDTO;
import com.operationsmanagement.workshop.backend.system.dto.UserRequestDTO;
import com.operationsmanagement.workshop.backend.system.dto.UserResponseDTO;
import com.operationsmanagement.workshop.backend.system.model.Role;
import com.operationsmanagement.workshop.backend.system.model.User;
import com.operationsmanagement.workshop.backend.system.service.UsersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "users")
public class UserController {

	@Autowired
	private UsersService usersService;

	private ModelMapper modelMapper = new ModelMapper();

	@GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get User by id")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public @ResponseBody UserResponseDTO getUser(@RequestParam Long id) {
		Optional<User> user = usersService.findUserById(id);
		return modelMapper.map(user.get(), UserResponseDTO.class);
	}

	@GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get all users")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public @ResponseBody List<UserResponseDTO> getAllUser() {
		List<User> users = usersService.findAllUsers();
		List<UserResponseDTO> result = new ArrayList<>();
		for (User c : users) {
			result.add(modelMapper.map(c, UserResponseDTO.class));
		}
		return result;
	}

	@PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "save user")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void createUser(@RequestBody UserRequestDTO userDTO) {

		User user = getUserFromDTO(userDTO);

		usersService.createUser(user);
	}

	private User getUserFromDTO(UserRequestDTO userDTO) {
		// Mapea los atributos que vienen del DTO a la Entidad (Esto es el famoso Mapeo
		// Objeto/Objeto)
		User user = modelMapper.map(userDTO, User.class);

		// El mapper pudo mapear (copiar) todos los atributos, menos el de rolesCode que
		// tengo que procesar por separado
		// 1) inicializo la coleccion
		user.setRoles(new HashSet<Role>());
		// 2) obtengo cada entidad Role a partir del Code
		for (String roleCode : userDTO.getRolesCodes()) {
			user.getRoles().add(usersService.findRoleByCode(roleCode).get());
		}
		return user;
	}

	@PostMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "update User")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void updateUser(@RequestBody UserRequestDTO userDTO) {
		User user = getUserFromDTO(userDTO);
		usersService.updateUser(user);
	}

	@PostMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "delete User")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void deleteUser(@RequestParam Long id) {
		User User = usersService.findUserById(id).get();
		usersService.deleteUser(User);
	}

	@GetMapping(path = "/getRole", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get Role by id")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public @ResponseBody RoleResponseDTO getRole(@RequestParam Long id) {
		Optional<Role> Role = usersService.findRoleById(id);
		return modelMapper.map(Role, RoleResponseDTO.class);
	}

	@GetMapping(path = "/getAllRoles", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get all roles")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public List<RoleResponseDTO> getAllRole() {
		List<Role> roles = usersService.findAllRoles();

		List<RoleResponseDTO> result = new ArrayList<>();

		for (Role r : roles) {
			result.add(modelMapper.map(r, RoleResponseDTO.class));
		}

		return result;
	}

	@PostMapping(path = "/saveRole", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "save Role")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void createRole(@RequestBody RoleRequestDTO roleDTO) {
		Role role = modelMapper.map(roleDTO, Role.class);
		usersService.createRole(role);
	}

	@PostMapping(path = "/updateRole", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "update Role")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void updateRole(@RequestBody RoleRequestDTO RoleDTO) {
		Role role = modelMapper.map(RoleDTO, Role.class);
		usersService.updateRole(role);
	}

	@PostMapping(path = "/deleteRole", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "delete Role")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Successful"))
	public void deleteRole(@RequestBody RoleRequestDTO RoleDTO) {
		Role role = modelMapper.map(RoleDTO, Role.class);
		usersService.deleteRole(role);
	}

}