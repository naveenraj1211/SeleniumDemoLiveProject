package commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;

public class CommonFunctions 
{

	public static Properties prop =null;
	public static WebDriver driver = null;
	
	Logger logger = Logger.getLogger(CommonFunctions.class);  //Factory design pattern; without using new keyword

	public Properties loadPropertyFile() throws IOException
	{ 
		FileInputStream fileInputStream = new FileInputStream("HRM.properties");
		prop = new Properties();
		prop.load(fileInputStream);	
		return prop;		
	}



	@BeforeSuite
	public void lunchBrowser() throws IOException
	{
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Orange HRM Test Begins");
		logger.info("Loding the propertiy file");
		loadPropertyFile();
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");

		if(browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("Chromedriver"));
			driver = new ChromeDriver();
			logger.info("Launching Chrome");
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", prop.getProperty("IEdriver"));
			driver = new InternetExplorerDriver();	
			logger.info("Launching Firefox");
		}
		driver.manage().window().maximize();
		driver.get(url);
		logger.info("Navigating to the Application");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterSuite
	public void tearDown() 
	{
		logger.info("Execution done. Closing the browser");
		//driver.quit();
	}


}
