package com.wells.inventory.repositories;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.wells.inventory.model.InventoryModel;

@Repository
public interface InventoryRepository extends ElasticsearchRepository<InventoryModel, String> {

	List<InventoryModel> findByProjectName(String projectName);
	List<InventoryModel> findBySummaryDetails(String keywords);
}
