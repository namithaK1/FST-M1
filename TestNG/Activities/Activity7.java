package TestNGActivity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {

	WebDriver driver;

	@Test(dataProvider = "Authentication")
	public void loginForm(String user, String pass) {

		String title = driver.getTitle();
		System.out.println("Title = " + title);
		Assert.assertEquals(title, "Login Form");
		WebElement userName = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));

		userName.clear();
		userName.sendKeys(user);
		password.clear();
		password.sendKeys(pass);

		driver.findElement(By.xpath("//button[contains(@onclick,'signIn')]")).click();
		Assert.assertEquals(driver.findElement(By.id("action-confirmation")).getText(), "Welcome Back, admin",
				"Confirmation message is not the excpected one");
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {

		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/login-form");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {

		driver.close();
	}

	@DataProvider(name = "Authentication")
	public Object[][] getData() {

		Object[][] data = { { "admin", "password" }, { "user", "password" }, { "admin", "pass" } };
		return data;

	}

}
