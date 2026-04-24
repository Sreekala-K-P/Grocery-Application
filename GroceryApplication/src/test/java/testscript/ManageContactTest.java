package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import project.Base;
import utilities.ExcelUtilities;
import utilities.RandomDataUtility;

public class ManageContactTest extends Base{
	
	HomePage logout;
	ManageContactPage manage;
	
	@Test(description="User is trying to edit the contact information")
	public void verifywhetheruserisabletoedittheManageContactInfo() throws IOException
	{
		String usernamevalue=ExcelUtilities.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtilities.getStringData(0, 1, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(usernamevalue).enterPassword(passwordvalue);   //after method calling these pages are in login page.so we use login page object.
		logout=login.clickSignin();
		
		
		//logout.clickAdminUsers();
		manage=logout.manageContact(); //this is in the home page so we use home page object(chaining)
		
		
		RandomDataUtility datautility=new RandomDataUtility();
		String phoneno=datautility.mobileNo();
		String address=ExcelUtilities.getStringData(3, 0, "ContactAddressEdit");
		manage.contactUsAction().editPhoneNumber(phoneno).editAddress(address).contactUpdateBtn();
		
		//assertEquals
			boolean actual=manage.contactEditAlert();
			System.out.println(actual);
			Assert.assertTrue(actual,Constant.EDITMANAGECONTACTERROR);
	}
	

}
