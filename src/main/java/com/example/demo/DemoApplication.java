package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

// RestController => @Controller ve @ResponseBody birleşiminden oluşur. Datanın kendisini JSON veya XML formatı ile direkt olarak sunabiliyor.
@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
