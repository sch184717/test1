package com.ttsx.service;

import java.util.List;

import com.ttsx.vo.EasyUI_Tree;

public interface ItemCatService {

	String findItemCatNameById(Long itemCatId);

	List<EasyUI_Tree> findItemCatByParentId(Long parentId);

}
