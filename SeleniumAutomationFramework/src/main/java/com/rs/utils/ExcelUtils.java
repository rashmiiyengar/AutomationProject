package com.rs.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.rs.constants.FrameworkConstants;

public class ExcelUtils {

	private ExcelUtils() {

	}

	static List<Map<String, String>> list;

	public static List<Map<String, String>> getTestDetails(String sheetname) throws IOException, FileNotFoundException {

		FileInputStream fs = null;
		try {
			fs = new FileInputStream(FrameworkConstants.getExcelPath());
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			//String sheetname = "RUNMANAGER";
			XSSFSheet sheet = workbook.getSheet(sheetname);

			int lastrownum = sheet.getLastRowNum();
			int lastcolnum = sheet.getRow(0).getLastCellNum();

			Map<String, String> map = null;
			list = new ArrayList<>();

			for (int i = 1; i <=lastrownum; i++) {
				map = new HashMap<>(); //

				for (int j = 0; j < lastcolnum; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();

					map.put(key, value);
				}
				list.add(map);
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (Objects.nonNull(fs)) {
					fs.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return list;

	}
}
