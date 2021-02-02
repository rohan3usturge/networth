package com.networth.dto;

import com.networth.svc.models.CurrencyCode;
import com.networth.svc.models.LineItemsContainerDm;

public class NetWorthRequestDto {

    private CurrencyCode currencyCode;

    private LineItemsContainerDm lineItems;

    public CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }

    public LineItemsContainerDm getLineItems() {
        return this.lineItems;
    }

    public void setLineItems(LineItemsContainerDm lineItems) {
        this.lineItems = lineItems;
    }

    @Override
    public String toString() {
        return "{" + " currencyCode='" + getCurrencyCode() + "'" + ", lineItems='" + getLineItems() + "'" + "}";
    }

}
