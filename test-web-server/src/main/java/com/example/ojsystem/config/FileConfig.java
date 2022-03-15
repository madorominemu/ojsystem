package com.example.ojsystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 定位各种文件或图片地址
 */
@Configuration
public class FileConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//前端用户头像地址定位
		registry.addResourceHandler("/img/avatarImages/**").addResourceLocations(
				"file:"+System.getProperty("user.dir")+System.getProperty("file.separator")+"img"+System.getProperty("file.separator")+"avatarImages"+System.getProperty("file.separator")
		);
		//用户头像默认地址
		registry.addResourceHandler("/img/**").addResourceLocations(
				"file:"+System.getProperty("user.dir")+System.getProperty("file.separator")+"img"+System.getProperty("file.separator")
		);
	}
}
