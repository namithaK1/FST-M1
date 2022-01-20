package TestNGActivity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {

	WebDriver driver;

	@Test()
	public void getTitle() {

		String title = driver.getTitle();
		System.out.println("Title = " + title);
		Assert.assertEquals(title, "Login Form");

		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");

		driver.findElement(By.xpath("//button[contains(@onclick, 'signIn')]")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("action-confirmation")),
				"Welcome Back, admin"));

		Assert.assertEquals(driver.findElement(By.id("action-confirmation")).getText(), "Welcome Back, admin");
	}

	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/login-form");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@AfterClass
	public void afterClass() {

		driver.close();
	}

}
