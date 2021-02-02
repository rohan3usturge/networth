package com.networth.builder;

import java.util.ArrayList;
import java.util.List;

import com.networth.models.AssetCategory;
import com.networth.models.LiabilityCategory;
import com.networth.models.LineItemsContainer;

public class LineItemsContainerBuilder {
    private List<AssetCategory> assets;

    private List<LiabilityCategory> liabilities;

    public LineItemsContainerBuilder() {
        this.assets = new ArrayList<>();
        this.liabilities = new ArrayList<>();
    }

    public LineItemsContainerBuilder addAssetCategory(AssetCategory assetCategory) {
        this.assets.add(assetCategory);
        return this;
    }

    public LineItemsContainerBuilder addAssetCategory(LiabilityCategory liabilityCategory) {
        this.liabilities.add(liabilityCategory);
        return this;
    }

    public LineItemsContainer build() {
        return new LineItemsContainer(this.assets, this.liabilities);
    }
}
