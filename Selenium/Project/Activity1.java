package SeleniumTestNGProject;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Activity1 extends BaseClass {

	@Test
	public void getTitle() {

		String title = driver.getTitle();
		Reporter.log("Title of page is " + title, true);
		Assert.assertEquals(title, "Alchemy Jobs – Job Board Application");

	}
}
