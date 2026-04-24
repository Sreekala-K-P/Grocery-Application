package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminuserPage {
	
	public WebDriver driver;
	
	PageUtility page=new PageUtility();
	
	public AdminuserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newbutton;
	@FindBy(id="username") WebElement adminuser;
	@FindBy(id="password") WebElement adminpwd;
	@FindBy(id="user_type") WebElement usertype;
	@FindBy(name="Create") WebElement adminsubmit;
	@FindBy(className="close") WebElement successalert;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") WebElement search;
	@FindBy(id="un") WebElement searchusername;
	@FindBy(id="ut") WebElement searchusertype;
	@FindBy(name="Search") WebElement searchsubmit;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement searchalert;
	
	
	
	public AdminuserPage clickNewButton()
	{
		newbutton.click();
		return this;
	}
	public AdminuserPage enterAdminUser(String adminusername)
	{
		adminuser.sendKeys(adminusername);
		return this;
	}
	public AdminuserPage enterAdminpassword(String adminpassword)
	{
		adminpwd.sendKeys(adminpassword);
		return this;
	}
	public AdminuserPage usertypeDropdown()
	{
		page.selectDragDropWithVisibleText(usertype, "Admin");
		return this;
		
		
	}
	public AdminuserPage adminuserSubmit()
	{
		adminsubmit.click();
		return this;
	
	}
	public boolean newAdminuser()
	{
		return successalert.isDisplayed();
	}
	public AdminuserPage searchButton()
	{
		search.click();
		return this;
	}
	public AdminuserPage searchUserName(String searchuser)
	{
		searchusername.sendKeys(searchuser);
		//searchusername.getText();
		return this;
	}
	public AdminuserPage searchTypeDropdown()
	{
		page.selectDragDropWithVisibleText(searchusertype, "Admin");
		return this;
		//Select select=new Select(searchusertype);
		//select.selectByVisibleText("Admin");
	}
	public AdminuserPage searchSubmit()
	{
		searchsubmit.click();
		return this;
	}
	public boolean searchAlertDisplay()
	{
		return searchalert.isDisplayed();
	}
	
}
