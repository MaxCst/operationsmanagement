package com.operationsmanagement.workshop.backend.management.dao;

import java.util.List;
import java.util.Optional;

import com.operationsmanagement.workshop.backend.management.model.View;

public interface ViewDAO {

	public View save(View view);

	public Optional<View> findViewById(Long id);

	public Optional<View> findViewByCode(String viewCode);

	public void update(View view);

	public void remove(View view);

	public List<View> findAll();

}