package com.naukri.executionEngine;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Window_alert {
  @Test
  public void f() throws AWTException, InterruptedException {
	  
	  WebDriver driver =new ChromeDriver();
	  driver.get("http://toolsqa.com/automation-practice-form/?firstname=&lastname=&photo=&continents=Asia&selenium_commands=Browser+Commands&submit=");
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath("//input[@id='photo']")).click();
	  Robot robo=new Robot();
	  robo.keyPress(KeyEvent.VK_E);
	  robo.keyRelease(KeyEvent.VK_E);
	  /*robo.keyPress(KeyEvent.VK_SHIFT);
	  robo.keyPress(KeyEvent.VK_SEMICOLON);
	  robo.keyRelease(KeyEvent.VK_SEMICOLON);
	  robo.keyRelease(KeyEvent.VK_SHIFT);
	  robo.keyPress(KeyEvent.VK_BACK_SLASH);
	  robo.keyRelease(KeyEvent.VK_BACK_SLASH);
	  robo.keyPress(KeyEvent.VK_ENTER);
	  robo.keyRelease(KeyEvent.VK_ENTER);*/
	  robo.keyPress(KeyEvent.VK_S);
	  robo.keyRelease(KeyEvent.VK_S);
	  Thread.sleep(5000);
	  robo.keyPress(KeyEvent.VK_DOWN);
	  robo.keyRelease(KeyEvent.VK_DOWN);
	  robo.keyPress(KeyEvent.VK_ENTER);
	  robo.keyRelease(KeyEvent.VK_ENTER);
	  
	  
	  
	  
  }
}
