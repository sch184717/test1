package com.jt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jt.mapper")//扫描dao层mapper
public class Springboot5JspApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot5JspApplication.class, args);
	}

}
