package mhdnurfaizzy.Test;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import mhdnurfaizzy.pageobjects.CartPage;
import mhdnurfaizzy.pageobjects.CheckoutPage;
import mhdnurfaizzy.pageobjects.ConfirmationPage;
import mhdnurfaizzy.pageobjects.LandingPage;
import mhdnurfaizzy.pageobjects.ProductCatalogue;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		String productName = "ADIDAS ORIGINAL";
		String countryName = "India";
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//POM (PageObjectModel)
		LandingPage landingPage = new LandingPage(driver);

		//Login
		landingPage.goTo();
		ProductCatalogue productCatalog = landingPage.loginApplication("izi@gmail.com", "Testing890-");
		//landed on home page
		List<WebElement> products = productCatalog.getListProducts();
		//add product to cart
		productCatalog.addProductToCart(productName);
		CartPage cartPage = productCatalog.goToCartPage();
		
		//verify product on cart
		Boolean match = cartPage.verifyProductTitleDisplayed(productName);	
		Assert.assertTrue(match);
		
		//scroll intoView submit button
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		//checkoutPage
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry(countryName);
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		
		//confirmationPage
		String confirmMassage = confirmationPage.confirmationMessagge();
		Assert.assertTrue(confirmMassage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.quit();
	
	}

}
