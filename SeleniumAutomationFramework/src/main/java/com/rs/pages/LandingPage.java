package com.rs.pages;

import org.openqa.selenium.By;

import com.rs.enums.WaitStratergy;

public final class LandingPage extends BasePage {

	private final By logout = By.xpath("//button[contains(text(), 'Sign Out')]");

	public LoginPage logout() throws Exception {

		click(logout, WaitStratergy.CLICKABLE,"Login Button");
//		/ExtentManager.getExtentTest().pass("logout clicked successfully");
		
		return new LoginPage();

	}

}
