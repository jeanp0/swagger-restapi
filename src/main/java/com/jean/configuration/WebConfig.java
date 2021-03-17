package com.jean.configuration;

import com.jean.interceptor.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Component
public class WebConfig implements WebMvcConfigurer  {
	private final LogInterceptor logInterceptor;

	@Autowired
	public WebConfig(LogInterceptor serviceInterceptor) {
		this.logInterceptor = serviceInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// agrega interceptor a la aplicación
		registry.addInterceptor(logInterceptor);
	}

}