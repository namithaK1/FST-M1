package SeleniumActivity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12_1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/iframes");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		System.out.println("Title of the page = " + driver.getTitle());

		driver.switchTo().frame(0);
		System.out.println("________________________Frame 1________________________");
		System.out.println("Header value =" + driver.findElement(By.cssSelector("div div.content")).getText());

		WebElement f1Btn = driver.findElement(By.id("actionButton"));
		System.out.println("Frame 1 new button = " + f1Btn.getText());
		System.out.println("Frame 1 new color = " + f1Btn.getCssValue("color"));
		System.out.println("Frame 1 new color = " + f1Btn.getCssValue("background-color"));
		f1Btn.click();

		WebElement f1NewBtn = driver.findElement(By.id("actionButton"));
		System.out.println("Frame 1 button = " + f1NewBtn.getText());
		System.out.println("Frame 1 color = " + f1NewBtn.getCssValue("color"));
		System.out.println("Frame 1 new color = " + f1NewBtn.getCssValue("background-color"));

		driver.switchTo().defaultContent();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(3000);

		driver.switchTo().frame(1);

		System.out.println("________________________Frame 2________________________");

		System.out.println("Header value =" + driver.findElement(By.cssSelector("div div.content")).getText());

		WebElement f2Btn = driver.findElement(By.id("actionButton"));
		System.out.println("Frame 2 button = " + f2Btn.getText());
		System.out.println("Frame 2 color = " + f2Btn.getCssValue("color"));
		System.out.println("Frame 2  color = " + f2Btn.getCssValue("background-color"));

		f2Btn.click();

		WebElement f2NewBtn = driver.findElement(By.id("actionButton"));
		System.out.println("Frame 2 new button = " + f2NewBtn.getText());
		System.out.println("Frame 2 new color = " + f2NewBtn.getCssValue("color"));
		System.out.println("Frame 2 new color = " + f2NewBtn.getCssValue("background-color"));

		driver.switchTo().defaultContent();

		driver.close();

	}

}
