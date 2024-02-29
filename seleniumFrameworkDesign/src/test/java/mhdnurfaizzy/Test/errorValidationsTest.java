package mhdnurfaizzy.Test;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import mhdnurfaizzy.pageobjects.CartPage;
import mhdnurfaizzy.pageobjects.ProductCatalogue;
import mhdnurfaizzy.testComponent.baseTest;

public class errorValidationsTest extends baseTest {

	@Test(groups= {"errorHandling"},retryAnalyzer=mhdnurfaizzy.testComponent.Retry.class)
	public void loginErrorValidation() throws IOException, InterruptedException{
		landingPage.loginApplication("izi@gmail.com", "Testing890");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	
	}
	
	@Test
	public void productErrorValidation() throws IOException, InterruptedException{
		String productName = "ADIDAS ORIGINAL";
		
		ProductCatalogue productCatalog = landingPage.loginApplication("izi@gmail.com", "Testing890-");
		//landed on home page
		List<WebElement> products = productCatalog.getListProducts();
		//add product to cart
		productCatalog.addProductToCart(productName);
		CartPage cartPage = productCatalog.goToCartPage();
		
		//verify product on cart
		Boolean match = cartPage.verifyProductTitleDisplayed("ZARA COAT 33");	
		Assert.assertFalse(match);
		
	}

}
