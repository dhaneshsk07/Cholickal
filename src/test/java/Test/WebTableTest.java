package Test;

import org.testng.annotations.Test;
import Ninaidh.Home.BaseTest;
import Objects.WebTablePage;

public class WebTableTest extends BaseTest{
	//WebDriver driver;
	
	@Test(description="TC_WebTableTest_01")
	public void clickWebTableRun() throws InterruptedException {
		driver.get("https://demoqa.com/webtables");
		
		WebTablePage wpg=new WebTablePage(driver,wait);
		wpg.clickAddButton();
		wpg.registrationForm("Joseph", "Alex", "jsp009@gmail.com","44","44000", "General");
		wpg.clickRegistrationSubmit();
		
		//assertion
		wpg.webPageTest01_Assertion();
		
	}
	
	

}
