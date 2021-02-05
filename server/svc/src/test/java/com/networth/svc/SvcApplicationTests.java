package com.networth.svc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.networth.svc.calculators.AssetCalculator;
import com.networth.svc.calculators.DefaultAssetCalculator;
import com.networth.svc.calculators.DefaultLiabilityCalculator;
import com.networth.svc.calculators.DefaultNetWorthCalculator;
import com.networth.svc.calculators.LiabilityCalculator;
import com.networth.svc.calculators.NetWorthCalculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SvcApplicationTests {

	@Autowired
	private CurrencyService currencyService;

	@Autowired
	private NetWorthService netWorthService;

	@Autowired
	private AssetCalculator assetCalculator;

	@Autowired
	private LiabilityCalculator liabilityCalculator;

	@Autowired
	private NetWorthCalculator netWorthCalculator;

	@Test
	void contextLoads() {

		assertNotNull(currencyService);
		assertNotNull(netWorthService);
		assertNotNull(assetCalculator);
		assertNotNull(liabilityCalculator);
		assertNotNull(netWorthCalculator);
		assertEquals(true, currencyService instanceof DefaultCurrencyService);
		assertEquals(true, netWorthService instanceof DefaultNetWorthService);
		assertEquals(true, assetCalculator instanceof DefaultAssetCalculator);
		assertEquals(true, liabilityCalculator instanceof DefaultLiabilityCalculator);
		assertEquals(true, netWorthCalculator instanceof DefaultNetWorthCalculator);
	}

}
