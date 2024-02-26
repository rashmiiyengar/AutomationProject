package com.rs.pages;

import org.openqa.selenium.By;

import com.rs.driver.DriverManager;

public final class LoginPage {

	
	//id ,name,classname,linktext,partiallinktext,css or xpath
	//Assertions should not be called in page layers
	//All your page methods needsto have some return type
	private final By textboxUsername= By.id("userEmail");
	private final By textboxPassword = By.xpath("//input[@id='userPassword' and @type='password']");
	private final By btnLogin = By.id("login");
	
	public LoginPage enterUserName(String userName) {
		DriverManager.getDriver().findElement(textboxUsername).sendKeys(userName);
		return this;
	}
	
	
	public LoginPage enterPassword(String password) {
		
		DriverManager.getDriver().findElement(textboxPassword).sendKeys(password);
		return this;
	}
	
	public LandingPage clickLogin() {
		DriverManager.getDriver().findElement(btnLogin).click();
		
		return new LandingPage();
}
	
	public String getTitle() {
		return DriverManager.getDriver().getTitle();
	}
}
