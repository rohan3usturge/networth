package com.networth.svc.models;

public class LineItemDm {

	private String id;
	private String name;
	private double amount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return "LineItemDm [name=" + name + ", amount=" + amount + "]";
	}

}
