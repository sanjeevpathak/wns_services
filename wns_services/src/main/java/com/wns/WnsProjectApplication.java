package com.wns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.wns.*")
public class WnsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(WnsProjectApplication.class, args);
	}

}
