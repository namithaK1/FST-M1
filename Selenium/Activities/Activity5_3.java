package SeleniumActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/dynamic-controls");
		Thread.sleep(3000);
		System.out.println("Title of the page = " + driver.getTitle());
		Thread.sleep(2000);

		System.out.println(
				"Textfield is enabled = " + driver.findElement(By.xpath("//input[@id='input-text']")).isEnabled());

		driver.findElement(By.id("toggleInput")).click();

		Thread.sleep(2000);

		System.out.println(
				"Textfield is enabled = " + driver.findElement(By.xpath("//input[@id='input-text']")).isEnabled());

		driver.close();

	}

}
