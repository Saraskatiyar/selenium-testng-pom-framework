package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static Object[][] getSheetData(String excelPath, String sheetName) {

		Object[][] data = null;

		try {
			// Load excel
			FileInputStream file = new FileInputStream(excelPath);

			// create workbook from file
			Workbook workbook = new XSSFWorkbook(file);

			// Get the sheet by name (like "login")
			Sheet sheet = workbook.getSheet(sheetName);

			// Find no of rows and columns
			int totalRows = sheet.getPhysicalNumberOfRows();
			int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();

			// Create 2D array to store data
			data = new Object[totalRows - 1][totalCols];

			// Read each cell
			for (int i = 1; i < totalRows; i++) { // start from 1 to skip header row
				Row row = sheet.getRow(i);
				for (int j = 0; j < totalCols; j++) {
					Cell cell = row.getCell(j);
					data[i - 1][j] = (cell != null) ? cell.toString() : "";
				}
			}
			// close workbook and file
			workbook.close();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

}
