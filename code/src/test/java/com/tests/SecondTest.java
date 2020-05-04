package com.tests;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.GenericLibrary.BaseWebDriver;
import com.GenericLibrary.Listener;
import com.GenericLibrary.ReUsableMethods;
import com.objectRepo.AuthenticationPage;

public class SecondTest extends BaseWebDriver {
	public WebDriver chromeDriver;
	@Test()
	public void yahooTest() {
		chromeDriver=driver.get();
		String url="http://yahoo.com";
		chromeDriver.get(url);
		
		Listener.logger.get().pass("Launched the "+ url +" Successfully");
		
		ReUsableMethods.maximizeBrowser(chromeDriver);
        AuthenticationPage authenPageObj=new AuthenticationPage(chromeDriver);
		
		authenPageObj.doAuthentication();
		
		Listener.logger.get().pass("Test is passed Successfully");
		
	}
	

}
