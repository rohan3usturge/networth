package com.networth.models;

public class LineItemCategoryMetadata {

	private String id;
	private String name;

	public LineItemCategoryMetadata(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "{" + " name='" + getName() + "'" + "}";
	}

}
