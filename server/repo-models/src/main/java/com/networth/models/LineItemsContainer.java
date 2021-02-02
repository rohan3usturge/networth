package com.networth.models;

import java.util.List;

public class LineItemsContainer {

    private List<AssetCategory> assets;

    private List<LiabilityCategory> liabilities;

    public LineItemsContainer(List<AssetCategory> assets, List<LiabilityCategory> liabilities) {
        this.assets = assets;
        this.liabilities = liabilities;
    }

    public List<AssetCategory> getAssets() {
        return this.assets;
    }

    public void setAssets(List<AssetCategory> assets) {
        this.assets = assets;
    }

    public List<LiabilityCategory> getLiabilities() {
        return this.liabilities;
    }

    public void setLiabilities(List<LiabilityCategory> liabilities) {
        this.liabilities = liabilities;
    }

    @Override
    public String toString() {
        return "{" + " assets='" + getAssets() + "'" + ", liabilities='" + getLiabilities() + "'" + "}";
    }

}
