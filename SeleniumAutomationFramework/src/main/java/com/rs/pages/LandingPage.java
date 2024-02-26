package com.rs.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.rs.driver.DriverManager;

public class LandingPage {

	
	private final By logout = By.xpath("//button[contains(text(), 'Sign Out')]");
	
	
	public LoginPage logout() {
		
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(logout)); //old way
		//wait.until(e->e.findElement(logout)).isEnabled(); java 8
		DriverManager.getDriver().findElement(logout).click();
		return new LoginPage();
		
	}
	
	
}
