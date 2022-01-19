package SeleniumActivity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity7_1 {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/dynamic-attributes");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Title of the page = " + driver.getTitle());

		driver.findElement(By.xpath("//input[starts-with(@class,'username')]")).sendKeys("admin");

		driver.findElement(By.xpath("//input[starts-with(@class,'password')]")).sendKeys("password");

		By welcomePath = By.xpath("//div[@id='action-confirmation' and not(contains(@class,'disabled'))]");

		driver.findElement(By.xpath("//button[contains(@onclick,'signIn')]")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElementLocated(welcomePath, "Welcome Back, admin"));

		System.out.println("Successfull message = " + driver.findElement(welcomePath).getText());

		driver.close();
	}
}
