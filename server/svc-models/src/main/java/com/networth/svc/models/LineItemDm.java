package com.networth.svc.models;

public class LineItemDm {

	private String id;
	private String name;
	private Double amount;
	private String displayAmount;

	public String getDisplayAmount() {
		return this.displayAmount;
	}

	public void setDisplayAmount(String displayAmount) {
		this.displayAmount = displayAmount;
	}

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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", amount='" + getAmount() + "'" + "}";
	}

}
