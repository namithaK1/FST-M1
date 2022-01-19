package SeleniumActivity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/input-events");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Title of the page = " + driver.getTitle());

		By sideText = By.xpath("//div[@class='active']");

		Actions act = new Actions(driver);
		System.out.println("Before any click value = " + driver.findElement(sideText).getText());
		Thread.sleep(2000);

		act.click().perform();
		System.out.println("Current active side after left click = " + driver.findElement(sideText).getText());
		Thread.sleep(2000);

		act.doubleClick().perform();
		System.out.println("Current active side after double click = " + driver.findElement(sideText).getText());
		Thread.sleep(2000);

		act.contextClick().perform();
		System.out.println("Current active side after right click = " + driver.findElement(sideText).getText());
		Thread.sleep(2000);

		driver.close();
	}

}
