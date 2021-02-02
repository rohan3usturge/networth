package com.networth.builder;

import java.util.UUID;

import com.networth.models.Asset;
import com.networth.models.LineItem;

public class AssetBuilder {

    private String id;
    private String name;
    private Double amount;

    public AssetBuilder() {
        this.id = UUID.randomUUID().toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Asset build() {
        return new Asset(new LineItem(this.id, this.name, this.amount));
    }

}
