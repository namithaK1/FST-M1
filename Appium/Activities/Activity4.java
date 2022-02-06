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

public class Activity4 {

	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("appPackage", "com.android.contacts");
		cap.setCapability("appActivity", ".activities.PeopleActivity");
		cap.setCapability("noReset", true);

		URL server = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(server, cap);

		wait = new WebDriverWait(driver, 20);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(priority = 0)
	public void calculateSum() {

		driver.findElement(MobileBy.xpath("//android.widget.ImageButton[contains(@content-desc,'new contact')]"))
				.click();

		driver.findElementByXPath("//android.widget.EditText[@text='First name']").sendKeys("Aaditya");

		driver.findElementByXPath("//android.widget.EditText[@text='Last name']").sendKeys("Varma");

		driver.findElementByXPath("//android.widget.EditText[@text='Phone']").sendKeys("999148292");

		driver.findElement(MobileBy.id("editor_menu_save_button")).click();

//		String contactName = driver
//				.findElement(
//						MobileBy.xpath("//android.view.View[contains(@resource-id,'photo_touch_intercept_overlay')]"))
//				.getAttribute("accessibility id");

		Boolean contactCreated = driver
				.findElement(MobileBy.xpath("//android.view.View[@content-desc='Aaditya Varma']")).isDisplayed();

//		driver.findElement(MobileBy.AndroidUIAutomator(
//				"new UiSelector().className(\"com.android.contacts:id/photo_touch_intercept_overlay\")")).isDisplayed();

		String contactNumber = driver.findElement(MobileBy.id("header")).getText().replaceAll("[^0-9]", "");

		System.out.println(contactNumber);

		Assert.assertEquals(contactNumber, "999148292");
		Assert.assertTrue(contactCreated);

	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}
