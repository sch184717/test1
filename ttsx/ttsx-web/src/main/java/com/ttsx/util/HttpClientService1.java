package com.ttsx.util;

import java.io.IOException;
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
public class HttpClientService1 {
	
	@Autowired
	private CloseableHttpClient closeableHttpClient;
	@Autowired
	public  RequestConfig requestConfig;
	
	public String doGet(String url,Map<String, String> params,String charset) {
		String result = null;
		if (StringUtils.isEmpty(charset)) {
			charset = "UTF-8";
		}
		if (params != null) {
			url += "?";
			for (Map.Entry<String, String> entry : params.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				url += key+"="+value+"&";
			}
			url = url.substring(0,url.length()-1);
			
		}
		//模拟发起get请求
		HttpGet get = new HttpGet(url);
		get.setConfig(requestConfig);
		try {
			CloseableHttpResponse http = closeableHttpClient.execute(get);
			
			result = EntityUtils.toString(http.getEntity());
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}

	public String doGet(String url,Map<String, String> params) {
		return doGet(url, params, null);
		
	}
	
	public String doGet(String url,String charset) {
		return doGet(url, null, charset);
		
	}
	public String doGet(String url) {
		return doGet(url, null, null);
		
	}
	
}
