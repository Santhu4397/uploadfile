package com.ty.uploadfile.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.ty.uploadfile.Repo.StudentRepo;
import com.ty.uploadfile.Repo.XmlReader;
import com.ty.uploadfile.dto.Student;
import com.ty.uploadfile.dto.Tutorial;

@Repository
public class ReadXLService {
	@Autowired
	XmlReader reader;
	@Autowired
	StudentRepo repo;

	public List<Tutorial> ReadDataFromExcel(String excelPath)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		Workbook workbook = WorkbookFactory.create(new File(excelPath));
		// Retrieving the number of sheets in the Workbook
		System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
		System.out.println("Retrieving Sheets using for-each loop");
		for (Sheet sheet : workbook) {
			System.out.println("=> " + sheet.getSheetName());

			for (Row row : sheet) {
				/*
				 * Tutorial tutorial=new Tutorial();
				 * tutorial.setId(row.getCell(0).getColumnIndex());
				 * tutorial.setTitle(row.getCell(4).getStringCellValue());
				 * tutorial.setDescription(row.getCell(2).getStringCellValue());
				 * tutorial.setPublished(row.getCell(3).getBooleanCellValue());
				 */
				Student student = new Student();
//				student.setId(row.getCell(0).getRowIndex());
				student.setName(row.getCell(3).getStringCellValue());
				student.setFees(row.getCell(2).getNumericCellValue());
				student.setAddress(row.getCell(1).getStringCellValue());

//				reader.save(tutorial);
				repo.save(student);

			}

		}

		return null;
	}

}
