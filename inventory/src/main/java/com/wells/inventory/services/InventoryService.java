package com.wells.inventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wells.inventory.model.InventoryModel;
import com.wells.inventory.repositories.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository iRepository;

	public InventoryModel createInventoryModelIndex(final InventoryModel data) {
		return iRepository.save(data);
	}

	public Iterable<InventoryModel> createInventoryModelIndices(final List<InventoryModel> inventoryModelList) {
		return iRepository.saveAll(inventoryModelList);
	}

	public List<InventoryModel> getAllInventoryModelForProject(String keyWord) {
		return iRepository.findByProjectName(keyWord);
	}

	public InventoryModel findById(String id) {
		return iRepository.findById(id).get();
	}

	public Page<InventoryModel> findAllWithPgination(Pageable pageable) {
		return iRepository.findAll(pageable);

	}

	public List<InventoryModel> findBySearchTerm(String keyWord) {
		return iRepository.findBySummaryDetails(keyWord);
	}

	public Page<InventoryModel> findAll(Pageable pageable) {
		return iRepository.findAll(pageable);
	}

}
