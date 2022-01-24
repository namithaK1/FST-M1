package StepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity2Activity4Activity5 {

	WebDriver driver;
	WebDriverWait wait;

	@Given("^User is on the login page$")
	public void navigateToLoginPage() {

		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/login-form");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		wait = new WebDriverWait(driver, 20);
	}

	// This block is for Activity2
	@When("^User enters username and password$")
	public void enterUsernameAndPassword() {

		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");

		driver.findElement(By.xpath("//button[contains(@onclick,'signIn')]")).click();

	}

	// This is for Activity4 and Activity5
	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void enterParametizedParameter(String username, String password) {

		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.xpath("//button[contains(@onclick,'signIn')]")).click();

	}

	@Then("^Read the page title and confirmation message$")
	public void readTheTitleAndConfirmationMessage() {

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));

		String title = driver.getTitle();

		System.out.println("Titleof the page = " + title);
		String confirmMsg = driver.findElement(By.id("action-confirmation")).getText().trim();
		System.out.println("Confirmation message = " + confirmMsg);

		if (confirmMsg.contains("admin"))
			Assert.assertEquals(confirmMsg, "Welcome Back, admin");
		else
			Assert.assertEquals(confirmMsg, "Invalid Credentials");

	}

	@And("^Close the Browser$")
	public void closeBrowser() {

		driver.close();
	}
}
