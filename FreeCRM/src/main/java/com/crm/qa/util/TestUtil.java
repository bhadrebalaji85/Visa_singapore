package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

 public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
 		public static int IMPLICIT_WAIT=10;
 		public static int PAGE_WAIT=10;
 		public static String TESTDATA_SHEET_PATH = "E://webdriver_Framework//FreeCRM//src//main//java//com//crm//qa//TestData//FreeCRM.xlsx";
 		
 		static Workbook book;
 		static Sheet sheet;
 
 		public void switchToFrame(String framename)
 			{
 				driver.switchTo().frame(prop.getProperty("HomePageFrame"));
 			}
 		
 		public static Object[][] getTestData(String sheetName) {
 			FileInputStream file = null;
 			try {
 				file = new FileInputStream(TESTDATA_SHEET_PATH);
 			} catch (FileNotFoundException e) {
 				e.printStackTrace();
 			}
 			try {
 				book = WorkbookFactory.create(file);
 			} catch (InvalidFormatException e) {
 				e.printStackTrace();
 			} catch (IOException e) {
 				e.printStackTrace();
 			}
 			sheet = book.getSheet(sheetName);
 			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
 			// System.out.println(sheet.getLastRowNum() + "--------" +
 			// sheet.getRow(0).getLastCellNum());
 			for (int i = 0; i < sheet.getLastRowNum(); i++) {
 				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
 					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
 					// System.out.println(data[i][k]);
 				}
 			}
 			return data;
 		}
 
 		public static void takeScreenshotAtEndOfTest() throws IOException {
 			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 			//String currentDir = System.getProperty("user.dir");
 			
 			//FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
 			FileUtils.copyFile(scrFile, new File("E://webdriver_Framework//Screenshot//Screenshot" + System.currentTimeMillis() + ".png"));
 			}
 		
 		public static void takeScreenshotAtEndOfTest1(String screenshotname) throws IOException {
 			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 			//String currentDir = System.getProperty("user.dir");
 			
 			//FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
 			FileUtils.copyFile(scrFile, new File("E://webdriver_Framework//Screenshot//" + "screenshotname" + System.currentTimeMillis() + ".png"));
 			}
}