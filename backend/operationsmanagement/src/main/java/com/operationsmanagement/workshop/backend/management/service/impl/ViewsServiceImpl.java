package com.operationsmanagement.workshop.backend.management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.operationsmanagement.workshop.backend.management.dao.ViewDAO;
import com.operationsmanagement.workshop.backend.management.model.View;
import com.operationsmanagement.workshop.backend.management.service.ViewsService;

@Service
public class ViewsServiceImpl implements ViewsService {

	@Autowired
	private ViewDAO viewDAO;

	@Override
	@Transactional(readOnly = false)
	public View createView(View view) {
		return viewDAO.save(view);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<View> findViewById(Long id) {
		return viewDAO.findViewById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<View> findViewByCode(String viewCode) {
		return viewDAO.findViewByCode(viewCode);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateView(View view) {
		viewDAO.update(view);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteView(View view) {
		viewDAO.remove(view);
	}

	@Override
	@Transactional(readOnly = true)
	public List<View> findAllViews() {
		return viewDAO.findAll();
	}

}