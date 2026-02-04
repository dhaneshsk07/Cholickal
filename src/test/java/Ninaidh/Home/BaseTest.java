package Ninaidh.Home;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import Reports.ExtentManager;
import Utils.DriverManager;

import com.aventstack.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	 protected WebDriver driver;
	 protected WebDriverWait wait;
	 
	 protected static ExtentReports extent;
	@BeforeMethod
	public void driverConnectionSetup() {
		WebDriverManager.chromedriver().clearResolutionCache().setup();

		driver = new ChromeDriver();
		DriverManager.setDriver(driver);


		driver.manage().window().maximize();
		// driver.get("https://www.demoblaze.com");
		
		//Explicit Wait for all classes
		 wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		driver.get("https://demoqa.com/elements"); // real working url
		// driver.get("https://www.amazon.in/");

		// driver.get("https://automationexercise.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		

	}
	
	   static {
	        extent = ExtentManager.getInstance();
	    }

	@AfterMethod
	public void tearDown() {

		// Quit the WebDriver after each test
		if (driver != null) {
			driver.quit();
		}
		
		if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
		extent.flush();
	}
	
	
}
