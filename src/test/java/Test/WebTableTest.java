package Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtils.ExcelUtil;
import Ninaidh.Home.BaseTest;
import Objects.WebTablePage;
import Reports.ExtentManager;
import Reports.ExtentTestManager;
public class WebTableTest extends BaseTest{
	//WebDriver driver;
	
	
    @DataProvider(name = "excelData")
    public String[][] getExcelData() throws Exception {

        String path = System.getProperty("user.dir")
                + "/test-data/TestData.xlsx";

        ExcelUtil excel = new ExcelUtil(path, "Sheet1");
        return excel.getData();
    }
	
	@Test(description="TC_WebTableTest_01",dataProvider = "excelData")
	public void clickWebTableRun(String firstName,String lastname,String email,String age,String salary,String dept) throws InterruptedException {
		driver.get("https://demoqa.com/webtables");
		
		WebTablePage wpg=new WebTablePage(driver,wait);
		wpg.clickAddButton();
		ExtentTestManager.getTest().info("Step1:Clicked on Add Button");
		
		//wpg.registrationForm("Joseph", "Alex", "jsp009@gmail.com","44","44000", "General");
		wpg.registrationForm(firstName, lastname, email, age, salary, dept);
		System.out.println("Running with data: " );

		ExtentTestManager.getTest().info("Step2:Registration form all fields filled");
		
		wpg.clickRegistrationSubmit();
		ExtentTestManager.getTest().info("Step3:Clicked Submit Button- Form Submitted");
		
		//assertion
		wpg.webPageTest01_Assertion("jsp009@gmail.com");
		ExtentTestManager.getTest().info("Assertion Successfull");
		
		  ExtentTestManager.getTest().info("Test Data Used:");
		  ExtentTestManager.getTest().info("First Name: " + firstName);
		  ExtentTestManager.getTest().info("Last Name: " + lastname);
		  ExtentTestManager.getTest().info("Email: " + email);
		  ExtentTestManager.getTest().info("Age: " + age);
		  ExtentTestManager.getTest().info("Salary: " + salary);
		  ExtentTestManager.getTest().info("Department: " + dept);
		
	}
	
	

}
