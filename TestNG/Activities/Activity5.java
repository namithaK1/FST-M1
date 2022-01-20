package TestNGActivity;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {

	WebDriver driver;

	@Test(priority = 1, groups = { "HeaderTest", "ButtonTest" })
	public void getTitle() {

		String title = driver.getTitle();
		System.out.println("Title = " + title);
		Assert.assertEquals(title, "Target Practice");

	}

	@Test(priority = 2, groups = { "HeaderTest" })
	public void thirdHeaderTest() {

		String thirdHeader = driver.findElement(By.cssSelector("h3#third-header")).getText();
		Assert.assertEquals(thirdHeader, "Third header");
	}

	@Test(priority = 3, groups = { "HeaderTest" })
	public void fifthHeaderTest() {

		String fifthHeader = driver.findElement(By.cssSelector("h5.ui")).getCssValue("color");
		System.out.println(fifthHeader);
		Assert.assertEquals(fifthHeader, "rgb(33, 186, 69)");

	}

	@Test(priority = 4, groups = { "ButtonTest" })
	public void oliveButtonTest() {

		Assert.assertEquals(driver.findElement(By.cssSelector("button.olive")).getText(), "Olive");
	}

	@Test(priority = 5, groups = { "ButtonTest" })
	public void brownButtonTest() {

		System.out.println(driver.findElement(By.cssSelector("button.brown")).getCssValue("color"));
		Assert.assertEquals(driver.findElement(By.cssSelector("button.brown")).getCssValue("color"),
				"rgb(255, 255, 255)");
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {

		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {

		driver.close();
	}

}
