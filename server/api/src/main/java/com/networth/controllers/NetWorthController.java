package com.networth.controllers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.networth.dto.NetWorthRequestDto;
import com.networth.dto.NetWorthResponseDto;
import com.networth.models.Currency;
import com.networth.svc.CurrencyService;
import com.networth.svc.NetWorthService;
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
	private CurrencyService currencyService;

	public NetWorthController(NetWorthService nwService, CurrencyService currencyService) {
		this.nwService = nwService;
		this.currencyService = currencyService;
	}

	@GetMapping(path = "/currencies")
	public Collection<String> getSupportedCurrencies() {
		List<Currency> all = this.currencyService.getAll();
		return all.stream().map(Currency::getCurrencyCode).collect(Collectors.toList());
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
