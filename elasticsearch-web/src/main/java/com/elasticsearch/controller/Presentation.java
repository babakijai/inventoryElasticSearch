package com.elasticsearch.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.elasticsearch.bean.InventoryModel;
import com.elasticsearch.bean.SearchTerms;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Controller
public class Presentation {

	final String contextUrl = "http://localhost:8484/v1/inventory";

	@GetMapping("/home")
	public String searchData() {
		return "/home";
	}

	@PostMapping("/search")
	public @ResponseBody List<InventoryModel> searchData(@RequestBody SearchTerms terms)
			throws JsonMappingException, JsonProcessingException {
		RestTemplate restTemplate = new RestTemplate();
		List<InventoryModel> registerBean = new ArrayList<>(2);
		if (terms.getKey().equals("id")) {

		} else if (terms.getKey().equals("projectName")) {
			String fullUrl = contextUrl + "/search?projectName=" + terms.getSearchVal();
			ResponseEntity<List<InventoryModel>> response = restTemplate.exchange(fullUrl, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<InventoryModel>>() {
					});
			List<InventoryModel> inventoryList = response.getBody();
			System.out.println("-------------findByproject list size--" + inventoryList.size());
			return inventoryList;

		} else if (terms.getKey().equals("submitterEmail")) {

		} else if (terms.getKey().equals("summaryDetails")) {

		} else {
			String fullUrl = contextUrl + "/findAll";
			ResponseEntity<List<InventoryModel>> response = restTemplate.exchange(fullUrl, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<InventoryModel>>() {
					});

			List<InventoryModel> inventoryList = response.getBody();
			System.out.println("-------------findAll list size--" + inventoryList.size());

			return inventoryList;
		}

		return registerBean;
	}

	@GetMapping("/register")
	public String getRegistration() {
		return "/register";
	}

	@PostMapping("/save")
	public String saveInnovationDetails(@RequestBody InventoryModel registerBean) throws JsonProcessingException {

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(registerBean);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(json, headers);

		ResponseEntity<InventoryModel> responseEntityPerson = restTemplate.postForEntity(contextUrl + "/save", request,
				InventoryModel.class);

		System.out.println("------------------" + responseEntityPerson.getBody());
		return responseEntityPerson.getBody().getProjectName() + " succesfully saved on "
				+ responseEntityPerson.getBody().getSubmittedDate() + " with ID"
				+ responseEntityPerson.getBody().getId();
	}

}
