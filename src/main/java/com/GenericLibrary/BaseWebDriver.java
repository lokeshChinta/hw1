package com.GenericLibrary;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseWebDriver {
	
	//private WebDriver driver;
		public ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	    public ThreadLocal<Properties> prop = new ThreadLocal<Properties>();
	    
		@BeforeTest
		public void configure() throws IOException {
			
			FileReader fr = new FileReader(System.getProperty("user.dir")+"\\proj.properties");
			Properties propObj=new Properties();
			prop.set(propObj);
			prop.get().load(fr);
		      	
			
			 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Files\\chromedriver.exe");
				driver.set(new ChromeDriver());
		}
		
		
		@AfterTest
		public void tearDown() {
			driver.get().quit();
		}
		

}
