package com.rs.factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rs.constants.FrameworkConstants;
import com.rs.driver.DriverManager;
import com.rs.enums.WaitStratergy;

public class ExplicitWaitFactory {

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
