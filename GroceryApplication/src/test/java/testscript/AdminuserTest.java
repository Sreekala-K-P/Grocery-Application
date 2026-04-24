package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminuserPage;
import pages.HomePage;
import pages.LoginPage;
import project.Base;
import utilities.ExcelUtilities;
import utilities.RandomDataUtility;

public class AdminuserTest extends Base{
	
	HomePage logout;
	AdminuserPage admin;
	
	@Test(description="User is trying to add new admin user")
	public void verifywhetheruserisabletoaddnewAdminUser() throws IOException
	{
		String usernamevalue=ExcelUtilities.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtilities.getStringData(0, 1, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(usernamevalue).enterPassword(passwordvalue);
		logout=login.clickSignin();
		
		
		logout.clickAdminUsers();
		
		RandomDataUtility datautility=new RandomDataUtility();
		
		String adminusername=datautility.randomUserName();
		String adminpassword=datautility.randomPassword();
		
		//AdminuserPage admin=new AdminuserPage(driver);
		
		admin.clickNewButton().enterAdminUser(adminusername).enterAdminpassword(adminpassword).usertypeDropdown().adminuserSubmit();
		
		//assertEquals method 
		
		boolean actual=admin.newAdminuser();
		System.out.println(actual);
		Assert.assertTrue(actual,Constant.NEWADMINUSERERROR);
	}
	
	@Test(description="User is trying to search newly added admin user name")
	public void verifywhetherUserisableTosearchtheNewlyAddedUser() throws IOException
	{
		String usernamevalue=ExcelUtilities.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtilities.getStringData(0, 1, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(usernamevalue).enterPassword(passwordvalue);
		logout=login.clickSignin();
		
		//HomePage logout=new HomePage(driver);
		logout.clickAdminUsers();
		
		//AdminuserPage admin=new AdminuserPage(driver);
		//admin.searchButton();
		
		String searchuser=ExcelUtilities.getStringData(0, 0, "SearchAdminUser");
		admin.searchButton().searchUserName(searchuser).searchTypeDropdown().searchSubmit();
		
		//assertEquals
		boolean actual=admin.searchAlertDisplay();
		System.out.println(actual);
		Assert.assertTrue(actual,Constant.SEARCHNEWADMINUSERERROR);
	}

}
