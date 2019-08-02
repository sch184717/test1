package com.ttsx.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class EasyUI_Tree {
	private Long id; //分类的id号
	private String text; //分类的名称
	private String state; //open表示节点打开  closed节点表示关闭
}
