package SeleniumActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/dynamic-controls");
		Thread.sleep(3000);
		System.out.println("Title of the page = " + driver.getTitle());
		Thread.sleep(2000);

		System.out.println("Checkbox is displayed on the UI = "
				+ driver.findElement(By.xpath("//input[@class='willDisappear']")).isDisplayed());

		driver.findElement(By.id("toggleCheckbox")).click();

		Thread.sleep(2000);

		System.out.println("Checkbox is displayed on the UI = "
				+ driver.findElement(By.xpath("//input[@class='willDisappear']")).isDisplayed());

		driver.close();
	}

}
