package com.ttsx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ttsx.service.FileService;
import com.ttsx.vo.EasyUI_Image;


@Controller
public class FileController {
	
	@Autowired
	private FileService fileService;
	/**
	 * 实现用户文件的上传
	 */
	@RequestMapping("/pic/upload")
	@ResponseBody //将数据转化成json
	public EasyUI_Image fileUpload(MultipartFile uploadFile) {
		return fileService.fileUpload(uploadFile);
	}
}
