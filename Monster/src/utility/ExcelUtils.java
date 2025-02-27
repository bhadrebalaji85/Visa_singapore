package utility;
import config.Constants;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.rowset.internal.Row;

import executionEngine.DriverScript;
    public class ExcelUtils {
                private static XSSFSheet ExcelWSheet;
                private static XSSFWorkbook ExcelWBook;
                private static XSSFCell Cell;
                private static XSSFRow Row;
 
                
                public static void setExcelFile(String Path) throws Exception {
                    FileInputStream ExcelFile = new FileInputStream(Path);
                    ExcelWBook = new XSSFWorkbook(ExcelFile);
            	}
                
                public static String getCellData(int RowNum, int ColNum, String SheetName ) throws Exception{
                	ExcelWSheet = ExcelWBook.getSheet(SheetName);
                	 try{
                   	  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                         String CellData = Cell.getStringCellValue();
                         return CellData;
                         }catch (Exception e){
                           return"";
                         }
            	}
                
                public static int getRowCount(String SheetName){
        			ExcelWSheet = ExcelWBook.getSheet(SheetName);
        			int number=ExcelWSheet.getLastRowNum()+1;
        			
        			return number;
        		}
                
                public static int getRowContains(String sTestCaseName, int colNum,String SheetName) throws Exception{
            		int i;	
            		ExcelWSheet = ExcelWBook.getSheet(SheetName);
            			int rowCount = ExcelUtils.getRowCount(SheetName);
            			for (i=0 ; i<rowCount; i++){
            				if  (ExcelUtils.getCellData(i,colNum,SheetName).equalsIgnoreCase(sTestCaseName)){
            					break;
            				}
            			}
            			return i;
            			}
     
    			//This method is to get the count of the test steps of test case
    			//This method takes three arguments (Sheet name, Test Case Id & Test case row number)
            	public static int getTestStepsCount(String SheetName, String sTestCaseID, int iTestCaseStart) throws Exception{
            		for(int i=iTestCaseStart;i<=ExcelUtils.getRowCount(SheetName);i++){
            			if(!sTestCaseID.equals(ExcelUtils.getCellData(i,Constants.Col_TestCasesID, SheetName))){
            				int number = i;
            				return number;
            			}
            		}
            		ExcelWSheet = ExcelWBook.getSheet(SheetName);
            		int number=ExcelWSheet.getLastRowNum()+1;
            		return number;
            	}

                @SuppressWarnings("static-access")
            	public static void setCellData(String Result,  int RowNum, int ColNum, String SheetName) throws Exception    {
            		   try{
            	 
            			   ExcelWSheet = ExcelWBook.getSheet(SheetName);
            			    Row  = ExcelWSheet.getRow(RowNum);
            			   Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
            			   
            			   if (Cell == null) {
            				   Cell = Row.createCell(ColNum);
            				   Cell.setCellValue(Result);
            			   } else {
            					Cell.setCellValue(Result);
            					}
            				// Constant variables Test Data path and Test Data file name
            				FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestData);
            				ExcelWBook.write(fileOut);
            				//fileOut.flush();
            				fileOut.close();
            				ExcelWBook = new XSSFWorkbook(new FileInputStream(Constants.Path_TestData));
            			 }catch(Exception e){
            				DriverScript.bResult = false;
            				}
            			} 
                
                
                
                
                
            
                
           
 
    	}