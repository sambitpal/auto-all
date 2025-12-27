package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CustomReport {

	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	protected static Properties property = new Properties();

	public static void setExtent() {
		try {
			property.load(new FileReader("src\\main\\resources\\properties\\reportlocation.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		htmlReporter = new ExtentSparkReporter(property.getProperty("reportlocation") + "/test-output/ExtentReport/"
				+ "TestExecutionReport" + ".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		System.out.println("Report Created");

	}

	public static void tearReport() {
		extent.flush();
	}
}
