package com.networth.svc.calculators;

import java.util.List;

import com.networth.svc.models.AssetCategoryDm;
import com.networth.svc.models.CalculationContext;
import com.networth.svc.models.LiabilityCategoryDm;
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
        NetWorthDm netWorthDm = new NetWorthDm();
        Double totalAssets = processAssets(targetCurrencyCode, portfolio);
        Double totalLiabilities = processLiabilities(targetCurrencyCode, portfolio);
        Double totalNetWorth = totalAssets - totalLiabilities;
        netWorthDm.setTotalAssets(totalAssets);
        netWorthDm.setTotalNetWorth(totalNetWorth);
        netWorthDm.setTotalLiabilities(totalLiabilities);
        portfolio.setNetWorth(netWorthDm);
        portfolio.setCurrencyCode(targetCurrencyCode);
        return portfolio;

    }

    private Double processAssets(String targetCurrencyCode, PortfolioDm portfolio) {
        CalculationContext<List<AssetCategoryDm>> assetContext = new CalculationContext<>(portfolio.getCurrencyCode(),
                targetCurrencyCode, portfolio.getLineItems().getAssets());
        return assetCalculator.calculate(assetContext);
    }

    private Double processLiabilities(String targetCurrencyCode, PortfolioDm portfolio) {
        CalculationContext<List<LiabilityCategoryDm>> liabilityContext = new CalculationContext<>(
                portfolio.getCurrencyCode(), targetCurrencyCode, portfolio.getLineItems().getLiabilities());
        return liabilityCalculator.calculate(liabilityContext);
    }

}
