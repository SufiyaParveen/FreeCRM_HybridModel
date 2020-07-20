package com.crm.qa.utils;
//import java.lang.Package;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	
	/** Clicks on the given Menu item and initiate the respective page object
	 *<p><b>clickMenuItem("Cases") clicks on cases menu item and returns the object of Cases page</b>
	 * @return Respective Page object
	 * @throws Exception
	 */
	public static void  clickMenuItem(String menuName, List<WebElement> el) throws Exception
	{
		for(int i=0; i<el.size();i++)
		{
			if(el.get(i).getText().equals(menuName))
			{
				menuName=el.get(i).getText();
				el.get(i).click();
			}	
		}
	}
	
	// To take the screenshot
		public static String takeScreenshot(String screenshotName)
		{
			String destination=null;
			try {
		       //  Convert web driver object to TakeScreenshot
				TakesScreenshot scrShot =((TakesScreenshot)driver);
				
				// Call getScreenshotAs method to create image file
				String SrcFile="data:image/png;base64,"+scrShot.getScreenshotAs(OutputType.BASE64);
				
				 destination= SrcFile;
//				//Move image file to new destination
//				String currentDir=System.getProperty("user.dir");
//				System.out.println(currentDir);
//				
//				// Copy file to Desired Location
//			    destination=currentDir+"\\Screenshots\\"+screenshotName+"_"+getCurrentDateTime()+".png";
//				File finalDestnation=new File(destination);
//			
//				FileUtils.copyFile(SrcFile, finalDestnation);		
				} 
			catch (Exception e) 
			   {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return destination;
		}

		// To get current directory 
		public static String getCurrentDir()
		{
			return System.getProperty("user.dir");
		}
		
		//To get current date time
		public static String getCurrentDateTime()
		{
			String currentDateTime=new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		    return currentDateTime;
		}
}