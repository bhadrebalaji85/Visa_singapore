package executionEngine;

import org.testng.annotations.Test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
 
import org.testng.Assert;
 
import org.testng.annotations.Test;
 
 
 

 
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
 
import com.relevantcodes.extentreports.LogStatus;
 
 
 
public class AdvanceReporting {
	ExtentReports extent;
	 ExtentTest test;
	 WebDriver driver;
	  
	 @BeforeClass
	 public void M1(){
	  //extent = ExtentManager.Instance();
	  driver = new FirefoxDriver();
	 }
	  
	 @Test
	 public void OpenAUT()
	 {
	  try{
	  driver.get("http://www.qavalidation.com/");
	  test = extent.startTest("OpenUT", "Verify HomePage");
	  if(driver.getTitle().contains("QA & Validation"))
	   test.log(LogStatus.PASS, driver.getTitle() +" contain "+"QA & Validation" );
	  else
	   test.log(LogStatus.FAIL, driver.getTitle() +" doesn't contain "+"QA & Validation" );
	  }catch(Exception e){test.log(LogStatus.ERROR, e.getMessage());}
	 }
	   
	 @AfterClass
	 public void tear()
	 {
	  extent.endTest(test);
	  extent.flush();
	  extent.close();
	  driver.quit();
	 }
	}