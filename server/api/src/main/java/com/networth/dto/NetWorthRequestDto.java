package com.networth.dto;

import com.networth.svc.models.PortfolioDm;

public class NetWorthRequestDto {

    private String targetCurrencyCode;

    private PortfolioDm portfolio;

    public PortfolioDm getPortfolio() {
        return this.portfolio;
    }

    public void setPortfolio(PortfolioDm portfolio) {
        this.portfolio = portfolio;
    }

    public String getTargetCurrencyCode() {
        return this.targetCurrencyCode;
    }

    public void setTargetCurrencyCode(String targetCurrencyCode) {
        this.targetCurrencyCode = targetCurrencyCode;
    }
}
