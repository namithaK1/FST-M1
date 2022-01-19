package SeleniumActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/simple-form");
		Thread.sleep(5000);
		System.out.println("Title=" + driver.getTitle());
		driver.findElement(By.id("firstName")).sendKeys("first name");
		Thread.sleep(2000);
		driver.findElement(By.id("lastName")).sendKeys("last name");
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("abc.abc.com");
		Thread.sleep(2000);
		driver.findElement(By.id("number")).sendKeys("9087654312");
		Thread.sleep(2000);
		driver.findElement(By.className("ui green button")).submit();
		Thread.sleep(6000);
		driver.close();
	}
}
