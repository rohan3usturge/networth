package com.networth.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.networth.models.Liability;
import com.networth.models.LiabilityCategory;
import com.networth.models.LineItemCategoryMetadata;

public class LiabilityCategoryBuilder {
    private String name;
    private List<Liability> items;

    public LiabilityCategoryBuilder() {
        this.items = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addItem(Liability item) {
        this.items.add(item);
    }

    public LiabilityCategory build() {
        return new LiabilityCategory(new LineItemCategoryMetadata(UUID.randomUUID().toString(), this.name), this.items);
    }

}
