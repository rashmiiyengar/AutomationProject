package com.rs.constants;

import com.rs.enums.ConfigProperties;
import com.rs.utils.PropertyUtils;


/**
 * Framework Constants holds all the constant values used within the framework.
 * If some value needs to be changed or modified often, then it should be stored in property files
 * 
 * 
 *
	Apr 15, 2024
	@author rashmisoundar
	{@summary}Framework Constants holds all the constant values used within the framework. 
	If some value needs to be changed or modified often, then it should be stored in property files.
	@see com.rs.utils.PropertyUtils
 */
public class FrameworkConstants {

	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private FrameworkConstants() {

	}

	private static final int EXPLICITWAIT = 10;

	private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
	
	private static final String CONFIGFILEPATH = System.getProperty("user.dir")
			+ "/src/test/resources/config/config.properties";

	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output";

	private static String EXCELPATH = RESOURCESPATH + "/excel/testdata.xlsx";

	private static final String RUNMANAGERSHEET = "RUNMANAGER";
	
	private static final String ITERATIONDATASHEET = "DATA";

	private static String extentReportFilePath = "";
	

	private static String createReportPath()  {
		if (PropertyUtils.get(ConfigProperties.OVERRIDERREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH + "/" + System.currentTimeMillis() + "index.html";
		}

		else {
			return EXTENTREPORTFOLDERPATH + "index.html";
		}
	}
	
	public static String getExtentReportFilePath()  {
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}
	
	public static int getExplicitwait() {

		return EXPLICITWAIT;
	}

	public static String getExcelPath() {
		return EXCELPATH;
	}

	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}

	public static String getJsonConfigfilepath() {
		return CONFIGFILEPATH;
	}

	protected static String getResourcespath() {
		return RESOURCESPATH;
	}

	public static String getRunmanagersheet() {
		return RUNMANAGERSHEET;
	}
	
	public static String getIterationdatasheet() {
		return ITERATIONDATASHEET;
	}

}