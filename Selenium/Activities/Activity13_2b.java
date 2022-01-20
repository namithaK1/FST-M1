package SeleniumActivity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity13_2b {

	public static void main(String[] args) throws IOException, InterruptedException {

		List<List<String>> data = readExcel(
				"C:\\Users\\002H57744\\Documents\\IBM FST\\Workspace\\Selenium Activity\\src\\SeleniumActivity\\Activity13_2.xlsx",
				"Employee");

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/selenium/simple-form");

		for (int i = 1; i < data.size(); i++) {

			List<String> rowData = data.get(i);

			driver.findElement(By.id("firstName")).sendKeys(rowData.get(1));
			driver.findElement(By.id("lastName")).sendKeys(rowData.get(2));

			driver.findElement(By.id("email")).sendKeys(rowData.get(3));

			driver.findElement(By.id("number")).sendKeys(rowData.get(4));

			Thread.sleep(1000);

			driver.findElement(By.cssSelector("input.green")).click();

			Thread.sleep(1000);
			Alert alt = driver.switchTo().alert();

			System.out.println(alt.getText());

			alt.accept();
			Thread.sleep(3000);

		}

		System.out.println("Browser closed");
		driver.close();

	}

	public static List<List<String>> readExcel(String filePath, String sheet) throws IOException {

		List<List<String>> data = new ArrayList<>();
		FileInputStream fis = new FileInputStream(filePath);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(sheet);

		Iterator<Row> rwIt = sh.iterator();

		while (rwIt.hasNext()) {

			Row rw = rwIt.next();

			Iterator<Cell> cellIt = rw.cellIterator();
			List<String> rowData = new ArrayList();
			while (cellIt.hasNext()) {

				Cell cell = cellIt.next();
				rowData.add(cell.getStringCellValue());

//				switch (cell.getCellType()) {
//				case NUMERIC:
//					rowData.add(cell.getNumericCellValue());
//					break;
//				case STRING:
//					rowData.add(cell.getStringCellValue());
//					break;
//				default:
//					rowData.add(" ");
//					break;
//				}
			}
			data.add(rowData);
			fis.close();
			wb.close();
		}
		return data;
	}

}
