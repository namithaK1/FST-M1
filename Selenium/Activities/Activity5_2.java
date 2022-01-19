package SeleniumActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/dynamic-controls");
		Thread.sleep(3000);
		System.out.println("Title of the page = " + driver.getTitle());
		Thread.sleep(2000);

		System.out.println("Checkbox is checked = "
				+ driver.findElement(By.xpath("//input[@class='willDisappear']")).isSelected());

		driver.findElement(By.xpath("//input[@class='willDisappear']")).click();

		Thread.sleep(2000);

		System.out.println("Checkbox is checked = "
				+ driver.findElement(By.xpath("//input[@class='willDisappear']")).isSelected());

		driver.close();
	}

}
