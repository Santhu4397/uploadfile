package com.ty.uploadfile.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.uploadfile.Repo.Uploadfile;
import com.ty.uploadfile.dto.Upload;

@Repository
public class UploadfileDao {
	@Autowired
	Uploadfile uploadfile;
	public Upload save(Upload upload) {
		return uploadfile.save(upload);
	}
	
	public Upload update(int id,Upload upload) {
		Upload ul2=uploadfile.getById(id);
		if(ul2!=null) {
			ul2.setDepartment(upload.getDepartment());
			ul2.setName(upload.getName());
			ul2.setYear(upload.getYear());
			return uploadfile.save(ul2);
		}else {
			return null;
		}
	
	}

}
