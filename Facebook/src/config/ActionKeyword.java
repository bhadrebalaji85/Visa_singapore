package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class ActionKeyword{
 
 public static void main(String[] args) { 
 
	 System.setProperty("webdriver.gecko.driver", "C:\\Users\\HP\\Desktop\\jar\\geckodriver.exe");

  WebDriver driver = new FirefoxDriver();
 
  driver.get("http://helloselenium.blogspot.com");
   
  driver.quit();
 }
 
}