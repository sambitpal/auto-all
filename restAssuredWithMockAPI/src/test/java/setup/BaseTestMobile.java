package setup;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestMobile extends BaseTest {
	
	@BeforeMethod
	public void init() {

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}