package com.networth.svc.models;

public class AssetDm {

    private LineItemDm lineItem;

    public LineItemDm getLineItem() {
        return this.lineItem;
    }

    public void setLineItem(LineItemDm lineItem) {
        this.lineItem = lineItem;
    }

    @Override
    public String toString() {
        return "{" + " lineItem='" + getLineItem() + "'" + "}";
    }

}
