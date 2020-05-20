package com.tests;


import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.GenericLibrary.BaseWebDriver;
import com.GenericLibrary.Listener;
import com.GenericLibrary.ReUsableMethods;
import com.objectRepo.FlightPage;
import com.objectRepo.HomePage;
import com.objectRepo.RegisterPage;

public class FlightTest extends BaseWebDriver {

	public FirstTest obj;
	public WebDriver chromeDriver;

	@Test(priority = 0)
	public void registerToApp() throws IOException {

		
		chromeDriver = driver.get();

		RegisterPage registerPageObj = new RegisterPage(chromeDriver);
		HomePage homePageObj = new HomePage(chromeDriver);
		// AuthenticationPage authenPageObj=new AuthenticationPage(chromeDriver);

		// String url="http://newtours.demoaut.com/";

		driver.get().get(prop.get().getProperty("url"));
		// ReUsableMethods.maximizeBrowser(chromeDriver);

		// authenPageObj.doAuthentication();

		homePageObj.clickRegisterButton();

		Listener.logger.get().pass("Register Button is clicked successfully");

		String name = ReUsableMethods.takeScreenshot(chromeDriver, "RegisterPage");

		Listener.logger.get().addScreenCaptureFromPath(name, "REGISTER PAGE");

		registerPageObj.register();

		Listener.logger.get().pass("user registered  successfully");
	}

	@Test(priority = 1)
	@Parameters({"noOfPassengers"})
	public void fillTheDetailsInTheApp(String noOfPassengers) throws InterruptedException {

		Thread.sleep(5000);

		HomePage homePageObj = new HomePage(chromeDriver);
		final FlightPage flightPageObj = new FlightPage(chromeDriver);

		// Listener.logger=Listener.extent.createTest(" Fill the Details in The APP ");

		Listener.logger.get().pass("Logging into APP Successfully");

		homePageObj.clickFlightButton();

		Listener.logger.get().pass("Flight Button is clicked successfully");

		ReUsableMethods.waitForPageToLoad(chromeDriver, 10);

		boolean status=flightPageObj.fillDetailsAndClickContinue(Integer.parseInt(noOfPassengers));

		Assert.assertTrue(status);
		
		
		
		Listener.logger.get().pass("Details entered by the user and clicked on Continue  Button");
	}

	@Test(priority = 2)
	public void verifySignOff() {

		HomePage homePageObj = new HomePage(chromeDriver);

		// Listener.logger=Listener.extent.createTest(" Verify Sign Off ");

		homePageObj.clickSignOffButton();

		Listener.logger.get().pass("sign Off Button is clicked successfully");

		ReUsableMethods.takeScreenshot(chromeDriver, "SignOffPage");

		System.out.println("Test script is authored Successfully");

	}


}
