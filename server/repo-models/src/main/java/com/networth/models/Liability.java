package com.networth.models;

public class Liability {

    private LineItem lineItem;

    private Double mothlyPayment;

    public Liability(LineItem lineItem, Double mothlyPayment) {
        this.lineItem = lineItem;
        this.mothlyPayment = mothlyPayment;
    }

    public LineItem getLineItem() {
        return this.lineItem;
    }

    public void setLineItem(LineItem lineItem) {
        this.lineItem = lineItem;
    }

    public Double getMothlyPayment() {
        return this.mothlyPayment;
    }

    public void setMothlyPayment(Double mothlyPayment) {
        this.mothlyPayment = mothlyPayment;
    }

    @Override
    public String toString() {
        return "{" + " lineItem='" + getLineItem() + "'" + ", mothlyPayment='" + getMothlyPayment() + "'" + "}";
    }

}
