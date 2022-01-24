package SeleniumTestNGProject;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Activity4 extends BaseClass {

	@Test
	public void getTitle() {

		String header = driver.findElement(By.cssSelector("div.entry-content h2")).getText().trim();
		Reporter.log("2nd header in the page is " + header, true);
		Assert.assertEquals(header, "Quia quis non");
	}
}
