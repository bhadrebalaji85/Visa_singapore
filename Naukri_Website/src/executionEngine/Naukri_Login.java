package executionEngine;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import refection_Classes.ReadPropertyFile;
import refection_Classes.ActionKeywords;


public class Naukri_Login extends ActionKeywords{

	WebDriver driver;

	
	@BeforeClass
	public void Open_url() throws Exception {
	
		driver = ActionKeywords.getDriver();
		//ReadPropertyFile p1= new ReadPropertyFile();
		//driver.get(p1.Type_Url());
		ActionKeywords.navigate();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// String home_page= d1.getWindowHandle();
		// System.out.println(home_page);

	}
	@Test
	public void login() throws Exception {
		
		ReadPropertyFile ob=new ReadPropertyFile();
		String home_page = driver.getWindowHandle();
        System.out.println(home_page);
        Set<String> windows= driver.getWindowHandles();
        System.out.println(windows.size());
        Iterator iterator= windows.iterator();
        while(iterator.hasNext()){
        	
        	String currentwindowid=iterator.next().toString();
        	
        	if(!currentwindowid.equals(home_page))
        	{
        		driver.switchTo().window(currentwindowid);
        		driver.close();
        	}
        	
        }
        driver.switchTo().window(home_page);
        driver.findElement(By.id("login_Layer")).click();
        driver.findElement(By.id("eLogin")).click();
        driver.findElement(By.id("eLogin")).clear();
       
		driver.findElement(By.id("eLogin")).sendKeys(ob.username());
		driver.findElement(By.id("pLogin")).sendKeys(ob.password());
		driver.findElement(By.xpath(ob.Login_btn())).click();      
	}

	@Test(dependsOnMethods = { "login" })
	public void logout() throws Exception {
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//ActionKeywords.nauri_logout();
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("//*[@id='mainHeader']/div/div/ul[2]/li[2]/a"));
		actions.moveToElement(mainMenu);

		//WebElement subMenu = driver.findElement(By.xpath("//*[@id='mainHeader']/div/div/ul[2]/li[2]/div/ul/li[5]/a"));
		//actions.moveToElement(subMenu);
		//actions.click().build().perform();
		//ReadPropertyFile ob=new ReadPropertyFile();
		//driver.findElement(By.xpath(ob.My_naukri())).click(); 
		//driver.findElement(By.xpath(ob.log_out())).click(); 
		
	}
	
	@AfterClass
	public void Close_browser() {
		
		driver.close();
	}

}
