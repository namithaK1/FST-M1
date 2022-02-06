package Project;

import java.io.FileInputStream;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

public class Activity4 {

	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;
	Properties pObj;

	@BeforeTest
	public void setUp() throws Exception {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("appPackage", "com.android.chrome");
		cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
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
	public void googleChromeActivity() throws InterruptedException {

		driver.get("https://www.training-support.net/selenium");

		Thread.sleep(5000);

		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollForward(40).scrollForward(40).scrollForward(40).scrollIntoView(new UiSelector().textContains(\"To-Do List\"));"));

		driver.findElement(MobileBy.xpath("//android.view.View[starts-with(@text,'To-Do')]")).click();

		for (int i = 1; i <= 3; i++) {

			String data = pObj.getProperty("activity4_" + i);
			System.out.println(data);
			Thread.sleep(2000);
			driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id='taskInput']")).sendKeys(data);
			Thread.sleep(2000);
			driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Add Task']")).click();

		}

		Thread.sleep(2000);
		List<MobileElement> elements = driver.findElements(
				MobileBy.xpath("//android.view.View[@resource-id='tasksList']//android.view.View[@text='']"));

		Reporter.log("Number of elements = " + (elements.size() - 1), true);

		Thread.sleep(2000);
		for (int i = 2; i <= 4; i++) {

			MobileElement ele = driver.findElement(MobileBy
					.xpath("//android.view.View[@resource-id='tasksList']//android.view.View[@text=''][" + i + "]"));

			Assert.assertTrue(ele.isDisplayed());

			Thread.sleep(2000);
			ele.click();

		}
		Thread.sleep(2000);

		driver.findElement(
				MobileBy.xpath("//android.view.View[@resource-id='tasksList']/following-sibling::android.view.View"))
				.click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(
				MobileBy.xpath("//android.view.View[@resource-id='tasksList']//android.view.View[@text='']")));

	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}
