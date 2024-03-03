package mhdnurfaizzy.stepDefinitions;


import mhdnurfaizzy.pageobjects.CartPage;
import mhdnurfaizzy.pageobjects.CheckoutPage;
import mhdnurfaizzy.pageobjects.ConfirmationPage;
import mhdnurfaizzy.pageobjects.LandingPage;
import mhdnurfaizzy.pageobjects.ProductCatalogue;
import mhdnurfaizzy.testComponent.baseTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends baseTest{
	
	public LandingPage landingPage;
	public ProductCatalogue productCatalog;
	public CheckoutPage checkoutPage;
	public ConfirmationPage confirmationPage;
	
	
	@Given("I landed on ecommerce page")
	public void I_landed_on_ecommerce_page() throws IOException {
		landingPage = launchApplication();
	}
	
	@Given("^I login with email (.+) and password (.+)$")
	public void I_login_with_email_and_password(String email, String password) {
		productCatalog = landingPage.loginApplication(email, password);
	}
	
	@When("^I added product (.+) to cart$")
	public void I_added_product_to_cart(String productName) throws InterruptedException {
		List<WebElement> products = productCatalog.getListProducts();
		//add product to cart
		productCatalog.addProductToCart(productName);
	}
	
	@When("^Checkout (.+) and submit order$")
	public void Checkout_and_submit_order(String productName) {
		CartPage cartPage = productCatalog.goToCartPage();
		//verify product on cart
		Boolean match = cartPage.verifyProductTitleDisplayed(productName);	
		Assert.assertTrue(match);
		//checkoutPage
		checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		confirmationPage = checkoutPage.submitOrder();
	}
	
	@Then("{string} message is displayed on confirmationPage")
	public void message_is_displayed_on_confirmationPage(String string) {
		String confirmMassage = confirmationPage.confirmationMessagge();
		Assert.assertTrue(confirmMassage.equalsIgnoreCase(string));
		driver.quit();
	}
	
	@Then("^\"([^\"]*)\" message is displayed$")
	public void something_message_is_displayed(String strArg1) throws Throwable {
	   
	   Assert.assertEquals(strArg1, landingPage.getErrorMessage());
	   driver.quit();
	}

}
