package com.naukri.executionEngine;




import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Dynamic_Webtable {
  @Test
  public void f() {
	  WebDriver driver =new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-table/#");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		List<WebElement> tableheader=driver.findElements(By.xpath("//*[@id='content']/table/tbody/tr"));
		System.out.println("List of table row:"+tableheader.size());
		for(int i=1;i<=(tableheader.size());i++)
		{
			 String rowname="";
			 String name="Burj Khalifa";
			 rowname=driver.findElement(By.xpath("//*[@id='content']/table/tbody/tr["+ i +"]/th")).getText();
			 System.out.print(rowname+ " ");
			 if(rowname.equalsIgnoreCase(name))
			 {
				 List<WebElement> rowcount=driver.findElements(By.xpath("//*[@id='content']/table/tbody/tr["+i+"]/td"));
				 System.out.println("Row count:"+rowcount.size());
				 for(int j=1;j<=(rowcount.size());j++)
				 {
					 String fullrow=driver.findElement(By.xpath("//*[@id='content']/table/tbody/tr["+i+"]/td["+j+"]")).getText();
					 if(fullrow.equals("details"))
					 {
						 driver.findElement(By.xpath("//*[@id='content']/table/tbody/tr["+i+"]/td["+j+"]")).click(); 
						 System.out.println("Clicking on details link");
					 }
					 System.out.print(fullrow +" ");
				 }
				 System.out.println();
				 
			 }
			 break;
		}
		
		
	driver.close();
  }
}
