package com.rs.pages;


import org.openqa.selenium.By;


public final  class LandingPage extends BasePage {

	
	private final By logout = By.xpath("//button[contains(text(), 'Sign Out')]");
	
	
	public LoginPage logout() {
		
		explicitWaitForElementToBeClickable(logout);
		click(logout,"clickable");
		return new LoginPage();
		
	}
	
	
}
