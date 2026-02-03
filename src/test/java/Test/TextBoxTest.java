package Test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Ninaidh.Home.BaseTest;
import Objects.TextBoxPage;

public class TextBoxTest extends BaseTest{
	//WebDriver driver;
	
	@Test(description="Test01")
	public void clickTextRun() throws InterruptedException {
		
		TextBoxPage pg=new TextBoxPage(driver,wait);
		pg.clickText();
		pg.textBox();
		Assert.assertTrue(driver.findElement(By.xpath("//p[@id='name']")).isDisplayed());

	}
	
	@Test(description="Test02")
	public void clickTextRunOne() throws InterruptedException {
		
		TextBoxPage pg=new TextBoxPage(driver,wait);
		pg.clickText();
		pg.textBox();
		Assert.assertTrue(driver.findElement(By.xpath("//p[@id='name']")).isDisplayed());

	}

}
