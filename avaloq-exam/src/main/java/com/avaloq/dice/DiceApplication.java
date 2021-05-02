package com.avaloq.dice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.avaloq.dice" })
@EnableAutoConfiguration
public class DiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiceApplication.class, args);
	}

}
