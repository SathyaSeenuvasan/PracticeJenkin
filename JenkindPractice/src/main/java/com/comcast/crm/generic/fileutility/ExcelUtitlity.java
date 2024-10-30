package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtitlity {
	
	public String getDataFormExcel(String sheetName,int rownum,int celNum) throws Throwable, IOException {
		
		FileInputStream fis=new FileInputStream("./testdata/MultitestScriptexcel.xlsx");
		
	Workbook wb = WorkbookFactory.create(fis);
	String data = wb.getSheet(sheetName).getRow(rownum).getCell(celNum).getStringCellValue();
	wb.close();
	
		
		
		return data;
		
		
	}
	
	public int getRowcount(String sheetName) throws Throwable {
		
		FileInputStream fis =new FileInputStream("./testdata/MultitestScriptexcel.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		int rowcount = wb.getSheet(sheetName).getLastRowNum();
		
		return rowcount;
	}
	
	public void setDataIntoExcel(String sheetName,int rowNum,int cellNum,String data) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./testdata/MultitestScriptexcel.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream("./testdata/MultitestScriptexcel.xlsx");
		
		wb.write(fos);
		wb.close();
	}

}
