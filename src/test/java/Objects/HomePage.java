package Objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage  {
	WebDriver driver;
	WebDriverWait wait;
	
	WebElement textBox;
	WebElement userName;
	WebElement userEmail;
	WebElement userCurAdd;
	WebElement userPerAdd;
	WebElement userSubmit;
	
	WebElement get_userName;
	WebElement get_email;
	WebElement get_currentAddress;
	WebElement get_permanentAddress;
	
	String name,email,curAdd,perAdd;

	
	public HomePage(WebDriver driver,WebDriverWait wait){
		
		this.driver = driver;
		this.wait=wait;
				
		
	}
	
	public void clickText() throws InterruptedException  {

		
		//textBox=driver.findElement(By.xpath("//span[text()='Text Box']"));
		textBox = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Text Box']"))
			);
		
		textBox.click();
		
	}
	

	public void textBox() {
	
	
	//-----User Name
	//userName=driver.findElement(By.xpath("//input[@id='userName']"));    
	userName = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userName']"))
		);
	userName.sendKeys("Jennifer Lopus");
	
	//-----email
	//userEmail=driver.findElement(By.xpath("//input[@id='email']"));
	userEmail = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userEmail']"))
		);
	userEmail.sendKeys("jenny_lopus03@gmail.com");
	
	//-----current Address
	//userCurAdd=driver.findElement(By.xpath("//input[@id='currentAddress']"));
	userCurAdd = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='currentAddress']"))
		);
	
	userCurAdd.sendKeys("Some Where in America");
	
	//-----Permanent Address
	//userPerAdd=driver.findElement(By.xpath("//input[@id='permanentAddress']"));
	userPerAdd = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='permanentAddress']"))
		);
	userPerAdd.sendKeys("Same as Current Address");
	
	//-----Submit Button
	//userSubmit=driver.findElement(By.xpath("//button[@id='submit']"));
	userSubmit = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='submit']"))
		);
	userSubmit.click();
	
	

	
	
	
	
	}
	
	//not used
	public void textBoxAssertion() {
		get_userName = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='name']"))
			);
		
		name=get_userName.getText();
		
		get_email = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='email']"))
			);
		email=get_userName.getText();
		
		get_currentAddress = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='currentAddress']"))
			);
		curAdd=get_userName.getText();
		
		get_permanentAddress = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='permanentAddress']"))
			);
		perAdd=get_userName.getText();
	}
	
}