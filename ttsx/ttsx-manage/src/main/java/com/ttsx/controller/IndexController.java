package com.ttsx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	/**
	 * 跳转到各个模块的index页面
	 */
	@RequestMapping("/page/{module}")
	public String module(@PathVariable("module") String module) {
		return module;
	}
}
