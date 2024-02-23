package mhdnurfaizzy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import mhdnurfaizzy.AbstractComponenet.abstractComponent;

public class CheckoutPage extends abstractComponent{
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".action__submit")
	 WebElement submit;
	
	@FindBy(css="input[placeholder='Select Country']")
	 WebElement country;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	 WebElement selectCountry;
	
	By result = By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitElementForAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
	}
	
	public ConfirmationPage submitOrder() {
//		waitWebElementForAppear(submit);
        Actions b = new Actions(driver);
        b.scrollToElement(submit).perform();
		submit.click();
		return new ConfirmationPage(driver);
	}
	

}
