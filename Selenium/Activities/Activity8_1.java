package SeleniumActivity;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8_1 {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/tables");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Title of the page = " + driver.getTitle());

		int noOfRows = driver.findElements(By.xpath("//table[@id='sortableTable']//tbody/tr")).size();
		int noOfColumns = driver.findElements(By.xpath("//table[@id='sortableTable']//thead//th")).size();

		System.out.println("Number of rows = " + noOfRows);
		System.out.println("Number of rows = " + noOfColumns);

		List<WebElement> thirdRow = driver.findElements(By.xpath("//table[@id='sortableTable']//tbody/tr[3]/td"));

		System.out.println("3rd row data");
		for (int i = 0; i < thirdRow.size(); i++)
			System.out.print(thirdRow.get(i).getText() + "\t");
		System.out.println();

		System.out.println("2nd row, 2nd coloumn data = "
				+ driver.findElement(By.xpath("//table[@id='sortableTable']//tbody/tr[2]/td[2]")).getText());

		driver.close();
	}

}
