package Listeners;

import com.aventstack.extentreports.ExtentTest;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import Reports.ExtentTestManager;
import Utils.DriverManager;
import Utils.ScreenshotUtil;
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

	    // Get Extent test instance (Thread-safe)
	    ExtentTest test = ExtentTestManager.getTest();

	    // Log test name and status
	    test.fail("Test Failed: " + result.getMethod().getMethodName());

	    // Log full exception + stack trace
	    if (result.getThrowable() != null) {
	        test.fail(result.getThrowable());
	    }
	    
	    
	    
	    //----------S C R E E N S H O T-----O N-----F A I L U R E-----------------------
	

	        try {
	            String screenshotPath = ScreenshotUtil.captureScreenshot(
	                    DriverManager.getDriver(),
	                    result.getMethod().getMethodName()
	            );

	            test.addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");

	        } catch (IOException e) {
	            test.warning("Screenshot capture failed: " + e.getMessage());
	        }
	    }
	


	@Override
	public void onFinish(ITestContext context) {
		ExtentTestManager.unload();
		
	}
}
