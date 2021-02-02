package com.networth.svc.models;

import java.util.List;

public class AssetCategoryDm {

    private LineItemCategoryMetadataDm meta;

    private List<AssetDm> items;

    public LineItemCategoryMetadataDm getMeta() {
        return this.meta;
    }

    public void setMeta(LineItemCategoryMetadataDm meta) {
        this.meta = meta;
    }

    public List<AssetDm> getItems() {
        return this.items;
    }

    public void setItems(List<AssetDm> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "{" + " meta='" + getMeta() + "'" + ", items='" + getItems() + "'" + "}";
    }

}
