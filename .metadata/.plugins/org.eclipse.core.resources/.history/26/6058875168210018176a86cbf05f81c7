package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;



public class LoginPage extends TestBase {

	

	


	@FindBy(name="username")
	WebElement username;
     
	@FindBy(name="password")
	WebElement password;
	
	//@FindBy(xpath="//input[@value='Login']")
	
	//@FindBy(xpath="//*[@id='loginForm']/div/div/input")
	//@FindBy(xpath="//*[@id='loginForm']");
	//WebElement Loginbutton;
	
	@FindBy(xpath="//button[text()='Sign Up']")
	WebElement Signup;
	
	
	@FindBy(xpath="//a[contains(@class,'navbar-brand')]/img")
	WebElement Logo;
	
	public LoginPage() throws IOException {
		
		PageFactory.initElements(driver, this);
		
		
		//super();
		// TODO Auto-generated constructor stub
	}
	
	public String validatepagetitle()
	{
		return driver.getTitle();
	}
	
	public boolean validatelogo()
	{
		return Logo.isDisplayed();
	}
	
	public HomePage login(String un,String pw) throws IOException
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//WebElement element = driver.findElement(By.xpath("//input[@value='Login']"));
		js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", driver.findElement(By.xpath("//input[@value='Login']")));
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		//Actions action=new Actions((WebDriver) Loginbutton);
		//action.moveToElement(Loginbutton).click().build().perform();
		//Loginbutton.click();
		//WebElement element = driver.findElement(By.xpath("//input[@value='Login']"));
		//Actions action = new Actions(driver);
		//action.moveToElement(element).click().build().perform();
		return new HomePage();
	}

}
