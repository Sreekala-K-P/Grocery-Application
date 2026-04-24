package project;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenshotUtility;

public class Base {
	
	Properties prop;
	FileInputStream file;
	
	public WebDriver driver;
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("browsers")
	public void initializeBrowser(String browsers) throws IOException
	{
		prop=new Properties();
		file=new FileInputStream(Constant.CONFIGFILE);
		prop.load(file);
		if(browsers.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browsers.equalsIgnoreCase("FireFox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browsers.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver();
			driver=new EdgeDriver();
		}
		
		driver.get(prop.getProperty("url"));  
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));            //implicit wait
		
	}
	@AfterMethod(alwaysRun=true)
	public void closeBrowser(ITestResult itestresult) throws IOException   //ITestResult is a predefined interface
	{
		if(itestresult.getStatus()==ITestResult.FAILURE) 
		{
			ScreenshotUtility screenshotutility=new ScreenshotUtility();
			screenshotutility.getScreenshot(driver, itestresult.getName());
		}
		 // driver.close();
		//driver.quit();
	}

}
