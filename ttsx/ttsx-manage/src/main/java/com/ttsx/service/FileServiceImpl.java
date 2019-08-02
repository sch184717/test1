package com.ttsx.service;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ttsx.vo.EasyUI_Image;

@Service
//加载配置文件
@PropertySource("classpath:/properties/image.properties")
public class FileServiceImpl implements FileService{
	
	/**
	 * 由于成员变量写死,扩展不容易,最好的方式应该写到配置文件中
	 * 有配置文件动态的获取
	 */
	@Value("${image.localDirPath}")
	private String localDirPath;//定义本地磁盘路径
	@Value("${image.urlDirPath}")
	private String urlDirPath;
	/**
	 * 文件上传思路
	 * 问题1:校验文件的类型是否为图片,如何校验
	 * 		利用后缀进行校验
	 * 问题2:木马.exe.jpg  如何防止恶意的文件上传
	 * 		将文件交给工具api进行检验,获取宽和高
	 * 问题3:众多图片如何保存
	 * 		分文件存储:按照yyyy/MM/dd
	 * 问题4:文件如果重名如何处理
	 * 		自定义UUID为文件名称
	 * 
	 * 
	 * 思路:
	 *		1.获取用户文件名称进行校验
	 *		2.校验文件时否为图片
	 *		3.利用工具api校验图片的宽度和高度
	 *		4.以时间格式创建文件夹保存数据   yyyy/MM/dd
	 *		5.判断文件夹是否存在,如果不存在就要新建文件目录
	 *		6.采用UUID为文件名,防止文件重复 32位16进制数
	 *		
 */		
	@Override
	public EasyUI_Image fileUpload(MultipartFile uploadFile) {
		EasyUI_Image ui_Image = new EasyUI_Image();
		//1.获取文件名称
		String fileName = uploadFile.getOriginalFilename();
		//2.校验文件名称  正则表达式
		fileName = fileName.toLowerCase();
		if(!fileName.matches("^.+\\.(jpg|png|gif)$")) {
			ui_Image.setError(1);
			return ui_Image;
		}
		//3.利用工具api读取用户提交的数据
		try {
			BufferedImage bufferedImage = ImageIO.read(uploadFile.getInputStream());
			int height = bufferedImage.getHeight();
			int width = bufferedImage.getWidth();
			
			if (height == 0 || width == 0) {
				ui_Image.setError(1);
				return ui_Image;
			}
			//封装用户数据
			ui_Image.setHeight(height).setWidth(width);
			//4.以时间格式创建文件夹
			String dataPathDir = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
			String realDirPath = localDirPath + dataPathDir;
			//   D:/1-JT/images/yyyy/MM/dd
			
			File dirFile = new File(realDirPath);
			if (!dirFile.exists()) {
				dirFile.mkdirs();
			}
			// 5.采用UUID为文件名,防止文件重复 32位16进制数
			String uuid = UUID.randomUUID().toString().replace("-","");
			// 截串
			String fileType = fileName.substring(fileName.lastIndexOf("."));
			
			String realName = uuid + fileType;
			String realFilePath = realDirPath +"/"+ realName;
			uploadFile.transferTo(new File(realFilePath));
			//编辑虚拟路径数据返回
			String realUrlPath = urlDirPath + dataPathDir + "/" + realName ; 
			ui_Image.setUrl(realUrlPath);
			
		} catch (IOException e) {
			e.printStackTrace();
			ui_Image.setError(1);//对象转换时异常
			return ui_Image;
		}
		
		return ui_Image;
	}

}
