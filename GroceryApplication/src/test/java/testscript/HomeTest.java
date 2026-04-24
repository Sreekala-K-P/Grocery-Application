package testscript;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import project.Base;
import utilities.ExcelUtilities;

public class HomeTest extends Base{
	
	HomePage logout;
	
	@Test(description="user is trying to logged out")
	public void verifywhethertheuserisabletosuccessfullyLoggedOut() throws IOException
	{
		String usernamevalue=ExcelUtilities.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtilities.getStringData(0, 1, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(usernamevalue).enterPassword(passwordvalue);
		logout=login.clickSignin();
		
		
		logout.clickAdmin(); 
		
		login=logout.clickLogout();
		
		
		//assertEquals method
		String expected="7rmart supermarket";
		String actual=login.superMarket();
		Assert.assertEquals(actual, expected,Constant.LOGGEDOUTERROR);
	}

}
