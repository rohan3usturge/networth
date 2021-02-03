package com.networth.dto;

import com.networth.svc.models.LineItemsContainerDm;

public class NetWorthRequestDto {

    private String currencyCode;

    private String targetCurrencyCode;

    private LineItemsContainerDm lineItems;

    public String getTargetCurrencyCode() {
        return this.targetCurrencyCode;
    }

    public void setTargetCurrencyCode(String targetCurrencyCode) {
        this.targetCurrencyCode = targetCurrencyCode;
    }

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

}
