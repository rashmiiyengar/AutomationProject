package com.rs.constants;

public class FrameworkConstants {

	private FrameworkConstants() {

	}

	private static final int EXPLICITWAIT = 10;

	public static int getExplicitwait() {

		return EXPLICITWAIT;
	}

	private static final String CONFIGFILEPATH = System.getProperty("user.dir")
			+ "/src/test/resources/config/config.properties";
	private static final String EXTENTREPORTPATH = System.getProperty("user.dir") + "/extent-test-output/index.html";

	protected static String getExtentreportpath() {
		return EXTENTREPORTPATH;
	}

	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}

	public static String getJsonConfigfilepath() {
		return CONFIGFILEPATH;
	}

}