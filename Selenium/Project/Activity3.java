package SeleniumTestNGProject;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Activity3 extends BaseClass {

	@Test
	public void getTitle() {

		String headerImageUrl = driver.findElement(By.xpath("//img[contains(@class,'attachment')]")).getAttribute("src")
				.trim();
		Reporter.log("URL of header image in the page is ==> " + headerImageUrl, true);
		Assert.assertTrue(!headerImageUrl.isEmpty());
	}

}
