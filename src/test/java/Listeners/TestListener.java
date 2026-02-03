package Listeners;

import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import Reports.ExtentTestManager;
import Ninaidh.Home.BaseTest;

public class TestListener extends BaseTest implements ITestListener {
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());
		ExtentTestManager.setTest(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().pass("Test Passed");

	

	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTestManager.getTest().fail(result.getThrowable());
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentTestManager.unload();
		
	}
}
