package com.networth.infra;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.networth.infra.mapper.InfraMapper;
import com.networth.infra.mapper.ModelMapperBasedInfraMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InfraApplicationTests {

	@Autowired
	private InfraMapper infraMapper;

	@Test
	void contextLoads() {
		assertNotNull(infraMapper);
		assertTrue(infraMapper instanceof ModelMapperBasedInfraMapper);
	}

}
