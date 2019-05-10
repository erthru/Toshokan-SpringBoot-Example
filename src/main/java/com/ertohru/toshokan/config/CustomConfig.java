package com.ertohru.toshokan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;

@Configuration
public class CustomConfig implements PageableHandlerMethodArgumentResolverCustomizer {

	@Override
	public void customize(PageableHandlerMethodArgumentResolver pageableResolver) {
		pageableResolver.setOneIndexedParameters(true);
		
	}

}
