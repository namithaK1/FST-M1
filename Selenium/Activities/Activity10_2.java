package SeleniumActivity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/input-events");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Title of the page = " + driver.getTitle());

		By keyText = By.id("keyPressed");

		Actions act = new Actions(driver);

		act.sendKeys(Keys.chord(Keys.SHIFT, "N")).perform();

		System.out.println("Entered value " + driver.findElement(keyText).getText());
		Thread.sleep(2000);

//		act.sendKeys(Keys.chord(Keys.CONTROL, "a")).build().perform();
//		act.sendKeys(Keys.chord(Keys.CONTROL, "c")).build().perform();

		act.keyDown(Keys.CONTROL).sendKeys("a", "c").keyUp(Keys.CONTROL).build().perform();

		Thread.sleep(2000);
		driver.close();

	}

}
