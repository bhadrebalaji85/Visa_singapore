package com.naukri.executionEngine;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpConnection;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import com.naukri.config.ActionKeywords;
import com.naukri.config.Constants;

public class Broken_link {
	
	
	public static WebDriver driver;
	@Test
	  public void beforeMethod() throws MalformedURLException, IOException {
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
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
	     List<WebElement> linkedlist=driver.findElements(By.tagName("a"));
	     linkedlist.addAll(driver.findElements(By.tagName("img")));
	     System.out.println("Total number of links:"+linkedlist.size());
	     driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	     List<WebElement> activelink= new ArrayList<WebElement>();
	     
	     try{
	    	 
	     
	    	 for(int i=1;i<=linkedlist.size();i++)
	    	 
	    	 	{
	    	 if(linkedlist.get(i).getAttribute("href")!=null)
	    	   	{
	    		 activelink.add(linkedlist.get(i));
	    	     // System.out.println("Active link is:"+activelink.get(i).getText());
	    	   	}
	    	 	}
	       
	    	 //System.out.println("Number of active links:"+activelink.size());
	      
	     }catch(IndexOutOfBoundsException e)
	         {
	    	 
	         }
		
	     System.out.println("Number of active links:"+activelink.size());
	     
	     for(int j=1;j<=activelink.size();j++)
	     {
	    	 HttpURLConnection con=(HttpURLConnection)new URL(activelink.get(j).getAttribute("href")).openConnection();
	    	 
            con.connect();
            int code=con.getResponseCode();
            String response=con.getResponseMessage();
            con.disconnect();
            System.out.println(activelink.get(j).getAttribute("href")+ " Response is:"+response+" response code:"+code);
	    	 
	    	 
	    	 
	    	 
	    	 
	     }
	     
	  }



	

}
