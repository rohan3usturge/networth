package com.networth.controllers;

import com.networth.dto.NetWorthRequestDto;
import com.networth.dto.NetWorthResponseDto;
import com.networth.svc.NetWorthService;
import com.networth.svc.models.LineItemsContainerDm;
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

	public NetWorthController(NetWorthService nwService) {
		this.nwService = nwService;
	}

	@GetMapping()
	public LineItemsContainerDm getLineItemsContainer() {
		return this.nwService.getLineItemsContainer();
	}

	@PostMapping()
	public NetWorthResponseDto calculateNetWorth(@RequestBody NetWorthRequestDto lineItemsContainer) {
		String currencyCode = lineItemsContainer.getCurrencyCode();
		NetWorthDm netWorth = this.nwService.calculate(currencyCode, lineItemsContainer.getLineItems());
		NetWorthResponseDto responseDto = new NetWorthResponseDto();
		responseDto.setNetWorthDm(netWorth);
		responseDto.setCurrencyCode(currencyCode);
		return responseDto;

	}
}
