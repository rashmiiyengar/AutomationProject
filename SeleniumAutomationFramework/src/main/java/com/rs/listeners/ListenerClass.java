package com.rs.listeners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.rs.annotations.FrameworkAnnotation;
import com.rs.reports.ExtentLogger;
import com.rs.reports.ExtentReport;

/**
 * Implements {@link org.testng.ITestListener} and {@link org.testng.ISuiteListener} to leverage
 * the abstract methods Mostly used to help in extent report generation
 * 
 * <pre> Please make sure to add the listener details testng.xml file</pre>
 * 
	Apr 15, 2024
	@author rashmisoundar
 */

public class ListenerClass implements ITestListener, ISuiteListener {

	/**
	 * Initialise the reports with the file name
	 * @see com.rs.reports.ExtentReport
	 */
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
			ExtentReport.initReports();
	}

	/**
	 * Terminate the report
	 * @see com.rs.reports.ExtentReport
	 */
	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
			ExtentReport.flushReports();
	}

	/**
	 * Starts a test node for each testng test
	 * @see com.rs.reports.ExtentReport
	 * @see com.rs.annotations.FramworkAnnotations
	 */
	@Override
	public void onTestStart(ITestResult result) {

		ExtentReport.createTest(result.getMethod().getDescription());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).category());

	}
	
	/**
	 * Marks the test as pass and logs in it report
	 * @see com.rs.reports.FrameworkLogger
	 */
	@Override
	public void onTestSuccess(ITestResult result) {

		ExtentLogger.pass(result.getMethod().getMethodName() + " is passed successfully");
	}
	
	/**
	 * Marks the test as fail, append base64 screenshot and logs in the report
	 * @see com.rs.reports.FrameworkLogger
	 * @see com.rs.utils.ScreenshotUtils
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		// ExtentLogger.fail(result.getMethod().getMethodName() + "is failed ");
		// attach screenshot
		try {
			ExtentLogger.fail(result.getMethod().getMethodName() + "is failed", true);
			ExtentLogger.fail(result.getThrowable().toString());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Marks the test as skipped
	 * @see com.rs.reports.FrameworkLogger
	 */
	@Override
	public void onTestSkipped(ITestResult result) {

		ExtentLogger.skip(result.getMethod().getMethodName() + "is skipped ");
	}
}
