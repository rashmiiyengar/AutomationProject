package com.rs.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {

	private int count = 0;
	private int retries = 1;

	@Override
	public boolean retry(ITestResult result) {

		// if(count<retries) {
		// count++;
		// return true;
		// }

		boolean value = count < retries;
		count++;
		return value;
	}

}
