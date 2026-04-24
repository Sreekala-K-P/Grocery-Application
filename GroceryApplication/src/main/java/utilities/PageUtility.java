package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class PageUtility {
	
	public WebDriver driver;
	
	public void selectDragDropWithValue(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByValue(value);
	}
	
	public void selectDragDropWithIndex(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByIndex(0);;
	}
	
	public void selectDragDropWithVisibleText(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByVisibleText(value);
	}
	
	public void clickUsingJS(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;    
		js.executeScript("arguments[0].click()",element);
	}
	
	public void pageScroll(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;  
		js.executeScript("window.scrollBy(0,350)","");
	}
	
	public void selectCheckBox(WebElement element)
	{
		element.isDisplayed();
		element.click();
	}
	
	public void mouseAction(WebElement element)
	{
		Actions obj=new Actions(driver);   
		obj.contextClick().build().perform();    //right click mouse action
	}
	
	public void mouseHover(WebElement element)
	{
		Actions obj=new Actions(driver);   
		obj.moveToElement(element).build().perform(); 
	}
	
	public void doubleClick(WebElement element)
	{
		Actions obj=new Actions(driver); 
		obj.doubleClick().build().perform();     //double click
	}
	
	public void dragDrop(WebElement element,WebElement elements)
	{
		Actions obj=new Actions(driver);
		obj.dragAndDrop(element, elements).build().perform();
	}
	
	public void clickKeyboard(WebElement element) throws AWTException
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	public void switchFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void navigation(WebElement element)
	{
		driver.navigate().forward();
		//driver.navigate().back();
		//driver.navigate().refresh();
		//driver.navigate().to("");
	}
	

}
