package com.wells.inventory.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "inventoryindex")
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor

public class InventoryModel {
	@Id
	@NotNull(message = "Invalide value for id")
	private String id;
	@NotNull(message = "Invalide value for submitterEmail")
	@Field(type = FieldType.Text, name = "submitterEmail")
	private String submitterEmail;
	@NotNull(message = "Invalide value for projectName")
	@Field(type = FieldType.Text, name = "projectName")
	private String projectName;
	@NotNull(message = "Invalide value for summaryDetails")
	@Field(type = FieldType.Text, name = "summaryDetails")
	private String summaryDetails;
	@NotNull(message = "Invalide value for petented")
	@Field(type = FieldType.Text, name = "petented")
	private String petented;
	@NotNull(message = "Invalide value for projectLink")
	@Field(type = FieldType.Text, name = "projectLink")
	private String projectLink;
	@NotNull(message = "Invalide value for submittedDate ,allowed format yyyy-mm-dd")
	@Field(type = FieldType.Text, name = "submittedDate")
	private String submittedDate;
	
	public String getPetented() {
		return petented;
	}

	public void setPetented(String petented) {
		this.petented = petented;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubmitterEmail() {
		return submitterEmail;
	}

	public void setSubmitterEmail(String submitterEmail) {
		this.submitterEmail = submitterEmail;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getSummaryDetails() {
		return summaryDetails;
	}

	public void setSummaryDetails(String summaryDetails) {
		this.summaryDetails = summaryDetails;
	}

	

	public String getProjectLink() {
		return projectLink;
	}

	public void setProjectLink(String projectLink) {
		this.projectLink = projectLink;
	}

	public String getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}

}
