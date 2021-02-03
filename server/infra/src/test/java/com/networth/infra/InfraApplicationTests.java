package com.networth.infra;

import com.networth.infra.money.InfraMoney;
import com.networth.infra.money.InfraMoneyClient;
import com.networth.infra.money.JavaMoneyBasedMoneyClient;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InfraApplicationTests {

	@Test
	void contextLoads() {

		InfraMoneyClient moneyClient = new JavaMoneyBasedMoneyClient();
		InfraMoney convert = moneyClient.convert(2.0, "CAD", "INR");
		System.out.println(convert);
	}

}
