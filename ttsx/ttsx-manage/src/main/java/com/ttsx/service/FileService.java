package com.ttsx.service;

import org.springframework.web.multipart.MultipartFile;

import com.ttsx.vo.EasyUI_Image;

public interface FileService {

	EasyUI_Image fileUpload(MultipartFile uploadFile);

}
