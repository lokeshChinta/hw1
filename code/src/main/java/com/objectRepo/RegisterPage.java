package com.objectRepo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericLibrary.Listener;
import com.GenericLibrary.ReUsableMethods;

public class RegisterPage {
	
	private WebDriver driver;
	 
	
	@FindBy(xpath="//*[contains(text(),'First')]")
	private By firstNameLabel;
	
	@FindBy(name="firstName")
	private WebElement firstNameEdtBox;
	
	@FindBy(name="lastName")
	private WebElement lastNameEdtBox;
	
	@FindBy(id="email")
	private WebElement emailEdtBox;
	
	
	@FindBy(name="password")
	private WebElement passwordEdtBox;
	
	@FindBy(name="confirmPassword")
	private WebElement confirmPasswordEdtBox;
	
	
	@FindBy(name="register")
	private WebElement registerBtn;
	
	By by= By.xpath("//*[contains(text(),'First')]");
	
	
	public RegisterPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void register() throws IOException {
		
		ReUsableMethods.waitForElementToAppearInUI(driver, 10, by );
		
		this.firstNameEdtBox.sendKeys("lokesh");
		this.lastNameEdtBox.sendKeys("chinta");
		
		this.emailEdtBox.sendKeys("lokeech@gmail.com");
		this.passwordEdtBox.sendKeys("password");
		this.confirmPasswordEdtBox.sendKeys("password");
		
		String name=ReUsableMethods.takeScreenshot(driver, "Login Page");
		
		// Listener.logger.get().addScreenCaptureFromPath(name);
		
		this.registerBtn.click();
		
		
		
	}
	
	
	
	

}
