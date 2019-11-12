package com.operationsmanagement.workshop.backend.management.service;

import java.util.List;
import java.util.Optional;

import com.operationsmanagement.workshop.backend.management.model.View;

public interface ViewsService {

	// Views

	public View createView(View view);

	Optional<View> findViewById(Long id);

	Optional<View> findViewByCode(String viewCode);

	public void updateView(View view);

	public void deleteView(View view);

	public List<View> findAllViews();

}
