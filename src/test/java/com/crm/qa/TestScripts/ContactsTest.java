package com.crm.qa.TestScripts;

import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;

public class ContactsTest extends BaseClass{
	
	
	@Test
	public void ValidateContactsPage_NoRecords() throws Exception
	{
		contactsPage.preReq();
		contactsPage.NoRecordsFound();
		System.out.println("Verified");
	}
	
	@Test
	public void ValidateCreateContactPage() throws Exception
	{
		contactsPage.preReq();
		contactsPage.CreateContactButton();
		contactsPage.verifyCreateContactHeader();
		Thread.sleep(5000);
	}
}