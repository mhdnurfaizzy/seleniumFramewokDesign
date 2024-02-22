package mhdnurfaizzy.Test;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import mhdnurfaizzy.pageobjects.CartPage;
import mhdnurfaizzy.pageobjects.CheckoutPage;
import mhdnurfaizzy.pageobjects.ConfirmationPage;
import mhdnurfaizzy.pageobjects.ProductCatalogue;
import mhdnurfaizzy.testComponent.baseTest;

public class e2eTest extends baseTest {

	@Test
	public void submitOrder() throws IOException, InterruptedException{
		String productName = "ADIDAS ORIGINAL";
		String countryName = "India";
		
		ProductCatalogue productCatalog = landingPage.loginApplication("izi@gmail.com", "Testing890-");
		//landed on home page
		List<WebElement> products = productCatalog.getListProducts();
		//add product to cart
		productCatalog.addProductToCart(productName);
		CartPage cartPage = productCatalog.goToCartPage();
		//verify product on cart
		Boolean match = cartPage.verifyProductTitleDisplayed(productName);	
		Assert.assertTrue(match);
		//checkoutPage
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry(countryName);
		//scroll intoView submit button
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,100)");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		
		//confirmationPage
		String confirmMassage = confirmationPage.confirmationMessagge();
		Assert.assertTrue(confirmMassage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	
	}

}
