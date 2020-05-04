package com.objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericLibrary.ReUsableMethods;

public class HomePage {
	
	private WebDriver driver;
	
	@FindBy(linkText = "REGISTER")
	private WebElement registerBtn;
	
	By linkText =By.linkText("REGISTER");
	
    @FindBy(linkText="Flights")
    private WebElement flightLinkTxt;
	
	@FindBy(linkText="SIGN-OFF")
	private WebElement signOffBtn;
    
    
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickRegisterButton() {
		
		
		ReUsableMethods.waitForElementToAppearInUI(driver, 10, linkText);
		this.registerBtn.click();
	}
	
	
	public void clickFlightButton() {
		this.flightLinkTxt.click();
	}
	
	public void clickSignOffButton() {
		this.signOffBtn.click();
	}

}
