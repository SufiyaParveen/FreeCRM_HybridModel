package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.utils.TestUtils;

public class ClassicCRM extends TestUtils{
	
	public ClassicCRM(WebDriver dr) 
	{
		super(dr);
		PageFactory.initElements(dr, this);
	}
	
	/** Reads the Classic CRM page title  
	 *  
	 * @return Page title as String value
	 */
	public void verifyClassicCRMPageTitle()
	{
		String cassicCRMpageheaderText= driver.getTitle();
		verifyExpectedResult(cassicCRMpageheaderText, "CRMPRO Log In Screen");
		
	}
	
	

}
