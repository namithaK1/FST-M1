package SeleniumActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
		Thread.sleep(5000);
		System.out.println("Title of page=" + driver.getTitle());

		System.out.println(driver.findElement(By.id("about-link")).getText());
		System.out.println(driver.findElement(By.className("ui inverted huge green button")).getText());
		System.out.println(driver.findElement(By.linkText("About Us")).getText());
		System.out.println(driver.findElement(By.cssSelector("#about-link")).getText());

		driver.close();

	}

}
