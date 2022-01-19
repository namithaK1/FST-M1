package SeleniumActivity;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity9_2 {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/selects");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Title of the page = " + driver.getTitle());

		WebElement multiDropdown = driver.findElement(By.id("multi-select"));

		Select sel = new Select(multiDropdown);

		System.out.println("This is multi dropdown " + sel.isMultiple());

		sel.selectByVisibleText("Javascript");

		sel.selectByValue("node");

		for (int i = 4; i <= 6; i++)
			sel.selectByIndex(i);

		sel.deselectByValue("node");

		sel.deselectByIndex(7);

		System.out.println("First selected = " + sel.getFirstSelectedOption().getText());

		List<WebElement> content = sel.getAllSelectedOptions();
		for (WebElement ele : content)
			System.out.println(ele.getText());

		driver.close();
	}

}
