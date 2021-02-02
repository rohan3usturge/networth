package com.networth.svc;

import java.util.List;

import com.networth.svc.models.AssetCategoryDm;
import com.networth.svc.models.CalculationContext;
import com.networth.svc.models.CurrencyCode;
import com.networth.svc.models.LiabilityCategoryDm;
import com.networth.svc.models.LineItemsContainerDm;
import com.networth.svc.models.NetWorthDm;

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
    public NetWorthDm calculate(CurrencyCode currentCode, LineItemsContainerDm container) {
        NetWorthDm netWorthDm = new NetWorthDm();
        CalculationContext<List<AssetCategoryDm>> assetContext = new CalculationContext<>(currentCode,
                container.getAssets());
        CalculationContext<List<LiabilityCategoryDm>> liabilityContext = new CalculationContext<>(currentCode,
                container.getLiabilities());
        Double totalAssets = assetCalculator.calculate(assetContext);
        Double totalLiabilities = liabilityCalculator.calculate(liabilityContext);
        Double totalNetWorth = totalAssets + totalLiabilities;
        netWorthDm.setTotalAssets(totalAssets);
        netWorthDm.setTotalNetWorth(totalNetWorth);
        netWorthDm.setTotalLiabilities(totalLiabilities);
        return netWorthDm;

    }

}
