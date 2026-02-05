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
	public void clickWebTableRun(String firstName,String lastname,String useremail,String age,String salary,String dept) throws InterruptedException {
		driver.get("https://demoqa.com/webtables");
		
		WebTablePage wpg=new WebTablePage(driver,wait);
		wpg.clickAddButton();
		ExtentTestManager.getTest().info("Step1:Clicked on Add Button");
		
		//wpg.registrationForm("Joseph", "Alex", "jsp009@gmail.com","44","44000", "General");
		wpg.registrationForm(firstName, lastname, useremail, age, salary, dept);
		System.out.println("Running with data: " );

		ExtentTestManager.getTest().info("Step2:Registration form all fields filled");
		
		wpg.clickRegistrationSubmit();
		ExtentTestManager.getTest().info("Step3:Clicked Submit Button- Form Submitted");
		
		//assertion
		ExtentTestManager.getTest().info("Assertion Values : " + "Expected email : nila119@gmail.com " + " and Actual email : " + useremail);
		wpg.webPageTest01_Assertion(useremail);
		
		
		  ExtentTestManager.getTest().info("Test Data Used:");
		  ExtentTestManager.getTest().info("First Name: " + firstName);
		  ExtentTestManager.getTest().info("Last Name: " + lastname);
		  ExtentTestManager.getTest().info("Email: " + useremail);
		  ExtentTestManager.getTest().info("Age: " + age);
		  ExtentTestManager.getTest().info("Salary: " + salary);
		  ExtentTestManager.getTest().info("Department: " + dept);
		
	}
	
	

}
