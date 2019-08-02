package com.ttsx.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("tt_item_desc")
public class ItemDesc extends BasePojo{
	@TableId
	private Long itemId;
	private String itemDesc;
}
