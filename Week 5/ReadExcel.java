package utility;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readExcelData(String excelFileName) throws IOException {

         //public static void main(String[] args) throws IOException {
		// 1.Goto the folder and open the file - Path location

		XSSFWorkbook book = new XSSFWorkbook("./data/" + excelFileName + ".xlsx");
		// XSSFWorkbook book= new XSSFWorkbook("./data/TC004.xlsx");

		// 2.Select the sheet-sheet name/index

		// XSSFSheet sheet = book.getSheet("Sheet 1");
		XSSFSheet sheet = book.getSheetAt(0);

		// 3.You need to get row count
		int rowCount = sheet.getLastRowNum();
		System.out.println("The No of Rows in Excel are: " + rowCount);

		// 3.You need to get Column Size

		XSSFRow headerRow = sheet.getRow(0);
		short colCount = headerRow.getLastCellNum();
		System.out.println("The No of Columns in Excel are: " + colCount);
		// Declare String Array
		String[][] array = new String[rowCount][colCount];
		// iterate over row
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			System.out.println("The Data for the row " + i + " is");
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				if (cell.getCellType() == CellType.NUMERIC) {
					double intdata = cell.getNumericCellValue();
					int value = (int) intdata;
					String data = Integer.toString(value);
					array[i - 1][j] = data;
					System.out.println(data);
				} else {
					String data = cell.getStringCellValue();
					array[i - 1][j] = data;
					System.out.println(data);
				}
			}
		}
		return array;
	}
}