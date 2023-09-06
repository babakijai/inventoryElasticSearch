package com.elasticsearch.bean;

import org.springframework.stereotype.Component;

@Component
public class InventoryModel {

	private String id;
	private String submitterEmail;
	private String projectName;
	private String summaryDetails;
	private String petented;
	private String projectLink;
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

	public String getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
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

}
