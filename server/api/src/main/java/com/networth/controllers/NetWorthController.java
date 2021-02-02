package com.networth.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.networth.dto.NwCalculateRequestDto;
import com.networth.infra.mapper.InfraMapper;
import com.networth.svc.NetWorthService;

@RestController()
@RequestMapping("/networth")
public class NetWorthController {

	private NetWorthService nwService;
	private InfraMapper infraMapper;

	public NetWorthController(NetWorthService cartCommandService, InfraMapper infraMapper) {
		super();
		this.nwService = cartCommandService;
		this.infraMapper = infraMapper;
	}

	@PostMapping()
	public void calculateNetWorth(@RequestBody NwCalculateRequestDto cart) {
		nwService.calculate();
	}
}
