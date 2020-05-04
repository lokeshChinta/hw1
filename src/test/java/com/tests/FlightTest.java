package com.tests;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


import com.GenericLibrary.BaseWebDriver;
import com.GenericLibrary.Listener;
import com.GenericLibrary.ReUsableMethods;
import com.objectRepo.AuthenticationPage;
import com.objectRepo.FlightPage;
import com.objectRepo.HomePage;
import com.objectRepo.Login;
import com.objectRepo.RegisterPage;



public class FlightTest extends BaseWebDriver  {


    
  public   FirstTest obj;
  public  WebDriver chromeDriver; 
   
	
	@Test(priority=0)
	public void registerToApp() throws IOException {

		
		//	Google_URL=http://google.com
		           chromeDriver=driver.get();     
		 
		         RegisterPage registerPageObj=new RegisterPage(chromeDriver);
		    	HomePage homePageObj=new HomePage(chromeDriver);
		        AuthenticationPage authenPageObj=new AuthenticationPage(chromeDriver);
		
		//String url="http://newtours.demoaut.com/";
		
		driver.get().get(prop.get().getProperty("url"));
		ReUsableMethods.maximizeBrowser(chromeDriver);
        
		
		authenPageObj.doAuthentication();
		
		
		
		homePageObj.clickRegisterButton();
		 
	 
	     
		 Listener.logger.get().pass("Register Button is clicked successfully");
	     
	     String name=ReUsableMethods.takeScreenshot(chromeDriver, "RegisterPage");
	     
	     Listener.logger.get().addScreenCaptureFromPath(name, "REGISTER PAGE");
	     
	     registerPageObj.register();
	     
	 
	     
	     Listener.logger.get().pass("Register Button is clicked successfully");
	}
	
	
	@Test(priority=1)
	public void fillTheDetailsInTheApp() throws InterruptedException {
		
		Thread.sleep(5000);
		
		HomePage homePageObj=new HomePage(chromeDriver);
		final FlightPage flightPageObj= new FlightPage(chromeDriver);
		
		//Listener.logger=Listener.extent.createTest(" Fill the Details in The APP "); 
		
		Listener.logger.get().pass("Logging into APP Successfully");
	     
		homePageObj.clickFlightButton();
	     
		Listener.logger.get().pass("Flight Button is clicked successfully");
	     
	     ReUsableMethods.waitForPageToLoad(chromeDriver, 10);
	     
	     flightPageObj.fillDetailsAndClickContinue();
	     
	     Listener.logger.get().pass("Details entered by the user and clicked on Continue  Button");
	}
	
	@Test(priority=2)
	public void verifySignOff() {
		
		HomePage homePageObj=new HomePage(chromeDriver);
		
		//Listener.logger=Listener.extent.createTest(" Verify Sign Off "); 
		
		homePageObj.clickSignOffButton();
	     
		Listener.logger.get().pass("sign Off Button is clicked successfully");
	     
	     ReUsableMethods.takeScreenshot(chromeDriver, "SignOffPage");
	     
	}
	
//	@Test
//	public void verifyTheAmountDisplayedInUI() throws IOException {
//		
//		FileReader reader = new FileReader(System.getProperty("user.dir")+"\\Env.properties");
//	    Properties prop =new Properties();
//	    prop.load(reader);
//	  
//		      BaseClass.driver.get(prop.getProperty("Env_URL"));
//		
//		     registerPageObj=new RegisterPage(BaseClass.driver);
//			 homePageObj=new HomePage(BaseClass.driver);
//			 flightPageObj= new FlightPage(BaseClass.driver);
//			 
//			 loginObj=new Login(BaseClass.driver);
//			 
//			 ReUsableMethods.logger=Listener.extent.createTest(" verify The Amount Displayed In UI "); 
//			 
//		     homePageObj.clickRegisterButton();
//		     
//		     ReUsableMethods.logger.pass("Register Button is clicked successfully");
//		     
//		     String name=ReUsableMethods.takeScreenshot(BaseClass.driver, "RegisterPage");
//		     
//		     ReUsableMethods.logger.addScreenCaptureFromPath(name, "REGISTER PAGE");
//		     
//		     
//		     registerPageObj.register();
//		     
//		     ReUsableMethods.logger.pass("Register Button is clicked successfully");
//			 
//			 // loginObj.loginToApp();
//			 
//			 ReUsableMethods.logger.pass("Logging into APP Successfully");
//		     
//		     homePageObj.clickFlightButton();
//		     
//		     ReUsableMethods.logger.pass("Flight Button is clicked successfully");
//		     
//		     ReUsableMethods.waitForPageToLoad(BaseClass.driver, 10);
//		     
//		     flightPageObj.fillDetailsAndClickContinue();
//		     
//		     ReUsableMethods.logger.pass("Details entered by the user and clicked on Continue  Button");
//		     
//		     homePageObj.clickSignOffButton();
//		     
//		     ReUsableMethods.logger.pass("sign Off Button is clicked successfully");
//		     
//		     ReUsableMethods.takeScreenshot(BaseClass.driver, "SignOffPage");
//		     
//		     
//		     
//		     
//		
//	}
	
	

	
}
