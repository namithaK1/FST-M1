package SeleniumActivity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/ajax");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Title of the page = " + driver.getTitle());

		driver.findElement(By.xpath("//button[contains(@class,'violet button')]")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h1[text()='HELLO!']"), "HELLO!"));
		System.out.println(driver.findElement(By.xpath("//h1[text()='HELLO!']")).getText());

		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h3[contains(text(),'late')]"),
				"I'm late!"));
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'late')]")).getText());

		driver.close();
	}

}
