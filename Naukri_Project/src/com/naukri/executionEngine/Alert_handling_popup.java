package com.naukri.executionEngine;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Alert_handling_popup {
  @Test
  public void f() {
	  
	  WebDriver driver =new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Alert alert=driver.switchTo().alert();
		System.out.println("Alert name is:"+alert.getText());
		alert.accept();
  }
}
