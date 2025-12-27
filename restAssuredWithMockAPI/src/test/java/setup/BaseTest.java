package setup;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.CustomReport;

public class BaseTest {
	
	@BeforeSuite(alwaysRun = true)
	public void inits() {
		CustomReport.setExtent();

	}

	@AfterSuite(alwaysRun = true)
	public void tearDowns() {
		CustomReport.tearReport();
	}

}
