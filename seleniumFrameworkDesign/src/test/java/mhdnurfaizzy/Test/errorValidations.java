package mhdnurfaizzy.Test;


import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import mhdnurfaizzy.testComponent.baseTest;

public class errorValidations extends baseTest {

	@Test
	public void submitOrder() throws IOException, InterruptedException{
		
		
		landingPage.loginApplication("izi@gmail.com", "Testing890");
		Assert.assertEquals("Incoret email or password", landingPage.getErrorMessage());

	
	}

}
