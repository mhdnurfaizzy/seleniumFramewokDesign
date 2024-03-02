package mhdnurfaizzy.Test;
//test

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import mhdnurfaizzy.pageobjects.CartPage;
import mhdnurfaizzy.pageobjects.CheckoutPage;
import mhdnurfaizzy.pageobjects.ConfirmationPage;
import mhdnurfaizzy.pageobjects.OrderPage;
import mhdnurfaizzy.pageobjects.ProductCatalogue;
import mhdnurfaizzy.testComponent.baseTest;

public class e2eTest extends baseTest {
//	String productName = "ADIDAS ORIGINAL";
	String productName = "ZARA COAT 3";
	
	@Test(dataProvider= "getData",groups="Purchase")
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException{
		
		String countryName = "India";
		
		ProductCatalogue productCatalog = landingPage.loginApplication(input.get("email"), input.get("password"));
		//landed on home page
		List<WebElement> products = productCatalog.getListProducts();
		//add product to cart
		productCatalog.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalog.goToCartPage();
		//verify product on cart
		Boolean match = cartPage.verifyProductTitleDisplayed(input.get("product"));	
		Assert.assertTrue(match);
		//checkoutPage
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry(countryName);
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		
		//confirmationPage
		String confirmMassage = confirmationPage.confirmationMessagge();
		Assert.assertTrue(confirmMassage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void ordersHistoryTest() {
		ProductCatalogue productCatalog = landingPage.loginApplication("izi@gmail.com", "Testing890-");
		OrderPage orderPage = productCatalog.goToOrderPage();
//		Assert.assertTrue(orderPage.verifyOrdersTitleDisplayed(input.get("product")));
		Assert.assertTrue(orderPage.verifyOrdersTitleDisplayed(productName));
	}
	
	 
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String, String>> data = getDataJsonToMap(System.getProperty("user.dir") + "\\src\\main\\java\\mhdnurfaizzy\\data\\Purchase.json");
		return new Object[][] { {data.get(0)},{data.get(1)} };
	}
	
	
	

}

//HashMap<String, String> map = new HashMap<String, String>();
//map.put("email", "izi@gmail.com");
//map.put("password", "Testing890-");
//map.put("product", "ADIDAS ORIGINAL");
//
//HashMap<String, String> map1 = new HashMap<String, String>();
//map1.put("email", "silori@gmail.com");
//map1.put("password", "Testing890-");
//map1.put("product", "ZARA COAT 3");
