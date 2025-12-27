package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import setup.BaseTest;
import utilities.CustomReport;

public class CustomTestListener extends CustomReport implements ITestListener {

	public static final Logger log = LogManager.getLogger(CustomTestListener.class);

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getName());
		log.info("Starting test" + result.getName());
		System.out.println(("Starting test" + result.getName()));
		test.log(Status.INFO, "test started: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("Success test" + result.getName());
		System.out.println(("Success test" + result.getName()));
		test.log(Status.PASS, "test Success: " + result.getName());	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("Failed test" + result.getName());
		System.out.println(("Failed test" + result.getName()));
		test.log(Status.FAIL, "test Failed: " + result.getName());	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}
}
