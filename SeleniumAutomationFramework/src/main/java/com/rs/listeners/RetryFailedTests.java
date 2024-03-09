package com.rs.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.rs.enums.ConfigProperties;
import com.rs.utils.PropertyUtils;

public class RetryFailedTests implements IRetryAnalyzer {

	private int count = 0;
	private int retries = 1;

	@Override
	public boolean retry(ITestResult result) {

		// if(count<retries) {
		// count++;
		// return true;
		// }
		boolean value=false;
		try {
			if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes"))
			{
				 value = count < retries;
				count++;

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

}
