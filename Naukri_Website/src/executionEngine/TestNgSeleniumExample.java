package executionEngine;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestNgSeleniumExample {
    private ExtentReports extent = Main.getInstance();
    private SoftAssert softAssert = new SoftAssert();
    private ExtentTest test;
    private WebDriver driver;
    
    @Test
    public void googleWithoutAssert() {
        test = extent
            .startTest("Google Search Without Assert", "Verifies if Google search button is displayed")
            .assignCategory("NoAssert", "ExtentAPI");

        test.log(LogStatus.INFO, "Launching browser");
        driver = new FirefoxDriver();

        test.log(LogStatus.INFO, "Navigating to google.com");
        driver.get("http://google.com");

        try
        {
            driver.findElement(By.cssSelector("input[value*='Google Search']"));
            test.log(LogStatus.PASS, "Search button displayed");
        }
        catch (NoSuchElementException e)
        {
            test.log(LogStatus.FAIL, "<pre>" + e.toString() + "</pre>");
            throw e;
        }
    }

    @Test
    public void googleWithAssert() {
        test = extent
            .startTest("Google Search With Assert", "Verifies if Google search button is displayed")
            .assignCategory("NoAssert", "ExtentAPI");

        test.log(LogStatus.INFO, "Launching browser");
        driver = new FirefoxDriver();

        test.log(LogStatus.INFO, "Navigating to google.com");
        driver.get("https://in.yahoo.com/?p=us");

        Boolean isFound = IsElementPresent(driver, By.cssSelector("input[value*='Gogl Search']"));

        try
        {
            softAssert.assertTrue(isFound, "googleWithAssert->IsFound");
            softAssert.assertAll();
            test.log(LogStatus.PASS, "Search button displayed");
        }
        catch (AssertionError e)
        {
            test.log(LogStatus.FAIL, "<pre>" + e.getMessage() + "</pre>");
            throw e;
        }
    }

    private Boolean IsElementPresent(WebDriver driver, By by) {
        try
        {
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e) { return false; }
    }
    
    @Test
    public void login(){
    	 test.log(LogStatus.INFO, "Navigating to google.com");
         driver.get("http://google.com");
      driver.findElement(By.xpath("//*[@id='gb_7']")).click();
         test.log(LogStatus.INFO, "google search.com");
    	
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
        extent.endTest(test);
        extent.flush();
    }
}