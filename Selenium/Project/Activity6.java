package SeleniumTestNGProject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 extends BaseClass {

	@Test(priority = 0)
	public void getTitle() {

		driver.findElement(By.xpath("//li[contains(@id,'item-24')]/a")).click();

		wait.until(ExpectedConditions.titleContains("Jobs"));

		String title = driver.getTitle().trim();
		Reporter.log("Title of new page is " + title, true);
		Assert.assertEquals(title, "Jobs – Alchemy Jobs");
	}

	@Test(priority = 1)
	@Parameters("jobSearchKeyword")
	public void searchForJob(String jobSearchKey) {

		By applyButton = By.xpath("//input[contains(@class,'application_button')]");
		By email = By.xpath("//div[contains(@style,'block')]//a");
		String jobXpath = "//ul[@class='job_listings']//h3[contains(text(),'" + jobSearchKey + "')]";

		driver.findElement(By.id("search_keywords")).sendKeys(jobSearchKey);

		driver.findElement(By.xpath("//div[@class='search_submit']/input")).click();
		// Wait for the job listing to have Banking in the result
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobXpath)));

		driver.findElement(By.xpath(jobXpath)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(applyButton));

		driver.findElement(applyButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(email));

		String applyEmail = driver.findElement(email).getText().trim();

		Reporter.log("Email id is " + applyEmail, true);
		Assert.assertTrue(!applyEmail.isEmpty());
	}

}
