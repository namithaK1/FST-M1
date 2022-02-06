package Project;

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

public class Activity2 {

	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("appPackage", "com.google.android.keep");
		cap.setCapability("appActivity", ".activities.BrowseActivity");
		cap.setCapability("noReset", true);

		URL server = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(server, cap);

		wait = new WebDriverWait(driver, 20);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(priority = 0)
	public void googleNotes() {

		driver.findElement(MobileBy.id("new_note_button")).click();
		driver.findElementById("editable_title").sendKeys("Activity Title");
		driver.findElement(MobileBy.id("edit_note_text")).sendKeys("Activity Note Content");
		driver.findElement(MobileBy.xpath("//android.widget.ImageButton[contains(@content-desc,'navigation')]"))
				.click();

		String title = driver.findElement(MobileBy.id("index_note_title")).getText();
		String decsription = driver.findElement(MobileBy.id("index_note_text_description")).getText();

		Assert.assertEquals(title, "Activity Title");
		Assert.assertEquals(decsription, "Activity Note Content");

	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}
