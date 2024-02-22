package mhdnurfaizzy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import mhdnurfaizzy.AbstractComponenet.abstractComponent;

public class OrderPage extends abstractComponent{
	
	WebDriver driver;
	
	@FindBy(css="li[class='totalRow'] button[type='button']")
	 WebElement checkoutEle;
	
	@FindBy(css="tr td:nth-child(3)")
	 List<WebElement> productNames;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyOrdersTitleDisplayed(String productName) {
		Boolean match = productNames.stream().anyMatch(titleProduct->titleProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
}
