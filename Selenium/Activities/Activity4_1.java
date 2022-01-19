package SeleniumActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
		Thread.sleep(3000);
		System.out.println("Title of the page = " + driver.getTitle());

		System.out.println(driver.findElement(By.xpath("//a[@id='about-link']")).getText());
		driver.findElement(By.xpath("//a[@id='about-link']")).click();

		Thread.sleep(3000);
		System.out.println("Title of the new page = " + driver.getTitle());
		Thread.sleep(3000);

		driver.close();

	}

}
