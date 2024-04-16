package com.rs.factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rs.constants.FrameworkConstants;
import com.rs.driver.DriverManager;
import com.rs.enums.WaitStratergy;


/**
 * Explicit wait factory produces different waits before operating on webelement
	Apr 15, 2024
 */
public final class ExplicitWaitFactory {
	/**
	 * Private constructor to avoid external isntantiation
	 */
	private ExplicitWaitFactory() {
		
	}
	
	/**
	 * @author rashmisoundar
	 * @param waitstratergy Stratergy to be applied to fild a webelement {@link com.rs.enums.WaitStratergy}
	 * @param by By locator of the webelement
	 * @return webelement Located and return the webelement
	 */
	public static WebElement performExplicitWait(WaitStratergy waitstratergy, By by) {
		WebElement element = null;

		if (waitstratergy == WaitStratergy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
					.until(ExpectedConditions.elementToBeClickable(by)); // old way
			// wait.until(e->e.findElement(logout)).isEnabled(); java 8
		} else if (waitstratergy == WaitStratergy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
					.until(ExpectedConditions.presenceOfElementLocated(by)); // old way
			// wait.until(e->e.findElement(logout)).isEnabled(); java 8
		} else if (waitstratergy == WaitStratergy.VISIBLE) {
			element = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
					.until(ExpectedConditions.visibilityOfElementLocated(by)); // old way
			// wait.until(e->e.findElement(logout)).isEnabled(); java 8
		} else if (waitstratergy == WaitStratergy.NONE) {
			element = DriverManager.getDriver().findElement(by);
		}
		return element;

	}
;
}
