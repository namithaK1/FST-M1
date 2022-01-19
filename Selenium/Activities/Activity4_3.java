package SeleniumActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
		Thread.sleep(3000);
		System.out.println("Title of the page = " + driver.getTitle());
		Thread.sleep(2000);

		System.out.println("visible text of 3rd header = " + driver.findElement(By.xpath("//h3")).getText());

		System.out.println(
				"CSS color value for 5th header = " + driver.findElement(By.xpath("//h5")).getCssValue("color"));

		System.out.println("Violet color attribute = "
				+ driver.findElement(By.xpath("//button[contains(@class,'violet')]")).getAttribute("class"));

		System.out.println("Absolute xpath = "
				+ driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]"))
						.getText());

		Thread.sleep(3000);
		driver.close();
	}

}
