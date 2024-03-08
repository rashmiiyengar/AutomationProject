package com.rs.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.rs.constants.FrameworkConstants;

public final class DataProviderUtils {

	private static List<Map<String, String>> list = new ArrayList<>();

	@DataProvider(name = "LoginTestdataProvider", parallel = true)
	public static Object[] getData(Method m) throws FileNotFoundException, IOException {

		String testcasename = m.getName();

		if (list.isEmpty()) {
			list=ExcelUtils.getTestDetails(FrameworkConstants.getIterationdatasheet());
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
