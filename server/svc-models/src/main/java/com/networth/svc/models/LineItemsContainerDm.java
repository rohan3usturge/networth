package com.networth.svc.models;

import java.util.List;

public class LineItemsContainerDm {

    private List<AssetCategoryDm> assets;

    private List<LiabilityCategoryDm> liabilities;

    public List<AssetCategoryDm> getAssets() {
        return this.assets;
    }

    public void setAssets(List<AssetCategoryDm> assets) {
        this.assets = assets;
    }

    public List<LiabilityCategoryDm> getLiabilities() {
        return this.liabilities;
    }

    public void setLiabilities(List<LiabilityCategoryDm> liabilities) {
        this.liabilities = liabilities;
    }

    @Override
    public String toString() {
        return "{" + " assets='" + getAssets() + "'" + ", liabilities='" + getLiabilities() + "'" + "}";
    }

}
