package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class SetupRestAssuredData extends WireMockSetup {

	RequestSpecBuilder rBuilder = new RequestSpecBuilder();
	protected static RequestSpecification reqSpec;
	WireMockSetup wms = new WireMockSetup();

	public RequestSpecification initApi() {
		WireMockSetup.setUpWireMock();
		WireMockSetup.setupPostStub();
		RestAssured.baseURI = "http://localhost:" + wireMockServer.port();
		rBuilder.setAccept("application/json").addHeader("x-api-key", "reqres-free-v1");
		reqSpec = rBuilder.build();
		return reqSpec;
	}
}
