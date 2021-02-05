package com.networth.models;

import java.util.List;

public class LineItemsContainer {

    private List<AssetCategory> assets;

    private List<LiabilityCategory> liabilities;

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

}
