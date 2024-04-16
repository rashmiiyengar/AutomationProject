package com.rs.driver;

import java.util.Objects;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.rs.enums.ConfigProperties;
import com.rs.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {

	
	/**
	 * Private constructor to avoid external instantiation
	 * 
	 */
	private Driver() {

	}
	/**
	 * Driver Class is responsible for invoking and closing the browsers also 
	 * 
	 * 
	 * responsible for setting the driver variable to driverManager which handles
	 * the thread safety for the webdriver instance
	 * 
	 * <pre> DriverManager has all the getter and setter mehods</pre>
	 * 
	 * March 19, 2024
	 * @author rashmisoundar
	 * @param browser value will be passed from base test value can be chrome or firefox
	 * @see DriverManager 
	 * @see com.rs.testcases.BaseTest
	 * 
	 * 
	 *
	 */ 

	public static void initDriver(String browser) {
		// Setup the WebDriver

		if (Objects.isNull(DriverManager.getDriver())) {

			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup(); 
				DriverManager.setDriver(new ChromeDriver());

			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				DriverManager.setDriver(new FirefoxDriver());
			}
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
		}

	}

	/**
	 * 
	 * quit driver is used to close the browser instance throughout the application
	 */
	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
