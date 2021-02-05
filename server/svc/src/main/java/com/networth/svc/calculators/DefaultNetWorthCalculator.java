package com.networth.svc.calculators;

import java.util.List;

import com.networth.svc.models.AssetCategoryDm;
import com.networth.svc.models.CalculationContext;
import com.networth.svc.models.LiabilityCategoryDm;
import com.networth.svc.models.LineItemsContainerDm;
import com.networth.svc.models.NetWorthDm;
import com.networth.svc.models.PortfolioDm;

import org.springframework.stereotype.Service;

@Service
public class DefaultNetWorthCalculator implements NetWorthCalculator {

    private AssetCalculator assetCalculator;
    private LiabilityCalculator liabilityCalculator;

    public DefaultNetWorthCalculator(AssetCalculator assetCalculator, LiabilityCalculator liabilityCalculator) {
        this.assetCalculator = assetCalculator;
        this.liabilityCalculator = liabilityCalculator;
    }

    @Override
    public PortfolioDm calculate(String targetCurrencyCode, PortfolioDm portfolio) {
        if (targetCurrencyCode == null) {
            targetCurrencyCode = portfolio.getCurrencyCode();
        }
        if (portfolio == null) {
            return null;
        }
        LineItemsContainerDm lineItems = portfolio.getLineItems();
        if (lineItems == null) {
            return portfolio;
        }
        NetWorthDm netWorthDm = new NetWorthDm();
        Double totalAssets;
        Double totalLiabilities;
        totalAssets = processAssets(targetCurrencyCode, portfolio.getCurrencyCode(), lineItems.getAssets());
        totalLiabilities = processLiabilities(targetCurrencyCode, portfolio.getCurrencyCode(),
                lineItems.getLiabilities());
        Double totalNetWorth = totalAssets - totalLiabilities;
        netWorthDm.setTotalAssets(totalAssets);
        netWorthDm.setTotalNetWorth(totalNetWorth);
        netWorthDm.setTotalLiabilities(totalLiabilities);
        portfolio.setNetWorth(netWorthDm);
        portfolio.setCurrencyCode(targetCurrencyCode);
        return portfolio;

    }

    private Double processLiabilities(String targetCurrencyCode, String currencyCode,
            List<LiabilityCategoryDm> liabilities) {
        if (liabilities == null || liabilities.isEmpty()) {
            return 0.0;
        }
        CalculationContext<List<LiabilityCategoryDm>> assetContext = new CalculationContext<>(currencyCode,
                targetCurrencyCode, liabilities);
        return liabilityCalculator.calculate(assetContext);
    }

    private Double processAssets(String targetCurrencyCode, String currencyCode, List<AssetCategoryDm> assets) {
        if (assets == null || assets.isEmpty()) {
            return 0.0;
        }
        CalculationContext<List<AssetCategoryDm>> assetContext = new CalculationContext<>(currencyCode,
                targetCurrencyCode, assets);
        return assetCalculator.calculate(assetContext);
    }

}
