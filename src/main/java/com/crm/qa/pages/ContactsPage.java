package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.utils.TestUtils;

public class ContactsPage extends TestUtils{
	
	@FindBy(xpath="//span/p[text()='No records found']")
	WebElement NoRecordFoundText;

	@FindBy(xpath="//button[text()='New']")
	WebElement CreateContactButton;
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement e;
	
	@FindBy(xpath="//div[contains(text(),'Create New Contact')]")  
	WebElement CreateContactPageHeaderText;
	
	@FindAll({@FindBy(xpath="//span[@class='item-text']")})
	static List<WebElement>  allMenuList;
	
	public ContactsPage(WebDriver dr) 
	{
		super(dr);
		PageFactory.initElements(dr, this);
	}
	
	public void preReq() throws Exception
	{
		TestUtils.clickMenuItem("Contacts", allMenuList);
	}
	
	public void NoRecordsFound()
	{
		
		String ActualText=TestUtils.verifyHeaderText(NoRecordFoundText);
		TestUtils.verifyExpectedResult(ActualText, "No records found");
	}
	
	public void CreateContactButton() throws InterruptedException
	{
		TestUtils.clickOn(CreateContactButton);
		System.out.println("clicked on new button");
		Thread.sleep(10000);
//		driver.navigate().refresh();
	}
	
//	
//	Assert.assertEquals(contactsPage.verifyCreateContactHeader(), "Create New Contact", "Title not matched");
//	System.out.println("Create contact header text is: "+contactsPage.verifyCreateContactHeader());

	public void verifyCreateContactHeader()
	{
		//System.out.println("Test create contact");
	//	String ActualCreateContactHeader=TestUtils.verifyHeaderText(CreateContactPageHeaderText);
		String ActualCreateContactHeader=TestUtils.verifyHeaderText(e);
		System.out.println("Header text is : "+ActualCreateContactHeader);
		TestUtils.verifyExpectedResult(ActualCreateContactHeader, "Create New Contact");
	}
		

}
