package com.operationsmanagement.workshop.backend.system.dao;

import java.util.List;
import java.util.Optional;

import com.operationsmanagement.workshop.backend.system.model.User;

public interface UserDAO {

	public User save(User user);

	public Optional<User> findUserById(Long id);

	public Optional<User> findUserByCode(String userCode);

	public void update(User user);

	public void remove(User user);

	public List<User> findAll();

}