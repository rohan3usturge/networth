package com.networth.svc.models;

public class LineItemDm {

	private String id;
	private String name;
	private String description;
	private double amount;

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
		return "LineItemDm [id=" + id + ", name=" + name + ", description=" + description + ", amount=" + amount + "]";
	}

}
