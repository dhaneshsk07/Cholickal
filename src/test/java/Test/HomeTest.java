package Test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Ninaidh.Home.BaseTest;
import Objects.HomePage;

public class HomeTest extends BaseTest{
	//WebDriver driver;
	
	@Test(description="Test01")
	public void clickTextRun() throws InterruptedException {
		
		HomePage pg=new HomePage(driver,wait);
		pg.clickText();
		pg.textBox();
		Assert.assertTrue(driver.findElement(By.xpath("//p[@id='name']")).isDisplayed());

	}

}
