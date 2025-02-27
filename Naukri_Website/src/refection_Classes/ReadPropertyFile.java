package refection_Classes;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ReadPropertyFile {

	public Properties prop = null;
	public InputStream input = ReadPropertyFile.class.getClassLoader()
			.getResourceAsStream("config/config.properties");

	public ReadPropertyFile() throws Exception  {
		prop = new Properties();
		prop.load(input);
	}

	public String Type_Url() {
		return prop.getProperty("URL");

	}

	public String username() {
		return prop.getProperty("Username");
	}

	public String password() {
		return prop.getProperty("Password");
		
	}
	
	public String Login_btn() {
		return prop.getProperty("Login_Btn");
		
	}


}
