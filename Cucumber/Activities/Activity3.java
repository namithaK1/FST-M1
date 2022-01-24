package StepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity3 {

	WebDriver driver;
	WebDriverWait wait;
	Alert alt;

	@Given("^User is on the page$")
	public void userIsOnThePage() {

		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 20);
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@When("^User clicks the Simple Alert button$")
	public void clickOnSimpleAlert() {

		driver.findElement(By.id("simple")).click();

	}

	@When("^User clicks the Confirm Alert button$")
	public void clickOnConfirmAlert() {

		driver.findElement(By.id("confirm")).click();
	}

	@When("^User clicks the Prompt Alert button$")
	public void clickOnPromptAlert() {

		driver.findElement(By.id("prompt")).click();
	}

	@Then("^Alert opens$")
	public void openAlert() {

		wait.until(ExpectedConditions.alertIsPresent());

		alt = driver.switchTo().alert();

	}

	@And("^Read the text from it and print it$")
	public void readTextAndPrint() {

		System.out.println("Text in the laert = " + alt.getText());

	}

	@And("^Write a custom message in it$")
	public void writeIntoPromptAlert() {

		alt.sendKeys("This is the prompt alert conent");
	}

	@And("^Close the alert$")
	public void closeAlert() {

		alt.accept();

	}

	@And("^Close the alert with Cancel$")
	public void closeAlertWithCancel() {

		alt.dismiss();

	}

	@And("^Close Browser$")
	public void closeBrowser() {

		driver.close();
	}

}
