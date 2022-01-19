package SeleniumActivity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity7_2 {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/dynamic-attributes");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Title of the page = " + driver.getTitle());

		driver.findElement(By.xpath(
				"//button[contains(@onclick,'signUp')]/preceding-sibling::div/input[contains(@class,'username')]"))
				.sendKeys("user1");

		driver.findElement(By.xpath(
				"//button[contains(@onclick,'signUp')]/preceding-sibling::div/input[contains(@class,'password')]"))
				.sendKeys("password");

		driver.findElement(
				By.xpath("//label[contains(text(),'Confirm')]/following-sibling::input[contains(@type,'password')]"))
				.sendKeys("password");

		driver.findElement(By.xpath("//input[starts-with(@class,'email')]")).sendKeys("abc@abc.com");

		By welcomePath = By.xpath("//div[@id='action-confirmation' and not(contains(@class,'disabled'))]");

		driver.findElement(By.xpath("//button[contains(@onclick,'signUp')]")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.presenceOfElementLocated(welcomePath));

		System.out.println("Successfull message = " + driver.findElement(welcomePath).getText());

		driver.close();
	}

}
