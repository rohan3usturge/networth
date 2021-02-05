package com.networth.models;

import java.util.List;

public class AssetCategory {

    private LineItemCategoryMetadata meta;

    private List<Asset> items;

    public LineItemCategoryMetadata getMeta() {
        return this.meta;
    }

    public void setMeta(LineItemCategoryMetadata meta) {
        this.meta = meta;
    }

    public List<Asset> getItems() {
        return this.items;
    }

    public void setItems(List<Asset> items) {
        this.items = items;
    }

}
