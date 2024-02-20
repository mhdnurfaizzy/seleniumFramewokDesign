package mhdnurfaizzy.seleniumFrameworkDesign.pageobjects;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import mhdnurfaizzy.seleniumFrameworkDesign.pageobjects.LandingPage;



import io.github.bonigarcia.wdm.WebDriverManager;

public class standAlone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		String productName = "ADIDAS ORIGINAL";
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//POM (PageObjectModel)
		LandingPage landingPage = new LandingPage(driver);

		//Login
		landingPage.goTo();
		landingPage.loginApplication("izi@gmail.com", "Testing890-");
		//landed on home page
		ProductCatalogue productCatalog = new ProductCatalogue(driver);
		List<WebElement> products = productCatalog.getListProducts();
		//add product to cart
		productCatalog.addProductToCart(productName);
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		//verify product on cart
		List<WebElement> cartProduct = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProduct.stream().anyMatch(titleProduct->titleProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		
		//Click btn checkout
		driver.findElement(By.cssSelector("li[class='totalRow'] button[type='button']")).click();
		
		//checkout product
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "india").build().perform();
		
		//fill details informastion
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
//		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
//		
//		//scroll intoView submit button
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,100)");
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));
//		driver.findElement(By.cssSelector(".action__submit")).click();
//		
//		//getText thankyou page
//		String confirmMassage = driver.findElement(By.cssSelector(".hero-primary")).getText();
//		Assert.assertTrue(confirmMassage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.quit();
	
	}

}
