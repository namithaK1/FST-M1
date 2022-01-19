package SeleniumActivity;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity9_1 {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/selects");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Title of the page = " + driver.getTitle());

		WebElement dropdownEle = driver.findElement(By.id("single-select"));

		Select sel = new Select(dropdownEle);

		sel.selectByVisibleText("Option 2");
		System.out.println(sel.getFirstSelectedOption().getText());

		sel.selectByIndex(3);
		System.out.println(sel.getFirstSelectedOption().getText());

		sel.selectByValue("4");
		System.out.println(sel.getFirstSelectedOption().getText());

		System.out.println("----------------All Options----------------");
		List<WebElement> dropdownOptions = sel.getOptions();
		for (WebElement ele : dropdownOptions)
			System.out.println(ele.getText());

		driver.close();
	}

}
