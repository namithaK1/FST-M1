package SeleniumActivity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/dynamic-controls");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("Title of the page = " + driver.getTitle());
		WebElement removeAddCheckbox = driver.findElement(By.xpath("//button[@id='toggleCheckbox']"));
		WebElement checkbox = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']"));

		removeAddCheckbox.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.invisibilityOf(checkbox));

		removeAddCheckbox.click();

		wait.until(ExpectedConditions.visibilityOf(checkbox));

		driver.close();

	}

}
