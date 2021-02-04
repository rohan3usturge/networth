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

    private void setName(String name) {
        this.name = name;
    }

    private void setAmount(Double amount) {
        this.amount = amount;
    }

    public AssetBuilder name(String name) {
        setName(name);
        return this;
    }

    public AssetBuilder amount(Double amount) {
        setAmount(amount);
        return this;
    }

    public Asset build() {
        return new Asset(new LineItem(this.id, this.name, this.amount));
    }

}
