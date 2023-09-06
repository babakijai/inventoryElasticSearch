package com.wells.inventory.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wells.inventory.model.InventoryModel;
import com.wells.inventory.services.InventoryService;

@RestController
@RequestMapping(value = "/v1/inventory")
public class InventoryApi {

	@Autowired
	private InventoryService iService;

	private ElasticsearchOperations elasticsearchOperations;

	public InventoryApi(ElasticsearchOperations elasticsearchOperations) {
		this.elasticsearchOperations = elasticsearchOperations;
	}

	@GetMapping("/search")
	public List<InventoryModel> searchByProject(@RequestParam("projectName") String projectName) {
		List<InventoryModel> inventoryList = iService.getAllInventoryModelForProject(projectName);

		return inventoryList;
	}

	@PostMapping("/saveByIndexQuery")
	public String save(@RequestBody InventoryModel dataset) {
		// customize indexing using index() or bulkIndex()

		IndexQuery indexQuery = new IndexQueryBuilder().withIndex(dataset.getId()).withObject(dataset).build();
		String documentId = elasticsearchOperations.index(indexQuery, IndexCoordinates.of("inventoryindex"));
		return documentId;
	}

	@GetMapping("/searchBySummary")
	public List<InventoryModel> searchDataBySummary(@RequestParam("term") String term) {
		return iService.findBySearchTerm(term);
	}

	@PostMapping("/save")
	public InventoryModel addInventoryData(@RequestBody InventoryModel InventoryModel) {
		return iService.createInventoryModelIndex(InventoryModel);
	}

	@PostMapping("/createInBulk")
	public List<InventoryModel> addDataInBulk(@RequestBody List<InventoryModel> logDataList) {
		return (List<InventoryModel>) iService.createInventoryModelIndices(logDataList);
	}

	@GetMapping("/findAllWithPgination")
	public Page<InventoryModel> findAllWithPgination() {
		final Page<InventoryModel> inventoryList = iService.findAllWithPgination(PageRequest.of(0, 10));
		return inventoryList;
	}

	@GetMapping("/findAll")
	public List<InventoryModel> findAll() {
		List<InventoryModel> inventoryList = iService.findAll(PageRequest.of(0, 10)).getContent();
		return inventoryList;
	}

}
