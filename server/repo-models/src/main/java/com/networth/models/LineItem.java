package com.networth.models;

public class LineItem {

	private String id;
	private String name;
	private String description;
	private double amount;

	public LineItem(String id, String name, String description, double amount) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", description='" + getDescription() + "'"
				+ ", amount='" + getAmount() + "'" + "}";
	}

}
