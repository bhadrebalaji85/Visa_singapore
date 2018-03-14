package com.naukri.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;

import com.naukri.config.Constants;

public class ExcelUtils {
	
	
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFCell cell;
	
	public static void SetExcelFile(String path) throws IOException
	{
		FileInputStream load=new FileInputStream(path);
		try{
			workbook = new XSSFWorkbook(load);
		} catch (Exception e) {
			   e.printStackTrace();
		}
		
		//sheet=workbook.getSheet(sheetname);
		
	}
	
	public static String getCellData(int RowNum, int ColNum,String sheetname)throws Exception{
	
        sheet=workbook.getSheet(sheetname);
        try{
		cell = sheet.getRow(RowNum).getCell(ColNum);
		String celldata=cell.getStringCellValue();
		return(celldata);
	}catch (Exception e){
        return"";
	}  
	}    
	
	public static int getRowCount(String SheetName){
		
		sheet=workbook.getSheet(SheetName);
		int number;
		number= sheet.getLastRowNum()+1;
		return number;
	}
	
	public static int getRowContains(String sTestCaseName, int colNum,String SheetName) throws Exception{
		int i;	
		sheet=workbook.getSheet(SheetName);
		int rowCount = ExcelUtils.getRowCount(SheetName);
		for (i=0 ; i<rowCount; i++){
			if  (ExcelUtils.getCellData(i,colNum,SheetName).equalsIgnoreCase(sTestCaseName)){
				break;
			}
		}
		return i;
	}
  
	public static int getTestStepsCount(String SheetName, String sTestCaseID, int iTestCaseStart) throws Exception{
		for(int i=iTestCaseStart;i<=ExcelUtils.getRowCount(SheetName);i++){
			if(!sTestCaseID.equals(ExcelUtils.getCellData(i, Constants.Col_TestCaseID, SheetName))){
				int number = i;
				return number;
			}
		}
		sheet=workbook.getSheet(SheetName);
		int number=sheet.getLastRowNum()+1;
		return number;
	}


}