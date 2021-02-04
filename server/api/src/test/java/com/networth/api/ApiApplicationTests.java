package com.networth.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.networth.controllers.NetWorthController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiApplicationTests {


	@Autowired
	private NetWorthController netWorthController;

	@Test
	void shouldLoadAllDependeciesOfController() {
		// This will check if all depdencies are resolved
		assertNotNull(netWorthController);
	}

}
