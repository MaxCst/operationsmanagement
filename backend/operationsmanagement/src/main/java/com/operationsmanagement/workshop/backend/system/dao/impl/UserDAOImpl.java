package com.operationsmanagement.workshop.backend.system.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.operationsmanagement.workshop.backend.system.dao.UserDAO;
import com.operationsmanagement.workshop.backend.system.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public User save(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public Optional<User> findUserById(Long id) {
		Optional<User> userOptional = Optional.empty();
		return userOptional.ofNullable(em.find(User.class, id));
	}

	@Override
	public Optional<User> findUserByCode(String userCode) {
		Optional<User> userOptional = Optional.empty();
		TypedQuery<User> queryResult = em
				.createQuery("SELECT u FROM User u WHERE u.active = true AND u.code = :userCode", User.class);
		queryResult.setParameter("userCode", userCode);
		return userOptional.ofNullable(queryResult.getSingleResult());
	}

	@Override
	public void update(User user) {
		em.merge(user);
	}

	@Override
	public void remove(User user) {
		user.setActive(false);
		em.merge(user);
	}

	@Override
	public List<User> findAll() {
		return em.createQuery("SELECT s FROM User s WHERE s.active = true ORDER BY s.code").getResultList();
	}

}