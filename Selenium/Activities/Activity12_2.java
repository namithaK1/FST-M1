package SeleniumActivity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12_2 {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/nested-iframes");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		System.out.println("Title of the page = " + driver.getTitle());

		driver.switchTo().frame(0);
		System.out.println("________________________Parent frame________________________");

		driver.switchTo().frame(0);

		System.out.println("________________________Nested Child 1 frame________________________");
		System.out.println("Header value =" + driver.findElement(By.cssSelector("div div.content")).getText());

		driver.switchTo().parentFrame();
		// driver.switchTo().defaultContent();

		driver.switchTo().frame(1);

		System.out.println("________________________Nested Child 2 frame________________________");
		System.out.println("Header value =" + driver.findElement(By.cssSelector("div div.content")).getText());

		driver.switchTo().defaultContent();

		driver.close();

	}

}
