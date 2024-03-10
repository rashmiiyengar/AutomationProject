package com.rs.pages;

import com.rs.driver.DriverManager;

public class AmazonLaptopPage {
	
	
	public String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
}
