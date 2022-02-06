package Activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity6 {

	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;

	@BeforeTest
	public void setUp() throws MalformedURLException {

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
	}

	@Test(priority = 0)
	public void chromeApp() throws InterruptedException {

		driver.get("https://www.training-support.net/selenium/lazy-loading");

		List<MobileElement> posts = driver
				.findElements(MobileBy.xpath("//android.view.View[contains(@text,'comments')]/.."));

		Reporter.log("Number of photos/posts = " + posts.size(), true);

		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"helen\"));"));

		Thread.sleep(5000);

		List<MobileElement> postsAfterScrolling = driver
				.findElements(MobileBy.xpath("//android.view.View[contains(@text,'comments')]/.."));

		Reporter.log("Number of photos/posts after scrolling to Helen = " + postsAfterScrolling.size(), true);

	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}
