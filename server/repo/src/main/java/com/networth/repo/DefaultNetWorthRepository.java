package com.networth.repo;

import java.util.Random;

import com.networth.builder.AssetBuilder;
import com.networth.builder.AssetCategoryBuilder;
import com.networth.builder.LiabilityBuilder;
import com.networth.builder.LiabilityCategoryBuilder;
import com.networth.builder.LineItemsContainerBuilder;
import com.networth.models.Asset;
import com.networth.models.AssetCategory;
import com.networth.models.Liability;
import com.networth.models.LiabilityCategory;
import com.networth.models.LineItemsContainer;

import org.springframework.stereotype.Repository;

@Repository
public class DefaultNetWorthRepository implements NetWorthRepository {

    @Override
    public LineItemsContainer getLineItemsContainer() {
        LineItemsContainerBuilder builder = new LineItemsContainerBuilder();
        int categoryCount = 5;
        int aCount = 7;
        int lCount = 3;

        for (int i = 0; i < categoryCount; i++) {

            boolean isOdd = i % 2 != 0;

            if (isOdd) {
                AssetCategoryBuilder aCategoryBuilder = new AssetCategoryBuilder();
                aCategoryBuilder.name("AssetCategory " + i);
                for (int j = 0; j < aCount; j++) {
                    AssetBuilder aBuilder = new AssetBuilder();
                    aBuilder.name("Asset -" + j);
                    aBuilder.amount(new Random().nextDouble());
                    Asset asset = aBuilder.build();
                    aCategoryBuilder.addItem(asset);

                }
                AssetCategory aCategory = aCategoryBuilder.build();
                builder.addCategory(aCategory);
            } else {
                LiabilityCategoryBuilder lCategoryBuilder = new LiabilityCategoryBuilder();
                lCategoryBuilder.name("LiabilityCategory " + i);
                for (int j = 0; j < lCount; j++) {

                    LiabilityBuilder lBuilder = new LiabilityBuilder();
                    lBuilder.name("Liablitity  -" + j);
                    lBuilder.amount(new Random().nextDouble());
                    Liability liablity = lBuilder.build();
                    lCategoryBuilder.addItem(liablity);
                }

                LiabilityCategory aCategory = lCategoryBuilder.build();
                builder.addCategory(aCategory);
            }

        }

        return builder.build();
    }

}
