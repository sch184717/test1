package com.jt.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties(prefix = "jdbcb")
public class JDBCServiceB {
 private String jdbcName;
 private String jdbcDriver;
public String getJdbcName() {
	return jdbcName;
}
public void setJdbcName(String jdbcName) {
	this.jdbcName = jdbcName;
}
public String getJdbcDriver() {
	return jdbcDriver;
}
public void setJdbcDriver(String jdbcDriver) {
	this.jdbcDriver = jdbcDriver;
}
@Override
public String toString() {
	return "JDBCServiceB [jdbcName=" + jdbcName + ", jdbcDriver=" + jdbcDriver + "]";
}
 
}
