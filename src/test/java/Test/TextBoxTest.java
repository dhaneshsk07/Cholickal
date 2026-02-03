package Test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Ninaidh.Home.BaseTest;
import Objects.TextBoxPage;

import Reports.ExtentTestManager;

public class TextBoxTest extends BaseTest {
	// WebDriver driver;

	@Test(description = "Test01")
	public void clickTextRun() throws InterruptedException {

		TextBoxPage pg = new TextBoxPage(driver, wait);
		pg.clickText();
		ExtentTestManager.getTest().info("Step1:Clicked on Text Tab button");

		pg.textBox();
		ExtentTestManager.getTest().info("Step2:Selected the TextBox Tab button");

		Assert.assertTrue(driver.findElement(By.xpath("//p[@id='name']")).isDisplayed());
		ExtentTestManager.getTest().info("Assertion Successfull - Name Value Displayed");

	}

	@Test(description = "Test02")
	public void clickTextRunOne() throws InterruptedException {

		TextBoxPage pg = new TextBoxPage(driver, wait);
		pg.clickText();
		ExtentTestManager.getTest().info("Step1:Clicked on Text Tab button");

		pg.textBox();
		ExtentTestManager.getTest().info("Step2:Selected the TextBox Tab button");

		Assert.assertTrue(driver.findElement(By.xpath("//p[@id='name']")).isDisplayed());
		ExtentTestManager.getTest().info("Assertion Successfull - Name Value Displayed");

	}

}
