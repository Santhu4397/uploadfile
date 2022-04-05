package com.ty.uploadfile.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ty.uploadfile.dao.UploadfileDao;
import com.ty.uploadfile.dto.Upload;
import com.ty.uploadfile.services.UploadService;

@RestController
public class UploadFileController {
	@Autowired
	UploadService service;
	
	@PostMapping("upload")//upload only signal file
	public String save(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
 Upload upload=service.save(file, null, 0, null);
 if(upload !=null) {
	 return "succesfully added to datebase";
 }else {
	 return "not added to datebase";
 }
	}
	@PutMapping("update")
	public String update(@RequestBody Upload upload,@RequestParam int id) {
		Upload upload2=service.update(id, upload);
		if(upload2  !=null) {
			 return "succesfully added to datebase";
		 }else {
			 return "not added to datebase";
		 } 
	}
	@PostMapping("uploadmulti")//upload multiple file to database
	public String multi(@RequestParam("file") MultipartFile[] file) throws IllegalStateException, IOException {
		
		for(MultipartFile file2:file) {
		 Upload upload=service.save(file2, null, 0, null);
		 
		 if(upload !=null) {
			 return "succesfully added to datebase";
		 }
		 
		}
		return "not added to datebase";
	}
	@GetMapping("hig")
	public Upload hi() {
		return new Upload();
	
	}

}
