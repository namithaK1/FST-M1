package Project;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1 {

	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;
	Properties pObj;

	@BeforeTest
	public void setUp() throws Exception {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("appPackage", "com.google.android.apps.tasks");
		cap.setCapability("appActivity", ".ui.TaskListsActivity");
		cap.setCapability("noReset", true);

		URL server = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(server, cap);

		wait = new WebDriverWait(driver, 20);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\002H57744\\Documents\\IBM FST\\Workspace\\Appium_Project\\src\\test\\java\\Project\\Activities.properties");
		pObj = new Properties();
		pObj.load(fis);
	}

	@Test(priority = 0)
	public void googleTask() {

		for (int i = 1; i <= 3; i++) {

			String data = pObj.getProperty("title" + i);
			Reporter.log(data, true);
			driver.findElement(MobileBy.id("tasks_fab")).click();
			driver.findElementById("add_task_title").sendKeys(data);
			driver.findElement(MobileBy.id("add_task_done")).click();
		}

		Boolean task1 = driver
				.findElement(MobileBy.xpath("//android.widget.TextView[@text='" + pObj.getProperty("title1") + "']"))
				.isDisplayed();

		Boolean task2 = driver
				.findElement(MobileBy.xpath("//android.widget.TextView[@text='" + pObj.getProperty("title2") + "']"))
				.isDisplayed();

		Boolean task3 = driver
				.findElement(MobileBy.xpath("//android.widget.TextView[@text='" + pObj.getProperty("title3") + "']"))
				.isDisplayed();

		Assert.assertTrue(task1);
		Assert.assertTrue(task2);
		Assert.assertTrue(task3);
	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}
