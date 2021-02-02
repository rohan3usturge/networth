package com.networth.repo;

import java.util.ArrayList;
import java.util.List;

import com.networth.models.LineItem;
import com.networth.models.LineItemCategory;
import com.networth.models.NetWorth;

import org.springframework.stereotype.Repository;

@Repository
public class DefaultNetWorthRepository implements NetWorthRepository {

    /**
     *
     */
    private static final String LIABILITY = "LIABILITY";
    /**
     *
     */
    private static final String ASSET = "ASSET";

    @Override
    public NetWorth getDefaultNetWorth() {
        List<LineItemCategory> categories = new ArrayList<>();

        LineItem item = new LineItem("1", "Cash and Investments", "Description1", 2000);
        LineItem item2 = new LineItem("2", "Primary Home", "Description1", 2000);
        LineItem item3 = new LineItem("3", "Credit Cart 1", "Description``", 2000);
        LineItem item4 = new LineItem("4", "Mortgage1", "Descriptio`1`1n", 2000);

        List<LineItem> category1Items = new ArrayList<>();
        category1Items.add(item);
        LineItemCategory category = new LineItemCategory("First", ASSET, category1Items);
        categories.add(category);

        List<LineItem> category2Items = new ArrayList<>();
        category2Items.add(item2);
        LineItemCategory category2 = new LineItemCategory("Second", ASSET, category2Items);
        categories.add(category2);

        List<LineItem> category3Items = new ArrayList<>();
        category3Items.add(item3);
        LineItemCategory category3 = new LineItemCategory("Third", LIABILITY, category3Items);
        categories.add(category3);

        List<LineItem> category4Items = new ArrayList<>();
        category4Items.add(item4);
        LineItemCategory category4 = new LineItemCategory("Fourth", LIABILITY, category4Items);
        categories.add(category4);

        NetWorth netWorth = new NetWorth();
        netWorth.setCategories(categories);
        return netWorth;
    }

}
