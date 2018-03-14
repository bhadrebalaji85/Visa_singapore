package com.naukri.executionEngine;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import com.naukri.config.ActionKeywords;
import com.naukri.config.Constants;
import com.naukri.utility.ExcelUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class DriverScript {
	
	    public static ExtentReports report;
	    public static ExtentTest logger;
		public static Properties p;
	    public static Properties OR;  
		public static ActionKeywords actionkeyword;
		public static String sActionKeyword;
		public static String sPageObject;
		public static Method method[];
		public static String sTestCaseID;
		public static String sRunMode;
        public static int iTestStep;
		public static int iTestLastStep;
  @BeforeClass
  public void beforeClass() throws IOException 
  { 
	  
	  report = new ExtentReports(Constants.Report_path);
	 
	  //p = new Properties();
		//FileInputStream fis = new FileInputStream("Data.properties");
		//p.load(fis);	
	   actionkeyword= new ActionKeywords();
		method = actionkeyword.getClass().getMethods();
		String sPath=Constants.File_path;
		ExcelUtils.SetExcelFile(sPath);
		String Path_OR = Constants.Path_OR;
		//Creating file system object for Object Repository text/property file
		FileInputStream fs = new FileInputStream(Path_OR);
		//Creating an Object of properties
		OR= new Properties(System.getProperties());
		//Loading all the properties from Object Repository property file in to OR object
		OR.load(fs);
	  
  }
  
  @Test
  public void login() throws  Exception,IllegalAccessException, IllegalArgumentException, InvocationTargetException 
  { 
	  	logger=report.startTest("Verify login to Naukri.com");
	  	int iTotalTestCases = ExcelUtils.getRowCount(Constants.Sheet_TestCases);
	  	for(int iTestcase=1;iTestcase<=iTotalTestCases;iTestcase++){
	  		  sTestCaseID = ExcelUtils.getCellData(iTestcase, Constants.Col_TestCaseID, Constants.Sheet_TestCases);
	  		  sRunMode = ExcelUtils.getCellData(iTestcase, Constants.Col_RunMode,Constants.Sheet_TestCases);
	  		if (sRunMode.equals("Yes")){
	  			iTestStep = ExcelUtils.getRowContains(sTestCaseID, Constants.Col_TestCaseID, Constants.Sheet_TestSteps);
				iTestLastStep = ExcelUtils.getTestStepsCount(Constants.Sheet_TestSteps, sTestCaseID, iTestStep);
				for (;iTestStep<=iTestLastStep;iTestStep++){
		    		sActionKeyword = ExcelUtils.getCellData(iTestStep, Constants.Col_ActionKeyword,Constants.Sheet_TestSteps);
		    		sPageObject = ExcelUtils.getCellData(iTestStep, Constants.Col_PageObject, Constants.Sheet_TestSteps);
		    		for(int i=0;i<method.length;i++){			
		    			if(method[i].getName().equals(sActionKeyword)){
		    				method[i].invoke(actionkeyword,sPageObject);
		    				break;
		    				}
	  		}
	  	}
		
	  		}
	  	}
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	/*for (int iRow = 1;iRow <= 8;iRow++){
		sActionKeyword = ExcelUtils.getCellData(iRow,Constants.Col_ActionKeyword);
		sPageObject=ExcelUtils.getCellData(iRow,Constants.Col_PageObject );
		System.out.println(sActionKeyword);
		for(int i = 0; i < method.length; i++) {
			Method element = method[i];
			if(element.getName().equals(sActionKeyword)){
				element.invoke(actionkeyword,sPageObject);
				break;
			}
		}
	}  */
	  	
	  	
		}
  
  @AfterMethod
  public void tearDown()
  {
	  report.endTest(logger);
	  report.flush();
  }
  

}
