package com.networth.models;

import java.util.List;

public class NetWorth {

    private List<LineItemCategory> categories;

    public List<LineItemCategory> getCategories() {
        return this.categories;
    }

    public void setCategories(List<LineItemCategory> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "{" + " categories='" + getCategories() + "'" + "}";
    }

}
