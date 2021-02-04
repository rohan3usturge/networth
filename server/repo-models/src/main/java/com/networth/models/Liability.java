package com.networth.models;

public class Liability {

    private LineItem lineItem;

    private Double monthlyPayment;

    public Liability(LineItem lineItem, Double monthlyPayment) {
        this.lineItem = lineItem;
        this.monthlyPayment = monthlyPayment;
    }

    public LineItem getLineItem() {
        return this.lineItem;
    }

    public void setLineItem(LineItem lineItem) {
        this.lineItem = lineItem;
    }

    public Double getMonthlyPayment() {
        return this.monthlyPayment;
    }

    public void setMonthlyPayment(Double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public String toString() {
        return "{" + " lineItem='" + getLineItem() + "'" + ", monthlyPayment='" + getMonthlyPayment() + "'" + "}";
    }

}
