package com.networth.svc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.networth" })
public class SvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SvcApplication.class, args);
	}

}
