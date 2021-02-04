package com.networth.svc;

import com.networth.svc.models.LineItemsContainerDm;
import com.networth.svc.models.PortfolioDm;

public interface NetWorthService {

	LineItemsContainerDm getLineItemsContainer();

	PortfolioDm calculate(String targetCurrencyCode, PortfolioDm portfolio);

}
