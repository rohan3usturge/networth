package com.networth.svc.calculators;

import java.util.List;

import com.networth.svc.models.AssetCategoryDm;
import com.networth.svc.models.CalculationContext;

public interface AssetCalculator {

    Double calculate(CalculationContext<List<AssetCategoryDm>> context);
}
