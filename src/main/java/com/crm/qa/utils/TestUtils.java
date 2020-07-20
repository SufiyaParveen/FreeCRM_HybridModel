package com.crm.qa.utils;
//import java.lang.Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class TestUtils {
	
	public static WebDriver driver;
	
	public TestUtils(WebDriver dr)
	{
		driver=dr;
	}

	/** Clicks on Webelement 
	 * @return Nothing to be returned 
	 */
	public static void clickOn(WebElement element)
	{
		element.click();
	}
	
	/** Reads page title
	 * @return Page title as a String 
	 */	
	public static String getPageTitle()
	{
		return driver.getTitle();
	}
	
	/** Compares the actual and expected result 
	 * @return Nothing to be returned   
	 */
	public static void verifyExpectedResult(String actual, String expected)
	{
		Assert.assertEquals(actual, expected);	
	}
	
	/** Reads text of the webelement 
	 * @return Returns a String  
	 */
	public static String verifyHeaderText(WebElement headerText)
	{
		return headerText.getText();
	}
	
	/** Insert the given text in the text field 
	 * @return Nothing to be returned 
	 */
	public static void sendKeysIn(WebElement textLocation, String textToBeEntered)
	{
	textLocation.sendKeys(textToBeEntered);
	}
}
