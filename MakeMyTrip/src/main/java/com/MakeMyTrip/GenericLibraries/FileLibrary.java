package com.MakeMyTrip.GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibrary {
	FileInputStream fis;
	FileInputStream fis1;
	Properties property;
	Workbook wb;
	public void openPropertyFile(String filepath)
	{
		try {
			fis=new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error during opening Property File");
		} 
		property=new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error during loading the Properties");
		}
	}
	
	public String getPropertyValue(String key)
	{
		return property.getProperty(key);
	}
	
	public void openExcelFile(String filepath)
	{
		try {
			fis1=new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error during opening Excel");
		}
		try {
			wb=WorkbookFactory.create(fis1);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error during creating Excel");
		}
	}
	
	public void getDataFromExcel(String sheetName, int rowNumber, int cellNumber)
	{
		wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
	}
	
	public void setDataToExcel(String sheetName, int rowNumber, int cellNumber, String value)
	{
		wb.getSheet(sheetName).getRow(rowNumber).createCell(cellNumber).setCellValue(value);
	}
	public void writeToExcel(String filepath)
	{
		FileOutputStream fos = null;
		try {
			fos=new FileOutputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error during opening Excel");
		}
		try {
			wb.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error during writing Excel");
		}
	}
	
	public void closeExcel()
	{
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error during closing Excel");
		}
	}
}
