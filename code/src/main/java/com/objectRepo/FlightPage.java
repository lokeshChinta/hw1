package com.objectRepo;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.GenericLibrary.ReUsableMethods;

public class FlightPage {
	
	 private  WebDriver driver;
	 
	 @FindBy(name="passCount")
	 private WebElement passengersSelectDropDown;
	 
	 
	 @FindBy(xpath="//*[contains(@value,'Business')]")
	 private WebElement businessClassRadioBtn;
	 
	 @FindBy(name="findFlights")
	 private WebElement continueBtn;
	 
	  
	 
	 @FindBy(name="reserveFlights")
	 private WebElement reserveFlightsContinueBtn;
	 
	 @FindBy(name="buyFlights")
	 private WebElement buyFlightsContinueBtn;
	 
	 
	 @FindBy(xpath="//*[contains(text(),'USD')]")
	 private List<WebElement> resultVal;
	 
	public FlightPage(WebDriver driver) {
		this.driver=driver;
	  PageFactory.initElements(this.driver, this);
	}
	
   public boolean fillDetailsAndClickContinue(int index) {
	   
	   String ExpectedVal="$1169 USD";
	   boolean status=false;
	   try {
		   
		   if(index >0 && index <4) {
	   ReUsableMethods.selectByIndexusingSelectClass(this.passengersSelectDropDown, index);
	   ReUsableMethods.takeScreenshot(driver, "FirstPage");
	   
	   businessClassRadioBtn.click();
	   ReUsableMethods.takeScreenshot(driver, "SecondPage");
	   continueBtn.click();
	   ReUsableMethods.takeScreenshot(driver, "ThirdPage");
	   ReUsableMethods.waitForPageToLoad(driver, 10);
	   ReUsableMethods.takeScreenshot(driver, "FourthPage");
	   this.reserveFlightsContinueBtn.click();
	   ReUsableMethods.waitForPageToLoad(driver, 10);
	   ReUsableMethods.takeScreenshot(driver, "FifthPage");
	   this.buyFlightsContinueBtn.click();
	   ReUsableMethods.waitForPageToLoad(driver, 10);
	   
	   System.out.println("Result is "+resultVal.get(1).getText());
	   
	   
	   
	  // Assert.assertEquals(resultVal.get(1).getText().trim(),ExpectedVal);
	   status=true;
	   
	   }
		   else
		   {
			   status=false;
		   }
	   }
	   
	   catch(Exception e) {
		   System.out.println(e.getMessage());
	   }
	   
	   Assert.assertTrue(status);
	   return status;
   }
	
	
	
}
