package Test;

import org.testng.annotations.Test;
import Ninaidh.Home.BaseTest;
import Objects.WebTablePage;

import Reports.ExtentTestManager;
public class WebTableTest extends BaseTest{
	//WebDriver driver;
	
	@Test(description="TC_WebTableTest_01")
	public void clickWebTableRun() throws InterruptedException {
		driver.get("https://demoqa.com/webtables");
		
		WebTablePage wpg=new WebTablePage(driver,wait);
		wpg.clickAddButton();
		ExtentTestManager.getTest().info("Step1:Clicked on Add Button");
		
		wpg.registrationForm("Joseph", "Alex", "jsp009@gmail.com","44","44000", "General");
		ExtentTestManager.getTest().info("Step2:Registration form all fields filled");
		
		wpg.clickRegistrationSubmit();
		ExtentTestManager.getTest().info("Step3:Clicked Submit Button- Form Submitted");
		
		//assertion
		wpg.webPageTest01_Assertion();
		ExtentTestManager.getTest().info("Assertion Successfull");
		
	}
	
	

}
