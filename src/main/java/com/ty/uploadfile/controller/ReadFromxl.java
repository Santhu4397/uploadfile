package com.ty.uploadfile.controller;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.ty.uploadfile.dto.Path;
import com.ty.uploadfile.services.ReadXLService;

@RestController
public class ReadFromxl {
	@Autowired
	ReadXLService readXLService;
	@PostMapping("my")//read from exl sheet and transfer to database
	public void save(@RequestParam String  path) throws InvalidFormatException, EncryptedDocumentException, IOException {		
		readXLService.ReadDataFromExcel(path);
	}

}
