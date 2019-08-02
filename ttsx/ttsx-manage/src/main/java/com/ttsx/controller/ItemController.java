package com.ttsx.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ttsx.pojo.Item;
import com.ttsx.pojo.ItemDesc;
import com.ttsx.service.ItemService;
import com.ttsx.vo.EasyUI_Table;
import com.ttsx.vo.SysResult;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	@RequestMapping("/query")
	@ResponseBody
	public EasyUI_Table findItemByPage(Integer page,Integer rows) {

		return itemService.findItemByPage(page,rows); 
	}
	/***
	 * 实现商品新增
	 * 练习:统一异常处理类
	 *
	 */
	@RequestMapping("/save")
	@ResponseBody
	public SysResult saveItem(Item item,ItemDesc itemDesc) {
		itemService.saveItem(item,itemDesc);
		return SysResult.success();
	}

	/*
	 * 实现商品的修改信息
	 */
	@RequestMapping("/update")
	@ResponseBody
	public SysResult updateItem(Item item,ItemDesc itemDesc) {
		itemService.updateItem(item,itemDesc);
		return SysResult.success();
	}

	/**
	 * 实现商品详情信息的回显
	 */
	@RequestMapping("/query/item/desc/{itemId}")
	@ResponseBody
	public SysResult findItemDescById(@PathVariable("itemId") Long itemId) {
		return SysResult.success(itemService.findItemDescById(itemId));
	} 
	/**
	 * 商品上架的实现
	 */

	@RequestMapping("/reshelf")
	@ResponseBody 
	public SysResult doReShelf(Integer[] ids) {
		itemService.doReShelf(Arrays.asList(ids));
		return SysResult.success();
	}
	/**
	 * 商品下架
	 */
	@RequestMapping("/instock")
	@ResponseBody 
	public SysResult doInstock(Integer[] ids) {
		itemService.doInstock(Arrays.asList(ids));
		return SysResult.success();
	}
}
