package com.ttsx.dubbo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.jttsx.dubbo.service.DetailService;
import com.ttsx.mapper.ItemDescMapper;
import com.ttsx.mapper.ItemMapper;
import com.ttsx.pojo.Item;
import com.ttsx.pojo.ItemDesc;
@Service
public class DetailServiceImpl implements DetailService{
	
	@Autowired
	private ItemMapper itemMapper;
	
	@Autowired
	private ItemDescMapper itemDescMapper;
	
	@Override
	public Item findItemById(Long id) {
		Item item = itemMapper.selectById(id);
		ItemDesc itemDesc = itemDescMapper.selectById(id);
		item.setItemDesc(itemDesc);
		System.out.println(item);
		return item;
	}

}
