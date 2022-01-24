package SeleniumTestNGProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity7 extends BaseClass {

	@Test(priority = 0)
	public void getTitle() throws InterruptedException {

		driver.findElement(By.xpath("//li[contains(@id,'item-26')]/a")).click();

		wait.until(ExpectedConditions.titleContains("Jobs"));

		String title = driver.getTitle().trim();
		Reporter.log("Title of new page is " + title, true);

		Assert.assertEquals(title, "Post a Job – Alchemy Jobs");
	}

	@Test(priority = 1)
	@Parameters({ "email", "jobTitle", "description", "applicationUrl", "companyName" })
	public void enterMandatoryFieldsInPostAJobPage(String email, String jobTitle, String description,
			String applicationUrl, String companyName) throws InterruptedException {

		driver.findElement(By.id("create_account_email")).sendKeys(email);
		driver.findElement(By.id("job_title")).sendKeys(jobTitle);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		driver.switchTo().frame("job_description_ifr");
		driver.findElement(By.id("tinymce")).sendKeys(description);
		driver.switchTo().defaultContent();

		driver.findElement(By.id("application")).sendKeys(applicationUrl);
		driver.findElement(By.id("company_name")).sendKeys(companyName);

		driver.findElement(By.xpath("//input[@value='Preview']")).click();

		// Wait for the job listing to have Banking in the result
		By submitListing = By.id("job_preview_submit_button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(submitListing));

		String finalJobTitle = driver.findElement(By.cssSelector("div.job_listing_preview h1")).getText().trim();

		driver.findElement(submitListing).click();

		By jobLinkXpath = By.xpath("//li[contains(@id,'item-24')]/a");
		wait.until(ExpectedConditions.visibilityOfElementLocated(jobLinkXpath));

		driver.findElement(jobLinkXpath).click();

		By jobDescrition = By.xpath("//ul[@class='job_listings']//h3");
		wait.until(ExpectedConditions.visibilityOfElementLocated(jobDescrition));

		String finalResult = driver.findElement(jobDescrition).getText().trim();
		Reporter.log("Job Title is " + finalResult, true);
		Assert.assertEquals(finalResult, finalJobTitle);
	}

}
