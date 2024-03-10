package com.rs.testcases;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.rs.pages.AmazonHomePage;

public final class AmazonDemoTests extends BaseTest {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private AmazonDemoTests() {
		
	}
	
	
	/**
	 * Test Name mentioned here should match the column name "testname" in excel sheet.This is mandatory to run this
	 * test. Otherwise it will be ignored. <p>
	 * The match has to be there in both of the RUNMANAGER and TESTDATA sheet.
	 * Set the category which this particular test case belongs to
	 * @param data HashMap containing all the values of test data needed to run the tests
	 */
	@Test
	public void amazonTest(Map<String,String> data) throws Exception {
		String  title = new AmazonHomePage()
		            .clickHamburger().clickComputer()
		            .clickOnSubMenuItem(data.get("menutext"))
		            .getPageTitle();
		
		
		
		Assertions.assertThat(title).isNotNull().isNotBlank();
	}
}
