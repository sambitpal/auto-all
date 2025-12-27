package setup;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.specification.RequestSpecification;
import utilities.CustomReport;
import utilities.SetupRestAssuredData;
import utilities.WireMockSetup;

public class BaseTest {

	WireMockSetup wms = new WireMockSetup();
	CustomReport rep = new CustomReport();
	SetupRestAssuredData srad = new SetupRestAssuredData();
	protected RequestSpecification rSpecObj;
	
	@BeforeSuite
	public void init() {
		CustomReport.setExtent();
		rSpecObj = srad.initApi();

	}

	@AfterSuite
	public void tearDown() {
		// Stop the WireMock server after all tests are finished
		srad.stopServer();
		CustomReport.tearReport();
	}
}