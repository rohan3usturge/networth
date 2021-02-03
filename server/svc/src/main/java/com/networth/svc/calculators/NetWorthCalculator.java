package com.networth.svc.calculators;

import com.networth.svc.models.LineItemsContainerDm;
import com.networth.svc.models.NetWorthDm;

public interface NetWorthCalculator {
    public NetWorthDm calculate(String currentCode, LineItemsContainerDm container);
}
