package setup;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.restassured.specification.RequestSpecification;
import utilities.SetupRestAssuredData;
import utilities.WireMockSetup;

public class BaseTestApi extends BaseTest{

	WireMockSetup wms = new WireMockSetup();
	SetupRestAssuredData srad = new SetupRestAssuredData();
	protected RequestSpecification rSpecObj;
	
	@BeforeTest
	public void init() {
		rSpecObj = srad.initApi();

	}

	@AfterTest
	public void tearDown() {
		// Stop the WireMock server after all tests are finished
		srad.stopServer();
	}
}