package com.networth.svc.models;

public class NetWorthDm {
    private String totalNetWorthDisplay;
    private Double totalNetWorth;

    private String totalAssetsDisplay;
    private Double totalAssets;
    private String totalLiabilitiesDisplay;
    private Double totalLiabilities;

    public String getTotalNetWorthDisplay() {
        return this.totalNetWorthDisplay;
    }

    public void setTotalNetWorthDisplay(String totalNetWorthDisplay) {
        this.totalNetWorthDisplay = totalNetWorthDisplay;
    }

    public String getTotalAssetsDisplay() {
        return this.totalAssetsDisplay;
    }

    public void setTotalAssetsDisplay(String totalAssetsDisplay) {
        this.totalAssetsDisplay = totalAssetsDisplay;
    }

    public String getTotalLiabilitiesDisplay() {
        return this.totalLiabilitiesDisplay;
    }

    public void setTotalLiabilitiesDisplay(String totalLiabilitiesDisplay) {
        this.totalLiabilitiesDisplay = totalLiabilitiesDisplay;
    }

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

    @Override
    public String toString() {
        return "{" + " totalNetWorth='" + getTotalNetWorth() + "'" + ", totalAssets='" + getTotalAssets() + "'"
                + ", totalLiabilities='" + getTotalLiabilities() + "'" + "}";
    }

}
