package com.naukri.executionEngine;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Actions_class {
  @Test
  public void f() {
	  
	  WebDriver driver =new ChromeDriver();
		driver.get("http://www.spicejet.com/");
		//System.out.println(driver.getPageSource());
		
		System.out.println(driver.findElement(By.xpath("//input[@name='ctl00$mainContent$view_date1']")).getAttribute("id"));
		/*driver.manage().window().maximize();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@id='highlight-addons']"))).build().perform();


		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='header-addons']/ul/li[7]/a")));
		

		driver.findElement(By.xpath("//*[@id='header-addons']/ul/li[7]/a")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);*/
  }
}
