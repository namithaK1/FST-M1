package SeleniumActivity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11_1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Title of the page = " + driver.getTitle());

		WebDriverWait wait = new WebDriverWait(driver, 20);

		driver.findElement(By.id("simple")).click();

		wait.until(ExpectedConditions.alertIsPresent());

		Alert alt = driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println(alt.getText());

		// alt.dismiss();
		alt.accept();

		Thread.sleep(2000);

		driver.close();

	}

}
