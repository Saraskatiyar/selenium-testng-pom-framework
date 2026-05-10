package dataproviders;

import org.testng.annotations.DataProvider;

import utils.ExcelUtil;

import java.io.File;

public class ExcelDataProviders {

	@DataProvider(name = "loginData")
	public Object[][] getLoginData() {
		// Step 1: Build the full file path
		String path = System.getProperty("user.dir") + "\\TestData.xlsx";
		System.out.println("Reading Excel file from: " + path);

		// Step 2: Check if file exists
		File file = new File(path);
		if (!file.exists()) {
			System.out.println("File not found at: " + path);
			return null;
		}

		// Step 3: Read Excel sheet
		Object[][] data = ExcelUtil.getSheetData(path, "Login");

		// Step 4: Check if data is returned
		if (data == null) {
			System.out.println("Data is null! Check if sheet 'Login' exists and has data.");
		} else {
			System.out.println("Data read successfully. Rows: " + data.length);
		}

		return data;
	}
}
