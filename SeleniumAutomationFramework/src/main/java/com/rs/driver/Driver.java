package com.rs.driver;
import java.util.Objects;
import org.openqa.selenium.chrome.ChromeDriver;

import com.rs.enums.ConfigProperties;
import com.rs.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;


public final class Driver {

	private Driver() {

	}

	//private static WebDriver driver;

	public static void initDriver() throws Exception {
		// Setup the WebDriver

		if (Objects.isNull(DriverManager.getDriver())) {
			WebDriverManager.chromedriver().setup();
			
			DriverManager.setDriver(new ChromeDriver());
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
		}

	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}

	}
}
