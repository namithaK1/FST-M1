package TestNGActivity;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class Activity2 {

	WebDriver driver;

	@Test(priority = 1)
	public void getTitle() {

		String title = driver.getTitle();
		System.out.println("Title = " + title);
		Assert.assertEquals(title, "Target Practice");
	}

	@Test(priority = 2)
	public void findTheElement() {

		String color = driver.findElement(By.xpath("//button[contains(@class,'black')]-link")).getText();
		Assert.assertTrue(color.equals("green"));

	}

	@Test(priority = 3, enabled = false)
	public void skipThisMethod() {

		System.out.println("This method is not skipped");
	}

	@Test(priority = 4)
	public void fskipWithException() {

		throw new SkipException("Skipping this method using exception");
	}

	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@AfterClass
	public void afterClass() {

		driver.close();
	}

}
