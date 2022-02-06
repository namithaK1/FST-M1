package Activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2 {

	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("appPackage", "com.android.chrome");
		cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		cap.setCapability("noReset", true);

		URL server = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(server, cap);
		wait = new WebDriverWait(driver, 20);
	}

	@Test
	public void browserActivity() {

		driver.get("https://www.training-support.net/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String pageHeader = driver.findElement(MobileBy.xpath("//android.view.View[@text='Training Support']"))
				.getText();

		Reporter.log("Header text = " + pageHeader, true);

		Assert.assertEquals(pageHeader, "Training Support");

		driver.findElement(MobileBy.xpath("//android.view.View[@resource-id='about-link']")).click();

		wait.until(
				ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@text='About Us']")));

		String pageTwoHeader = driver.findElementByXPath("//android.view.View[@text='About Us']").getText();

		Reporter.log("2nd page header text =" + pageTwoHeader, true);

		Assert.assertEquals(pageTwoHeader, "About Us");

	}

	@AfterClass
	public void tearDown() {

		driver.quit();
	}
}
