package com.operationsmanagement.workshop.backend.system.service;

import java.util.List;
import java.util.Optional;

import com.operationsmanagement.workshop.backend.system.exception.BusinessException;
import com.operationsmanagement.workshop.backend.system.model.Role;
import com.operationsmanagement.workshop.backend.system.model.User;
import com.operationsmanagement.workshop.backend.system.model.code.RoleType;

public interface UsersService {

	// Users CRUD Services

	public User createUser(User user);

	public Optional<User> findUserById(Long id);

	public Optional<User> findUserByCode(String userCode);

	public void updateUser(User user);

	public void deleteUser(User user);

	public List<User> findAllUsers();

	// Roles CRUD Services

	public Role createRole(Role role);

	public Optional<Role> findRoleById(Long id);

	public Optional<Role> findRoleByCode(String roleCode);

	public void updateRole(Role role);

	public void deleteRole(Role role);

	public List<Role> findAllRoles();

	public void checkRole(String user, RoleType allowed) throws BusinessException;
	
	// View Support Services 

	// ...
}
