package com.networth.repo;

import com.networth.builder.AssetBuilder;
import com.networth.builder.AssetCategoryBuilder;
import com.networth.builder.LineItemsContainerBuilder;
import com.networth.models.Asset;
import com.networth.models.AssetCategory;
import com.networth.models.LineItemsContainer;

import org.springframework.stereotype.Repository;

@Repository
public class DefaultNetWorthRepository implements NetWorthRepository {

    @Override
    public LineItemsContainer getLineItemsContainer() {
        LineItemsContainerBuilder builder = new LineItemsContainerBuilder();

        AssetCategoryBuilder aCategoryBuilder = new AssetCategoryBuilder();
        for (int i = 0; i < 100; i++) {
            AssetBuilder assetBuilder = new AssetBuilder();
            assetBuilder.setName("Dummy 1");
            assetBuilder.setAmount(1212.2);
            Asset asset = assetBuilder.build();
            aCategoryBuilder.addItem(asset);
        }

        AssetCategory aCategory = aCategoryBuilder.build();
        builder.addAssetCategory(aCategory);

        return builder.build();
    }

}
