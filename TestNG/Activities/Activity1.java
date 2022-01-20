package TestNGActivity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {

	WebDriver driver;

	@BeforeMethod()
	public void beforeMethod() {

		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {

		driver.close();
	}

	@Test
	public void TrainingSupport() {

		String title = driver.getTitle();
		System.out.println("Title = " + title);

		Assert.assertEquals(title, "Training Support");

		driver.findElement(By.id("about-link")).click();

		String newTitle = driver.getTitle();
		System.out.println("New title = " + newTitle);

		Assert.assertEquals(newTitle, "About Training Support");

	}
}
