package com.networth.models;

import java.util.List;

public class LiabilityCategory {

    private LineItemCategoryMetadata meta;

    private List<Liability> items;

    public LiabilityCategory(LineItemCategoryMetadata meta, List<Liability> items) {
        this.meta = meta;
        this.items = items;
    }

    public LineItemCategoryMetadata getMeta() {
        return this.meta;
    }

    public void setMeta(LineItemCategoryMetadata meta) {
        this.meta = meta;
    }

    public List<Liability> getItems() {
        return this.items;
    }

    public void setItems(List<Liability> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "{" + " meta='" + getMeta() + "'" + ", items='" + getItems() + "'" + "}";
    }

}
