package com.arpiox.spboot2ng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.arpiox"})
public class Spboot2ngApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spboot2ngApplication.class, args);
	}
}
