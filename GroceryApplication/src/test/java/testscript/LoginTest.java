package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import project.Base;
import utilities.ExcelUtilities;

public class LoginTest extends Base {
	
	HomePage home;
	
	@Test(priority=1,description="User is trying to login with valid credentials",groups= {"smoke"})
	public void verifywhetheruserisabletologinValidCredential() throws IOException
	{
		String usernamevalue=ExcelUtilities.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtilities.getStringData(0, 1, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(usernamevalue).enterPassword(passwordvalue);  //chaining-after method calling the username & pwd methods are stayed in the same login page.
		home=login.clickSignin();   //after calling the method it is go to the next page ie,home page.so we use home page object.(chaining)
		
		//assertTrue method 
		boolean dashboarddisplay=login.dashBoard();
		Assert.assertTrue(dashboarddisplay,Constant.VALIDCREDENTIALERROR);
	}
	
	@Test(priority=4,description="User is trying to login with invalid credentials",retryAnalyzer=retry.Retry.class)
	public void verifywhetheruserisabletoLoginwithInvalidCredentials() throws IOException
	{
		String usernamevalue=ExcelUtilities.getStringData(1, 0, "LoginPage");
		String passwordvalue=ExcelUtilities.getStringData(1, 1, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(usernamevalue).enterPassword(passwordvalue).clickSignin();
		
		//assertEquals method
		String expected="7rmart supermarket";
		String actual=login.superMarket();
		Assert.assertEquals(actual, expected,Constant.INVALIDCREDENTIALERROR);
	}
	
	@Test(priority=3,description="User is trying to login with valid username and invalid password")
	public void verifywhetheruserisabletoLoginwithValidUsernameandInvalidPassword() throws IOException
	{
		String usernamevalue=ExcelUtilities.getStringData(2, 0, "LoginPage");
		String passwordvalue=ExcelUtilities.getStringData(2, 1, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(usernamevalue).enterPassword(passwordvalue).clickSignin();
		
		//assert equals
		String expected="7rmart supermarket";
		String actual=login.superMarket();
		Assert.assertEquals(actual, expected,Constant.VALIDUSERINVALIDPWDERROR);
	}
	
	@Test(priority=2,description="User is trying to login with invalid username and valid password",groups={"smoke"},dataProvider="loginProvider")
	public void verifywhetheruserisabletoLoginwithInvalidUsernameandValidPassword(String usernamevalue,String passwordvalue) throws IOException
	{
		//String usernamevalue=ExcelUtilities.getStringData(3, 0, "LoginPage");
		//String passwordvalue=ExcelUtilities.getStringData(3, 1, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(usernamevalue).enterPassword(passwordvalue).clickSignin();
		
		//assert equals
		String expected="7rmart supermarket";
		String actual=login.superMarket();
		Assert.assertEquals(actual, expected,Constant.INVALIDUSERVALIDPWDERROR);
	}
	
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

	return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
	// new Object[] {ExcelUtility.getStringData(3,
	// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
	};
	}

}
