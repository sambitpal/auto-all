package setup;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utilities.CustomReport;

public class BaseTest {

	public static AppiumDriverLocalService appiumLocalService;
	public static AppiumDriver driver;

	@BeforeSuite(alwaysRun = true)
	public void inits() {
		CustomReport.setExtent();
		appiumLocalService = new AppiumServiceBuilder().usingAnyFreePort().build();
		appiumLocalService.start();
		System.out.println(appiumLocalService.getUrl());
		DesiredCapabilities desiredCaps = new DesiredCapabilities();

		desiredCaps.setCapability("platformName", "Android");
		desiredCaps.setCapability("appium:automationName", "UiAutomator2");
		desiredCaps.setCapability("appium:deviceName", "emulator-5554");
		desiredCaps.setCapability("appium:appPackage", "com.google.android.apps.photos");
		desiredCaps.setCapability("appium:appActivity", "com.google.android.apps.photos.home.HomeActivity");
		driver = new AndroidDriver(appiumLocalService, desiredCaps);

	}

	@AfterSuite(alwaysRun = true)
	public void tearDowns() {
		CustomReport.tearReport();
		appiumLocalService.stop();
	}

}
