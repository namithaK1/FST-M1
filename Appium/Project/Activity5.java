package Project;

import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity5 {

	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;

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

	}

	@BeforeClass
	public void navigateToSite() throws InterruptedException {
		driver.get("https://www.training-support.net/selenium");

		Thread.sleep(5000);

		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollForward(30).scrollIntoView(new UiSelector().textContains(\"Login Form\"));"));

		driver.findElement(MobileBy.xpath("//android.view.View[starts-with(@text,'Login Form')]")).click();

	}

	@Test(dataProvider = "getLoginFormData")
	public void googleChromeActivity(String username, String password, String expectedMessage)
			throws InterruptedException {

		MobileElement usernameField = driver
				.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id='username']"));
		usernameField.clear();
		usernameField.sendKeys(username);

		Thread.sleep(1000);

		MobileElement passwordField = driver
				.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id='password']"));
		passwordField.clear();
		passwordField.sendKeys(password);

		driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Log in']")).click();

		Thread.sleep(2000);

		String confirmMessage = driver
				.findElement(MobileBy.xpath("//android.view.View[@resource-id='action-confirmation']")).getText();

		Reporter.log("Actual confirmation message = " + confirmMessage, true);
		Reporter.log("Expected confirmation message = " + expectedMessage, true);

		Assert.assertEquals(confirmMessage, expectedMessage);

	}

	@DataProvider
	public Object[][] getLoginFormData() throws Exception {

		Object[][] data = { { "admin", "password", "Welcome Back, admin" },
				{ "admin", "wrongPassword", "Invalid Credentials" } };

		return data;

	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}
