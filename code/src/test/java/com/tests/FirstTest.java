package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.GenericLibrary.BaseWebDriver;
import com.GenericLibrary.Listener;
import com.GenericLibrary.ReUsableMethods;
import com.objectRepo.AuthenticationPage;

public class FirstTest extends BaseWebDriver {

	public WebDriver chromeDriver;
	@Test()
	public void googleTest() {
		chromeDriver=driver.get();
		String url="http://google.com";
		
		chromeDriver.get(url);
		Listener.logger.get().pass("Launched the "+ url +" Successfully");
		
	//	ReUsableMethods.maximizeBrowser(chromeDriver);
	//	AuthenticationPage authenPageObj=new AuthenticationPage(chromeDriver);
		
		//authenPageObj.doAuthentication();
		
		
		Listener.logger.get().pass("Test is passed Successfully");
		
	}
	
	

}
