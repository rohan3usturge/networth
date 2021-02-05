package com.networth.svc.models;

public class LiabilityDm {

    private LineItemDm lineItem;

    private Double monthlyPayment;

    public LineItemDm getLineItem() {
        return this.lineItem;
    }

    public void setLineItem(LineItemDm lineItem) {
        this.lineItem = lineItem;
    }

    public Double getMonthlyPayment() {
        return this.monthlyPayment;
    }

    public void setMonthlyPayment(Double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

}
