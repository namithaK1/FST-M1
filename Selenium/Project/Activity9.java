package SeleniumTestNGProject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity9 extends BaseClass {

	By addNew = By.xpath("//a[@class='page-title-action']");
	String jobPosition = "";

	@Test
	@Parameters({ "user", "password" })
	public void step_b_c_Login(String username, String password) {

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

		Reporter.log("Successfully user logged in and verified using title and logo element", true);

	}

	@Test
	public void step_c_ClickJobListing() {

		driver.findElement(By.xpath("//li[contains(@id,'job_listing')]//a")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(addNew));

		Assert.assertTrue(driver.findElement(addNew).isDisplayed(), "Add new button is not displayed");

		Reporter.log("Successfully clicked on Job listing and Add new button is well displayed", true);
	}

	@Test
	public void step_d_ClickAddNewButton() {

		driver.findElement(addNew).click();

		wait.until(ExpectedConditions.titleContains("Add Job"));

		Assert.assertEquals(driver.getTitle().trim(), "Add Job ‹ Alchemy Jobs — WordPress");

		Reporter.log("Succefully clicked on Add New button and navigated to the jobs page", true);
	}

	@Test
	@Parameters({ "position", "companyWebsite", "companyTwitter", "jobLocation", "companyName", "companyTag" })
	public void step_e_FillMandatoryFields(String position, String companyWebsite, String companyTwitter,
			String jobLocation, String companyName, String companyTag) {

		driver.findElement(By.id("post-title-0")).sendKeys(position);

		jobPosition = driver.findElement(By.id("post-title-0")).getText();

		Assert.assertTrue(!driver.findElement(By.id("post-title-0")).getText().isEmpty(), "Position Field is empty");

		driver.findElement(By.id("_company_website")).sendKeys(companyWebsite);

		driver.findElement(By.id("_company_twitter")).sendKeys(companyTwitter);

		driver.findElement(By.id("_job_location")).sendKeys(jobLocation);

		driver.findElement(By.id("_company_name")).sendKeys(companyName);

		driver.findElement(By.id("_company_tagline")).sendKeys(companyTag);

		Assert.assertTrue(!driver.findElement(By.id("_company_website")).getAttribute("value").isEmpty(),
				"Website Field is empty");

		Assert.assertTrue(!driver.findElement(By.id("_company_twitter")).getAttribute("value").isEmpty(),
				"Twitter Field is empty");

		Assert.assertTrue(!driver.findElement(By.id("_job_location")).getAttribute("value").isEmpty(),
				"Job location Field is empty");

		Assert.assertTrue(!driver.findElement(By.id("_company_name")).getAttribute("value").isEmpty(),
				"Company Field is empty");

		Assert.assertTrue(!driver.findElement(By.id("_company_tagline")).getAttribute("value").isEmpty(),
				"Tagline Field is empty");

		Assert.assertTrue(
				driver.findElement(By.xpath("//button[contains(@class,'publish') and contains(@class,'primary')]"))
						.isEnabled(),
				"Publish button is not enabled");

		Reporter.log("Succefully entered all mandatory fields", true);
	}

	@Test
	public void step_f_ClickOnPublishButton() throws InterruptedException {

		Thread.sleep(5000);

		// Click on publish button
		driver.findElement(By.xpath("//button[contains(@class,'publish') and contains(@class,'primary')]")).click();

		Thread.sleep(10000);

		// Click on panel publish button
		driver.findElement(By.xpath(
				"//div[contains(@class,'panel')]//button[contains(@class,'publish') and contains(@class,'primary')]"))
				.click();

		Thread.sleep(10000);

		Reporter.log("Succefully clicked on Publish button", true);
	}

	@Test
	public void step_g_VerifyJobListingWasCreated() {

		driver.findElement(By.xpath("//div[@class='edit-post-header']//a[contains(@href,'job_listing')]")).click();

		By xpath = By.xpath("//tr[1]//div[@class='job_position']/a");

		wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));

		Assert.assertEquals(driver.findElement(xpath).getText().trim(), jobPosition, "Job listing is not created");

		Reporter.log("Succefully verified job listing has been created", true);
	}

}
