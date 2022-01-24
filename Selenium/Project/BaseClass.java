package SeleniumTestNGProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	@Parameters("url")
	public void launchAndNavigateToAlchemyJobs(String url) {

		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Reporter.log("Navigated to https://alchemy.hguy.co/jobs/", true);
		wait = new WebDriverWait(driver, 20);

	}

	@AfterClass
	public void closeBrowser() {

		driver.close();
		Reporter.log("Browser Closed", true);

	}

}
