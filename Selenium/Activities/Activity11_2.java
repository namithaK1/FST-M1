package SeleniumActivity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11_2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Title of the page = " + driver.getTitle());

		WebDriverWait wait = new WebDriverWait(driver, 20);

		driver.findElement(By.id("confirm")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		Thread.sleep(1000);
		alt.accept();

		driver.findElement(By.id("confirm")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alt1 = driver.switchTo().alert();
		Thread.sleep(1000);
		alt1.dismiss();
		Thread.sleep(1000);

		driver.close();
	}

}
