package mhdnurfaizzy.testComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import mhdnurfaizzy.pageobjects.LandingPage;

public class baseTest {
	
	public WebDriver driver;

	public WebDriver Inittialized() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\mhdnurfaizzy\\resource\\globalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		} else if(browserName.equalsIgnoreCase("chrome"))
			{
			//ChromeDriver
			driver = new ChromeDriver();

			} else if(browserName.equalsIgnoreCase("firefox"))
				{
				driver = new FirefoxDriver();

				}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver; 
	}
	
	public LandingPage launchApplication() throws IOException
	{
		 driver = Inittialized();
			LandingPage landingPage = new LandingPage(driver);
			landingPage.goTo();
			return landingPage;
		 
	}
	
	
	
}
