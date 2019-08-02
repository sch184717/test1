package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.service.JDBCConnectionService;
import com.jt.service.JDBCServiceB;
import com.jt.service.JDBCServiceC;

@RestController
public class JDBCController {
	@Autowired
	private JDBCConnectionService jdbcService;
	//如何需要返回json串
	//获取数据检查赋值是否正常
	//对象转化json串时调用了对象的get方法
	@RequestMapping("/jdbcTest")
	public  JDBCConnectionService jdbcTest() {
		System.out.println(jdbcService);
		return jdbcService;
	}
	@Autowired
	private JDBCServiceB jdbcServiceB;
	//2.测试批量赋值操作
	@RequestMapping("/jdbcTestB")
	public JDBCServiceB jdbcTestB() {
		System.out.println(jdbcServiceB);
		return jdbcServiceB;
	}
	@Autowired
	private JDBCServiceC jdbcServiceC;
	//3.测试自定义配置文件
	@RequestMapping("/jdbcTestC")
	public JDBCServiceC jdbcTestC() {
		System.out.println(jdbcServiceC);
		return jdbcServiceC;
	}
}
