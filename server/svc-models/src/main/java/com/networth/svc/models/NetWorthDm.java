package com.networth.svc.models;

import java.util.List;

public class NetWorthDm {

    private List<LineItemCategoryDm> categories;

    public List<LineItemCategoryDm> getCategories() {
        return this.categories;
    }

    public void setCategories(List<LineItemCategoryDm> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "{" + " categories='" + getCategories() + "'" + "}";
    }

}
