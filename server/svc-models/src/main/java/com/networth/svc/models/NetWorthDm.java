package com.networth.svc.models;

public class NetWorthDm {

    private Double totalNetWorth;
    private Double totalAssets;
    private Double totalLiabilities;

    public Double getTotalNetWorth() {
        return this.totalNetWorth;
    }

    public void setTotalNetWorth(Double totalNetWorth) {
        this.totalNetWorth = totalNetWorth;
    }

    public Double getTotalAssets() {
        return this.totalAssets;
    }

    public void setTotalAssets(Double totalAssets) {
        this.totalAssets = totalAssets;
    }

    public Double getTotalLiabilities() {
        return this.totalLiabilities;
    }

    public void setTotalLiabilities(Double totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }
}
