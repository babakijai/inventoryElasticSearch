package com.elasticsearch.bean;

import org.springframework.stereotype.Component;

@Component
public class SearchTerms {
	
	private String key;
	private String searchVal;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getSearchVal() {
		return searchVal;
	}
	public void setSearchVal(String searchVal) {
		this.searchVal = searchVal;
	}

}
