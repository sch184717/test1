package com.jt.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JDBCConnectionService {
	//如何为属性赋值
	/**
	 * 从spring容器中为属性赋值
	 * 利用@value给属性赋值原理
	 * 根据用户自定义的key去spring维护的map
	 * 集合中取值,之后利用反射技术用set为属性赋值*/
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.driverName}")
	private String driverName;
	@Value("${jdbc.username}")
	private String username;
	@Override
	public String toString() {
		return "JDBCConnectionService [url=" + url + ", driverName=" + driverName + ", username=" + username + "]";
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
