package com.ttsx.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ttsx.mapper.ItemCatMapper;
import com.ttsx.pojo.ItemCat;
import com.ttsx.vo.EasyUI_Tree;

@Service
public class ItemCatServiceImpl implements	ItemCatService{

	@Autowired
	private ItemCatMapper itemCatMapper;
	@Override
	public String findItemCatNameById(Long itemCatId) {

		ItemCat selectById = itemCatMapper.selectById(itemCatId);

		return selectById.getName();
	}
	/**
	 * 实现树形结构的封装查询
	 */
	@Override
	public List<EasyUI_Tree> findItemCatByParentId(Long parentId) {
		List<EasyUI_Tree> list = new ArrayList<EasyUI_Tree>();
		List<ItemCat> listItemCat = findListItemCat(parentId);
		for (ItemCat itemCat : listItemCat) {
			Long id  = itemCat.getId();
			String text = itemCat.getName();
			String state = itemCat.getIsParent()?"closed":"open";
			EasyUI_Tree tree = new EasyUI_Tree();
			tree.setId(id).setState(state).setText(text);
			list.add(tree);
		}
		return list;
		
	}
	private List<ItemCat> findListItemCat(Long parentId) {
		
		QueryWrapper<ItemCat> queryWrapper = new QueryWrapper<ItemCat>();
		queryWrapper.eq("parent_id", parentId);
		List<ItemCat> selectList = itemCatMapper.selectList(queryWrapper);
		return selectList;
	}

}
