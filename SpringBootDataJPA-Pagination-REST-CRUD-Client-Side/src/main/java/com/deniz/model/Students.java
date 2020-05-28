package com.deniz.model;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Students extends RepresentationModel{
	
	@JsonProperty("_embedded")
	private StudentsEmbeddedListJson embedded;
	
	Page page;

	public StudentsEmbeddedListJson getEmbedded() {
		return embedded;
	}

	public void setEmbedded(StudentsEmbeddedListJson embedded) {
		this.embedded = embedded;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	
	
}
