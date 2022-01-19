package SeleniumActivity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity10_3 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/drag-drop");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Title of the page = " + driver.getTitle());

		WebElement ball = driver.findElement(By.id("draggable"));

		WebElement dropZone1 = driver.findElement(By.id("droppable"));

		WebElement dropZone2 = driver.findElement(By.id("dropzone2"));

		Actions act = new Actions(driver);

		act.clickAndHold(ball).moveToElement(dropZone1).release().build().perform();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.attributeContains(dropZone1, "style", "background-color"));

		driver.findElement(By.xpath("//div[@id='droppable' and contains(@style,'background')]"));
		System.out.println("Ball is dragged to zone 1");

		act.dragAndDrop(dropZone1, dropZone2).perform();

		wait.until(ExpectedConditions.attributeContains(dropZone2, "style", "background-color"));

		driver.findElement(By.xpath("//div[@id='dropzone2' and contains(@style,'background')]"));
		System.out.println("Ball is dragged from zone 1 to zone 2");

		Thread.sleep(2000);
		driver.close();

	}

}
