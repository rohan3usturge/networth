package com.networth.dto;

import com.networth.svc.models.PortfolioDm;

public class NetWorthResponseDto {

    private PortfolioDm portfolio;

    public PortfolioDm getPortfolio() {
        return this.portfolio;
    }

    public void setPortfolio(PortfolioDm portfolio) {
        this.portfolio = portfolio;
    }

    @Override
    public String toString() {
        return "{" + " portfolio='" + getPortfolio() + "'" + "}";
    }

}
