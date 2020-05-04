package com.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericLibrary.ReUsableMethods;

public class AuthenticationPage {
	
	private WebDriver driver;
	
	@FindBy(css="input.form-input-field")
	private WebElement  formLoginButton;
	
	
	@FindBy(id="userNameInput")
	private WebElement  userNameInputBtn;
	
	@FindBy(id="passwordInput")
	private WebElement  pwdInputBtn;
	
	@FindBy(id="submitButton")
	private WebElement  submitBtn;
	
	@FindBy(name="submit")
	private WebElement submitBtn1;
	
	 public AuthenticationPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	 
	 public void doAuthentication() {
		 formLoginButton.sendKeys("lokesh.chinta@citiustech.com");
		 submitBtn1.submit();
		 
		 ReUsableMethods.waitForElementToDisplayInUI(this.driver, 10, userNameInputBtn);
		 userNameInputBtn.sendKeys("lokesh.chinta@citiustech.com");
		 pwdInputBtn.sendKeys("Welcome@1234");
		 submitBtn.click();
		 ReUsableMethods.waitForPageToLoad(this.driver, 10);
	 }
	 

}
