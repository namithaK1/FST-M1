package TestNGActivity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity9 {

	WebDriver driver;

	@Test(priority = 0)
	public void simpleAlertTestCase() {

		driver.findElement(By.cssSelector("button#simple")).click();

		Alert alt = driver.switchTo().alert();

		String alertText = alt.getText();
		Reporter.log(alertText);

		Assert.assertEquals(alertText, "This is a JavaScript Alert!");

		alt.accept();
	}

	@Test(priority = 1)
	public void confirmAlertTestCase() {

		driver.findElement(By.cssSelector("button#confirm")).click();

		Alert alt = driver.switchTo().alert();

		String alertText = alt.getText();
		Reporter.log(alertText);

		Assert.assertEquals(alertText, "This is a JavaScript Confirmation!");

		alt.dismiss();
	}

	@Test(priority = 2)
	public void promptAlertTestCase() {

		driver.findElement(By.cssSelector("button#prompt")).click();

		Alert alt = driver.switchTo().alert();

		alt.sendKeys("Hello this is prompt content");

		String alertText = alt.getText();
		Reporter.log(alertText);

		Assert.assertEquals(alertText, "This is a JavaScript Prompt!");

		alt.accept();
	}

	@BeforeTest()
	public void before() {

		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Reporter.log("Opening browser");

		String title = driver.getTitle();
		Reporter.log("Title = " + title);

		Assert.assertEquals(title, "Javascript Alerts");

	}

	@AfterTest()
	public void after() {
		Reporter.log("Closing browser");
		driver.close();
	}

	@BeforeMethod
	public void beforeEachMethodSwitchAlert() {

		Reporter.log("Switching to default");
		driver.switchTo().defaultContent();
	}

}
