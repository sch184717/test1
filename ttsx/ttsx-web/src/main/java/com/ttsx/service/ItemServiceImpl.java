package com.ttsx.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jttsx.util.ObjectMapperUtil;
import com.ttsx.util.HttpClientService;
import com.ttsx.vo.SysResult;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private HttpClientService httpClient;
	@Override
	public SysResult findItemManage() {
		String url = "http://manage.ttsx.com/web/item/findItems/";
		String itemJSON = httpClient.doGet(url);
		SysResult object = ObjectMapperUtil.toObject(itemJSON, SysResult.class);
		System.out.println(object);
		return object;
		
	}
	

}
