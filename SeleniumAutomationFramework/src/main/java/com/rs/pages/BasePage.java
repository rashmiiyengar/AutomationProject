package com.rs.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rs.driver.DriverManager;

public class BasePage {

	
	protected void click(By by,String waitStratergy) {
		
		if(waitStratergy.equalsIgnoreCase("clickable")) {
			explicitWaitForElementToBeClickable(by);
		}
		else if(waitStratergy.equalsIgnoreCase("present")) {
			explicitWaitForElementToBrPresent(by);
		}
		DriverManager.getDriver().findElement(by).click();
	}
	
	protected void sendKeys(By by,String value,String waitStratergy) {
		explicitWaitForElementToBeClickable(by);
		DriverManager.getDriver().findElement(by).sendKeys(value);
	}
	
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
	protected void explicitWaitForElementToBeClickable(By by) {
	new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(by)); //old way
		//wait.until(e->e.findElement(logout)).isEnabled(); java 8
	}
	
	protected void explicitWaitForElementToBrPresent(By by) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(by)); //old way
		//wait.until(e->e.findElement(logout)).isEnabled(); java 8
	}
}