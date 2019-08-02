package com.ttsx.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttsx.mapper.ItemCatMapper;
import com.ttsx.mapper.ItemDescMapper;
import com.ttsx.mapper.ItemMapper;
import com.ttsx.pojo.Item;
import com.ttsx.pojo.ItemCat;
import com.ttsx.pojo.ItemDesc;
import com.ttsx.vo.EasyUI_Table;
import com.ttsx.vo.itemPname;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private ItemDescMapper itemDescMapper;
	@Autowired
	private ItemCatMapper itemCatMapper;
	@Override
	public EasyUI_Table findItemByPage(Integer page, Integer rows) {
		//1.获取总记录数:
		Integer total = itemMapper.selectCount(null);
		Integer startIndex = (page-1)*rows;
		
		List<Item> ItemList = itemMapper.findItemByPage(startIndex,rows);
		return new EasyUI_Table(total,ItemList);
	}
	@Override
	@Transactional
	public void saveItem(Item item, ItemDesc itemDesc) {
		item.setStatus(1);
		item.setCreated(new Date());
		item.setUpdated(item.getCreated());
		itemMapper.insert(item);
		itemDesc.setItemId(item.getId());
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(item.getCreated());
		itemDescMapper.insert(itemDesc);
	}
	@Override
	public void updateItem(Item item, ItemDesc itemDesc) {
		
		item.setUpdated(new Date());
		itemMapper.updateById(item);
		itemDesc.setItemId(item.getId());
		itemDesc.setUpdated(item.getUpdated());
		itemDescMapper.updateById(itemDesc);
	}
	/**
	 * 一句商品id查询商品的详细信息
	 */
	@Override
	public ItemDesc findItemDescById(Long itemId) {
		ItemDesc selectById = itemDescMapper.selectById(itemId);
		return selectById;
	}
	/**
	 * 商品上架的而实现
	 */
	
	@Override
	public void doReShelf(List<Integer> ids) {
		for (Integer id : ids) {
			Item selectById = itemMapper.selectById(id);
			Integer status = selectById.getStatus();
			if (status == 2) {
				selectById.setStatus(1);
				itemMapper.updateById(selectById);
			}else {
				continue;
			}
		}
		
	}
	/**
	 * 商品下架的而实现
	 */
	@Override
	public void doInstock(List<Integer> ids) {
		for (Integer id : ids) {
			Item selectById = itemMapper.selectById(id);
			Integer status = selectById.getStatus();
			if (status == 1) {
				selectById.setStatus(2);
				itemMapper.updateById(selectById);
			}else {
				continue;
			}
		}
		
	}
	@Override
	public List<itemPname> findItems() {
		List<itemPname> list = new ArrayList<itemPname>();
		List<Item> selectList = itemMapper.selectList(null);
		for (Item item : selectList) {
			itemPname itemp = new itemPname();
			ItemCat itemCat = itemCatMapper.selectById(item.getCid());
			ItemCat itemCat2 = itemCatMapper.selectById(itemCat.getParentId());
			ItemCat itemCat3 = itemCatMapper.selectById(itemCat2.getParentId());
			itemp.setName(itemCat3.getName()).setItem(item);
			list.add(itemp);
		}
		return list;
	}

}
