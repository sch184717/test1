package com.ttsx.util;

import java.util.Map;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class HttpClientService {
	
	@Autowired
	private CloseableHttpClient httpClient;
	@Autowired
	private RequestConfig requestConfig;
	/***
	 * 目的:
	 * 		发起请求,获取结果
	 * 参数说明:
	 * 		URL地址
	 * 		GET请求:参数?    用户请求提交的额参数使用Map封装
	 * 		指定编码的格式
	 * 步骤:
	 * 		1.校验字符集.如果字符集为空null 设定一个默认值
	 * 		2.校验params是否为空null
	 * 			null:表示用户get请求无需传参
	 * 			!null:表示需要传参 url?key=value&...
	 */
	public String doGet(String url,Map<String,String> params,String charset) {
		
		//校验字符集
		if (StringUtils.isEmpty(charset)) {
			charset = "UTF-8";
		}
		/**
		 * 校验参数是否为空  url如何拼接
		 */
		if (params != null) {
			url += "?";
			//遍历map集合 迭代器 fore循环
			for (Map.Entry<String, String> entry : params.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				url += key+"="+value+"&";
			}
			//经过循环遍历最后url多一个&
			url = url.substring(0,url.length()-1);
		}
		//发起get请求
		HttpGet get = new HttpGet(url);
		get.setConfig(requestConfig);
		String result = null;
		try {
			CloseableHttpResponse response = httpClient.execute(get);
			if (response.getStatusLine().getStatusCode()==200) {
				result = EntityUtils.toString(response.getEntity());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		return result;
	}
	
	public String doGet(String url) {
		return doGet(url,null,null);
	}
	
	public String doGet(String url,String charset) {
		return doGet(url,null,charset);
	}
	
	public String doGet(String url,Map<String,String> params) {
		return doGet(url, params, null);
	}
}
