package com.example.ojsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 热更新 热加载
 * 1、Ctrl+shift+A -->搜索registry，找到Registry...，注意带3个点，找到compiler.automake.allow.when.app.running勾选
 * 2、执行快捷键Ctrl+F9进行热加载
 **/
@SpringBootApplication
@MapperScan("com.example.ojsystem.mapper")
public class OjsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OjsystemApplication.class, args);
	}

}
