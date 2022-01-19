package SeleniumActivity;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11_4 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/tab-opener");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		System.out.println("Title of the page = " + driver.getTitle());
		System.out.println("Current window's window id = " + driver.getWindowHandle());

		driver.findElement(By.id("launcher")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		Set<String> windows = driver.getWindowHandles();
		System.out.println("All window id = " + windows);
		Iterator<String> it = windows.iterator();

//		String parentWindow = it.next();
//		String childWindow = it.next();

		String switchId = "";
		while (it.hasNext())
			switchId = it.next();

		System.out.println("switchId=" + switchId);
		driver.switchTo().window(switchId);

		wait.until(ExpectedConditions.titleContains("New"));

		System.out.println("Current new page title = " + driver.getTitle());
		System.out.println("Header text = " + driver.findElement(By.xpath("//div[@class='content']")).getText());

		System.out.println("______________________________________________________________________________");

		driver.findElement(By.id("actionButton")).click();

		wait.until(ExpectedConditions.numberOfWindowsToBe(3));

		Set<String> newWindows = driver.getWindowHandles();
		System.out.println("All window id = " + newWindows);

		for (String windowId : newWindows)
			driver.switchTo().window(windowId);

		wait.until(ExpectedConditions.titleContains("New"));
		System.out.println("Current new page title = " + driver.getTitle());
		System.out.println("Header text = " + driver.findElement(By.xpath("//div[@class='content']")).getText());

		driver.quit();
	}

}
