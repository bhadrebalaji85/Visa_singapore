package executionEngine;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import utility.ExcelUtils;

import config.ActionKeywords;
import config.Constants;
import java.util.Properties;
import utility.Log;

public class DriverScript {
      
	public static Properties OR;
	public static ActionKeywords actionKeywords;
	public static String sActionKeyword;
	public static String sPageObject;
	public static Method method[];
	public static int iTestStep;
	public static int iTestLastStep;
	public static String sTestCaseID;
	public static String sRunMode;
	public static boolean bResult;
	public static String sData;
	
	//method = actionKeywords.getClass().getMethods();
 
	@BeforeClass
	public void beforeClass() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		actionKeywords = new ActionKeywords();
		method = actionKeywords.getClass().getMethods();
		String sPath = Constants.Path_TestData;
		ExcelUtils.setExcelFile(sPath);
		String Path_OR = Constants.Path_OR;
		FileInputStream fs = new FileInputStream(Path_OR);
		OR= new Properties(System.getProperties());
		OR.load(fs);
		
	}

	@Test
	public void login() throws Exception {
	
		//method = actionKeywords.getClass().getMethods();
		//This will return the total number of test cases mentioned in the Test cases sheet
    	int iTotalTestCases = ExcelUtils.getRowCount(Constants.Sheet_TestCases);
		//This loop will execute number of times equal to Total number of test cases
		for(int iTestcase=1;iTestcase<=iTotalTestCases;iTestcase++){
			//This is to get the Test case name from the Test Cases sheet
			bResult = true;
			sTestCaseID = ExcelUtils.getCellData(iTestcase, Constants.Col_TestCaseID, Constants.Sheet_TestCases); 
			//This is to get the value of the Run Mode column for the current test case
			sRunMode = ExcelUtils.getCellData(iTestcase, Constants.Col_RunMode,Constants.Sheet_TestCases);
			//This is the condition statement on RunMode value
			if (sRunMode.equals("Yes")){
				//Only if the value of Run Mode is 'Yes', this part of code will execute
				iTestStep = ExcelUtils.getRowContains(sTestCaseID, Constants.Col_TestCaseID, Constants.Sheet_Testcase);
				iTestLastStep = ExcelUtils.getTestStepsCount(Constants.Sheet_Testcase, sTestCaseID, iTestStep);
				//This loop will execute number of times equal to Total number of test steps
				for (;iTestStep<=iTestLastStep;iTestStep++){
						
		    		sActionKeyword = ExcelUtils.getCellData(iTestStep, Constants.Col_ActionKeyword,Constants.Sheet_Testcase);
		    		System.out.println(sActionKeyword);
		    		sPageObject = ExcelUtils.getCellData(iTestStep, Constants.Col_PageObject, Constants.Sheet_Testcase);
		    		System.out.println(sPageObject);
		    		sData = ExcelUtils.getCellData(iTestStep, Constants.Col_DataSet, Constants.Sheet_Testcase);
		    		System.out.println(sData);
		    		for(int i=0;i<method.length;i++){
		    			System.out.println(method[i]);
		    			if(method[i].getName().equals(sActionKeyword)){method[i].invoke(actionKeywords,sPageObject, sData);
		    				if(bResult==true){
		    					//If the executed test step value is true, Pass the test step in Excel sheet
		    					ExcelUtils.setCellData(Constants.KEYWORD_PASS, iTestStep, Constants.Col_TestStepResult, Constants.Sheet_Testcase);
		    					break;
		    				
		    				}else{
		    					//If the executed test step value is false, Fail the test step in Excel sheet
		    					ExcelUtils.setCellData(Constants.KEYWORD_FAIL, iTestStep, Constants.Col_TestStepResult, Constants.Sheet_Testcase);
		    					//In case of false, the test execution will not reach to last step of closing browser
		    					//So it make sense to close the browser before moving on to next test case
		    					//ActionKeywords.Close_Browser("");
		    					break;
		    					}
		    				
		    				}
		    			
		    			}
		    		if(bResult==false){
						//If 'false' then store the test case result as Fail
						ExcelUtils.setCellData(Constants.KEYWORD_FAIL,iTestcase,Constants.Col_Result,Constants.Sheet_TestCases);
						//End the test case in the logs
						Log.endTestCase(sTestCaseID);
						//By this break statement, execution flow will not execute any more test step of the failed test case
						break;
						}
		    		if(bResult==true){
						//Storing the result as Pass in the excel sheet
						ExcelUtils.setCellData(Constants.KEYWORD_PASS,iTestcase,Constants.Col_Result,Constants.Sheet_TestCases);
						Log.endTestCase(sTestCaseID);	
							}
		    		
 // }}}
				
					}
    			}
    		}
		
	}




}