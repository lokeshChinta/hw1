package com.stepsDefinitions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.GenericLibrary.BaseWebDriver;
import com.GenericLibrary.Listener;
import com.GenericLibrary.ReUsableMethods;
import com.objectRepo.AuthenticationPage;
import com.objectRepo.FlightPage;
import com.objectRepo.HomePage;
import com.objectRepo.RegisterPage;
import com.tests.FirstTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlightWebSiteTest1 {
	public FirstTest obj;
	public WebDriver driver;

	public FileReader fr;
	public Properties propObj;


	@Given("^user launches the  flight WebSite$")
	public void user_launches_the_flight_WebSite() throws Throwable {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Files\\chromedriver.exe");
		// driver.set(new RemoteWebDriver(new URL(completeURL),caps));
		driver = new ChromeDriver();

		RegisterPage registerPageObj = new RegisterPage(driver);
		HomePage homePageObj = new HomePage(driver);
		AuthenticationPage authenPageObj = new AuthenticationPage(driver);

		String url = "http://newtours.demoaut.com/";

		System.out.println("URL is " + url);

		driver.get(url);
		// ReUsableMethods.maximizeBrowser(chromeDriver);

		 authenPageObj.doAuthentication();

		homePageObj.clickRegisterButton();

        //Listener.logger.get().pass("Register Button is clicked successfully");

	   //String name = ReUsableMethods.takeScreenshot(driver, "RegisterPage");

       //Listener.logger.get().addScreenCaptureFromPath(name, "REGISTER PAGE");

		registerPageObj.register();

        //Listener.logger.get().pass("Register Button is clicked successfully");
	}
	
	


	@When("^user provides the (\\d+) Information$")
	public void user_provides_the_Information(int noOfPassengers) throws Throwable {
		
		Thread.sleep(5000);

		HomePage homePageObj = new HomePage(driver);
		final FlightPage flightPageObj = new FlightPage(driver);

		// Listener.logger=Listener.extent.createTest(" Fill the Details in The APP ");

		// Listener.logger.get().pass("Logging into APP Successfully");

		homePageObj.clickFlightButton();

		// Listener.logger.get().pass("Flight Button is clicked successfully");

		ReUsableMethods.waitForPageToLoad(driver, 10);

		flightPageObj.fillDetailsAndClickContinue(noOfPassengers);

		// Listener.logger.get().pass("Details entered by the user and clicked on
		// Continue Button");
	}

	@When("^user Submits the Details$")
	public void user_Submits_the_Details() throws Throwable {
	
		System.out.println("user Submits the Details");
	}

	@Then("^user should able to see the Total amount required to pay for Tickets$")
	public void user_should_able_to_see_the_Total_amount_required_to_pay_for_Tickets() throws Throwable {
	
		HomePage homePageObj = new HomePage(driver);

		// Listener.logger=Listener.extent.createTest(" Verify Sign Off ");

		homePageObj.clickSignOffButton();

		// Listener.logger.get().pass("sign Off Button is clicked successfully");

		ReUsableMethods.takeScreenshot(driver, "SignOffPage");

		System.out.println("Test script is authored Successfully");

		driver.quit();

	}

}
