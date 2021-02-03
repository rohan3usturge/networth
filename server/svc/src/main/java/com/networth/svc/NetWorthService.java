package com.networth.svc;

import com.networth.svc.models.LineItemsContainerDm;
import com.networth.svc.models.NetWorthDm;

public interface NetWorthService {

	LineItemsContainerDm getLineItemsContainer();

	NetWorthDm calculate(String currentCode, LineItemsContainerDm lineItems);

}
