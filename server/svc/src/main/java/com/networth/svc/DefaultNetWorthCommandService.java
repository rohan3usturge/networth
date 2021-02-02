package com.networth.svc;

import com.networth.infra.mapper.InfraMapper;
import com.networth.models.NetWorth;
import com.networth.repo.NetWorthRepository;
import com.networth.svc.models.NetWorthDm;

import org.springframework.stereotype.Service;

@Service
public class DefaultNetWorthCommandService implements NetWorthService {

	private NetWorthRepository netWorthRepository;
	private InfraMapper infraMapper;

	public DefaultNetWorthCommandService(NetWorthRepository netWorthRepository, InfraMapper infraMapper) {
		this.netWorthRepository = netWorthRepository;
		this.infraMapper = infraMapper;
	}

	@Override
	public NetWorthDm calculate(NetWorthDm networthDomainModel) {
		NetWorth savedNetWorth = netWorthRepository.getDefaultNetWorth();
		return this.infraMapper.map(savedNetWorth, NetWorthDm.class);

	}

	@Override
	public NetWorthDm getDefaultNetWorth() {
		NetWorth savedNetWorth = netWorthRepository.getDefaultNetWorth();
		return this.infraMapper.map(savedNetWorth, NetWorthDm.class);
	}
}
