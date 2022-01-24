package SeleniumTestNGProject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity8 extends BaseClass {

	@Test
	@Parameters({ "user", "password" })
	public void login(String username, String password) {

		driver.findElement(By.id("user_login")).sendKeys(username);
		driver.findElement(By.id("user_pass")).sendKeys(password);
		driver.findElement(By.id("wp-submit")).click();

		wait.until(ExpectedConditions.titleContains("Dashboard"));

		// Verify by logout is displayed

		Boolean logoDisplayed = driver.findElement(By.xpath("//li[contains(@id,'site-name')]")).isDisplayed();
		Assert.assertTrue(logoDisplayed, "Logout button not displayed");

		// Verify by title
		String title = driver.getTitle();
		Assert.assertEquals(title, "Dashboard ‹ Alchemy Jobs — WordPress", "Title did not match");

		Reporter.log("User logged and verified using title and logo element", true);

	}
}
