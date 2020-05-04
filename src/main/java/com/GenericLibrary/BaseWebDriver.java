package com.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseWebDriver {
	
	//private WebDriver driver;
		public ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
		
		@BeforeTest
		public void configure() {
			 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Files\\chromedriver.exe");
				driver.set(new ChromeDriver());
		}
		
		
		@AfterTest
		public void tearDown() {
			driver.get().quit();
		}
		

}
