package TestNGActivity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {

	WebDriver driver;

	@Test(priority = 1)
	@Parameters({ "username", "password" })
	public void loginForm(String user, String pass) {

		String title = driver.getTitle();
		System.out.println("Title = " + title);
		Assert.assertEquals(title, "Login Form");

		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pass);

		driver.findElement(By.xpath("//button[contains(@onclick,'signIn')]")).click();

		Assert.assertEquals(driver.findElement(By.id("action-confirmation")).getText(), "Welcome Back, admin");
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

}
