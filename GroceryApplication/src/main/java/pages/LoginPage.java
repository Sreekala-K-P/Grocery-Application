package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	
	public WebDriver driver;
	
	WaitUtility wait=new WaitUtility();
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//button[@type='submit']") WebElement signIn;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement supermarket;
	
	public LoginPage enterUserName(String usernamevalue)
	{
		username.sendKeys(usernamevalue);
		return this;
	}
	public LoginPage enterPassword(String passwordvalue)
	{
		password.sendKeys(passwordvalue);
		return this;
	}
	public HomePage clickSignin()
	{
		wait.waitUntilElementToBeClickable(driver, signIn);  //applying wait utility
		signIn.click();
		return new HomePage(driver);
	}
	public boolean dashBoard()
	{
		return dashboard.isDisplayed();  //displaying home page element through assertTrue method
	}
	public String superMarket()
	{
		return supermarket.getText();  //for getting text name from login page  - assert equals method
	}

}
