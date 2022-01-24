package SeleniumTestNGProject;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Activity2 extends BaseClass {

	@Test
	public void getTitle() {

		String header = driver.findElement(By.cssSelector("h1.entry-title")).getText().trim();
		Reporter.log("Heading of page is " + header, true);
		Assert.assertEquals(header, "Welcome to Alchemy Jobs");
	}
}
