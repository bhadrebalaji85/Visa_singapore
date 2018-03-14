package com.naukri.executionEngine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Handling_frame {
  @Test
  public void f() {
	  
	  WebDriver driver =new ChromeDriver();
		driver.get("https://www.freecrm.com/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("bhagwan");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("sufi@143");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//*[text()='Contacts']")).click();
		
		
  }
}
