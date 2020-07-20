package com.crm.qa.TestScripts;

import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;

public class HomeTest extends BaseClass {
	
	@Test 
	public void validateHomePage()
	{
		loginPage.login();
		homePage.getPageHeader();
	}
	
	@Test
	public void validateUser()
	{
		loginPage.login();
		homePage.getLoggedUser();
	}
	
	@Test
	public void validateMenuList()
	{
		loginPage.login();
		homePage.getMenuList();
	}

}
