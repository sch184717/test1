package com.ttsx.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;
@Data
@Accessors(chain = true)
public class BasePojo implements Serializable{
	
	//定义创建时间
	private Date created;
	//定义更新时间
	private Date updated;
}
