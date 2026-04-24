package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Admin") WebElement admin;
	@FindBy(linkText="Logout") WebElement logout;
	@FindBy(linkText="More info") WebElement adminusers;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']") WebElement managecontact;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']") WebElement managenews;
	
	public HomePage clickAdmin()
	{
		admin.click();
		return this;
	}
	public LoginPage clickLogout()
	{
		 
		logout.click();
		return new LoginPage(driver);
	}
	public AdminuserPage clickAdminUsers()
	{
		adminusers.click();
		return new AdminuserPage(driver);
	}
	public ManageContactPage manageContact()
	{
		managecontact.click();
		return new ManageContactPage(driver);
	}
	public ManageNewsPage manageNews()
	{
		managenews.click();
		return new ManageNewsPage(driver);
	}

}
