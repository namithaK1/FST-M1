package Activities;

import java.net.MalformedURLException;
import java.net.URL;
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

public class Activity5 {

	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("appPackage", "com.google.android.apps.messaging");
		cap.setCapability("appActivity", ".ui.ConversationListActivity");
		cap.setCapability("noReset", true);

		URL server = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(server, cap);

		wait = new WebDriverWait(driver, 20);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(priority = 0)
	public void messageApp() throws InterruptedException {

		driver.findElement(MobileBy.xpath("//android.widget.ImageView[contains(@resource-id,'new_conversation')]"))
				.click();

		driver.findElementById("recipient_text_view").sendKeys("8156734546");

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("contact_picker_create_group")));

		driver.findElementById("contact_picker_create_group").click();

		driver.findElement(MobileBy.id("action_confirm_participants")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("compose_message_text")));

		driver.findElementById("compose_message_text").sendKeys("Hello from Appium");

		driver.findElement(MobileBy.id("send_message_button_icon")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("message_status")));

		String actualMessageStatus = driver.findElement(MobileBy.id("message_status")).getText();

		String actualSentMessage = driver.findElement(MobileBy.id("message_text")).getText();

		Reporter.log(actualSentMessage, true);
		Reporter.log(actualMessageStatus, true);

		Assert.assertEquals(actualSentMessage, "Hello from Appium");
		Assert.assertEquals(actualMessageStatus, "Now • SMS");

	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}
