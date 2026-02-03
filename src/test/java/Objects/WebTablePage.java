package Objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebTablePage {
	WebDriver driver;
	WebDriverWait wait;

	WebElement addButton;
	WebElement fName_txt;
	WebElement lName_txt;
	WebElement email_txt;
	WebElement age_txt;
	WebElement sal_txt;
	WebElement dept_txt;

	WebElement get_userName;
	WebElement get_email;
	WebElement get_currentAddress;
	WebElement get_permanentAddress;

	WebElement submit_btn;

	// String name, email, curAdd, perAdd;

	public WebTablePage(WebDriver driver, WebDriverWait wait) {

		this.driver = driver;
		this.wait = wait;

	}

	// add ,edit,delete,search

	// click add button
	public void clickAddButton() throws InterruptedException {

		addButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='addNewRecordButton']")));

		addButton.click();

	}

	public void registrationForm(String fName, String lName, String email, String age, String salary, String dept) {

		// fname
		fName_txt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='firstName']")));
		fName_txt.sendKeys(fName);

		// lname
		lName_txt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='lastName']")));
		lName_txt.sendKeys(lName);

		// email
		email_txt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userEmail']")));
		email_txt.sendKeys(email);

		// age
		age_txt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='age']")));
		age_txt.sendKeys(age); // how can handle sendkeys int value?

		// salar
		sal_txt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='salary']")));
		sal_txt.sendKeys(salary); // how can handle sendkeys double value?

		// dept
		dept_txt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='department']")));
		dept_txt.sendKeys(dept);
	}

	// -------------------------------------------------------

	public void clickRegistrationSubmit() {
		submit_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='submit']")));
		submit_btn.click();
	}

	public void webPageTest01_Assertion() {

	    String expectedEmail = "jsp009@gmail.com";
	    boolean emailFound = false;

	    List<WebElement> emailsList =
	            driver.findElements(By.xpath("//div[@role='gridcell'][4]"));

	    for (WebElement email : emailsList) {

	        if (email.getText().equals(expectedEmail)) {
	            emailFound = true;
	            break;
	        }
	    }

	    Assert.assertTrue(emailFound, "Expected email not found in WebTable");
	}


}
