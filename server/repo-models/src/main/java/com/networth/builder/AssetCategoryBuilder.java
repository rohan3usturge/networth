package com.networth.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.networth.models.Asset;
import com.networth.models.AssetCategory;
import com.networth.models.LineItemCategoryMetadata;

public class AssetCategoryBuilder {
    private String name;
    private List<Asset> items;

    public AssetCategoryBuilder() {
        this.items = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addItem(Asset item) {
        this.items.add(item);
    }

    public AssetCategory build() {
        return new AssetCategory(new LineItemCategoryMetadata(UUID.randomUUID().toString(), this.name), this.items);
    }

}
