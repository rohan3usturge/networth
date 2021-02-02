package com.networth.svc;

import com.networth.svc.models.NetWorthDm;

public interface NetWorthService {

	NetWorthDm getDefaultNetWorth();

	NetWorthDm calculate(NetWorthDm networthDomainModel);

}
