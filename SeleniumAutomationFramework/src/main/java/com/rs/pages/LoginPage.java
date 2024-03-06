package com.rs.pages;

import org.openqa.selenium.By;

import com.rs.enums.WaitStratergy;

public final class LoginPage extends BasePage {

	// id ,name,classname,linktext,partiallinktext,css or xpath
	// Assertions should not be called in page layers
	// All your page methods needsto have some return type

	private final By textboxUsername = By.id("userEmail");
	private final By textboxPassword = By.xpath("//input[@id='userPassword' and @type='password']");
	private final By btnLogin = By.id("login");

	public LoginPage enterUserName(String userName) {
		sendKeys(textboxUsername, userName,WaitStratergy.PRESENCE,"UserName");
		return this;
	}

	public LoginPage enterPassword(String password) {

		sendKeys(textboxPassword, password,WaitStratergy.PRESENCE,"Password");
		return this;
	}

	public LandingPage clickLogin() {
		click(btnLogin,WaitStratergy.PRESENCE,"Login Button");

		return new LandingPage();
	}

	public String getTitle() {
		return getPageTitle();
	}

}
