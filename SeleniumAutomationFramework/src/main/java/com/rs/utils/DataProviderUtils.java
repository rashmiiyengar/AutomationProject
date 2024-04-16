package com.rs.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.rs.constants.FrameworkConstants;


/**
 * Holds the data provider for all the testcases in the framework.
 * @author rashmisoundar
	Apr 15, 2024
 */
public final class DataProviderUtils {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private DataProviderUtils() {}

	private static List<Map<String, String>> list = new ArrayList<>();

	
	/**
	 * Acts as a dataprovider for all testcases
	 * 
	 * @param m {@link java.lang.reflect.Method} holds the information about the testcases at runtime
	 * @returnObject[] containing the List. Each index of the list contains HashMap and each of them 
	 * contains the test data needed to run the iterations.
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @see com.rs.testcases
	 * @see com.rs.listener.AnnotationTransformer
	 */
	@DataProvider(name = "LoginTestdataProvider")
	public static Object[] getData(Method m) throws FileNotFoundException, IOException {

		String testcasename = m.getName();

		if (list.isEmpty()) {
			list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationdatasheet());
		}

		List<Map<String, String>> smallList = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).get("testname").equalsIgnoreCase(testcasename)
					&& (list.get(i).get("execute").equalsIgnoreCase("yes"))) {
				smallList.add(list.get(i));
			}

		}

		return smallList.toArray();

	}
}
