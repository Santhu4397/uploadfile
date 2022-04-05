package com.ty.uploadfile.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.uploadfile.dto.Upload;

public interface Uploadfile extends JpaRepository<Upload,Integer> {

}
