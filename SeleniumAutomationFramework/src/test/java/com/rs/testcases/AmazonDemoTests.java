package com.rs.testcases;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.rs.annotations.FrameworkAnnotation;
import com.rs.enums.CategoryType;
import com.rs.pages.AmazonHomePage;

public final class AmazonDemoTests extends BaseTest {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private AmazonDemoTests() {

	}

	@FrameworkAnnotation(author = { "Rashmi", "Iyengar" }, category = { CategoryType.REGRESSION,CategoryType.SMOKE })
	@Test
	public void amazonTest(Map<String, String> data) throws Exception {

		String title = new AmazonHomePage().clickHamburger().clickComputer().clickOnSubMenuItem(data.get("menutext"))
				.getPageTitle();

		Assertions.assertThat(title).isNotNull().isNotBlank();
	}
}
