package com.networth.svc;

import com.networth.infra.mapper.InfraMapper;
import com.networth.models.LineItemsContainer;
import com.networth.repo.NetWorthRepository;
import com.networth.svc.calculators.NetWorthCalculator;
import com.networth.svc.models.LineItemsContainerDm;
import com.networth.svc.models.NetWorthDm;

import org.springframework.stereotype.Service;

@Service
public class DefaultNetWorthService implements NetWorthService {

	private NetWorthRepository netWorthRepository;
	private NetWorthCalculator netWorthCalculator;
	private InfraMapper infraMapper;

	public DefaultNetWorthService(NetWorthRepository netWorthRepository, NetWorthCalculator netWorthCalculator,
			InfraMapper infraMapper) {
		this.netWorthRepository = netWorthRepository;
		this.netWorthCalculator = netWorthCalculator;
		this.infraMapper = infraMapper;
	}

	@Override
	public NetWorthDm calculate(String currentCode, LineItemsContainerDm lineItems) {
		return this.netWorthCalculator.calculate(currentCode, lineItems);
	}

	@Override
	public LineItemsContainerDm getLineItemsContainer() {
		LineItemsContainer savedNetWorth = netWorthRepository.getLineItemsContainer();
		return this.infraMapper.map(savedNetWorth, LineItemsContainerDm.class);
	}
}
