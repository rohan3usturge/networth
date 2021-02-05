package com.networth.models;

import java.util.List;

public class LiabilityCategory {

    private LineItemCategoryMetadata meta;

    private List<Liability> items;

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

}
