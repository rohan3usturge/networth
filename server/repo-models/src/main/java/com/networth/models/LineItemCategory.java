package com.networth.models;

import java.util.List;

public class LineItemCategory {

	private String name;

	private String type;

	private List<LineItem> items;

	public LineItemCategory(String name, String type, List<LineItem> items) {
		this.name = name;
		this.type = type;
		this.items = items;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<LineItem> getItems() {
		return items;
	}

	public void setItems(List<LineItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "{" + " name='" + getName() + "'" + ", type='" + getType() + "'" + ", items='" + getItems() + "'" + "}";
	}

}
