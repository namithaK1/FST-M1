package SeleniumActivity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity12_3 {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/popups");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		System.out.println("Title of the page = " + driver.getTitle());

		WebElement signInBtn = driver.findElement(By.cssSelector("button.orange"));

		Actions act = new Actions(driver);
		act.moveToElement(signInBtn).perform();

		System.out.println("Tooltip value = " + signInBtn.getAttribute("data-tooltip"));

		signInBtn.click();

		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[contains(@onclick,'signIn')]")).click();

		System.out.println(driver.findElement(By.id("action-confirmation")).getText());

		driver.close();

	}

}
