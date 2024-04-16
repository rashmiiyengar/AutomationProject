package com.rs.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.rs.constants.FrameworkConstants;
import com.rs.exceptions.FramworkException;
import com.rs.exceptions.InvalidPathExcelException;

public class ExcelUtils {

	private ExcelUtils() {

	}

	static List<Map<String, String>> list;

	public static List<Map<String, String>> getTestDetails(String sheetname) {

		
		
		try (FileInputStream fs = new FileInputStream(FrameworkConstants.getExcelPath())) {

			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			// String sheetname = "RUNMANAGER";
			XSSFSheet sheet = workbook.getSheet(sheetname);

			int lastrownum = sheet.getLastRowNum();
			int lastcolnum = sheet.getRow(0).getLastCellNum();

			Map<String, String> map = null;
			list = new ArrayList<>();

			for (int i = 1; i <= lastrownum; i++) {
				map = new HashMap<>(); //

				for (int j = 0; j < lastcolnum; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}

		}  catch(FileNotFoundException e) {
			throw new InvalidPathExcelException("Excel file is not found");
		}
		catch(IOException e) {
			throw new FramworkException("Some IO Exception happened while reading excel file");
		}
		
		return list;

	}
}
