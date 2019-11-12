package com.operationsmanagement.workshop.backend.system.dao;

import java.util.List;
import java.util.Optional;

import com.operationsmanagement.workshop.backend.system.model.Role;

public interface RoleDAO {

	public Role save(Role role);

	public Optional<Role> findRoleById(Long id);

	public Optional<Role> findRoleByCode(String roleCode);

	public void update(Role role);

	public void remove(Role role);

	public List<Role> findAll();

}