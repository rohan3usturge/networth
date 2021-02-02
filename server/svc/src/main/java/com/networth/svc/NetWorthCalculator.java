package com.networth.svc;

import com.networth.svc.models.CurrencyCode;
import com.networth.svc.models.LineItemsContainerDm;
import com.networth.svc.models.NetWorthDm;

public interface NetWorthCalculator {
    public NetWorthDm calculate(CurrencyCode currentCode, LineItemsContainerDm container);
}
