package com.webui.baseURL;

import java.io.FileInputStream;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class webuiCoreFunctions {
	public HashMap<String, String> Test_formData() {
		HashMap<String, String> userTest_Data = new HashMap<>();

		try {
			FileInputStream fis = new FileInputStream("src/test/resources/Test-Data-Files/TestData.xlsx");

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			// Access the sheet named "RegistrationForm"
			XSSFSheet sheet = workbook.getSheet("Form-Data");

			if (sheet != null) {
				for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
					Cell Key = sheet.getRow(rowIndex).getCell(0);
					Cell Value = sheet.getRow(rowIndex).getCell(1);
					if (Key.getStringCellValue() != null && Value.getStringCellValue() != null) {
						userTest_Data.put(Key.getStringCellValue().toString(), Value.getStringCellValue().toString());
					} else {
						break;
					}
				}
			}

			// Close the workbook to free resources
			workbook.close();

		} catch (Exception e) {
			System.err.checkError();
		}
		return userTest_Data;
	}
}
