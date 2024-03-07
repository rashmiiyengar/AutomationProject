package com.rs.constants;

import com.rs.enums.ConfigProperties;
import com.rs.utils.PropertyUtils;

public class FrameworkConstants {

	private FrameworkConstants() {

	}

	private static final int EXPLICITWAIT = 10;

	public static int getExplicitwait() {

		return EXPLICITWAIT;
	}

	private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
	private static final String CONFIGFILEPATH = System.getProperty("user.dir")
			+ "/src/test/resources/config/config.properties";

	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output";

	private static String EXCELPATH = RESOURCESPATH + "/excel/testdata.xlsx";


	private static String extentReportFilePath = "";

	public static String getExtentReportFilePath() throws Exception {
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}

	private static String createReportPath() throws Exception {
		if (PropertyUtils.get(ConfigProperties.OVERRIDERREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH + "/" + System.currentTimeMillis() + "index.html";
		}

		else {
			return EXTENTREPORTFOLDERPATH + "index.html";
		}
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

}