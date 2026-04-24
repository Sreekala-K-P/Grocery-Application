package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {
	
public WebDriver driver;

	PageUtility page=new PageUtility();
	
	public ManageContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']") WebElement contactactionbutton;
	@FindBy(id="phone") WebElement editphone;
	@FindBy(id="content") WebElement editaddress;
	@FindBy(xpath="//button[@type='submit']") WebElement updatebutton;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement contactalert;
	
	public ManageContactPage contactUsAction()
	{
		contactactionbutton.click();
		return this;
	}
	public ManageContactPage editPhoneNumber(String phoneno)
	{
		editphone.clear();
		editphone.sendKeys(phoneno);
		return this;
	}
	public ManageContactPage editAddress(String address)
	{
		editaddress.clear();
		editaddress.sendKeys(address);
		return this;
	}
	public ManageContactPage contactUpdateBtn()
	{
		page.clickUsingJS(updatebutton);
		return this;
		
		//JavascriptExecutor js=(JavascriptExecutor)driver;    //interface
		//js.executeScript("arguments[0].click()",updatebutton);
	}
	public boolean contactEditAlert()
	{
		return contactalert.isDisplayed();
	}

}
