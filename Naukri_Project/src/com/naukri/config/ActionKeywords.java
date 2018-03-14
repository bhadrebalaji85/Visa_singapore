package com.naukri.config;
import static com.naukri.executionEngine.DriverScript.OR;
import static com.naukri.executionEngine.DriverScript.logger;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.naukri.executionEngine.DriverScript;
import com.relevantcodes.extentreports.LogStatus;


public class ActionKeywords {
	
	public static WebDriver driver;
	
	public static void OpenBrowser(String object)
	{
		driver =new ChromeDriver();
		logger.log(LogStatus.INFO, "Broswer is opening");
		//ATUReports.setWebDriver(driver);
		//ATUReports.add("Opening broswer",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
	
	public static void Navigate(String object)
	{
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(Constants.URL);
		driver.manage().window().maximize();
		logger.log(LogStatus.INFO, "Navigating to naukri");
		//driver.get(DriverScript.p.getProperty((Constants.URL)));
	}
	
	public static void Close_Popup(String object)
	{
		String home_page = driver.getWindowHandle();
		System.out.println(home_page);
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows.size());
		Iterator iterator = windows.iterator();
		while (iterator.hasNext()) {

			String currentwindowid = iterator.next().toString();

			if (!currentwindowid.equals(home_page)) {
				driver.switchTo().window(currentwindowid);
				driver.close();
				
			}
       
		}
		driver.switchTo().window(home_page);
		//driver.switchTo().defaultContent();
		logger.log(LogStatus.INFO, "Pop ups are closed");
	}
	
	public static void Click_Login_menu(String object) throws InterruptedException
	{
		List <WebElement> element=driver.findElements(By.className(OR.getProperty(object)));
	       element.get(5).click();
	       //Thread.sleep(5);
	       logger.log(LogStatus.INFO, "Click on Login button");
		
	}
	
	public static void Input_Username(String object) throws InterruptedException
	{
		 
	      //Actions action=new Actions(driver);
	      //Thread.sleep(5);
	      driver.findElement(By.name(OR.getProperty(object))).sendKeys(Constants.Username);
	      //Thread.sleep(5000);
	      logger.log(LogStatus.INFO, "Username entered");
	}
	
	public static void Input_Password(String object) throws InterruptedException
	{
		
		driver.findElement(By.name(OR.getProperty(object))).sendKeys(Constants.Password);
		  //Thread.sleep(5000);
		logger.log(LogStatus.INFO, "password entered");
		
	}
	
	public static void Click_Login_Button(String object) throws InterruptedException
	{
		//driver.findElement(By.cssSelector(OR.getProperty(object))).click();
		
		//driver.findElement(By.name(OR.getProperty(object))).submit();
		
		driver.findElement(By.xpath(OR.getProperty(object))).click();
//		List <WebElement> element2=driver.findElements(By.className(OR.getProperty(object)));
//		element2.get(2).click();
		//Thread.sleep(5000);
		logger.log(LogStatus.INFO, "Clicking on Login button");
		
	}
	
	public static void CloseBrowser(String object) throws InterruptedException
	{
		Thread.sleep(5);
		driver.close();
		logger.log(LogStatus.INFO, "Browser is closing");
	}
	
	
	

}
