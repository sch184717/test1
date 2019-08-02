package com.ttsx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jttsx.dubbo.service.DetailService;
import com.ttsx.pojo.Item;
import com.ttsx.vo.SysResult;

@Controller
@RequestMapping("/detail")
public class DetailController {
	
	@Reference(timeout = 3000,check = false)
	private DetailService detailService;
	
	@RequestMapping("/{id}")
	@ResponseBody
	public SysResult findItemById(@PathVariable(value = "id") Long id) {
		Item item = detailService.findItemById(id);
		System.out.println("调用成功!");
		return SysResult.success(item);
		
	}
}
