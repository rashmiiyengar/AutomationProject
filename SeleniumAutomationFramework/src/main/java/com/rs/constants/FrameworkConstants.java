package com.rs.constants;

import com.rs.enums.ConfigProperties;
import com.rs.utils.PropertyUtils;

public class FrameworkConstants {

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
	

	private static String createReportPath() throws Exception {
		if (PropertyUtils.get(ConfigProperties.OVERRIDERREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH + "/" + System.currentTimeMillis() + "index.html";
		}

		else {
			return EXTENTREPORTFOLDERPATH + "index.html";
		}
	}
	
	public static String getExtentReportFilePath() throws Exception {
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