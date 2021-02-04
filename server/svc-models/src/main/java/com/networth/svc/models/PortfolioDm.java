package com.networth.svc.models;

public class PortfolioDm {

    private String currencyCode;

    private LineItemsContainerDm lineItems;

    private NetWorthDm netWorth;

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public LineItemsContainerDm getLineItems() {
        return this.lineItems;
    }

    public void setLineItems(LineItemsContainerDm lineItems) {
        this.lineItems = lineItems;
    }

    public NetWorthDm getNetWorth() {
        return this.netWorth;
    }

    public void setNetWorth(NetWorthDm netWorth) {
        this.netWorth = netWorth;
    }

    @Override
    public String toString() {
        return "{" + " currencyCode='" + getCurrencyCode() + "'" + ", lineItems='" + getLineItems() + "'"
                + ", netWorth='" + getNetWorth() + "'" + "}";
    }

}
