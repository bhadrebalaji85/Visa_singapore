package com.naukri.executionEngine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class Logo_google {
  @Test
  public void Logo() {
	  WebDriver driver =new ChromeDriver();
		driver.get("https://www.google.co.in/?gfe_rd=cr&dcr=0&ei=V2p8WpLuHbOIX8vjr6AL");
		driver.manage().window().maximize();
		Boolean b=driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
		Assert.assertTrue(b);
		
  
  }
  
}
