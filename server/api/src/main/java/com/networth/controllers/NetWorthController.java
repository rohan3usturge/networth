package com.networth.controllers;

import com.networth.dto.NetWorthRequestDto;
import com.networth.dto.NetWorthResponseDto;
import com.networth.svc.NetWorthService;
import com.networth.svc.models.LineItemsContainerDm;
import com.networth.svc.models.PortfolioDm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/networth")
public class NetWorthController {

	private NetWorthService nwService;

	public NetWorthController(NetWorthService nwService) {
		this.nwService = nwService;
	}

	@GetMapping()
	public LineItemsContainerDm getLineItemsContainer() {
		return this.nwService.getLineItemsContainer();
	}

	@PostMapping()
	public NetWorthResponseDto calculateNetWorth(@RequestBody NetWorthRequestDto request) {
		String targetCurrencyCode = request.getTargetCurrencyCode();
		PortfolioDm portfolio = this.nwService.calculate(targetCurrencyCode, request.getPortfolio());
		NetWorthResponseDto responseDto = new NetWorthResponseDto();
		responseDto.setPortfolio(portfolio);
		return responseDto;
	}
}
