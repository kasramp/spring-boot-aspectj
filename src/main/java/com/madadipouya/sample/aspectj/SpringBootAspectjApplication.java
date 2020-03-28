package com.madadipouya.sample.aspectj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class SpringBootAspectjApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAspectjApplication.class, args);
	}

}
