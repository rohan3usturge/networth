package com.networth.svc.calculators;

import java.util.List;

import com.networth.svc.CurrencyService;
import com.networth.svc.models.AssetCategoryDm;
import com.networth.svc.models.AssetDm;
import com.networth.svc.models.CalculationContext;
import com.networth.svc.models.LineItemDm;

import org.springframework.stereotype.Service;

@Service
public class DefaultAssetCalculator implements AssetCalculator {

    private CurrencyService currencyService;

    public DefaultAssetCalculator(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Override
    public Double calculate(CalculationContext<List<AssetCategoryDm>> context) {
        Double totalAssets = 0.0;
        for (AssetCategoryDm category : context.getPayload()) {
            for (AssetDm item : category.getItems()) {
                LineItemDm lineItem = item.getLineItem();
                Double conversionRate = currencyService.getConversionRate(context.getCurrentCode());
                totalAssets += lineItem.getAmount() * conversionRate;
            }
        }
        return totalAssets;
    }

}
