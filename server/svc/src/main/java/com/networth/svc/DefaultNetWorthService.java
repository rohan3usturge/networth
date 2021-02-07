package com.networth.svc;

import com.networth.svc.calculators.NetWorthCalculator;
import com.networth.svc.models.PortfolioDm;

import org.springframework.stereotype.Service;

@Service
public class DefaultNetWorthService implements NetWorthService {

	private NetWorthCalculator netWorthCalculator;

	public DefaultNetWorthService(NetWorthCalculator netWorthCalculator) {
		this.netWorthCalculator = netWorthCalculator;
	}

	@Override
	public PortfolioDm calculate(String targetCurrencyCode, PortfolioDm portfolio) {
		return this.netWorthCalculator.calculate(targetCurrencyCode, portfolio);
	}
}
