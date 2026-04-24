package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import project.Base;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base{
	
	HomePage logout;
	ManageNewsPage news;
	
	@Test(description="user is trying to add news information")
	public void verifywhethertheuserisabletoaddnews() throws IOException
	{
		String usernamevalue=ExcelUtilities.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtilities.getStringData(0, 1, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(usernamevalue).enterPassword(passwordvalue);
		logout=login.clickSignin();
		
		
		logout.manageNews();
		
		
		//news.manageNewsNew();
		
		String newsinformation=ExcelUtilities.getStringData(1, 0, "AddNewNews");
		news.manageNewsNew().addNewsInformation(newsinformation).newsSaveButton();
		
		boolean actual=news.alertNews();
		System.out.println(actual);
		Assert.assertTrue(actual,Constant.ADDNEWNEWSERROR);
	}
	
	@Test(description="user is trying to search newly added news information")
	public void verifywhethertheuserisabletosearchtheNewlyAddedNews() throws IOException
	{
		String usernamevalue=ExcelUtilities.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtilities.getStringData(0, 1, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(usernamevalue).enterPassword(passwordvalue);
		logout=login.clickSignin();
		
		//HomePage logout=new HomePage(driver);
		logout.manageNews();
		
		//ManageNewsPage news=new ManageNewsPage(driver);
		//news.newsSearchBtn();
		
		String newsinformation=ExcelUtilities.getStringData(1, 0, "AddNewNews");
		news.newsSearchBtn().searchUpdatedNews(newsinformation).searchNewsButton();
		
		String expected="Search Manage News";
		String actual=news.addedNewsAlert();
		System.out.println(actual);
		Assert.assertEquals(actual, expected,Constant.SEARCHNEWNEWS);
	}
	

}
