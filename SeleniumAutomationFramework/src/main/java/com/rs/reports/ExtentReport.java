package com.rs.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.rs.constants.FrameworkConstants;
import com.rs.enums.CategoryType;


/**
 * Perform initialisation and termination of {@link com.aventstack.extentreports.ExtentReports}
 * After creating an instance for {@link com.aventstack.extentreports.ExtentTest}, it is delegated to ThreadLocal 
 * variable for providing thread safety.
	Apr 15, 2024
	@author rashmisoundar
	@see com.rs.ListenerClass
	@see com.rs.annotations.FrameworkAnnotation
 */
public final class ExtentReport {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentReport() {

	}

	private static ExtentReports extent;
	
	/**
	 * Set the iniitial configuration of extent report and decides the report generation path
	 * @author rashmisoundar
	 */
	@BeforeSuite
	public static void initReports()  {
		
		if(Objects.isNull(extent)) {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("RS Report");
		spark.config().setReportName("Automation project");
		}
		
	}

	/**
	 * Flushing the reports ensures that extent logs are reflected properly
	 * Opens the report in default desktop browser.
	 * Sets the ThreadLocal variable to default value.
	 * @author rashmisoundar
	 */
	public static void flushReports()  {
		if(Objects.nonNull(extent)) {
		extent.flush();}
		ExtentManager.unload();
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}

	/**
	 * Creates a testnode in extent report. Delegates to {@link ExtentManager} for providing thread safety
	 * @author rashmisoundar
	 * @param testcasename Testcasename that needs to be reflected in the report
	 */
	public static void createTest(String testcasename) {
		 ExtentTest test = extent.createTest(testcasename);
		 ExtentManager.setExtentTest(test);
	};
	
	
	/**
	 * Logs the authors details in the authors view in the extent report
	 * Gives the clear idea of Authors
	 * @author rashmisoundar
	 * @param authors Author who created the particular testcase
	 */
	public static void addAuthors(String[] authors) {
		
		for(String temp:authors) {
			ExtentManager.getExtentTest().assignAuthor(temp);
		}
		
	}
	
	/**
	 * Adds the category a particular test case belongs to.
	 * Gives an clear idea of Group
	 * @author rashmisoundar
	 * @param categories category a particular test case belongs to.
	 */
	public static void addCategories(CategoryType[] categoryTypes) {
		for(CategoryType temp:categoryTypes) {
			ExtentManager.getExtentTest().assignCategory(temp.toString());
		}
	}
}
