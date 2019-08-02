package com.ttsx.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ttsx.service.ItemService;
import com.ttsx.vo.SysResult;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/showlist")
	@ResponseBody
	public SysResult findItemManage(){
		System.out.println(123245614);
		SysResult list = itemService.findItemManage();
		return list;
	}
	
}
