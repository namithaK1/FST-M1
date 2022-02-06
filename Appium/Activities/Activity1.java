package Activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1 {

	@Test
	public void setUp() throws MalformedURLException {

		AppiumDriver<MobileElement> driver;

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", ".Calculator");
		cap.setCapability("noReset", true);

		URL server = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(server, cap);

		driver.findElementById("digit_5").click();

		driver.findElementByAccessibilityId("multiply").click();

		driver.findElementByXPath("//android.widget.Button[@text='9']").click();

		driver.findElementById("eq").click();

		String result = driver.findElement(MobileBy.id("result")).getText();
		Reporter.log(result, true);

		Assert.assertEquals(result, "45");

		driver.quit();
	}

}
