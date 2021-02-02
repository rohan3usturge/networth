package com.networth.svc.models;

import java.util.List;

public class LineItemCategoryDm {

	private String name;

	private LineItemCategoryType type;

	private List<LineItemDm> items;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LineItemCategoryType getType() {
		return type;
	}

	public void setType(LineItemCategoryType type) {
		this.type = type;
	}

	public List<LineItemDm> getItems() {
		return items;
	}

	public void setItems(List<LineItemDm> items) {
		this.items = items;
	}

}
