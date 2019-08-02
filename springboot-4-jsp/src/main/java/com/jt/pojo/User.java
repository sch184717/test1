package com.jt.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;
@Data
@Accessors(chain = true)//链式加载,改变返回值
@TableName//表名一一对应
public class User implements Serializable{
	//序列化问题:对象转化与字节数组互转时必须序列化
	//定义pojo对象时一定使用包装类型
	@TableId(type = IdType.AUTO)//主键自增
	private Integer id;
	private String name;
	private Integer age;
	private String sex;
}
