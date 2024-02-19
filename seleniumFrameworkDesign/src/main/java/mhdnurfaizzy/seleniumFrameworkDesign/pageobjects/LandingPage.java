package mhdnurfaizzy.seleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	

	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	@FindBy(id="userEmail")
	 WebElement useremail;
	
	//driver.findElement(By.id("userPassword")) 
	@FindBy(id="userPassword")
	 WebElement passwordEle;
	
	@FindBy(id="login")
	 WebElement submit;
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public void loginApplication(String email, String password) {
		useremail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		
	}
}
