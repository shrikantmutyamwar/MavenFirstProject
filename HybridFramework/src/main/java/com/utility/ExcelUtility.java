package com.utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	
	public String getData(String filepath,String sheetname,int row,int col){
		FileInputStream fis = null;
		Workbook wb = null;
		Sheet sh = null;
		try{
			fis = new FileInputStream("");
			wb = WorkbookFactory.create(fis);
			sh = wb.getSheet("");
		}catch(Exception e){
			e.printStackTrace();
		}
		return sh.getRow(row).getCell(col).getStringCellValue();
		
		
	}
}
