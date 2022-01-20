package SeleniumActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Activity13_2a {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Random random = new Random();
		String sheet = "Employee" + random.nextInt(100);

		System.out.println("Sheet is " + sheet);
		System.out.println("___________________________________________________________");

		writeExcel(
				"C:\\Users\\002H57744\\Documents\\IBM FST\\Workspace\\Selenium Activity\\src\\SeleniumActivity\\Activity13_2.xlsx",
				sheet);

		readExcel(
				"C:\\Users\\002H57744\\Documents\\IBM FST\\Workspace\\Selenium Activity\\src\\SeleniumActivity\\Activity13_2.xlsx",
				sheet);

	}

	public static void readExcel(String filePath, String sheetName) throws IOException {

		FileInputStream fis = new FileInputStream(filePath);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		Iterator<Row> rowIt = sheet.iterator();

		while (rowIt.hasNext()) {

			Row row = rowIt.next();

			Iterator<Cell> cellIt = row.cellIterator();

			while (cellIt.hasNext()) {

				Cell cell = cellIt.next();
				switch (cell.getCellType()) {
				case NUMERIC:
					System.out.print(cell.getNumericCellValue() + "\t");
					break;

				case STRING:
					System.out.print(cell.getStringCellValue() + "\t");
					break;

				default:
					System.out.print("Invalid data" + "\t");
					break;
				}

			}
			System.out.println();
		}

//		Workbook wb = WorkbookFactory.create(fis);
//
//		Sheet sheet = wb.getSheet(sheetName);
//
//		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
//			Row row = sheet.getRow(i);
//
//			for (int j = 0; j < row.getLastCellNum(); j++) {
//
//				System.out.print(row.getCell(j).getStringCellValue() + "\t");
//			}
//			System.out.println();
//		}

	}

	public static void writeExcel(String filePath, String sheetName) throws EncryptedDocumentException, IOException {

		List<String[]> data = new ArrayList<String[]>();
		String[] heading = { "ID", "First Name", "Last Name", "Email", "Ph.No." };
		String[] row1 = { "1", "Satvik", "Shah", "satshah@example.com", "4537829158" };
		String[] row2 = { "2", "Avinash", "Kati", "avinashK@example.com", "4892184058" };
		String[] row3 = { "3", "Lahri", "Rath", "lahri.rath@example.com", "4528727830" };

		data.add(heading);
		data.add(row1);
		data.add(row2);
		data.add(row3);

		FileInputStream fis = new FileInputStream(filePath);

//		Workbook workbook = WorkbookFactory.create(fis);
//		Sheet sh = wb.createSheet(sheetName);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sh = workbook.createSheet(sheetName);

		for (int i = 0; i < data.size(); i++) {

			XSSFRow rw = sh.createRow(i);

			for (int j = 0; j < data.get(i).length; j++) {

				XSSFCell cel = rw.createCell(j);

				cel.setCellValue(data.get(i)[j]);

			}
		}
		FileOutputStream fos = new FileOutputStream(filePath);
		workbook.write(fos);
		workbook.close();

	}
}
