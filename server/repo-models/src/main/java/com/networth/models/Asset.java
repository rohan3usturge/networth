package com.networth.models;

public class Asset {

    private LineItem lineItem;

    public Asset(LineItem lineItem) {
        this.lineItem = lineItem;
    }

    public LineItem getLineItem() {
        return this.lineItem;
    }

    public void setLineItem(LineItem lineItem) {
        this.lineItem = lineItem;
    }

    @Override
    public String toString() {
        return "{" + " lineItem='" + getLineItem() + "'" + "}";
    }

}
