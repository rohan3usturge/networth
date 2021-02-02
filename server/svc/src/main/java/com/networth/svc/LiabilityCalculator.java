package com.networth.svc;

import java.util.List;

import com.networth.svc.models.CalculationContext;
import com.networth.svc.models.LiabilityCategoryDm;

public interface LiabilityCalculator {
    Double calculate(CalculationContext<List<LiabilityCategoryDm>> context);
}
