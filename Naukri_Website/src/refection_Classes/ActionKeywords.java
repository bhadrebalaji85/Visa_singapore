package refection_Classes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionKeywords {

	static WebDriver driver;
    
	
	public static WebDriver getDriver() {

		if (driver == null) {

			driver = new FirefoxDriver();

		}

		return driver;
	}

	public static void navigate() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.naukri.com/");
	}
	
	public static void nauri_logout() {
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/div[2]/ul/li[4]"));
		actions.moveToElement(mainMenu);

		WebElement subMenu = driver.findElement(By.xpath("html/body/div[1]/div/div/ul[2]/li[2]/div/ul/li[5]/a"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();
	}
	
}