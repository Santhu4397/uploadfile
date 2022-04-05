package com.ty.uploadfile.services;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ty.uploadfile.dao.UploadfileDao;
import com.ty.uploadfile.dto.Upload;

@Service
public class UploadService {
	@Autowired
	UploadfileDao dao;
	public Upload save(MultipartFile file,String name,int yoy,String depr) throws IllegalStateException, IOException {
		 String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		Upload upload=new  Upload(name, yoy, depr, fileName,file.getBytes());
		return dao.save(upload);
	}
	
	public Upload update(int id,Upload upload) {
	
		return dao.update(id,upload);
	}
}
