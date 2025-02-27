package config;

import java.sql.Time;
import java.util.Iterator;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import utility.Log;


import org.openqa.selenium.By;
import static executionEngine.DriverScript.OR;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import executionEngine.DriverScript;



public class ActionKeywords {
	
	
	public static WebDriver driver;
	
   //public static log logger=new log();

   
	public static void openBrowser(String object,String data){		
		Log.info("Opening Browser");
		try{
			//If value of the parameter is Mozilla, this will execute
			if(data.equals("Mozilla")){
				 System.setProperty("webdriver.gecko.driver", "C:\\Users\\HP\\Desktop\\jar\\geckodriver.exe");
				driver=new FirefoxDriver();
				Log.info("Mozilla browser started");
				}
			else if(data.equals("IE")){
				//You may need to change the code here to start IE Driver
				driver=new InternetExplorerDriver();
				//Log.info("IE browser started");
				}
			else if(data.equals("Chrome")){
				System.setProperty("webdriver.chrome.driver", "C://Users//HP//Desktop//Jar//chromedriver.exe");
				driver=new ChromeDriver();
				Log.info("Chrome browser started");
				}
 
			//int implicitWaitTime=(10);
			//driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		}catch (Exception e){
			Log.info("Not able to open the Browser --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	} 
	
	

	public static void navigateURL(String object, String data){
		try{
			Log.info("Navigating to URL");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//Constant Variable is used in place of URL
			driver.get(Constants.URL);
		}catch(Exception e){
			Log.info("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
			}
		}
 
	

	public static void window_Maximize(String object,String data) {
		Log.info("Maximize Window");
		driver.manage().window().maximize();
	}

	public static void close_Popup(String object, String data) {
		Log.info("Closing All Popup");
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
	}

	public static void click(String object, String data) {
		Log.info("Clicking on Click buttom");
		driver.findElement(By.xpath(OR.getProperty(object))).click();

	}

	public static void input(String object, String data){
		try{
			Log.info("Entering the text in " + object);
			
			//WebDriverWait wait = new WebDriverWait(driver,12);
		    //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty(object))));   /*examining the xpath for a search     
		    //box*/
		    //driver.findElement(By.xpath(object)).sendKeys(data);
			//JavascriptExecutor jse = (JavascriptExecutor)driver;
			//jse.executeScript("document.getElementsByName('body')[0].setAttribute('type', 'text');");
			driver.findElement(By.xpath(OR.getProperty(object))).click();
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
			
			
		 }catch(Exception e){
			 Log.error("Not able to Enter UserName --- " + e.getMessage());
			 DriverScript.bResult = false;
		 	}
		}
	
	public static void input_Password(String object,String data) throws InterruptedException{
		JavascriptExecutor javascript = (JavascriptExecutor) driver; 
		//- See more at: http://software-testing-tutorials-automation.blogspot.in/2014/02/how-to-enabledisable-textbox-in.html#sthash.8uv61R7D.dpuf
		String toenable = "document.getElementsByName('passwd')[0].removeAttribute('disabled');"; 

		javascript.executeScript(toenable); 
		Thread.sleep(3000); 
		//- See more at: http://software-testing-tutorials-automation.blogspot.in/2014/02/how-to-enabledisable-textbox-in.html#sthash.8uv61R7D.dpuf
	}
	
	
	public static void waitFor(String object,String data) throws Exception{
		Log.info("Waiting for page to load");
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		}
	
	
	public static void validate(String object,String data){
		Log.info("Validating Profile Page with User name");
		Assert.assertEquals(driver.findElement(By.xpath(OR.getProperty(object))).getText(),"Balaji Bhadre");
	}
	
	public static void hover_mouse(String object,String data) throws InterruptedException{
		try{
			
		Log.info("Mouse Hover");
		WebElement webElement = driver.findElement(By.xpath(OR.getProperty(object)));
		Actions act = new Actions(driver);
		        act.moveToElement(webElement).perform();//This opens menu list

		        Thread.sleep(5000);//This line will help you to hold menu 	
	
	
	}catch(Exception e){
		DriverScript.bResult=false;
	}
	}
	
	public static void Close_Browser(String object,String data){
		Log.info("Closing the Browser");
		driver.close();
	}
}

