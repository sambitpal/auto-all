package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestUI extends BaseTest {

	public static WebDriver driver;
	public static ChromeDriverService service;

	@BeforeTest
	public void init() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--relaxed-security");

		// Build the ChromeDriverService with desired options (e.g., a specific port)
		service = new ChromeDriverService.Builder().usingAnyFreePort() // Use any available port or specify with
																		// usingPort(9515)
				// You can add further service-specific augments/environment variables here
				.withEnvironment(java.util.Collections.emptyMap()).build();

		// Start the driver with both the service and options
		driver = new ChromeDriver(service, options);

		// (Optional, for advanced use) Augment the driver for capabilities like taking
		// screenshots remotely
		// driver = new Augmenter().augment(driver);

		// Use the driver
		driver.get("https://www.google.com");
		System.out.println("Page Title: " + driver.getTitle());

	}

	@AfterTest
	public void tearDown() {
		// Clean up
		driver.quit();
		service.stop(); // Stop the service manually if needed
	}
}
