package com.operationsmanagement.workshop.backend.system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.operationsmanagement.workshop.backend.system.dao.RoleDAO;
import com.operationsmanagement.workshop.backend.system.dao.UserDAO;
import com.operationsmanagement.workshop.backend.system.exception.BusinessException;
import com.operationsmanagement.workshop.backend.system.model.Role;
import com.operationsmanagement.workshop.backend.system.model.User;
import com.operationsmanagement.workshop.backend.system.model.code.RoleType;
import com.operationsmanagement.workshop.backend.system.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private RoleDAO roleDAO;

	@Override
	@Transactional(readOnly = false)
	public User createUser(User user) {
		user.setId(null);
		user.setActive(true);
		return userDAO.save(user);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> findUserById(Long id) {
		return userDAO.findUserById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> findUserByCode(String userCode) {
		return userDAO.findUserByCode(userCode);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateUser(User user) {
		User toBeUpdated = findUserById(user.getId()).get();
		toBeUpdated.setName(user.getName());
		toBeUpdated.setActive(user.getActive());
		toBeUpdated.setEmail(user.getEmail());
		toBeUpdated.setRoles(user.getRoles());
		toBeUpdated.setCode(user.getCode());
		userDAO.update(toBeUpdated);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteUser(User user) {
		User toBeUpdated = findUserById(user.getId()).get();
		toBeUpdated.setActive(false);
		userDAO.update(toBeUpdated);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findAllUsers() {
		return userDAO.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Role createRole(Role role) {
		role.setId(null);
		role.setActive(true);
		return roleDAO.save(role);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Role> findRoleById(Long id) {
		return roleDAO.findRoleById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Role> findRoleByCode(String roleCode) {
		return roleDAO.findRoleByCode(roleCode);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateRole(Role role) {
		Role toBeUpdated = findRoleById(role.getId()).get();
		toBeUpdated.setName(role.getName());
		toBeUpdated.setActive(role.getActive());
		toBeUpdated.setCode(role.getCode());
		roleDAO.update(toBeUpdated);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteRole(Role role) {
		roleDAO.remove(role);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Role> findAllRoles() {
		return roleDAO.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public void checkRole(String user, RoleType allowed) throws BusinessException {
		Role isAllowed = findRoleByCode(allowed.name()).get();
		User usr = findUserByCode(user).get();
		if (!usr.getRoles().contains(isAllowed)) {
			throw new BusinessException("El usuario no tiene los permisos correspondientes");
		}
	}
}
