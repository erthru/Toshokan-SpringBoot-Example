package com.ertohru.toshokan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;

@SpringBootApplication
public class ToshokanApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToshokanApplication.class, args);
	}

}
