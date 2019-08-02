package com.ttsx.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ttsx.service.ItemService;
import com.ttsx.vo.SysResult;
import com.ttsx.vo.itemPname;
import com.ttsx.vo.listItemp;

@Controller
@RequestMapping("/web/item")
public class WebItemController {
	//http://manage.ttsx.com/web/item/findItems
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/findItems")
	@ResponseBody
	public SysResult findItems(){
		List<itemPname> listItemPname = itemService.findItems();
		listItemp list = new listItemp(listItemPname);
		System.out.println("后端查询数据库!");
		return SysResult.success(list);
	}
}
