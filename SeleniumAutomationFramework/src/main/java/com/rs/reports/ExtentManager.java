package com.rs.reports;

import com.aventstack.extentreports.ExtentTest;

/**
 * ExtentManager class helps us to achieve thread safety for the {@link com.aventstack.extentreports.ExtentTest} instance.
 * @author rashmisoundar
 * 
	Apr 15, 2024
 */
public class ExtentManager {

	/**
	 * Private constructor to avoid external instantiation.
	 */
	private ExtentManager() {

	}

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	/**
	 * Returns the thread safe {@link com.aventstack.extentreports.ExtentTest} instance fetched from ThreadLocal variable.
	 *@author rashmisoundar
	 * @return Thread safe {@link com.aventstack.extentreports.ExtentTest} instance.
	 */
	public static ExtentTest getExtentTest() // desfault access modifier it can only be accessed within the package
	{
		return extentTest.get();
	}

	/**
	 * Set the {@link com.aventstack.extentreports.ExtentTest} instance to thread local variable.
	 * @author rashmisoundar
	 * @param test {@link com.aventstack.extentreports.ExtentTest} instance that needs to saved from Thread safety issues.<p>
	 * 
	 */
	static void setExtentTest(ExtentTest test) {
		extentTest.set(test);
	}

	/**
	 *Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
	 *It is much safer than assigning null value to ThreadLocal variable.
	 */
	static void unload() {
		extentTest.remove();
	}

}
