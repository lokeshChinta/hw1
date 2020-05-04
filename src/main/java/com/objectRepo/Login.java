package com.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericLibrary.ReUsableMethods;

public class Login {
	
	
	private WebDriver driver;
	
	@FindBy(name="userName")
	private WebElement userNameEditBox;
	
	@FindBy(name="password")
     private WebElement pwdEditBox;
	
	@FindBy(name="login")
	private WebElement loginBtn;
	
	@FindBy(xpath="//*[contains(text(),'Welcome back to')] ")
	private WebElement confirmationTxt;
	
	
	
	
	public Login(WebDriver driver){
	 this.driver=driver;	
	 PageFactory.initElements(this.driver, this);
	}
	
	
	public void loginToApp() {
		this.userNameEditBox.sendKeys("lokeech@gmail.com");
		this.pwdEditBox.sendKeys("password");
		this.loginBtn.click();
		
		ReUsableMethods.waitForElementToDisplayInUI(this.driver, 10, confirmationTxt);
		
		System.out.println(confirmationTxt.getText());
		
		
		
	}
	

}
