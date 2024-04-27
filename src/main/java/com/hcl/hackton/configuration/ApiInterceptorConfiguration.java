package com.hcl.hackton.configuration;


import com.hcl.hackton.interceptor.ApiInterceptor;
import com.hcl.hackton.interceptor.ApiInterceptorProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;


@Configuration
@Slf4j
@EnableConfigurationProperties({ApiInterceptorProperties.class})
public class ApiInterceptorConfiguration implements WebMvcConfigurer {

    @Autowired
    ApiInterceptorProperties apiInterceptorProperties;
    
	@Bean
	public ApiInterceptor apiInterceptor() {
		return new ApiInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		if (apiInterceptorProperties.getEnable()) {
			log.info("-------enable api interceptor------");
			registry.addInterceptor(apiInterceptor()).addPathPatterns(apiInterceptorProperties.getInclude())
					.excludePathPatterns(apiInterceptorProperties.getExclude());
		}
	}

}
