package com.networth.svc.models;

import java.util.List;

public class LineItemCategoryDm {

	private LineItemCategoryType type;

	private List<LineItemDm> items;

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

	@Override
	public String toString() {
		return "LineItemCategory [type=" + type + ", items=" + items + "]";
	}

}
