package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.utils.TestUtils;

public class HomePage extends TestUtils{
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement loginPageHeaderText;
	
	@FindBy(xpath="//div[@class='ui left fixed vertical  icon menu sidebar-dark expanded left-to-right']//span")
	WebElement homeNav;
	
	@FindAll({@FindBy(xpath="//span[@class='item-text']")})
	List<WebElement> allMenuList;
	
	
	public HomePage(WebDriver dr) 
	{
		super(dr);
		PageFactory.initElements(dr, this);
	}
		
	/** Fetches the logged in user name
	 * @return User name as a String  
	 */
	public void getLoggedUser()
	{
		String actulLoginPageHeaderText= loginPageHeaderText.getText();
		TestUtils.verifyExpectedResult(actulLoginPageHeaderText, "Test Users");
	}
	
	/** Fetches current URL 
	 * @return Current URL as a String  
	 */
	public void getPageHeader()
	{
		TestUtils.clickOn(homeNav);
		String homePageURL=driver.getCurrentUrl();
		TestUtils.verifyExpectedResult(homePageURL, "https://ui.cogmento.com/home");
	}
	
	public void getMenuList()
	{
		for(int i=0; i<allMenuList.size(); i++)
		{
			System.out.println(allMenuList.get(i).getText());
		}
	}
}
