package com.example.ojsystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 解决跨域问题
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				//设置允许跨域请求的域名
				.allowedOriginPatterns("*")
				//设置允许的方法
				.allowedMethods("*")
				//是否允许证书（cookies）
				.allowCredentials(true);
	}
}
