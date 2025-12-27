package utilities;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

public class WireMockSetup {

	public static final int PORT = 0;
	public static WireMockServer wireMockServer;

	public static void setUpWireMock() {
		String expectedJson = "{ \"Name\": \"Sammy\", \"Job\": \"QA\" }";
		// Start the WireMock server
		wireMockServer = new WireMockServer(WireMockConfiguration.options().globalTemplating(true).port(PORT)
				.notifier(new ConsoleNotifier(true)));
		wireMockServer.start();
		// Configure RestAssured base URI to point to the mock server
		System.out.println("WireMock server started on port " + wireMockServer.port());
		wireMockServer.stubFor(get(urlEqualTo("/api/test")).willReturn(aResponse().withStatus(200)));
		wireMockServer.stubFor(post(urlEqualTo("/api/users")) // Matches the URL and method
				.withHeader("Content-Type", equalTo("application/json")) // Matches a specific header
				//.withRequestBody(equalToJson(expectedJson)) // Matches the request body
				// content (JSON)
				.willReturn(aResponse() // Defines the response
						.withStatus(201) // HTTP status code for "Created"
						.withHeader("Content-Type", "application/json")
						.withBody("{\"status\":\"created\", \"id\": \"123\",\"name\":\"test\", {\"job\":\"QA\"}")));
		System.out.println("Stub mapping size: " + wireMockServer.getStubMappings().size());

	}

	public static void SetupGetStub() {
	}

	public static void setupPostStub() {
		
	}

	public void stopServer() {
		// wireMockServer.stop();
	}
}
