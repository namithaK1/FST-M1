package TestNGActivity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity10 {

	WebDriver driver;
	Actions act;

	@Test(priority = 0)
	public void middleValue() {

		WebElement slider = driver.findElement(By.id("slider"));

		act.click(slider).perform();
		// act.release().perform();

		String value = driver.findElement(By.id("value")).getText();
		Reporter.log("Slider is " + value);
		Assert.assertEquals(value, "50");

	}

	@Test(priority = 1)
	public void maximumValue() throws InterruptedException {

		WebElement slider = driver.findElement(By.id("slider"));

		act.clickAndHold(slider).moveByOffset(75, 0).build().perform();
		act.release().perform();
		Thread.sleep(2000);
		String value = driver.findElement(By.id("value")).getText();
		Reporter.log("Slider is " + value);
		Assert.assertEquals(value, "100");
	}

	@Test(priority = 2)
	public void minimumValue() throws InterruptedException {

		WebElement slider = driver.findElement(By.id("slider"));

		act.clickAndHold(slider).moveByOffset(-75, 0).build().perform();
		act.release().perform();
		Thread.sleep(2000);
		String value = driver.findElement(By.id("value")).getText();
		Reporter.log("Slider is " + value);
		Assert.assertEquals(value, "0");
	}

	@Test(priority = 3)
	public void thirtyPercentValue() throws InterruptedException {

		WebElement slider = driver.findElement(By.id("slider"));

		act.clickAndHold(slider).moveByOffset(-30, 0).build().perform();
		act.release().perform();
		Thread.sleep(2000);

		String value = driver.findElement(By.id("value")).getText();
		Reporter.log("Slider is " + value);
		Assert.assertEquals(value, "30");
	}

	@Test(priority = 4)
	public void eightyPercentValue() throws InterruptedException {

		WebElement slider = driver.findElement(By.id("slider"));

		act.clickAndHold(slider).moveByOffset(45, 0).build().perform();
		act.release().perform();
		Thread.sleep(2000);

		String value = driver.findElement(By.id("value")).getText();
		Reporter.log("Slider is " + value);
		Assert.assertEquals(value, "80");
	}

	@BeforeTest()
	public void before() {

		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/sliders");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Reporter.log("Opening browser");

		String title = driver.getTitle();
		Reporter.log("Title = " + title);

		act = new Actions(driver);
	}

	@AfterTest()
	public void after() {
		Reporter.log("Closing browser");
		driver.close();
	}

}
