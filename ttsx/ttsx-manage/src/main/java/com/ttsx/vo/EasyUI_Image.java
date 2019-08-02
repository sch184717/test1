package com.ttsx.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class EasyUI_Image {
	private Integer error = 0; //表示用户上传文件是否出错
	private String url; //表示图片的虚拟路径
	private  Integer width; //宽度
	private Integer height; //高度
	
	/**
	 * 多系统之间对象直接传递时必须要序列化
	 */
}
