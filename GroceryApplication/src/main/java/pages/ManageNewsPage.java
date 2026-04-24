package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newsnewbtn;
	@FindBy(id="news") WebElement addnews;
	@FindBy(xpath="//button[@type='submit']") WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement newsalert;
	
	@FindBy(xpath="//a[text()=' Search']") WebElement newssearch;
	@FindBy(name="un") WebElement updatednews;
	@FindBy(name="Search") WebElement searchnewsbtn;
	@FindBy(xpath="//h4[text()='Search Manage News']") WebElement addednewsalert;
	
	public ManageNewsPage manageNewsNew()
	{
		newsnewbtn.click();
		return this;
	}
	public ManageNewsPage addNewsInformation(String newsinformation)
	{
		addnews.sendKeys(newsinformation);
		return this;
	}
	public ManageNewsPage newsSaveButton()
	{
		savebutton.click();
		return this;
	}
	public boolean alertNews()
	{
		return newsalert.isDisplayed();
	}
	public ManageNewsPage newsSearchBtn()
	{
		newssearch.click();
		return this;
	}
	public ManageNewsPage searchUpdatedNews(String newsinformation)
	{
		updatednews.sendKeys(newsinformation);
		return this;
	}
	public ManageNewsPage searchNewsButton()
	{
		searchnewsbtn.click();
		return this;
	}
	public String addedNewsAlert()
	{
		return addednewsalert.getText();
	}

}
