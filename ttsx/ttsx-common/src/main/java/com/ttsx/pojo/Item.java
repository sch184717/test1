package com.ttsx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("tt_item")
public class Item extends BasePojo{
	@TableId(type = IdType.AUTO)
	private Long id;  //定义主键
	private String title;  //定义标题
	private String sellPoint; //卖点信息
	private Long price; //商品价格    将商品扩大100 倍存储
	private Integer num; //商品数量
	private String barcode; //二维码
	private String image; //商品图片
	private Long cid; //商品分类信息
	private Integer status; //商品状态信息1，可选值：1正常，2下架，3删除'
	
	@TableField(exist = false)
	private ItemDesc itemDesc;
}
