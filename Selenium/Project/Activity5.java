package SeleniumTestNGProject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Activity5 extends BaseClass {

	@Test
	public void getTitle() throws InterruptedException {

		// Adding thread sleep, just to see the execution flow
		Thread.sleep(3000);

		driver.findElement(By.xpath("//li[contains(@id,'item-24')]/a")).click();

		wait.until(ExpectedConditions.titleContains("Jobs"));
		Thread.sleep(3000);
		String title = driver.getTitle().trim();
		Reporter.log("Title of new page is " + title, true);
		Assert.assertEquals(title, "Jobs – Alchemy Jobs");
	}

}
