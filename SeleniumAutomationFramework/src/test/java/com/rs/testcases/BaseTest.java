package com.rs.testcases;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.rs.driver.Driver;

public class BaseTest {

	protected BaseTest() {

	}

	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data) throws Exception {
		
		Map<String,String> map=(Map<String,String>)data[0];
		Driver.initDriver(map.get("browser"));
	
	}

	@AfterMethod
	protected void tearDown() {
		
		Driver.quitDriver();
	
	}
	
}
