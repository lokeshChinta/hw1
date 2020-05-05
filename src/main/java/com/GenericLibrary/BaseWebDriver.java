package com.GenericLibrary;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
		      	
			String host="localhost";
			DesiredCapabilities caps= DesiredCapabilities.chrome();
			
			if(System.getProperty("BROWSER")!=null &&
					System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
				caps=DesiredCapabilities.firefox();
			}
			
			if(System.getProperty("HUB_HOST")!=null)
			{
				host=System.getProperty("HUB_HOST");
			}
			
			String completeURL="http://" + host +":4444/wd/hub";
			System.out.println("Complete URL is " +completeURL);
			// System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Files\\chromedriver.exe");
				driver.set(new RemoteWebDriver(new URL(completeURL),caps));
				
				
		}
		
		
		@AfterTest
		public void tearDown() {
			driver.get().quit();
		}
		

}
