package com.operationsmanagement.workshop.backend.system.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.operationsmanagement.workshop.backend.system.dao.RoleDAO;
import com.operationsmanagement.workshop.backend.system.model.Role;
import com.operationsmanagement.workshop.backend.system.model.State;
import com.operationsmanagement.workshop.backend.system.model.StateValue;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Role save(Role role) {
		role.setId(null);
		role.setActive(true);
		em.persist(role);
		return role;
	}

	@Override
	public Optional<Role> findRoleById(Long id) {
		return Optional.ofNullable(em.find(Role.class, id));
	}

	@Override
	public Optional<Role> findRoleByCode(String roleCode) {
		Optional<Role> roleOptional = Optional.empty();
		TypedQuery<Role> queryResult = em
				.createQuery("SELECT r FROM Role r WHERE r.active = true AND r.code = :roleCode", Role.class);
		queryResult.setParameter("roleCode", roleCode);
		return roleOptional.ofNullable(queryResult.getSingleResult());
	}

	@Override
	public void update(Role role) {
		em.merge(role);
	}

	@Override
	public void remove(Role role) {
		role.setActive(false);
		em.merge(role);
	}

	@Override
	public List<Role> findAll() {
		return em.createQuery("SELECT s FROM Role s WHERE s.active = true ORDER BY s.code").getResultList();
	}

}
