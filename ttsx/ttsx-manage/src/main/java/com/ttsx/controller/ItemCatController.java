package com.ttsx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ttsx.service.ItemCatService;
import com.ttsx.vo.EasyUI_Tree;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;
	//一句商品id查询商品叶子目录
	@RequestMapping("/queryItemName")
	@ResponseBody
	public String findItemCatNameById(Long itemCatId) {
		
		String name = itemCatService.findItemCatNameById(itemCatId);
		return name;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUI_Tree> findItemCatByParentId(@RequestParam(name = "id",defaultValue = "0")Long parentId){
		System.out.println(1232);
		return itemCatService.findItemCatByParentId(parentId);
	}
	
}
