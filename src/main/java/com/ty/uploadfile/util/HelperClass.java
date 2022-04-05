package com.ty.uploadfile.util;

import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ty.uploadfile.dto.Tutorial;
import com.ty.uploadfile.dto.Upload;

public class HelperClass {

Tutorial tutorial=new Tutorial();
InputStream inputStream;

	Workbook workbook = new XSSFWorkbook(inputStream );
	Sheet sheet = workbook.getSheet("SHEET");
	
	
	Iterator<Row> rows = sheet.iterator();
	
	
	
	while (rows.hasNext()) {
	  Row currentRow = rows.next();
	  Iterator<Cell> cellsInRow = currentRow.iterator();
	  while (cellsInRow.hasNext()) {
	     Cell currentCell = cellsInRow.next();
	     // each cell case
	     tutorial.setId( currentCell.getColumnIndex());
	     tutorial.setTitle(currentCell.getStringCellValue());
	     tutorial.setDescription(currentCell.getStringCellValue());
	     tutorial.setPublished( currentCell.getBooleanCellValue());
	  }
	     
	workbook.close();
	} 
	}
}

