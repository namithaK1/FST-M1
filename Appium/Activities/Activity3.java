package Activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity3 {

	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", ".Calculator");
		cap.setCapability("noReset", true);

		URL server = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(server, cap);

		wait = new WebDriverWait(driver, 20);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(priority = 0)
	public void calculateSum() {

		driver.findElement(MobileBy.id("com.android.calculator2:id/digit_5")).click();

		// driver.findElementByAccessibilityId("plus").click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"+\")")).click();

		driver.findElement(MobileBy.xpath("//android.widget.Button[contains(@resource-id,'digit_9')]")).click();
		driver.findElement(MobileBy.AccessibilityId("equals")).click();
		String result = driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'result')]")
				.getText();
		Assert.assertEquals(result, "14");

	}

	@Test(priority = 1)
	public void calculateSubtract() {

		driver.findElement(MobileBy.id("digit_1")).click();
		driver.findElement(MobileBy.id("digit_0")).click();

		driver.findElement(MobileBy.id("op_sub")).click();

		driver.findElement(MobileBy.id("digit_5")).click();

		driver.findElement(MobileBy.AccessibilityId("equals")).click();

		String result = driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'result')]")
				.getText();
		Assert.assertEquals(result, "5");

	}

	@Test(priority = 2)
	public void calculateMul() {

		driver.findElement(MobileBy.id("digit_5")).click();

		driver.findElement(MobileBy.id("op_mul")).click();

		driver.findElement(MobileBy.id("digit_1")).click();
		driver.findElement(MobileBy.id("digit_0")).click();
		driver.findElement(MobileBy.id("digit_0")).click();

		driver.findElement(MobileBy.AccessibilityId("equals")).click();

		String result = driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'result')]")
				.getText();
		Assert.assertEquals(result, "500");

	}

	@Test(priority = 3)
	public void calculateDiv() {

		driver.findElement(MobileBy.id("digit_5")).click();
		driver.findElement(MobileBy.id("digit_0")).click();

		driver.findElement(MobileBy.id("op_div")).click();

		driver.findElement(MobileBy.id("digit_2")).click();

		driver.findElement(MobileBy.AccessibilityId("equals")).click();

		String result = driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'result')]")
				.getText();
		Assert.assertEquals(result, "25");

	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}
