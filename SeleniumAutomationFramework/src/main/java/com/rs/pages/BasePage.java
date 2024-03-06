package com.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.rs.driver.DriverManager;
import com.rs.enums.WaitStratergy;
import com.rs.factories.ExplicitWaitFactory;
import com.rs.reports.ExtentLogger;

public class BasePage {

	
	//we want to make sure user can only choose from list of predefined options
	protected void click(By by, WaitStratergy waitstratergy,String elementName) {
		WebElement element= ExplicitWaitFactory.performExplicitWait(waitstratergy, by);
		element.click();
		ExtentLogger.pass(elementName+ " is clicked");
	}

	protected void sendKeys(By by, String value, WaitStratergy waitstratergy,String elementName) {
		WebElement element=ExplicitWaitFactory.performExplicitWait(waitstratergy, by);
		element.sendKeys(value);
		ExtentLogger.pass(value+ " is entered successfully in " +elementName);
		//DriverManager.getDriver().findElement(by).sendKeys(value);
	}
 
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}	
}