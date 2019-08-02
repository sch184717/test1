package com.ttsx.service;

import java.util.List;

import com.ttsx.pojo.Item;
import com.ttsx.pojo.ItemDesc;
import com.ttsx.vo.EasyUI_Table;
import com.ttsx.vo.itemPname;

public interface ItemService {

	EasyUI_Table findItemByPage(Integer page, Integer rows);

	void saveItem(Item item, ItemDesc itemDesc);

	void updateItem(Item item, ItemDesc itemDesc);

	ItemDesc findItemDescById(Long itemId);

	void doReShelf(List<Integer> ids);

	void doInstock(List<Integer> ids);

	List<itemPname> findItems();

}
