package com.aj.wipro.excelutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.aj.wipro.global.Constants;





public class ExcelUtil {
	private static HSSFSheet ExcelWSheet;

	private static HSSFWorkbook ExcelWBook;

	private static org.apache.poi.ss.usermodel.Cell Cell;

	private static HSSFRow Row;

	// Create a new Excel file
	public static void CreateExcelFile(String filePath, String fileName, String sheetName) throws IOException {
		File excelFile = new File(filePath + "\\" + fileName);
		// Assuming XLSX here. If XLS use HSSFWorkbook
		// Workbook excelWorkbook = new HSSFWorkbook();
		Workbook excelWorkbook = new HSSFWorkbook();

		// Create the sheet in the workbook
		Sheet sheet1 = excelWorkbook.createSheet(sheetName);
		for (int i = 0; i <= 2; i++) {
			// Create the row in the sheet
			Row row = sheet1.createRow(i);

			// Create cells in the row
			Cell cell = row.createCell(0);

			// Add cell value
			cell.setCellValue("Test123" + i);
		}

		// Now actually create the entire file
		FileOutputStream excelOutputStream = new FileOutputStream(excelFile);
		excelWorkbook.write(excelOutputStream);

		// Close our open objects
		excelOutputStream.close();
		excelWorkbook.close();

	}

	public static void log(String msg) {
		System.out.println(msg);
	}

	// Load Excel data from file
	public static void loadExcelData(String filePath, String fileName, String sheetName) throws IOException {
		File excelFile = new File(filePath + "\\" + fileName);
		FileInputStream excelInputStream = new FileInputStream(excelFile);
		Workbook excelWorkbook = null;

		// Assuming XLSX here. If XLS use HSSFWorkbook
		// excelWorkbook = new HSSFWorkbook(excelInputStream);
		excelWorkbook = new HSSFWorkbook(excelInputStream);

		// Read the sheet inside the excel workbook
		Sheet excelSheet = excelWorkbook.getSheet(sheetName);

		// Get the number of rows
		int rowCount = excelSheet.getLastRowNum();

		// Read all the rows
		for (int i = 0; i <= rowCount; i++) {
			Row excelRow = excelSheet.getRow(i);

			// Now we need to read all the cell (column) values in each row
			for (int j = 0; j < excelRow.getLastCellNum(); j++) {
				// Output value to the console for now
				log(excelRow.getCell(j).getStringCellValue());
				// excelData.add(excelRow.getCell(j).getStringCellValue());
			}

		}

		// Close the file stream
		excelWorkbook.close();
		excelInputStream.close();

	}

	// This method is to set the File path and to open the Excel file, Pass
	// Excel Path and Sheetname as Arguments to this method

	public static void setExcelFile(String Path, String SheetName) throws Exception {

		try {

			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new HSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			int lastRowNo = ExcelWSheet.getLastRowNum();
			System.out.println(lastRowNo);
		} catch (Exception e) {

			throw (e);

		}

	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num

	public static String getCellData(String Path, String SheetName, int RowNum, int ColNum) throws Exception {

		try {
			// Open the Excel file

			File excelFile = new File(Path);
			FileInputStream excelInputStream = new FileInputStream(excelFile);
			Workbook excelWorkbook = null;

			// Access the required test data sheet

			// Assuming XLSX here. If XLS use HSSFWorkbook
			// excelWorkbook = new HSSFWorkbook(excelInputStream);
			excelWorkbook = new HSSFWorkbook(excelInputStream);
			Sheet ExcelWSheet = excelWorkbook.getSheet(SheetName);

			// Get the required cell value

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();

			return CellData;

		} catch (Exception e) {

			return "";

		}

	}

	// This method is to write in the Excel cell, Row num and Col num are the
	// parameters

	public static void setCellData(String Path, String SheetName, String Result, int RowNum, int ColNum)
			throws Exception {

		try {
			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new HSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			// Get the RowNumber and ColumnNumber to set value
			Row = ExcelWSheet.getRow(RowNum);

			Cell = Row.getCell(ColNum);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);

			} else {

				Cell.setCellValue(Result);

			}

			FileOutputStream excelOutputStream = new FileOutputStream(Path);
			ExcelWBook.write(excelOutputStream);
			excelOutputStream.close();
			ExcelWBook.close();

		} catch (Exception e) {

			throw (e);

		}

	}

	/**
	 * @author Rashmi Rudrawadi
	 * 
	 */

	// Below method is to get userName and password from excel sheet

	public static Object[][] getCellLoginData(String Path, String SheetName, int i, int j) throws IOException {
		String[][] arrayExcelData = null;

		arrayExcelData = new String[2][2];
		FileInputStream ExcelFile = new FileInputStream(Path);

		// Access the required test data sheet

		ExcelWBook = new HSSFWorkbook(ExcelFile);

		ExcelWSheet = ExcelWBook.getSheet(SheetName);

		for (int k = 1; k <= 2; k++) {

			// Get the RowNumber and ColumnNumber to set value
			Row = ExcelWSheet.getRow(k);

			for (int l = 1; l <= 2; l++) {

				arrayExcelData[k - 1][l - 1] = Row.getCell(2).getStringCellValue().trim();
				arrayExcelData[k - 1][l - 1] = Row.getCell(l).getStringCellValue().trim();
			}

		}
		return arrayExcelData;
	}

	public String[][] getUserNamePassword(String sheetName) throws IOException {
		int lastRowNo;
		Sheet sheet;
		String[][] arrayExcelData = null;

		arrayExcelData = new String[6][2];

		// File src = new File(Constants.Excel_Data_Path);

		FileInputStream fis = new FileInputStream(Constants.Excel_Data_Path);

		Workbook wb = new HSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		// lastRowNo = sheet.getLastRowNum();
		for (int i = 0; i < 6; i++) {
			Row row = sheet.getRow(i);
			for (int j = 1; j <= 1; j++) {

				arrayExcelData[i][j - 1] = row.getCell(0).getStringCellValue().trim();
				arrayExcelData[i][j] = row.getCell(1).getStringCellValue().trim();
			}

		}

		return arrayExcelData;

	}

}
