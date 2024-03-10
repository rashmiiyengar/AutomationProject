package com.rs.pages;

import org.openqa.selenium.By;

import com.rs.enums.WaitStratergy;
import com.rs.utils.DynamicXpathUtils;

public class AmazonHamburgerMenuPage extends BasePage {

	private String linkSubMenu = "//a[text()='%s']";
	private String linkComputers= "//div[text()='Mobiles, Computers']/parent::a";
	
	public AmazonHamburgerMenuPage clickComputer() throws Exception {
		click(By.xpath(linkComputers),WaitStratergy.CLICKABLE,"Mobiles, Computers");
		return this;
	}
	
	
	public AmazonLaptopPage clickOnSubMenuItem(String menutext) throws Exception {
		String newxpath = DynamicXpathUtils.getDynamicXpath(linkSubMenu, menutext);
		click(By.xpath(newxpath), WaitStratergy.CLICKABLE, menutext);
		if(menutext.contains("Tablets")) {
			return new AmazonLaptopPage();
		}
		return null;
	}
	
}
