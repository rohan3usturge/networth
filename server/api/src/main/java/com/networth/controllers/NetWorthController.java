package com.networth.controllers;

import com.networth.dto.NwCalculateRequestDto;
import com.networth.infra.mapper.InfraMapper;
import com.networth.svc.NetWorthService;
import com.networth.svc.models.NetWorthDm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/networth")
public class NetWorthController {

	private NetWorthService nwService;
	private InfraMapper infraMapper;

	public NetWorthController(NetWorthService nwService, InfraMapper infraMapper) {
		super();
		this.nwService = nwService;
		this.infraMapper = infraMapper;
	}

	@GetMapping()
	public NetWorthDm getDefaultNetWorth() {
		return this.nwService.getDefaultNetWorth();
	}

	@PostMapping()
	public void calculateNetWorth(@RequestBody NwCalculateRequestDto nwCalculateRequestDto) {
		NetWorthDm netWorthDm = infraMapper.map(nwCalculateRequestDto, NetWorthDm.class);
		nwService.calculate(netWorthDm);
	}
}
