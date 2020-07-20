package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.utils.TestUtils;

public class HomePage extends TestUtils{
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement loginPageHeaderText;
	
	public HomePage(WebDriver dr) 
	{
		super(dr);
		PageFactory.initElements(dr, this);
	}
		
	/** Fetches the logged in user name
	 * @return User name as a String  
	 */
	public String getLoggedUser()
	{
		return loginPageHeaderText.getText();
	}
}
