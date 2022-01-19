package SeleniumActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/simple-form");
		Thread.sleep(3000);
		System.out.println("Title of the page = " + driver.getTitle());

		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("first name");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("last name");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@abc.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='number']")).sendKeys("9087654312");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@class,'ui green')]")).submit();
		Thread.sleep(6000);
		driver.close();
	}

}
