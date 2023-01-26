package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// It is a combination of three annotations @EnableAutoConfiguration,
// @ComponentScan, and @Configuration.

// @EnableAutoConfiguration is used to enable the auto-configuration feature.
// @ComponentScan to specify the packages that we want to be scanned.
// @Configuration Indicates that a component is only eligible for registration when all specified conditions match.
@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
