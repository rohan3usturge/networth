package com.networth.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RepoApplicationTests {

	@Autowired
	private CurrencyRepository currencyRepo;

	@Test
	void contextLoads() {
		assertNotNull(currencyRepo);
		assertEquals(true, currencyRepo instanceof MemoryBasedCurrencyRepository);
	}

}
