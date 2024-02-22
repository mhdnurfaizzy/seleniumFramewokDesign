package mhdnurfaizzy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mhdnurfaizzy.AbstractComponenet.abstractComponent;

public class LandingPage extends abstractComponent{

	

	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
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
	
	@FindBy(css="[class*='flyInOut']")
	 WebElement errorMessage;
	
	public String getErrorMessage() {
		waitWebElementForAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public ProductCatalogue loginApplication(String email, String password) {
		useremail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalog = new ProductCatalogue(driver);
		return productCatalog;
		
	}
}
