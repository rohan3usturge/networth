package com.networth.svc.models;

import java.util.List;

public class LiabilityCategoryDm {

    private LineItemCategoryMetadataDm meta;

    private List<LiabilityDm> items;

    public LineItemCategoryMetadataDm getMeta() {
        return this.meta;
    }

    public void setMeta(LineItemCategoryMetadataDm meta) {
        this.meta = meta;
    }

    public List<LiabilityDm> getItems() {
        return this.items;
    }

    public void setItems(List<LiabilityDm> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "{" + " meta='" + getMeta() + "'" + ", items='" + getItems() + "'" + "}";
    }

}
