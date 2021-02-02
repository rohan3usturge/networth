package com.networth.svc.models;

public class LiabilityDm {

    private LineItemDm lineItem;

    private Double mothlyPayment;

    public LineItemDm getLineItem() {
        return this.lineItem;
    }

    public void setLineItem(LineItemDm lineItem) {
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
