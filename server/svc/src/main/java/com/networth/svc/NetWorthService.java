package com.networth.svc;

import com.networth.svc.models.PortfolioDm;

public interface NetWorthService {

	PortfolioDm calculate(String targetCurrencyCode, PortfolioDm portfolio);

}
