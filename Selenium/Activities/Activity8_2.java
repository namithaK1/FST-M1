package SeleniumActivity;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8_2 {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/tables");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Title of the page = " + driver.getTitle());

		int noOfRows = driver.findElements(By.xpath("//table[@id='sortableTable']//tbody/tr")).size();
		int noOfColumns = driver.findElements(By.xpath("//table[@id='sortableTable']//thead//th")).size();

		System.out.println("Number of rows = " + noOfRows);
		System.out.println("Number of rows = " + noOfColumns);

		System.out.println("2nd row, 2nd coloumn data = "
				+ driver.findElement(By.xpath("//table[@id='sortableTable']//tbody/tr[2]/td[2]")).getText());

		driver.findElement(By.xpath("//table[@id='sortableTable']//thead//th")).click();

		System.out.println("2nd row, 2nd coloumn data after sorting = "
				+ driver.findElement(By.xpath("//table[@id='sortableTable']//tbody/tr[2]/td[2]")).getText());

		System.out.println("Table footer valuee");

		List<WebElement> footer = driver.findElements(By.xpath("//table[@id='sortableTable']//tfoot//th"));

		for (WebElement ele : footer)
			System.out.print(ele.getText() + "\t");

		driver.close();

	}

}
