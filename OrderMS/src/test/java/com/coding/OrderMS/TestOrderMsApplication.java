package com.coding.OrderMS;

import org.springframework.boot.SpringApplication;

public class TestOrderMsApplication {

	public static void main(String[] args) {
		SpringApplication.from(OrderMsApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
