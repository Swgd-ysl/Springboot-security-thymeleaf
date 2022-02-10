package com.huashuohair.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages ="com.huashuohair.app.mapper")
public class HuaShuoHairApplication {

	public static void main(String[] args) {
		SpringApplication.run(HuaShuoHairApplication.class, args);
	}
}
